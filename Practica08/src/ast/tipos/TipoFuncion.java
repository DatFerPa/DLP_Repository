package ast.tipos;

import java.util.List;

import ast.definiciones.DefVariable;
import visitor.Visitor;

public class TipoFuncion extends TipoAbstracto {

	private List<DefVariable> argumentos;
	private Tipo tipoRetorno;

	public TipoFuncion(Tipo tipoRetorno, List<DefVariable> argumentos) {
		this.argumentos = argumentos;
		this.tipoRetorno = tipoRetorno;
	}

	public TipoFuncion(Object tipoRetorno, Object argumentos) {
		this.argumentos = (List<DefVariable>) argumentos;
		this.tipoRetorno = (Tipo) tipoRetorno;
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

	@Override
	public Tipo parentesis(List<Tipo> argumentos) {
		if (argumentos.size() != this.argumentos.size()) {
			return null;
		}
		// a partir de aqui se presupone que tienen el mismo tamaño
		for (int i = 0; i < argumentos.size(); i++) {
			if(argumentos.get(i).getClass() != this.argumentos.get(i).getTipoBase().getClass()) {
				return null;
			}
		}

		return this.tipoRetorno;

	}

}
