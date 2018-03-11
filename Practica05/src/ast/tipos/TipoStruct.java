package ast.tipos;

import java.util.List;

public class TipoStruct implements Tipo {
	
	private List<Campo> campos;
	
	public TipoStruct(List<Campo> campos) {
		this.campos = campos;
	}
	
	public TipoStruct(Object campos) {
		this.campos = (List<Campo>)campos;
	}
	

	@Override
	public String toString() {
		return "TipoStruct [campos=" + campos + "]";
	}				
}
