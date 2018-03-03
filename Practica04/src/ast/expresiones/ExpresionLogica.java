package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class ExpresionLogica extends NodoASTAbstract implements Expresion {
	
	private Expresion operando1;
	private String operador;
	private Expresion operando2;
	
	public ExpresionLogica(int linea, int columna, Expresion operando1, String operador, Expresion operando2) {
		setLinea(linea);
		setColumna(columna);
		this.operador = operador;
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	@Override
	public String toString() {
		return "ExpresionLogica [operando1=" + operando1 + ", operador=" + operador + ", operando2=" + operando2
				+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	
	
	

}
