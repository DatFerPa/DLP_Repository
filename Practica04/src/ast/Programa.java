package ast;

import java.util.List;

public class Programa extends NodoASTAbstract implements NodoAST{
	
	List<Sentencia> definiciones;
	
	public Programa(int linea, int columna, List<Definicion> definiciones, List<DefVariable> variablesLocales, List<Sentencia> cuerpoMain) {
		setColumna(columna);
		setLinea(linea);
		this.definiciones = definiciones;
		DefFuncion mi_main = new DefFuncion(linea,columna,"main",new TipoFuncion(TipoVoid.getInstancia(), new ArrayList<DefVAriable>()));
		this.definiciones.add(mi_main);
	}

	@Override
	public String toString() {
		return "Programa [definiciones=" + definiciones + "]";
	}
	
	

}
