package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.tipos.Tipo;

public class ExpresionCast extends NodoASTAbstract implements Expresion {
		
	private Tipo tipo;
	private Expresion expresion;
	
	public ExpresionCast(int linea, int columna,Tipo tipo, Expresion expresion) {
		super();
		this.tipo = tipo;
		this.expresion = expresion;
		setLinea(linea);
		setColumna(columna);
	}
	
	public ExpresionCast(int linea, int columna,Object tipo, Object expresion) {
		super();
		this.tipo = (Tipo)tipo;
		this.expresion = (Expresion)expresion;
		setLinea(linea);
		setColumna(columna);
	}

	@Override
	public String toString() {
		return "ExpresionCast [tipo=" + tipo + ", expresion=" + expresion + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

	
			
}
