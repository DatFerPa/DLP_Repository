package ast.expresiones;

import ast.Expresion;
import ast.NodoASTAbstract;

public class AccesoArray extends NodoASTAbstract implements Expresion {
		private Expresion fuera_corchetes;
		private Expresion dentro_corchetes;
		
		public AccesoArray(int linea, int columna,Expresion fuera_corchetes, Expresion dentro_corchetes) {
			super();
			this.fuera_corchetes = fuera_corchetes;
			this.dentro_corchetes = dentro_corchetes;
			setLinea(linea);
			setColumna(columna);
		}
		
		public AccesoArray(int linea, int columna,Object fuera_corchetes, Object dentro_corchetes) {
			super();
			this.fuera_corchetes = (Expresion)fuera_corchetes;
			this.dentro_corchetes = (Expresion)dentro_corchetes;
			setLinea(linea);
			setColumna(columna);
		}

		@Override
		public String toString() {
			return "AccesoArray [fuera_corchetes=" + fuera_corchetes + ", dentro_corchetes=" + dentro_corchetes
					+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
		}
		
		
		
}
