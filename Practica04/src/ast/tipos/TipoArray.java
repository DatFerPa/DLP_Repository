package ast.tipos;

public class TipoArray implements Tipo {
		
	
	private int tam;
	private Tipo tipo_retorno;

	public TipoArray(int tam, Tipo tipo_retorno) {
		this.tam = tam;
		this.tipo_retorno = tipo_retorno;
	}



	@Override
	public String toString() {
		return "TipoArray [tam=" + tam + ", tipo_retorno=" + tipo_retorno + "]";
	}
	
	
}
