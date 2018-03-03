package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class ExpresionCompuesta extends NodoASTAbstract implements Expresion {
	
	private Expresion expresionPrincipal;
	private Expresion expresionCompuesta;
	
	public ExpresionCompuesta(int linea, int columna,Expresion expresionPrincipal, Expresion expresionCompuesta) {
		super();
		this.expresionPrincipal = expresionPrincipal;
		this.expresionCompuesta = expresionCompuesta;
		setLinea(linea);
		setColumna(columna);
	}
	
	public ExpresionCompuesta(int linea, int columna, Object expresionPrincipal, Object expresionCompuesta) {
		super();
		this.expresionPrincipal = (Expresion)expresionPrincipal;
		this.expresionCompuesta = (Expresion)expresionCompuesta;
		setLinea(linea);
		setColumna(columna);
	}

	@Override
	public String toString() {
		return "ExpresionCompuesta [expresionPrincipal=" + expresionPrincipal + ", expresionCompuesta="
				+ expresionCompuesta + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}
	
	
}
