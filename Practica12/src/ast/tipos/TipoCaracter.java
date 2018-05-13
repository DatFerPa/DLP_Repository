package ast.tipos;

import visitor.Visitor;

public class TipoCaracter extends TipoAbstracto {
	private static TipoCaracter instancia;

	private TipoCaracter() {

	}

	public static TipoCaracter getInstancia() {
		if (instancia == null) {
			instancia = new TipoCaracter();
		}

		return instancia;

	}
	
	@Override
	public Tipo aritmetica(Tipo expresion) {
		if (expresion instanceof TipoCaracter) {
			return TipoEntero.getInstancia();
		}
		return null;
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	@Override
	public Tipo equivalente(Tipo tipo) {
		if (tipo instanceof TipoCaracter) {
			return this;
		} else {
			return null;
		}
	}

	@Override
	public Tipo comparacion(Tipo expresion) {

		// instanceof
		if (expresion instanceof TipoError) {
			return expresion;
		}
		if (expresion instanceof TipoCaracter) {
			return this;
		}
		return null;

	}

	@Override
	public Tipo cast(Tipo destino) {
		if (destino instanceof TipoEntero) {
			return TipoEntero.getInstancia();
		} else if (destino instanceof TipoCaracter) {
			return TipoCaracter.getInstancia();
		} else if (destino instanceof TipoReal) {
			return TipoReal.getInstancia();
		} else {
			return null;
		}
	}

	@Override
	public int getBits() {
		return 1;
	}

}
