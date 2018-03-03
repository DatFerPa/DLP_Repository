package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class AccesoACampo extends NodoASTAbstract implements Expresion {
	private Expresion izq;
	private String nombre;
	public AccesoACampo(int linea, int columna,Expresion izq, String nombre) {
		super();
		this.izq = izq;
		this.nombre = nombre;
		setLinea(linea);
		setColumna(columna);
	}
	
	public AccesoACampo(int linea, int columna,Object izq, Object nombre) {
		super();
		this.izq = (Expresion)izq;
		this.nombre = (String)nombre;
		setLinea(linea);
		setColumna(columna);
	}
	
	@Override
	public String toString() {
		return "AccesoACampo [izq=" + izq + ", nombre=" + nombre + ", getLinea()=" + getLinea() + ", getColumna()="
				+ getColumna() + "]";
	}
	
	
	
	
}
