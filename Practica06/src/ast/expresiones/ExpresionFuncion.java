package ast.expresiones;

import java.util.List;

import ast.AbstractExpresion;
import ast.Expresion;
import visitor.Visitor;

public class ExpresionFuncion extends AbstractExpresion {
		private Variable identificador;
		private List<AbstractExpresion> argumentos;
		
		public ExpresionFuncion(int linea, int columna,Variable identificador, List<AbstractExpresion> argumentos) {
			super();
			this.identificador = identificador;
			this.argumentos = argumentos;
			setLinea(linea);
			setColumna(columna);
		}
		
		public ExpresionFuncion(int linea, int columna,Object identificador, Object argumentos) {
			super();
			this.identificador = (Variable)identificador;
			this.argumentos = (List<AbstractExpresion>)argumentos;
			setLinea(linea);
			setColumna(columna);
		}

		public Variable getIdentificador() {
			return identificador;
		}

		public List<AbstractExpresion> getArgumentos() {
			return argumentos;
		}

		@Override
		public String toString() {
			return "ExpresionFuncion [identificador=" + identificador + ", argumentos=" + argumentos + ", getLinea()="
					+ getLinea() + ", getColumna()=" + getColumna() + "]";
		}

		@Override
		public Object aceptar(Visitor visitor, Object param) {
			return visitor.visitar(this, param);
		}
		
}
