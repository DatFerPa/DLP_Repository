package ast.tipos;

import java.util.List;

import ast.definiciones.DefVariable;
import visitor.Visitor;

public class TipoFuncion implements Tipo {
		
	
	private  List<DefVariable> argumentos;
	private  Tipo tipoRetorno;

	public TipoFuncion(Tipo tipoRetorno,List<DefVariable> argumentos) {
		this.argumentos = argumentos;
		this.tipoRetorno = tipoRetorno;
	}
	
	public TipoFuncion(Object tipoRetorno,Object argumentos) {
		this.argumentos = (List<DefVariable>)argumentos;
		this.tipoRetorno = (Tipo)tipoRetorno;
	}

	@Override
	public String toString() {
		return "TipoFuncion [argumentos=" + argumentos + ", tipoRetorno=" + tipoRetorno + "]";
	}

	@Override
	public Object aceptar(Visitor visitor, Object param) {
		return visitor.visitar(this, param);
	}

	public List<DefVariable> getArgumentos() {
		return argumentos;
	}

	public Tipo getTipoRetorno() {
		return tipoRetorno;
	}


	
	
}
