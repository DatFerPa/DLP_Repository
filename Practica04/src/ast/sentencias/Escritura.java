package ast.sentencias;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class Escritura extends NodoASTAbstract implements Sentencia{
	private Expresion expresion;
	
	public Escritura(int linea, int columna,Expresion expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = expresion;
	}
	
	public Escritura(int linea, int columna,Object expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = (Expresion)expresion;
	}

	@Override
	public String toString() {
		return "Escritura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	
}
