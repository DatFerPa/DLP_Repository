package ast.sentencias;

import java.util.List;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import visitor.Visitor;

public class SentenciaWhile extends NodoASTAbstract implements Sentencia {

	private AbstractExpresion condicion;
	private List<Sentencia> cuerpo;

	public SentenciaWhile(int linea, int columna, AbstractExpresion condicion, List<Sentencia> cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.condicion = condicion;
		this.cuerpo = cuerpo;
	}
	
	public SentenciaWhile(int linea, int columna, Object condicion, Object cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.condicion = (AbstractExpresion)condicion;
		this.cuerpo = (List<Sentencia>)cuerpo;
	}

	public AbstractExpresion getCondicion() {
		return condicion;
	}

	public List<Sentencia> getCuerpo() {
		return cuerpo;
	}

	@Override
	public String toString() {
		return "SentenciaWhile [condicion=" + condicion + ", cuerpo=" + cuerpo + ", getLinea()=" + getLinea()
				+ ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	

}
