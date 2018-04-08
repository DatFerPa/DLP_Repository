package ast;

public abstract class NodoASTAbstract implements NodoAST{
	private int linea;
	private int columna;
	
	public int getLinea() {
		return linea;
	}
	public int getColumna() {
		return columna;
	}
	public void setLinea(int linea) {
		this.linea = linea;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
		

}
