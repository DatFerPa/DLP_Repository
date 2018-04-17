package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import visitor.Visitor;

public class AccesoACampo extends AbstractExpresion {
	private AbstractExpresion izq;
	private String nombre;
	public AccesoACampo(int linea, int columna,AbstractExpresion izq, String nombre) {
		super();
		this.izq = izq;
		this.nombre = nombre;
		setLinea(linea);
		setColumna(columna);
	}
	
	public AccesoACampo(int linea, int columna,Object izq, Object nombre) {
		super();
		this.izq = (AbstractExpresion)izq;
		this.nombre = (String)nombre;
		setLinea(linea);
		setColumna(columna);
	}
	
	public AbstractExpresion getIzq() {
		return izq;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "AccesoACampo [izq=" + izq + ", nombre=" + nombre + ", getLinea()=" + getLinea() + ", getColumna()="
				+ getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
	
	
}
