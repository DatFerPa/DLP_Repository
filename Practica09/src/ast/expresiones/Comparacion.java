package ast.expresiones;

import ast.AbstractExpresion;
import ast.AbstractExpresion;
import visitor.Visitor;

public class Comparacion extends AbstractExpresion {
	private AbstractExpresion operando1;
	private String operador;
	private AbstractExpresion operando2;
	
	public Comparacion(int linea, int columna,AbstractExpresion operando1, String operador, AbstractExpresion operando2) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.operando1 = operando1;
		this.operador = operador;
		this.operando2 = operando2;
	}
	
	public Comparacion(int linea, int columna,Object operando1, Object operador, Object operando2) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.operando1 = (AbstractExpresion)operando1;
		this.operador = (String)operador;
		this.operando2 = (AbstractExpresion)operando2;
	}

	public AbstractExpresion getOperando1() {
		return operando1;
	}

	public String getOperador() {
		return operador;
	}

	public AbstractExpresion getOperando2() {
		return operando2;
	}

	@Override
	public String toString() {
		return "Comparacion [operando1=" + operando1 + ", operador=" + operador + ", operando2=" + operando2
				+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
}
