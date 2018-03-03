package ast.tipos;

import java.util.List;

import ast.NodoASTAbstract;

public class Campo extends NodoASTAbstract {
	
	private Tipo tipo;
	private String nombre;
		
	public Campo( String nombre,Tipo tipo) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public Campo( Object nombre,Object tipo) {
		super();
		this.tipo = (Tipo)tipo;
		this.nombre = (String)nombre;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipos(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Campo [tipo=" + tipo + ", nombre=" + nombre + "]";
	}
	
	

}
