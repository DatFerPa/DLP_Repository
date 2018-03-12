package ast.tipos;

import ast.NodoASTAbstract;
import manejadorDeErrores.ME;

public class TipoError extends NodoASTAbstract implements Tipo {

	private String msg;

	private NodoASTAbstract nodo;

	public TipoError(NodoASTAbstract nodo, String msg) {
		this.msg = msg;
		this.nodo = nodo;
		setLinea(nodo.getLinea());
		setColumna(nodo.getColumna());
		ME.getME().addError(this);
	}

	public String getmsg() {
		return msg;
	}

	public NodoASTAbstract getNodo() {
		return nodo;
	}

	@Override
	public String toString() {
		return "TipoError [msg=" + msg + ", nodo=" + nodo + "]";
	}

}
