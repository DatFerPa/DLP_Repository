package ast.tipos;

public class TipoArray implements Tipo {
		
	
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



	@Override
	public String toString() {
		return "TipoArray [tam=" + tam + ", de=" + de + "]";
	}
	
	
}
