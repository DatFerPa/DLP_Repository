package ast.sentencias;

import java.util.List;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class Lectura extends NodoASTAbstract implements Sentencia {

	private List<AbstractExpresion> expresion;

	public Lectura(int linea, int columna, List<AbstractExpresion> expresion) {
		setColumna(columna);
		setLinea(linea);
		this.expresion = expresion;
	}
	
	public Lectura(int linea, int columna, Object expresion) {
		setColumna(columna);
		setLinea(linea);
		this.expresion = (List<AbstractExpresion>)expresion;
	}

	@Override
	public String toString() {
		return "Lectura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public List<AbstractExpresion> getExpresion() {
		return expresion;
	}
	
	
}
