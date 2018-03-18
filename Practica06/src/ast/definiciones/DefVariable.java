package ast.definiciones;

import ast.tipos.Tipo;
import visitor.Visitor;

public class DefVariable extends DefinicionAbstracta{
	

	public DefVariable(int linea, int columna,String nombre, Tipo tipoBase) {
		super( linea, columna,nombre, tipoBase);		
	}
	
	public DefVariable(int linea, int columna,Object nombre, Object tipoBase) {
		super( linea, columna,(String)nombre, (Tipo)tipoBase);
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);	}
	
	

}
