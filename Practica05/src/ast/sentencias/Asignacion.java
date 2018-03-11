package ast.sentencias;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class Asignacion extends NodoASTAbstract implements Sentencia {

	private Expresion izquierda;
	private Expresion derecha;

	public Asignacion(int linea, int columna, Expresion izquierda, Expresion derecha) {
		setLinea(linea);
		setColumna(columna);
		this.izquierda = izquierda;
		this.derecha = derecha;
	}
	
	public Asignacion(int linea, int columna, Object izquierda, Object derecha) {
		setLinea(linea);
		setColumna(columna);
		this.izquierda = (Expresion)izquierda;
		this.derecha = (Expresion)derecha;
	}

	@Override
	public String toString() {
		return "Asignacion [izquierda=" + izquierda.toString() + ", derecha=" + derecha.toString() + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

}
