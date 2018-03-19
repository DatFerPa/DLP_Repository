package ast.expresiones;

import ast.AbstractExpresion;
import ast.definiciones.Definicion;
import ast.tipos.Tipo;
import visitor.Visitor;

public class Variable extends AbstractExpresion {
	private String nombre;
	private Tipo tipo;
	private Definicion definicion;
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Definicion getDefinicion() {
		return definicion;
	}

	public void setDefinicion(Definicion definicion) {
		this.definicion = definicion;
	}
	
	
	
	
}
