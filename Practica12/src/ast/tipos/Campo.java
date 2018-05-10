package ast.tipos;

import ast.NodoASTAbstract;
import visitor.Visitor;

public class Campo extends NodoASTAbstract {

	private Tipo tipo;
	private String nombre;
	private int desplazamiento;

	public Campo(String nombre, Tipo tipo) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
	}

	public Campo(Object nombre, Object tipo) {
		super();
		this.tipo = (Tipo) tipo;
		this.nombre = (String) nombre;
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

	public int getdesplazamiento() {
		return desplazamiento;
	}

	public void setdesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento + getTipo().getBits();
	}

	@Override
	public String toString() {
		return "Campo [tipo=" + tipo + ", nombre=" + nombre + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

}
