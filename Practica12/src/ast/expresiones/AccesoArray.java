package ast.expresiones;

import ast.AbstractExpresion;
import visitor.Visitor;

public class AccesoArray extends AbstractExpresion {
		private AbstractExpresion fuera_corchetes;
		private AbstractExpresion dentro_corchetes;
		
		public AccesoArray(int linea, int columna,AbstractExpresion fuera_corchetes, AbstractExpresion dentro_corchetes) {
			super();
			this.fuera_corchetes = fuera_corchetes;
			this.dentro_corchetes = dentro_corchetes;
			setLinea(linea);
			setColumna(columna);
		}
		
		public AccesoArray(int linea, int columna,Object fuera_corchetes, Object dentro_corchetes) {
			super();
			this.fuera_corchetes = (AbstractExpresion)fuera_corchetes;
			this.dentro_corchetes = (AbstractExpresion)dentro_corchetes;
			setLinea(linea);
			setColumna(columna);
		}

		@Override
		public String toString() {
			return "AccesoArray [fuera_corchetes=" + fuera_corchetes + ", dentro_corchetes=" + dentro_corchetes
					+ ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna() + "]";
		}

		@Override
		public Object aceptar(Visitor visitor, Object param) {
			return visitor.visitar(this, param);
		}

		public AbstractExpresion getFuera_corchetes() {
			return fuera_corchetes;
		}

		public AbstractExpresion getDentro_corchetes() {
			return dentro_corchetes;
		}
		
		
		
}
