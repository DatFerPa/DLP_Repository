package ast.expresiones;

import ast.AbstractExpresion;
import ast.AbstractExpresion;
import visitor.Visitor;

public class ExpresionAritmetica extends AbstractExpresion {

	private String operador;
	private AbstractExpresion operando1;
	private AbstractExpresion operando2;

	public ExpresionAritmetica(int linea, int columna, AbstractExpresion operando1, String operador, AbstractExpresion operando2) {
		setLinea(linea);
		setColumna(columna);
		this.operador = operador;
		this.operando1 = operando1;
		this.operando2 = operando2;
	}
	
	public ExpresionAritmetica(int linea, int columna, Object operando1, Object operador, Object operando2) {
		setLinea(linea);
		setColumna(columna);
		this.operador = (String)operador;
		this.operando1 = (AbstractExpresion)operando1;
		this.operando2 = (AbstractExpresion)operando2;
	}
	
	

	public String getOperador() {
		return operador;
	}

	public AbstractExpresion getOperando1() {
		return operando1;
	}

	public AbstractExpresion getOperando2() {
		return operando2;
	}

	@Override
	public String toString() {
		return "Aritmetica [operador=" + operador + ", operando1=" + operando1 + ", operando2=" + operando2
				+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

}
