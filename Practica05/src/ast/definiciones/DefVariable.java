package ast.definiciones;

import ast.tipos.Tipo;

public class DefVariable extends DefinicionAbstracta{
	

	public DefVariable(int linea, int columna,String nombre, Tipo tipoBase) {
		super( linea, columna,nombre, tipoBase);		
	}
	
	public DefVariable(int linea, int columna,Object nombre, Object tipoBase) {
		super( linea, columna,(String)nombre, (Tipo)tipoBase);
	}
	
	

}
