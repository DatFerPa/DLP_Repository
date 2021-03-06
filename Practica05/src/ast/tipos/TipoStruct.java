package ast.tipos;

import java.util.List;

import ast.expresiones.Variable;

public class TipoStruct implements Tipo {
	
	private List<Campo> campos;
	
	public TipoStruct(List<Campo> campos) {
		this.campos = campos;
		comprobarCampos();
	}
	
	public TipoStruct(Object campos) {
		this.campos = (List<Campo>)campos;
		comprobarCampos();
	}
	
	private void comprobarCampos() {
		for(int i = 0; i< campos.size();i++) {
			for(int j = 0; j < campos.size();j++) {
				if(i!=j && i<j && campos.get(i).getNombre().equals(campos.get(j).getNombre())) {
					new TipoError(campos.get(i),"Campo duplicada");
				}
			}
		}
	}
	

	@Override
	public String toString() {
		return "TipoStruct [campos=" + campos + "]";
	}				
}
