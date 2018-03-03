package ast.sentencias;

import java.util.List;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class Lectura extends NodoASTAbstract implements Sentencia {

	private List<Expresion> expresion;

	public Lectura(int linea, int columna, List<Expresion> expresion) {
		setColumna(columna);
		setLinea(linea);
		this.expresion = expresion;
	}
	
	public Lectura(int linea, int columna, Object expresion) {
		setColumna(columna);
		setLinea(linea);
		this.expresion = (List<Expresion>)expresion;
	}

	@Override
	public String toString() {
		return "Lectura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	
}
