package ast.tipos;

public class TipoVoid implements TipoRetorno {

	private static TipoVoid instancia;

	private TipoVoid() {

	}

	public static TipoVoid getInstancia() {
		if (instancia == null) {
			instancia = new TipoVoid();
		}

		return instancia;

	}
}
