package ast.definiciones;

import java.util.List;

import ast.Sentencia;
import ast.tipos.TipoFuncion;

public class DefFuncion extends DefinicionAbstracta{
	
	private List<DefVariable> variablesLocales;
	private List<Sentencia> lista_sentencias;
	
	public DefFuncion(int linea, int columna,String nombre, TipoFuncion tipoBase,List<DefVariable> variablesLocales,List<Sentencia> lista_sentencias) {
		super(nombre, tipoBase);
		this.lista_sentencias = lista_sentencias;
		this.variablesLocales = variablesLocales;	
		setLinea(linea);
		setColumna(columna);
	}

	public List<Sentencia> getLista_sentencias() {
		return lista_sentencias;
	}

	public void setLista_sentencias(List<Sentencia> lista_sentencias) {
		this.lista_sentencias = lista_sentencias;
	}

	@Override
	public String toString() {
		return "DefFuncion [lista_sentencias=" + lista_sentencias + ", getNombre()=" + getNombre() + ", getTipoBase()="
				+ getTipoBase() + "]";
	}
	
	

}
