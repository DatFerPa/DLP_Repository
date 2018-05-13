package ast.tipos;

import java.util.List;

import ast.NodoASTAbstract;

public abstract class TipoAbstracto extends NodoASTAbstract implements Tipo {

	@Override
	public Tipo aritmetica(Tipo expresion) {
		return null;
	}

	@Override
	public Tipo aritmetica() {
		return null;

	}

	@Override
	public Tipo comparacion(Tipo expresion) {

		// instanceof
		if (expresion instanceof TipoError) {
			return expresion;
		}
		return null;// cuando lo llame desde el visitor
		// devuelva el null, hago allí la llamada al new Tipo Error, para usar ese nodo
		// AST, con la linea y la columna correctas

	}

	@Override
	public Tipo logica() {
		return null;

	}

	@Override
	public Tipo logica(Tipo expresion) {
		return null;

	}

	@Override
	public Tipo cast(Tipo destino) {
		return null;

	}

	@Override
	public Tipo punto(String campo) {
		return null;
	}

	@Override
	public Tipo corchetes(Tipo indice) {
		return new TipoError((TipoAbstracto) indice, "no es un tipo array");

	}

	@Override
	public Tipo parentesis(List<Tipo> argumentos) {
		return null;

	}

	@Override
	public Tipo equivalente(Tipo tipo) {
		return null;

	}
	
	@Override
	public boolean esLogica() {
		return false;
	}
	
	@Override
	public int getBits() {
		new TipoError(this,"Implementacion de getBits() nula");
		return -1;
	}
	
	@Override 
	public int desplazamiento(String nombre) {
		throw new RuntimeException("El desplazamiento no se puede encontrar fuera de un tipo Struct");
	}
	
	@Override
	public Tipo tipoAccesoCampo(String nombre) {
		throw new RuntimeException("No se puede realizar el acceso a un campo si no se es un tipo Struct");
	}

	
}
