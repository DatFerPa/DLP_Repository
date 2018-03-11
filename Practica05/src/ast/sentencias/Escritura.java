package ast.sentencias;

import java.util.List;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class Escritura extends NodoASTAbstract implements Sentencia{
	private List<Expresion> expresion;
	
	public Escritura(int linea, int columna,List<Expresion> expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = expresion;
	}
	
	public Escritura(int linea, int columna,Object expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = (List<Expresion>)expresion;
	}

	@Override
	public String toString() {
		return "Escritura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	
}
