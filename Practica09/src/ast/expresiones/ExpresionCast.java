package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import ast.tipos.Tipo;
import visitor.Visitor;

public class ExpresionCast extends AbstractExpresion {
		
	private Tipo tipoDestino;
	private Expresion expresion;
	
	public ExpresionCast(int linea, int columna,Tipo tipoDestino, Expresion expresion) {
		super();
		this.tipoDestino = tipoDestino;
		this.expresion = expresion;
		setLinea(linea);
		setColumna(columna);
	}
	
	public ExpresionCast(int linea, int columna,Object tipoDestino, Object expresion) {
		super();
		this.tipoDestino = (Tipo)tipoDestino;
		this.expresion = (Expresion)expresion;
		setLinea(linea);
		setColumna(columna);
	}

	public Tipo getTipoDestino() {
		return tipoDestino;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	@Override
	public String toString() {
		return "ExpresionCast [tipoDestino=" + tipoDestino + ", expresion=" + expresion + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	
			
}
