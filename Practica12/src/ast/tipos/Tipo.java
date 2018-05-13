package ast.tipos;

import java.util.List;

import ast.NodoAST;

public interface Tipo extends NodoAST {

	//
	public Tipo aritmetica(Tipo expresion);// tenemos el tipo implicito y la expresion

	public Tipo aritmetica();//menos unario

	public Tipo comparacion(Tipo expresion);

	public Tipo logica();//negacion

	public Tipo logica(Tipo expresion); //int

	public Tipo cast(Tipo destino);

	public Tipo punto(String campo);// el Tipo, es implicito, ya que lo modificamos en la de TipoStruct

	public Tipo corchetes(Tipo indice);// miramos que el indice sea entero y tipo implicito tiene que ser error

	public Tipo parentesis(List<Tipo> argumentos);// usamos en funcion, si se cumple, devolvemos el tipo de retorno

	// sentencias    
	public Tipo equivalente(Tipo tipo);// para la asignacion izq.tipo.equivalente(dch.tipo) ; también en la lectura y
										// en el return

	public boolean esLogica();// interviene el objeto implcito ; en sentencia IF y WHILE. por defecto falso;
								// retornamos true en Tipo int y tipo caracter
	
	
	public int getBits();
	
	
	
	//solo para buscar el desplazamiento de un campo
	public int desplazamiento(String nombre);
	
	public Tipo tipoAccesoCampo(String nombre);
}
