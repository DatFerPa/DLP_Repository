package ast.tipos;

public class TipoCaracter implements TipoRetorno {
	private static TipoCaracter instancia;
	
	private TipoCaracter() {
		
	}
	
	public static TipoCaracter getInstancia() {
		if(instancia == null) {
			instancia = new TipoCaracter();
		}
		
		return instancia;
		
	}
}
