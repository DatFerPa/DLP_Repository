package ast.tipos;

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
}
