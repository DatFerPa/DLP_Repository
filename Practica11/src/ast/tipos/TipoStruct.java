package ast.tipos;

import java.util.List;

import ast.expresiones.Variable;
import visitor.Visitor;

public class TipoStruct extends TipoAbstracto {
	
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
	

	public List<Campo> getCampos() {
		return campos;
	}

	@Override
	public String toString() {
		return "TipoStruct [campos=" + campos + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	@Override
	public Tipo punto(String campo) {
		for(Campo c:campos) {
			if(campo.equals(c.getNombre())) {
				return c.getTipo();
			}
		}
		return null;
	}
	
	@Override
	public int getBits() {
		int tamTotal = 0;
		for (Campo camp : campos) {
			camp.setdesplazamiento(tamTotal);
			tamTotal += camp.getTipo().getBits();
		}
		return tamTotal;
	}
	
	@Override 
	public int desplazamiento(String nombre) {
		for(Campo c:campos) {
			if(nombre.equals(c.getNombre())) {
				return c.getdesplazamiento();
			}
		}
		throw new RuntimeException("El campo que se est� buscando no exite");
	}
	
	
}
