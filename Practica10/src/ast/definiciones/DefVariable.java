package ast.definiciones;

import ast.tipos.Tipo;
import visitor.Visitor;

public class DefVariable extends DefinicionAbstracta {

	// variable booleana para decir si es parametro¿?
	private boolean parametro;

	public DefVariable(int linea, int columna, String nombre, Tipo tipoBase) {
		super(linea, columna, nombre, tipoBase);
	}

	public DefVariable(int linea, int columna, Object nombre, Object tipoBase) {
		super(linea, columna, (String) nombre, (Tipo) tipoBase);
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	@Override
	public void setOffset(int offset) {

		// mirar mi ambito, si es 0 es global, si no, es local
		if (this.getAmbito() == 0) {
			// variable globales
			// nos quedamos con el tamaño anterior al nuestro (luego en el visitor,
			// pasaremos el tamaño de esta variable y la sumaremos al offset global, para
			// pasarselo a la siguiente definicion global)
			this.offset = offset;
		} else {
			if (isParametro()) {
				// parametros
				this.offset = offset;
			} else {
				// variables locales
				this.offset = (getTipoBase().getBits()*-1)+offset;
			}

		}
	}

	public boolean isParametro() {
		return parametro;
	}

	public void setParametro(boolean parametro) {
		this.parametro = parametro;
	}

}
