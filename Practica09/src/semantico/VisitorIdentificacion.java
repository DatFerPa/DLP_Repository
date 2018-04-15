package semantico;

import java.util.ArrayList;
import java.util.List;

import ast.AbstractExpresion;
import ast.Sentencia;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionFuncion;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.sentencias.Asignacion;
import ast.sentencias.Lectura;
import ast.sentencias.SentenciaFuncion;
import ast.sentencias.SentenciaIf;
import ast.sentencias.SentenciaReturn;
import ast.sentencias.SentenciaWhile;
import ast.tipos.Tipo;
import ast.tipos.TipoError;
import ast.tipos.TipoFuncion;
import tablasimbolos.TablaSimbolos;
import visitor.VisitorAbstracto;

public class VisitorIdentificacion extends VisitorAbstracto {

	private TablaSimbolos tablaSimbolos;

	public VisitorIdentificacion() {
		tablaSimbolos = new TablaSimbolos();
	}

	@Override
	public Object visitar(Variable m, Object param) {

		Definicion def = tablaSimbolos.buscar(m.getNombre());
		if (def == null) {
			new TipoError(m, "variable no definida");
		} else {
			m.setDefinicion(def);
		}
		super.visitar(m, param);
		return null;
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {
		if (!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una funcion con ese nombre");
		}

		tablaSimbolos.set();
		m.getTipoBase().aceptar(this, param);
		for (DefVariable defV : m.getVariablesLocales()) {
			if (tablaSimbolos.buscarAmbitoActual(defV.getNombre()) != null) {
				new TipoError(defV, "Ya existe una variable con ese nombre");
			}

			defV.aceptar(this, param);
		}
		for (Sentencia s : m.getLista_sentencias()) {
			s.aceptar(this, ((TipoFuncion)m.getTipoBase()).getTipoRetorno());
		}
		tablaSimbolos.reset();

		return null;
	}

	@Override
	public Object visitar(DefVariable m, Object param) {
		if (!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una variable con ese nombre");
		}
		m.getTipoBase().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(TipoFuncion m, Object param) {
		m.getTipoRetorno().aceptar(this, param);
		for (DefVariable defV : m.getArgumentos()) {
			//le decimos a la variable, que es parte del parametro ()
			defV.setParametro(true);
			if (!tablaSimbolos.insertar(defV)) {
				new TipoError(defV, "Ya existe una variable con ese nombre");
			}
		}
		return null;
	}

	@Override
	public Object visitar(AccesoACampo m, Object param) {
		super.visitar(m, param);
		Tipo tipo = m.getIzq().getTipo().punto(m.getNombre());
		if (tipo == null) {
			tipo = new TipoError(m, "El tipo no se corresponde para acceder a un registro del struct");
		}
		m.setTipo(tipo);

		return null;
	}

	@Override
	public Object visitar(AccesoArray m, Object param) {
		super.visitar(m, param);
		m.setTipo(m.getFuera_corchetes().getTipo().corchetes(m.getDentro_corchetes().getTipo()));
		return null;
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		super.visitar(m, param);

		Tipo tipo = m.getOperando1().getTipo().comparacion(m.getOperando2().getTipo());

		if (tipo == null) {
			tipo = new TipoError(m,
					"Los tipos para una comparacion tienen que ser del mismo tipo y de tipos entero, real o caracter");
		}
		m.setTipo(tipo);
		return null;
	}

	@Override
	public Object visitar(ExpresionAritmetica m, Object param) {
		super.visitar(m, param);
		m.setTipo(m.getOperando1().getTipo().aritmetica(m.getOperando2().getTipo()));
		return null;
	}

	@Override
	public Object visitar(MenosUnario m, Object param) {
		super.visitar(m, param);
		Tipo tipo = m.getOperando().getTipo().aritmetica();
		if (tipo == null) {
			tipo = new TipoError(m, "El tipo no se corresponde con uno de los permitidos");
		}
		return null;
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		super.visitar(m, param);

		Tipo tipo = ((AbstractExpresion) m.getExpresion()).getTipo().cast(m.getTipoDestino());

		if (tipo == null) {
			tipo = new TipoError(m, "El tipo de destino o de origen son invalidos para hacer un CAST");
		}

		m.setTipo(tipo);
		return null;
	}

	@Override
	public Object visitar(ExpresionFuncion m, Object param) {
		super.visitar(m, param);
		// tipo funcion

		List<Tipo> tipos = new ArrayList<Tipo>();
		for (AbstractExpresion exp : m.getArgumentos()) {
			tipos.add(exp.getTipo());
		}

		Tipo tipo = m.getIdentificador().getTipo().parentesis(tipos);

		if (tipo == null) {
			tipo = new TipoError(m, "Uno o varios de los argumentos no concuerdan con la descripción");
		}

		m.setTipo(tipo);

		return null;
	}

	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		super.visitar(m, param);

		Tipo tipo = m.getOperando1().getTipo().logica(m.getOperando2().getTipo());
		if (tipo == null) {
			tipo = new TipoError(m, "Las expresiones logicas se tienen que hacer con enteros o con caracteres");
		}
		m.setTipo(tipo);
		return null;
	}

	@Override
	public Object visitar(Negacion m, Object param) {
		super.visitar(m, param);
		Tipo tipo = m.getExpresion().getTipo().logica();
		if (tipo == null) {
			tipo = new TipoError(m, "Las expresiones logicas se tienen que hacer con enteros o con caracteres");
		}
		m.setTipo(tipo);
		return null;
	}

	// sentencias

	@Override
	public Object visitar(Asignacion m, Object param) {
		super.visitar(m, param);

		if (m.getIzquierda().getTipo().equivalente(m.getDerecha().getTipo()) == null) {
			new TipoError(m, "Los tipos en la asignación tienen que ser iguales");
		}

		return null;
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		super.visitar(m, param);
		return null;
	}

	@Override
	public Object visitar(SentenciaFuncion m, Object param) {
		super.visitar(m, param);
		
		List<Tipo> tipos = new ArrayList<Tipo>();
		for (AbstractExpresion exp : m.getargumentos()) {
			tipos.add(exp.getTipo());
		}

		Tipo tipo = m.getIdentificador().getTipo().parentesis(tipos);

		if (tipo == null) {
			tipo = new TipoError(m, "Uno o varios de los argumentos no concuerdan con la descripción");
		}

		return null;
	}

	@Override
	public Object visitar(SentenciaIf m, Object param) {
		super.visitar(m, param);
		if(m.getCondicion().getTipo().esLogica()==false) {
			new TipoError(m,"El tipo de la condicion tiene que ser de tipo entero o caracter");
		}
		return null;
	}

	@Override
	public Object visitar(SentenciaWhile m, Object param) {
		super.visitar(m, param);
		if(m.getCondicion().getTipo().esLogica()==false) {
			new TipoError(m,"El tipo de la condicion tiene que ser de tipo entero o caracter");
		}
		return null;
	}

	@Override
	public Object visitar(SentenciaReturn m, Object param) {
		super.visitar(m, param);
		//vamos a usar el tipo que pasamos por parametro
		Tipo tipo =((Tipo)param).equivalente(m.getExp().getTipo());
		if(tipo == null) {
			new TipoError(m,"El tipo de la sentencia return no se corresponde con el de la definicion de la funcion");
		}
		return null;
	}
	
	
	

	/*
	 * @Override public Object visitar( m, Object param) { super.visitar(m, param);
	 * return null; }
	 * 
	 */

}
