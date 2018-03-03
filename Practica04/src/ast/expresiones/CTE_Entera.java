package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class CTE_Entera extends NodoASTAbstract implements Expresion {
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
	
	
}
