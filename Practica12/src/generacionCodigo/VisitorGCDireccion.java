package generacionCodigo;

import ast.definiciones.DefinicionAbstracta;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.Variable;
import ast.tipos.TipoArray;
import ast.tipos.TipoEntero;

public class VisitorGCDireccion extends AbstractVisitorGC {

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
	
	@Override
	public Object visitar(AccesoACampo m, Object param) {
		m.getIzq().aceptar(this, param);
		GC.pushi(String.valueOf(m.getIzq().getTipo().desplazamiento(m.getNombre())));
		GC.add(TipoEntero.getInstancia());
		return null;
	}
	
	
	@Override
	public Object visitar(AccesoArray m,Object param) {
		m.getFuera_corchetes().aceptar(this, param);
		m.getDentro_corchetes().aceptar(valor, param);
		if(m.getFuera_corchetes().getTipo() instanceof TipoArray) {
			GC.pushi(String.valueOf(((TipoArray)m.getFuera_corchetes().getTipo()).getDe().getBits()));
		}else {
			GC.pushi(String.valueOf(m.getFuera_corchetes().getTipo().getBits()));
		}
		GC.mul(TipoEntero.getInstancia());
		GC.add(TipoEntero.getInstancia());		
		return null;
	}
	

}
