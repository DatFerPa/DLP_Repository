package ast.expresiones;

import ast.AbstractExpresion;
import visitor.Visitor;

public class CTE_Caracter extends AbstractExpresion {

		private String valor;

		public CTE_Caracter(int linea, int columna,String valor) {
			super();
			this.valor = valor;
			setLinea(linea);
			setColumna(columna);
		}
		
		public CTE_Caracter(int linea, int columna,Object valor) {
			super();
			this.valor = (String)valor;
			setLinea(linea);
			setColumna(columna);
		}

		@Override
		public String toString() {
			return "CTE_Caracter [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
					+ "]";
		}

		@Override
		public Object aceptar(Visitor visitor, Object param) {
			return visitor.visitar(this, param);
		}
		
		
}
