package ast.sentencias;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class SentenciaReturn extends NodoASTAbstract implements Sentencia {
	
	private Expresion exp;
	public SentenciaReturn(int linea, int columna,Expresion exp) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "SentenciaReturn [expresion=" + this.exp +"]";
	}
	
	
	

}
