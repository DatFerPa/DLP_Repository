package ast.expresiones;

import ast.AbstractExpresion;
import ast.tipos.TipoReal;
import visitor.Visitor;

public class CTE_Real extends AbstractExpresion {
	private float valor;

	public CTE_Real(int linea, int columna,float valor) {
		super();
		this.valor = valor;
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoReal.getInstancia());
	}
	
	public CTE_Real(int linea, int columna,Object valor) {
		super();
		this.valor = Float.parseFloat((String)valor);
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoReal.getInstancia());
	}

	@Override
	public String toString() {
		return "CTE_Real [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	};
	
	public float getValor() {
		return valor;
	}
	
}
