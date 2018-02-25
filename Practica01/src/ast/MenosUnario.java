package ast;

public class MenosUnario extends NodoASTAbstract implements Expresion {
	
	private Expresion operando;
	
	public MenosUnario(int linea,int columna,Expresion operando) {
		setLinea(linea);
		setColumna(columna);
		this.operando = operando;
	}

	@Override
	public String toString() {
		return "MenosUnario [operando=" + operando.toString() + ", getLinea()=" + getLinea() + ", getColumna()=" + getColumna()
				+ "]";
	}
	

}
