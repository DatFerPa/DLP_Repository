package ast.expresiones;

import ast.AbstractExpresion;
import ast.Expresion;
import visitor.Visitor;

public class Negacion extends AbstractExpresion {
	
	private AbstractExpresion expresion;

	public Negacion(int linea,int columna,AbstractExpresion expresion) {
		super();
		this.expresion = expresion;
		setLinea(linea);
		setColumna(columna);		
	}
	
	public Negacion(int linea,int columna,Object expresion) {
		super();
		this.expresion = (AbstractExpresion)expresion;
		setLinea(linea);
		setColumna(columna);		
	}

	public AbstractExpresion getExpresion() {
		return expresion;
	}

	@Override
	public String toString() {
		return "Negacion [expresion=" + expresion + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	

}
