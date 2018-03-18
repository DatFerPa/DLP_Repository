package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import visitor.Visitor;

public class ExpresionCompuesta extends AbstractExpresion {
	
	private AbstractExpresion expresionPrincipal;
	private AbstractExpresion expresionCompuesta;
	
	public ExpresionCompuesta(int linea, int columna,AbstractExpresion expresionPrincipal, AbstractExpresion expresionCompuesta) {
		super();
		this.expresionPrincipal = expresionPrincipal;
		this.expresionCompuesta = expresionCompuesta;
		setLinea(linea);
		setColumna(columna);
	}
	
	public ExpresionCompuesta(int linea, int columna, Object expresionPrincipal, Object expresionCompuesta) {
		super();
		this.expresionPrincipal = (AbstractExpresion)expresionPrincipal;
		this.expresionCompuesta = (AbstractExpresion)expresionCompuesta;
		setLinea(linea);
		setColumna(columna);
	}

	@Override
	public String toString() {
		return "ExpresionCompuesta [expresionPrincipal=" + expresionPrincipal + ", expresionCompuesta="
				+ expresionCompuesta + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public Expresion getExpresionPrincipal() {
		return expresionPrincipal;
	}

	public Expresion getExpresionCompuesta() {
		return expresionCompuesta;
	}
	
	
}
