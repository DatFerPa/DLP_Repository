package ast.tipos;

import visitor.Visitor;

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

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
}
