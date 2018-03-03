package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class CTE_Caracter extends NodoASTAbstract implements Expresion {

		private String valor;

		public CTE_Caracter(int linea, int columna,String valor) {
			super();
			this.valor = valor;
			setLinea(linea);
			setColumna(columna);
		}

		@Override
		public String toString() {
			return "CTE_Caracter [valor=" + valor + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
					+ "]";
		}
		
		
}
