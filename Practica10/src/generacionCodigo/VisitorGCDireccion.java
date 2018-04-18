package generacionCodigo;

import ast.definiciones.DefinicionAbstracta;
import ast.expresiones.Variable;
import ast.tipos.TipoEntero;

public class VisitorGCDireccion extends VisitorOffset {

	private VisitorGCEjecutor ejecutar;
	private VisitorGCValor valor;
	private GeneradorDeCodigo GC;

	public VisitorGCDireccion(VisitorGCEjecutor ejecutar, GeneradorDeCodigo GC) {
		this.ejecutar = ejecutar;
		this.GC = GC;
	}

	public void setValor(VisitorGCValor valor) {
		this.valor = valor;
	}

	@Override
	public Object visitar(Variable m, Object param) {
		if (((DefinicionAbstracta) m.getDefinicion()).getAmbito() != 0) {
			GC.bp();
			GC.pushValor(TipoEntero.getInstancia(),String.valueOf(((DefinicionAbstracta) m.getDefinicion()).getOffset()));
			GC.add(TipoEntero.getInstancia());
		}else {
			GC.pusha(String.valueOf(((DefinicionAbstracta) m.getDefinicion()).getOffset()));
		}
		
		return null;
	}

}
