package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class Comparacion extends NodoASTAbstract implements Expresion {
	private Expresion operando1;
	private String operador;
	private Expresion operando2;
	
	public Comparacion(int linea, int columna,Expresion operando1, String operador, Expresion operando2) {
		super();
		setLinea(linea);
		setColumna(columna);
		this.operando1 = operando1;
		this.operador = operador;
		this.operando2 = operando2;
	}

	@Override
	public String toString() {
		return "Comparacion [operando1=" + operando1 + ", operador=" + operador + ", operando2=" + operando2
				+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}
	
	
}
