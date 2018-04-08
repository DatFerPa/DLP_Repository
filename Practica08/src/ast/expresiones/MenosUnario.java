package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import visitor.Visitor;

public class MenosUnario extends AbstractExpresion {
	
	private AbstractExpresion operando;
	
	public MenosUnario(int linea,int columna,AbstractExpresion operando) {
		setLinea(linea);
		setColumna(columna);
		this.operando = operando;
	}
	
	public AbstractExpresion getOperando() {
		return operando;
	}

	public MenosUnario(int linea,int columna,Object operando) {
		setLinea(linea);
		setColumna(columna);
		this.operando = (AbstractExpresion)operando;
	}

	@Override
	public String toString() {
		return "MenosUnario [operando=" + operando.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	

}
