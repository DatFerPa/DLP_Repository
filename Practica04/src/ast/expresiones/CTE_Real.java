package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class CTE_Real extends NodoASTAbstract implements Expresion {
	private String valor;

	public CTE_Real(int linea, int columna,String valor) {
		super();
		this.valor = valor;
		setLinea(linea);
		setColumna(columna);
	}
	
	public CTE_Real(int linea, int columna,Object valor) {
		super();
		this.valor = (String)valor;
		setLinea(linea);
		setColumna(columna);
	}

	@Override
	public String toString() {
		return "CTE_Real [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	};
	
	
	
}
