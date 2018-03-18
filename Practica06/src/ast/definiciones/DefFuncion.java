package ast.definiciones;

import java.util.List;

import ast.Sentencia;
import ast.tipos.TipoFuncion;
import visitor.Visitor;

public class DefFuncion extends DefinicionAbstracta{
	
	private List<DefVariable> variablesLocales;
	private List<Sentencia> lista_sentencias;
	
	public DefFuncion(int linea, int columna,String nombre, TipoFuncion tipoBase,List<DefVariable> variablesLocales,List<Sentencia> lista_sentencias) {
		super( linea, columna,nombre, tipoBase);
		this.lista_sentencias = lista_sentencias;
		this.variablesLocales = variablesLocales;	
		
	}
	
	public DefFuncion(int linea, int columna,Object nombre, Object tipoBase,Object variablesLocales,Object lista_sentencias) {
		super( linea, columna,(String)nombre, (TipoFuncion)tipoBase);
		this.lista_sentencias = (List<Sentencia>)lista_sentencias;
		this.variablesLocales = (List<DefVariable>) variablesLocales;	
		
	}

	public List<Sentencia> getLista_sentencias() {
		return lista_sentencias;
	}
		
	public List<DefVariable> getVariablesLocales() {
		return variablesLocales;
	}

	@Override
	public String toString() {
		return "DefFuncion [lista_sentencias=" + lista_sentencias + ", getNombre()=" + getNombre() + ", getTipoBase()="
				+ getTipoBase() + "]";
	}
	
	

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	

}
