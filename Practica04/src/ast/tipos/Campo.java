package ast.tipos;

import java.util.List;

import ast.NodoASTAbstract;

public class Campo extends NodoASTAbstract {
	
	private List<Tipo> tipos;
	private String nombre;
		
	public Campo(List<Tipo> tipos, String nombre) {
		super();
		this.tipos = tipos;
		this.nombre = nombre;
	}
	
	public List<Tipo> getTipos() {
		return tipos;
	}
	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Campo [tipos=" + tipos + ", nombre=" + nombre + "]";
	}
	
	

}
