package ast.sentencias;

import java.util.List;


import ast.Expresion;

import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class SentenciaIf extends NodoASTAbstract implements Sentencia {
	private Expresion condicion;
	private List<Sentencia> cuerpo_if;
	private List<Sentencia> cuerpo_else;
	
	public SentenciaIf(int linea,int columna,Expresion condicion, List<Sentencia> cuerpo_if, List<Sentencia> cuerpo_else) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.condicion = condicion;
		this.cuerpo_if = cuerpo_if;
		this.cuerpo_else = cuerpo_else;
	}
	
	public SentenciaIf(int linea,int columna,Object condicion, Object cuerpo_if, Object cuerpo_else) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.condicion = (Expresion)condicion;
		this.cuerpo_if = (List<Sentencia>)cuerpo_if;
		this.cuerpo_else = (List<Sentencia>)cuerpo_else;
	}
	
	@Override
	public String toString() {
		return "SentenciaIf [condicion=" + condicion + ", cuerpo_if=" + cuerpo_if + ", cuerpo_else=" + cuerpo_else
				+ "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public Expresion getCondicion() {
		return condicion;
	}

	public List<Sentencia> getCuerpo_if() {
		return cuerpo_if;
	}

	public List<Sentencia> getCuerpo_else() {
		return cuerpo_else;
	}
	

}
