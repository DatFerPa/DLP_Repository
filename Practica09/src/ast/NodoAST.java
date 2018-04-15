package ast;

import visitor.Visitor;

public interface NodoAST {
	public Object aceptar(Visitor visitor, Object param);
}
