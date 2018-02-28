package ast;

public class Lectura extends NodoASTAbstract implements Sentencia {

	private Expresion expresion;

	public Lectura(int linea, int columna, Expresion expresion) {
		setColumna(columna);
		setLinea(linea);
		this.expresion = expresion;
	}

	@Override
	public String toString() {
		return "Lectura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	
}
