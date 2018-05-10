package ast.sentencias;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class Asignacion extends NodoASTAbstract implements Sentencia {

	private AbstractExpresion izquierda;
	private AbstractExpresion derecha;

	public Asignacion(int linea, int columna, AbstractExpresion izquierda, AbstractExpresion derecha) {
		setLinea(linea);
		setColumna(columna);
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	public Asignacion(int linea, int columna, Object izquierda, Object derecha) {
		setLinea(linea);
		setColumna(columna);
		this.izquierda = (AbstractExpresion) izquierda;
		this.derecha = (AbstractExpresion) derecha;
	}

	public AbstractExpresion getIzquierda() {
		return izquierda;
	}

	public AbstractExpresion getDerecha() {
		return derecha;
	}

	@Override
	public String toString() {
		return "Asignacion [izquierda=" + izquierda.toString() + ", derecha=" + derecha.toString() + ", getLinea()="
				+ getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

}
