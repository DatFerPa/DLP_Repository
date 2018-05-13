package generacionCodigo;

import ast.AbstractExpresion;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.CTE_Caracter;
import ast.expresiones.CTE_Entera;
import ast.expresiones.CTE_Real;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionFuncion;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.tipos.TipoArray;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoReal;

public class VisitorGCValor extends AbstractVisitorGC {

	private VisitorGCEjecutor ejecutar;
	private VisitorGCDireccion direccion;
	private GeneradorDeCodigo GC;

	public VisitorGCValor(VisitorGCEjecutor ejecutar, GeneradorDeCodigo GC) {
		this.ejecutar = ejecutar;
		this.GC = GC;
	}

	public void setDireccion(VisitorGCDireccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public Object visitar(ExpresionAritmetica m, Object param) {
		m.getOperando1().aceptar(this, param);
		if (m.getOperando1().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		m.getOperando2().aceptar(this, param);
		if (m.getOperando2().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		if (m.getOperador().equals("+")) {
			GC.add(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("*")) {
			GC.mul(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("-")) {
			GC.sub(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("/")) {
			GC.div(m.getOperando1().getTipo());
		} else {
			GC.mod(m.getOperando1().getTipo());
		}
		return null;
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		m.getOperando1().aceptar(this, param);
		if (m.getOperando1().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		m.getOperando2().aceptar(this, param);
		if (m.getOperando2().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		if (m.getOperador().equals(">")) {
			GC.gt(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("<")) {
			GC.lt(m.getOperando1().getTipo());
		} else if (m.getOperador().equals(">=")) {
			GC.ge(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("<=")) {
			GC.le(m.getOperando1().getTipo());
		} else if (m.getOperador().equals("==")) {
			GC.eq(m.getOperando1().getTipo());
		} else {
			GC.ne(m.getOperando1().getTipo());
		}
		return null;

	}

	@Override
	public Object visitar(MenosUnario m, Object param) {
		m.getOperando().aceptar(this, param);
		if (m.getOperando().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}

		if (m.getOperando().getTipo() instanceof TipoReal) {
			GC.pushf("-1.0");
			GC.mul(TipoReal.getInstancia());
		} else {
			GC.pushi("-1");
			GC.mul(TipoEntero.getInstancia());
		}
		return null;
	}

	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		m.getOperando1().aceptar(this, param);
		m.getOperando2().aceptar(this, param);
		if (m.getOperador().equals("&&")) {
			GC.and();
		} else {
			GC.or();
		}
		return null;
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		m.getExpresion().aceptar(this, param);
		if (((AbstractExpresion) m.getExpresion()).getTipo() instanceof TipoReal) {
			if (m.getTipoDestino() instanceof TipoEntero) {
				GC.f2i();
			} else if (m.getTipoDestino() instanceof TipoCaracter) {
				GC.f2i();
				GC.i2b();
			}

		} else if (((AbstractExpresion) m.getExpresion()).getTipo() instanceof TipoEntero) {
			if (m.getTipoDestino() instanceof TipoReal) {
				GC.i2f();
			} else if (m.getTipoDestino() instanceof TipoCaracter) {
				GC.i2b();
			}
		} else {
			if (m.getTipoDestino() instanceof TipoEntero) {
				GC.b2i();
			} else if (m.getTipoDestino() instanceof TipoReal) {
				GC.b2i();
				GC.i2f();
			}
		}
		return null;
	}

	@Override
	public Object visitar(Negacion m, Object param) {
		m.getExpresion().aceptar(this, param);
		GC.not();
		return null;
	}

	@Override
	public Object visitar(CTE_Caracter m, Object param) {
		GC.pushValor(m.getTipo(), String.valueOf(m.getValor()));
		return null;
	}

	@Override
	public Object visitar(CTE_Real m, Object param) {
		GC.pushValor(m.getTipo(), String.valueOf(m.getValor()));
		return null;
	}

	@Override
	public Object visitar(CTE_Entera m, Object param) {
		GC.pushValor(m.getTipo(), String.valueOf(m.getValor()));
		return null;
	}

	@Override
	public Object visitar(Variable m, Object param) {
		m.aceptar(direccion, param);
		GC.load(m.getTipo());
		return null;
	}
	
	@Override
	public Object visitar(AccesoACampo m, Object param) {
		m.aceptar(direccion,param);
		GC.load(m.getIzq().getTipo().tipoAccesoCampo(m.getNombre()));		
		return null;
	}
	
	
	@Override
	public Object visitar(AccesoArray m,Object param) {
		m.aceptar(direccion, param);
		GC.load(((TipoArray)m.getFuera_corchetes().getTipo()).getDe());
		return null;
	}
	
	@Override
	public Object visitar(ExpresionFuncion m,Object param) {
		for(AbstractExpresion exp:m.getArgumentos()) {
			exp.aceptar(this, param);
		}
		GC.call(m.getIdentificador().getNombre());
		return null;
	}

}
