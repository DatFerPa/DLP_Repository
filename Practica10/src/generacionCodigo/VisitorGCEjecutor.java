package generacionCodigo;

import ast.AbstractExpresion;
import ast.Programa;
import ast.Sentencia;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.sentencias.Asignacion;
import ast.sentencias.Escritura;
import ast.sentencias.Lectura;
import ast.tipos.Campo;
import ast.tipos.TipoArray;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoReal;
import ast.tipos.TipoStruct;

//aqui ejecutar
public class VisitorGCEjecutor extends VisitorOffset {

	private VisitorGCDireccion direccion;
	private VisitorGCValor valor;

	private String nombreEntrada;
	private String nombreSAlida;
	private GeneradorDeCodigo GC;

	public VisitorGCEjecutor(String nombreEntrada, String nombreSAlida) {
		GC = new GeneradorDeCodigo();
		this.nombreEntrada = nombreEntrada;
		this.nombreSAlida = nombreSAlida;
		this.GC = new GeneradorDeCodigo();
		direccion = new VisitorGCDireccion(this,this.GC);
		valor = new VisitorGCValor(this,this.GC);
		valor.setDireccion(direccion);
		direccion.setValor(valor);
	}

	@Override
	public Object visitar(Programa m, Object param) {
		GC.source(nombreEntrada,nombreSAlida);

		for (Definicion def : m.getDefiniciones()) {
			if (def instanceof DefVariable) {
				def.aceptar(this, param);
			}
		}

		GC.call("main");
		GC.halt();

		for (Definicion def : m.getDefiniciones()) {
			if (def instanceof DefFuncion) {
				def.aceptar(this, param);
			}
		}
		
		GC.closeprogram();

		return null;
	}

	@Override
	public Object visitar(Escritura m, Object param) {
		for (AbstractExpresion exp : m.getExpresion()) {
			exp.aceptar(valor, param);
			GC.out(exp.getTipo());
		}

		return null;
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		for (AbstractExpresion exp : m.getExpresion()) {
			exp.aceptar(direccion, param);
			GC.in();
			GC.store(exp.getTipo());
		}
		return null;
	}

	@Override
	public Object visitar(Asignacion m, Object param) {
		m.getIzquierda().aceptar(direccion, new Object());
		m.getDerecha().aceptar(valor, param);
		GC.store(m.getIzquierda().getTipo());
		return null;
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		m.getExpresion().aceptar(valor, param);
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
	public Object visitar(ExpresionAritmetica m, Object param) {

		m.getOperando1().aceptar(valor, param);
		if (m.getOperando1().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		m.getOperando2().aceptar(valor, param);
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
		m.getOperando1().aceptar(valor, param);
		if (m.getOperando1().getTipo() instanceof TipoCaracter) {
			GC.b2i();
		}
		m.getOperando2().aceptar(valor, param);
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
		m.getOperando().aceptar(valor, param);
		if(m.getOperando().getTipo() instanceof TipoCaracter){
			GC.b2i();
		}
		
		if(m.getOperando().getTipo() instanceof TipoReal) {
			GC.pushf("-1.0");
			GC.mul(TipoReal.getInstancia());
		}else {
			GC.pushi("-1");
			GC.mul(TipoEntero.getInstancia());
		}

		return null;
	}
	
	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		m.getOperando1().aceptar(valor, param);
		m.getOperando2().aceptar(valor, param);
		if(m.getOperador().equals("&&")) {
			GC.and();
		}else {
			GC.or();
		}		
		return null;
	}
	
	
	@Override
	public Object visitar(Negacion m, Object param) {
		m.getExpresion().aceptar(valor, param);
		GC.not();
		return null;
	}
	
	@Override
	public Object visitar(DefFuncion m, Object param) {
		GC.tag(m.getNombre());
		GC.parametros();
		for(DefVariable def:((TipoFuncion)m.getTipoBase()).getArgumentos()) {
			def.aceptar(this, param);
		}		
		GC.variablesLocales();
		int tamEnter = 0;
		for(DefVariable def : m.getVariablesLocales()) {
			def.aceptar(this, param);
			tamEnter+= def.getTipoBase().getBits();
		}
		GC.enter(tamEnter);
		for(Sentencia sent: m.getLista_sentencias()) {
			sent.aceptar(this, param);
		}
		return null;
	}
	
	@Override
	public Object visitar(DefVariable m, Object param) {
		
		GC.print("\t' var " + m.getNombre());
		m.getTipoBase().aceptar(this, param);
		GC.print(" ( offset "+m.getOffset()+" )\n");
		
		return null;
	}
	
	@Override
	public Object visitar(TipoCaracter m, Object param) {
		GC.print(" char");
		
		return null;
	}

	@Override
	public Object visitar(TipoEntero m, Object param) {
		GC.print(" int");
		
		return null;
	}
	
	@Override
	public Object visitar(TipoReal m, Object param) {
		GC.print(" float32");
		
		return null;
	}
	
	@Override
	public Object visitar(TipoArray m, Object param) {
		GC.print("["+m.getTam()+"]");
		m.getDe().aceptar(this, param);
		return null;
	}
	
	@Override
	public Object visitar(TipoStruct m, Object param) {
		GC.print(" struct{");
		for(Campo camp:m.getCampos()) {
			camp.aceptar(this, param);
		}
		GC.print("}\n");
		return null;
	}
	
	@Override
	public Object visitar(Campo m, Object param) {
		GC.print(m.getNombre());
		m.getTipo().aceptar(this, param);
		return null;
	}
	
	@Override 
	public Object visitar(Variable m,Object param) {
		//si viene de una asignacion true
		if(param != null) {
			m.aceptar(direccion, null);
		}else {
			m.aceptar(valor, null);
		}
		return null;
	}
	
	
	
	
	

}
