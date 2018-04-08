package ast.tipos;

import visitor.Visitor;

public class TipoArray extends TipoAbstracto {
		
	
	private int tam;
	private Tipo de;

	public TipoArray(int tam, Tipo de) {
		this.tam = tam;
		this.de = de;
	}
	
	public TipoArray(Object tam, Object de) {
		this.tam = (int)tam;
		this.de = (Tipo)de;
	}



	public Tipo getDe() {
		return de;
	}

	@Override
	public String toString() {
		return "TipoArray [tam=" + tam + ", de=" + de + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
}
