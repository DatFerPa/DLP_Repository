package ast.sentencias;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class SentenciaReturn extends NodoASTAbstract implements Sentencia {
	
	private AbstractExpresion exp;
	public SentenciaReturn(int linea, int columna,AbstractExpresion exp) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.exp = exp;
	}
	
	public SentenciaReturn(int linea, int columna,Object exp) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.exp = (AbstractExpresion)exp;
	}
	
	public AbstractExpresion getExp() {
		return exp;
	}

	@Override
	public String toString() {
		return "SentenciaReturn [exp=" + exp + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
	
	
	

}
