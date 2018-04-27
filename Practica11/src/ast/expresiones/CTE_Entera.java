package ast.expresiones;

import ast.AbstractExpresion;
import ast.tipos.TipoEntero;
import visitor.Visitor;

public class CTE_Entera extends AbstractExpresion {
	private int valor;
	public CTE_Entera (int linea, int columna, int valor) {
		setLinea(linea);
		setColumna(columna);
		this.valor = valor;
		setTipo(TipoEntero.getInstancia());
	}
	
	public CTE_Entera (int linea, int columna, Object valor) {
		setLinea(linea);
		setColumna(columna);
		this.valor = Integer.parseInt((String)valor);
		setTipo(TipoEntero.getInstancia());
	}
	@Override
	public String toString() {
		return "LiteralEntero [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	public int getValor() {
		return valor;
	}
	
}
