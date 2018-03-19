package ast.tipos;

import visitor.Visitor;

public class TipoEntero implements TipoRetorno {

	private static TipoEntero instancia;

	private TipoEntero() {

	}

	public static TipoEntero getInstancia() {
		if (instancia == null) {
			instancia = new TipoEntero();
		}

		return instancia;

	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
}
