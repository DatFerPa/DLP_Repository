package ast.definiciones;

import ast.tipos.Tipo;

public class DefVariable extends DefinicionAbstracta{

	public DefVariable(String nombre, Tipo tipoBase) {
		super(nombre, tipoBase);
	}
	
	public DefVariable(Object nombre, Object tipoBase) {
		super((String)nombre, (Tipo)tipoBase);
	}

}
