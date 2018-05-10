package ast;

import ast.tipos.Tipo;

public abstract class AbstractExpresion extends NodoASTAbstract implements Expresion{
	
	private boolean Lvalue;
	private Tipo tipo;

	public boolean isLvalue() {
		return Lvalue;
	}

	public void setLvalue(boolean lvalue) {
		Lvalue = lvalue;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}
