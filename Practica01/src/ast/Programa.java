package ast;

import java.util.List;

public class Programa extends NodoASTAbstract implements NodoAST{
	
	List<Sentencia> sentencias;
	
	public Programa(int linea, int columna, List<Sentencia> sentencias) {
		setColumna(columna);
		setLinea(linea);
		this.sentencias = sentencias;
	}

	@Override
	public String toString() {
		return "Programa [sentencias=" + sentencias + "]";
	}
	
	

}
