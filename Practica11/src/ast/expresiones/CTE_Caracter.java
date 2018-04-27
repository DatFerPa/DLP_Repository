package ast.expresiones;

import ast.AbstractExpresion;
import ast.tipos.TipoCaracter;
import visitor.Visitor;

public class CTE_Caracter extends AbstractExpresion {

	private int valor;
	private String valorString;

	public CTE_Caracter(int linea, int columna, int valor) {
		super();
		this.valor = valor;
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoCaracter.getInstancia());
	}

	public CTE_Caracter(int linea, int columna, Object valor) {
		super();
		this.valor = Integer.parseInt(String.valueOf(valor));
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoCaracter.getInstancia());
	}

	@Override
	public String toString() {
		return "CTE_Caracter [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	public int getValor() {
		return valor;
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

}
