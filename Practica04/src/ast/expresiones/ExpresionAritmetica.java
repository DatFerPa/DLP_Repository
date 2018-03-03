package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class ExpresionAritmetica extends NodoASTAbstract implements Expresion {

	private String operador;
	private Expresion operando1;
	private Expresion operando2;

	public ExpresionAritmetica(int linea, int columna, Expresion operando1, String operador, Expresion operando2) {
		setLinea(linea);
		setColumna(columna);
		this.operador = operador;
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	@Override
	public String toString() {
		return "Aritmetica [operador=" + operador + ", operando1=" + operando1 + ", operando2=" + operando2
				+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

}
