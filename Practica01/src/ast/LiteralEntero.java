package ast;

public class LiteralEntero extends NodoASTAbstract implements Expresion {
	private int valor;
	public LiteralEntero (int linea, int columna, int valor) {
		setLinea(linea);
		setColumna(columna);
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "LiteralEntero [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}
	
	
}
