package ast.expresiones;

import java.util.List;

import ast.Expresion;
import ast.NodoASTAbstract;

public class ExpresionFuncion extends NodoASTAbstract implements Expresion {
		private Variable identificador;
		private List<Expresion> argumentos;
		
		public ExpresionFuncion(int linea, int columna,Variable identificador, List<Expresion> argumentos) {
			super();
			this.identificador = identificador;
			this.argumentos = argumentos;
			setLinea(linea);
			setColumna(columna);
		}

		@Override
		public String toString() {
			return "ExpresionFuncion [identificador=" + identificador + ", argumentos=" + argumentos + ", getLinea()="
					+ getLinea() + ", getColumna()=" + getColumna() + "]";
		}
		
}
