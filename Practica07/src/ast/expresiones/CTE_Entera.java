package ast.expresiones;

import ast.AbstractExpresion;
import visitor.Visitor;

public class CTE_Entera extends AbstractExpresion {
	private String valor;
	public CTE_Entera (int linea, int columna, String valor) {
		setLinea(linea);
		setColumna(columna);
		this.valor = valor;
	}
	
	public CTE_Entera (int linea, int columna, Object valor) {
		setLinea(linea);
		setColumna(columna);
		this.valor = (String)valor;
	}
	@Override
	public String toString() {
		return "LiteralEntero [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
}
