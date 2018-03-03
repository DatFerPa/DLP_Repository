package ast.sentencias;

import java.util.List;

import ast.Expresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import ast.expresiones.Variable;

public class SentenciaFuncion extends NodoASTAbstract implements Sentencia {
	
	private List<Expresion> cuerpo;
	private Variable identificador;
	
	public SentenciaFuncion (int linea, int columna, Variable identificador, List<Expresion> cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.cuerpo = cuerpo;
		this.identificador = identificador;
	}

	@Override
	public String toString() {
		return "SentenciaFuncion [cuerpo=" + cuerpo + ", identificador=" + identificador + "]";
	}
	
	
	

}
