package ast.expresiones;

import ast.AbstractExpresion;
import visitor.Visitor;

public class Variable extends AbstractExpresion {
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

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
	
	
}
