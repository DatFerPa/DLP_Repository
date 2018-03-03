package ast.tipos;

import java.util.List;

import ast.definiciones.DefVariable;

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


	
	
}
