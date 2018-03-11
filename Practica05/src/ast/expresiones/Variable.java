package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class Variable extends NodoASTAbstract implements Expresion {
	private String nombre;
	
	public Variable (int linea, int columna, String nombre) {
		setLinea(linea);
		setColumna(columna);
		this.nombre = nombre;
	}
	
	public Variable (int linea, int columna, Object nombre) {
		setLinea(linea);
		setColumna(columna);
		this.nombre = (String)nombre;
	}

	@Override
	public String toString() {
		return "Variable [nombre=" + nombre + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}
	
	
	
	
}
