package ast.expresiones;

import ast.AbstractExpresion;
import ast.tipos.TipoCaracter;
import visitor.Visitor;

public class CTE_Caracter extends AbstractExpresion {

	private int valor;
	private String valorString;

	public CTE_Caracter(int linea, int columna, String valorS) {
		super();
		this.valorString = valorS;
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoCaracter.getInstancia());
		definirValor();
	}

	public CTE_Caracter(int linea, int columna, Object valorS) {
		super();
		this.valorString = (String) valorS;
		setLinea(linea);
		setColumna(columna);
		setTipo(TipoCaracter.getInstancia());
		definirValor();
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
	
	private void definirValor() {
		if(valorString.length() == 3) {			
			this.valor = Integer.valueOf(valorString.charAt(1));
		}else {
			this.valor = Integer.valueOf(valorString.charAt(1)+valorString.charAt(2));
		}
	}

}
