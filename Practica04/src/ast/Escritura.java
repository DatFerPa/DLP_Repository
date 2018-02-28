package ast;

public class Escritura extends NodoASTAbstract implements Sentencia{
	private Expresion expresion;
	
	public Escritura(int linea, int columna,Expresion expresion) {
		setLinea(linea);
		setColumna(columna);
		this.expresion = expresion;
	}

	@Override
	public String toString() {
		return "Escritura [expresion=" + expresion.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	
	
}
