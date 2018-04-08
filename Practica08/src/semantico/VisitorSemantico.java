package semantico;

import ast.AbstractExpresion;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.Variable;
import ast.sentencias.Asignacion;
import ast.sentencias.Lectura;
import ast.tipos.TipoError;
import visitor.VisitorAbstracto;

public class VisitorSemantico extends VisitorAbstracto {

	@Override
	public Object visitar(Asignacion m, Object param) {
		super.visitar(m, param);
		if (!m.getIzquierda().isLvalue()) {
			new TipoError(m.getIzquierda(), "Lvalue required");
		}
		//cambiar igual
		if(m.getIzquierda().getTipo().equivalente(m.getDerecha().getTipo())==null) {
			new TipoError(m,"El tipo de no coincide");
		}
		return null;
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		super.visitar(m, param);
		for (AbstractExpresion ex : m.getExpresion()) {
			if (!ex.isLvalue()) {
				new TipoError(ex, "Lvalue required");
			}
		}
		return null;
	}

	@Override
	public Object visitar(AccesoACampo m, Object param) {
		m.setLvalue(true);
		super.visitar(m, param);
		return null;
	}

	@Override
	public Object visitar(AccesoArray m, Object param) {
		m.setLvalue(true);
		super.visitar(m, param);
		return null;
	}

	@Override
	public Object visitar(Variable m, Object param) {
		m.setLvalue(true);
		super.visitar(m, param);
		return null;
	}

}
