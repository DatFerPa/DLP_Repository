package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class Negacion extends NodoASTAbstract implements Expresion {
	
	private Expresion expresion;

	public Negacion(int linea,int columna,Expresion expresion) {
		super();
		this.expresion = expresion;
		setLinea(linea);
		setColumna(columna);		
	}

	@Override
	public String toString() {
		return "Negacion [expresion=" + expresion + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	

}
