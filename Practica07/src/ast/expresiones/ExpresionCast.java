package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import ast.tipos.Tipo;
import visitor.Visitor;

public class ExpresionCast extends AbstractExpresion {
		
	private Tipo tipo;
	private Expresion expresion;
	
	public ExpresionCast(int linea, int columna,Tipo tipo, Expresion expresion) {
		super();
		this.tipo = tipo;
		this.expresion = expresion;
		setLinea(linea);
		setColumna(columna);
	}
	
	public ExpresionCast(int linea, int columna,Object tipo, Object expresion) {
		super();
		this.tipo = (Tipo)tipo;
		this.expresion = (Expresion)expresion;
		setLinea(linea);
		setColumna(columna);
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	@Override
	public String toString() {
		return "ExpresionCast [tipo=" + tipo + ", expresion=" + expresion + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	
			
}
