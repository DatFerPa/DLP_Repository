package ast.definiciones;

import ast.NodoASTAbstract;
import ast.tipos.Tipo;

public abstract class DefinicionAbstracta extends NodoASTAbstract implements Definicion {

	private String nombre;
	private Tipo tipoBase;
	private int ambito;
	protected int offset;

	public DefinicionAbstracta(int linea, int columna, String nombre, Tipo tipoBase) {
		super();
		this.nombre = nombre;
		this.tipoBase = tipoBase;
		setLinea(linea);
		setColumna(columna);
	}

	@Override
	public String toString() {
		return "DefinicionAbstracta [nombre=" + nombre + ", tipoBase=" + tipoBase + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tipo getTipoBase() {
		return tipoBase;
	}

	public void setTipoBase(Tipo tipoBase) {
		this.tipoBase = tipoBase;
	}

	public int getAmbito() {
		return ambito;
	}

	public void setAmbito(int ambito) {
		this.ambito = ambito;
	}

	public int getOffset() {
		return offset;
	}

	public abstract void setOffset(int offset);
	/*
	 * primero vamos a mirar el ambito de nuestra defincion, si es 0, nuestra
	 * defVariable va a ser global, si no es local
	 * 
	 * 
	 */
}
