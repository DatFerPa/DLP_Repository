package ast.tipos;

import visitor.Visitor;

public class TipoReal extends TipoAbstracto {
	private static TipoReal instancia;

	private TipoReal() {

	}

	public static TipoReal getInstancia() {
		if (instancia == null) {
			instancia = new TipoReal();
		}

		return instancia;

	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	@Override
	public Tipo aritmetica(Tipo expresion) {
		if (expresion instanceof TipoReal) {
			return this;
		}
		return null;
	}
	
	@Override
	public Tipo equivalente(Tipo tipo) {
		if (tipo instanceof TipoReal) {
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
		if (expresion instanceof TipoReal) {
			return this;
		}
		return null;

	}

	@Override
	public Tipo aritmetica() {
		return this;

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
		return 4;
	}
}
