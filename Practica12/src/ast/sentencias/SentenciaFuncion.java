package ast.sentencias;

import java.util.List;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Sentencia;
import ast.expresiones.Variable;
import visitor.Visitor;

public class SentenciaFuncion extends NodoASTAbstract implements Sentencia {

	private List<AbstractExpresion> argumentos;
	private Variable identificador;

	public SentenciaFuncion(int linea, int columna, Variable identificador, List<AbstractExpresion> argumentos) {
		setLinea(linea);
		setColumna(columna);
		this.argumentos = argumentos;
		this.identificador = identificador;
	}

	public SentenciaFuncion(int linea, int columna, Object identificador, Object argumentos) {
		setLinea(linea);
		setColumna(columna);
		this.argumentos = (List<AbstractExpresion>) argumentos;
		this.identificador = (Variable) identificador;
	}

	@Override
	public String toString() {
		return "SentenciaFuncion [argumentos=" + argumentos + ", identificador=" + identificador + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public List<AbstractExpresion> getargumentos() {
		return argumentos;
	}

	public Variable getIdentificador() {
		return identificador;
	}

}
