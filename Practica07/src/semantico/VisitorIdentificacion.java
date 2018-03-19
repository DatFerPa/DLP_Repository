package semantico;

import ast.Programa;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.CTE_Caracter;
import ast.expresiones.CTE_Entera;
import ast.expresiones.CTE_Real;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionCompuesta;
import ast.expresiones.ExpresionFuncion;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.sentencias.Asignacion;
import ast.sentencias.Escritura;
import ast.sentencias.Lectura;
import ast.sentencias.SentenciaFuncion;
import ast.sentencias.SentenciaIf;
import ast.sentencias.SentenciaReturn;
import ast.sentencias.SentenciaWhile;
import ast.tipos.Campo;
import ast.tipos.TipoArray;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoError;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoReal;
import ast.tipos.TipoStruct;
import ast.tipos.TipoVoid;
import tablasimbolos.TablaSimbolos;
import visitor.Visitor;
import visitor.VisitorAbstracto;

public class VisitorIdentificacion extends VisitorAbstracto {
	
	private TablaSimbolos tablaSimbolos;

	public VisitorIdentificacion() {
		tablaSimbolos = new TablaSimbolos();
	}





	@Override
	public Object visitar(ExpresionCast m, Object param) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object visitar(Campo m, Object param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitar(Variable m, Object param) {
		super.visitar(m, param);
		
		return null;
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {
		super.visitar(m, param);
		if(!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una funcion con ese nombre");
		}
		m.getTipoBase().aceptar(this, null);
		
		return null;
	}

	@Override
	public Object visitar(DefVariable m, Object param) {		
		super.visitar(m, param);
		if(!tablaSimbolos.insertar(m)) {
			new TipoError(m, "Ya existe una variable con ese nombre");
		}		
		return null;
	}


	@Override
	public Object visitar(TipoFuncion m, Object param) {
		return null;
	}



}
