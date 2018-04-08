package ast.tipos;

import visitor.Visitor;

public class TipoVoid extends TipoAbstracto {

	private static TipoVoid instancia;

	private TipoVoid() {

	}

	public static TipoVoid getInstancia() {
		if (instancia == null) {
			instancia = new TipoVoid();
		}

		return instancia;

	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
}
