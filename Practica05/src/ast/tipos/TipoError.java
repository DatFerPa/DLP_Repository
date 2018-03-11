package ast.tipos;

import ast.NodoASTAbstract;
import manejadorDeErrores.ME;

public class TipoError implements Tipo{
	
	private String msg;
	
	private NodoASTAbstract nodo;

	public TipoError(NodoASTAbstract nodo, String msg) {
		this.msg = msg;
		this.nodo = nodo;
		ME.getME().addError(this);
	}
	
	
	public String getmsg() {
		return msg;
	}
	
	public NodoASTAbstract getNodo() {
		return nodo;
	}

}
