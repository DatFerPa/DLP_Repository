package ast.tipos;

import visitor.Visitor;

public class TipoEntero extends TipoAbstracto {

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

	@Override
	public Tipo aritmetica(Tipo expresion) {
		if(expresion instanceof TipoEntero) {
			return this;
		}
		return null;
	}
	
	@Override
	public Tipo equivalente(Tipo tipo) {
		if(tipo instanceof TipoEntero) {
			return this;
		}else {
			return null;
		}
	}
	
	@Override
	public boolean esLogica() {
		return true;
	}
	
	@Override
	public Tipo logica(Tipo expresion) {
		if(expresion instanceof TipoEntero) {
			return this;
		}
		return null;

	}
	
	@Override
	public Tipo logica() {
		return this;

	}
	
	@Override
	public Tipo comparacion(Tipo expresion) {

		// instanceof
		if (expresion instanceof TipoError) {
			return expresion;
		}
		if(expresion instanceof TipoEntero) {
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
		if(destino instanceof TipoEntero) {
			return TipoEntero.getInstancia();
		}
		else if(destino instanceof TipoCaracter) {
			return TipoCaracter.getInstancia();
		}else if(destino instanceof TipoReal) {
			return TipoReal.getInstancia();
		}else {
			return null;
		}
	}
}
