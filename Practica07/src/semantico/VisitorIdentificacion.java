package semantico;

import ast.Sentencia;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.expresiones.Variable;
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
		if(def == null) {
			new TipoError(m, "variable no definida");
		}else {
			m.setDefinicion(def);
		}
		super.visitar(m, param);
		return null;
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {		
		if(!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una funcion con ese nombre");
		}
		
		tablaSimbolos.set();
		m.getTipoBase().aceptar(this, param);
		for(DefVariable defV:m.getVariablesLocales()) {
			if(tablaSimbolos.buscarAmbitoActual(defV.getNombre())!=null) {
				new TipoError(defV, "Ya existe una variable con ese nombre");
			}
			
			defV.aceptar(this, param);
		}		
		for(Sentencia s: m.getLista_sentencias()) {
			s.aceptar(this, param);
		}				
		tablaSimbolos.reset();
		
		return null;
	}

	@Override
	public Object visitar(DefVariable m, Object param) {		
		if(!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una variable con ese nombre");
		}	
		m.getTipoBase().aceptar(this, param);
		return null;
	}


	@Override
	public Object visitar(TipoFuncion m, Object param) {
		m.getTipoRetorno().aceptar(this, param);
		for(DefVariable defV: m.getArgumentos()) {
			if(!tablaSimbolos.insertar(defV)) {
				new TipoError(defV, "Ya existe una variable con ese nombre");
			}
		}
		return null;
	}



}
