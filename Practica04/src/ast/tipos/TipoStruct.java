package ast.tipos;

import java.util.List;

public class TipoStruct implements Tipo {
	
	private static TipoStruct instancia;
	private List<Campo> campos;
	
	public TipoStruct(List<Campo>campos) {
		this.campos = campos;
	}
	

	@Override
	public String toString() {
		return "TipoStruct [campos=" + campos + "]";
	}				
}
