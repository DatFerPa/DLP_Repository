package semantico;

import ast.AbstractExpresion;
import ast.Expresion;
import ast.sentencias.Asignacion;
import ast.sentencias.Escritura;
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

}
