package ast.sentencias;

import java.util.List;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;

public class SentenciaWhile extends NodoASTAbstract implements Sentencia {

	private Expresion condicion;
	private List<Sentencia> cuerpo;

	public SentenciaWhile(int linea, int columna, Expresion condicion, List<Sentencia> cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.condicion = condicion;
		this.cuerpo = cuerpo;
	}

	@Override
	public String toString() {
		return "SentenciaWhile [condicion=" + condicion + ", cuerpo=" + cuerpo + "]";
	}

}
