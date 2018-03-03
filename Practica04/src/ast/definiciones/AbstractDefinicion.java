package ast.definiciones;

import ast.tipos.Tipo;

public abstract class AbstractDefinicion implements Definicion {
	private String nombre;
	private Tipo tipo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}
