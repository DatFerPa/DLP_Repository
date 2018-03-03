package ast.sentencias;

import java.util.List;


import ast.Expresion;

import ast.NodoASTAbstract;
import ast.Sentencia;

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
	@Override
	public String toString() {
		return "SentenciaIf [condicion=" + condicion + ", cuerpo_if=" + cuerpo_if + ", cuerpo_else=" + cuerpo_else
				+ "]";
	}
	

}
