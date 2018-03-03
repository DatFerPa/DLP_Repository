package ast.sentencias;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import ast.expresiones.Variable;

public class Asignacion extends NodoASTAbstract implements Sentencia {

	private Variable izquierda;
	private Expresion derecha;

	public Asignacion(int linea, int columna, Variable izquierda, Expresion derecha) {
		setLinea(linea);
		setColumna(columna);
		this.izquierda = izquierda;
		this.derecha = derecha;
	}

	@Override
	public String toString() {
		return "Asignacion [izquierda=" + izquierda.toString() + ", derecha=" + derecha.toString() + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

}
