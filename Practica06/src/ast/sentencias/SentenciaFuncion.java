package ast.sentencias;

import java.util.List;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import ast.expresiones.Variable;
import visitor.Visitor;

public class SentenciaFuncion extends NodoASTAbstract implements Sentencia {
	
	private List<AbstractExpresion> cuerpo;
	private Variable identificador;
	
	public SentenciaFuncion (int linea, int columna, Variable identificador, List<AbstractExpresion> cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.cuerpo = cuerpo;
		this.identificador = identificador;
	}
	
	public SentenciaFuncion (int linea, int columna, Object identificador, Object cuerpo) {
		setLinea(linea);
		setColumna(columna);
		this.cuerpo = (List<AbstractExpresion>) cuerpo;
		this.identificador = (Variable) identificador;
	}

	@Override
	public String toString() {
		return "SentenciaFuncion [cuerpo=" + cuerpo + ", identificador=" + identificador + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public List<AbstractExpresion> getCuerpo() {
		return cuerpo;
	}

	public Variable getIdentificador() {
		return identificador;
	}
	
	
	

}
