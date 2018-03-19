package ast.tipos;

import visitor.Visitor;

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

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
}
