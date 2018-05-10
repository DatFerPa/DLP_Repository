package ast.sentencias;

import java.util.List;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class Escritura extends NodoASTAbstract implements Sentencia{
	private List<AbstractExpresion> expresion;
	
	public Escritura(int linea, int columna,List<AbstractExpresion> expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = expresion;
	}
	
	public List<AbstractExpresion> getExpresion() {
		return expresion;
	}

	public Escritura(int linea, int columna,Object expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = (List<AbstractExpresion>)expresion;
	}

	@Override
	public String toString() {
		return "Escritura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
}
