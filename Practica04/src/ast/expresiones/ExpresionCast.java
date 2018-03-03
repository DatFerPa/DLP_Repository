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

	public ExpresionCast(Tipo tipo, Expresion expresion) {
		super();
		this.tipo = tipo;
		this.expresion = expresion;
	}
			
}
