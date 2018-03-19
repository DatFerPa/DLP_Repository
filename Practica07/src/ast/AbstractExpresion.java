package ast;

public abstract class AbstractExpresion extends NodoASTAbstract implements Expresion{
	
	private boolean Lvalue;

	public boolean isLvalue() {
		return Lvalue;
	}

	public void setLvalue(boolean lvalue) {
		Lvalue = lvalue;
	}
	
	

}
