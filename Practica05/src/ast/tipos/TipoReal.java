package ast.tipos;

public class TipoReal implements TipoRetorno {
	private static TipoReal instancia;
	
	private TipoReal() {
		
	}
	
	public static TipoReal getInstancia() {
		if(instancia == null) {
			instancia = new TipoReal();
		}
		
		return instancia;
		
	}
}
