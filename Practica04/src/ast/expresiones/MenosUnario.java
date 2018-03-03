package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class MenosUnario extends NodoASTAbstract implements Expresion {
	
	private Expresion operando;
	
	public MenosUnario(int linea,int columna,Expresion operando) {
		setLinea(linea);
		setColumna(columna);
		this.operando = operando;
	}
	
	public MenosUnario(int linea,int columna,Object operando) {
		setLinea(linea);
		setColumna(columna);
		this.operando = (Expresion)operando;
	}

	@Override
	public String toString() {
		return "MenosUnario [operando=" + operando.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	

}
