package ast;

import java.util.ArrayList;
import java.util.List;

import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoVoid;
import visitor.Visitor;

public class Programa extends NodoASTAbstract implements NodoAST{
	
	List<Definicion> definiciones;
		
	public Programa(int linea, int columna, List<Definicion> definiciones, List<DefVariable> variablesLocales, List<Sentencia> cuerpoMain) {
		setColumna(columna);
		setLinea(linea);
		this.definiciones = definiciones;
		
		DefFuncion mi_main = new DefFuncion(linea,columna,"main",new TipoFuncion(TipoVoid.getInstancia(), new ArrayList<DefVariable>()),variablesLocales,cuerpoMain);
		this.definiciones.add(mi_main);
	}

	@Override
	public String toString() {
		return "Programa [definiciones=" + definiciones + "]";
	}

	public List<Definicion> getDefiniciones() {
		return definiciones;
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}
	
	
	
	

}
