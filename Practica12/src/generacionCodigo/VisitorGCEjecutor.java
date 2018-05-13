package generacionCodigo;

import ast.AbstractExpresion;
import ast.NodoASTAbstract;
import ast.Programa;
import ast.Sentencia;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.definiciones.DefinicionAbstracta;
import ast.expresiones.ExpresionFuncion;
import ast.sentencias.Asignacion;
import ast.sentencias.Escritura;
import ast.sentencias.Lectura;
import ast.sentencias.SentenciaFuncion;
import ast.sentencias.SentenciaIf;
import ast.sentencias.SentenciaReturn;
import ast.sentencias.SentenciaWhile;
import ast.tipos.Campo;
import ast.tipos.Tipo;
import ast.tipos.TipoArray;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoReal;
import ast.tipos.TipoStruct;
import ast.tipos.TipoVoid;

//aqui ejecutar
public class VisitorGCEjecutor extends AbstractVisitorGC {

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
		direccion = new VisitorGCDireccion(this, this.GC);
		valor = new VisitorGCValor(this, this.GC);
		valor.setDireccion(direccion);
		direccion.setValor(valor);
	}

	@Override
	public Object visitar(Programa m, Object param) {
		GC.source(nombreEntrada, nombreSAlida);

		for (Definicion def : m.getDefiniciones()) {
			if (def instanceof DefVariable) {
				def.aceptar(this, param);
			}
		}

		GC.print("call main\n");
		GC.print("halt\n");

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
			GC.print("\t' * Write\n");
			exp.aceptar(valor, param);
			GC.out(exp.getTipo());
		}

		return null;
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		for (AbstractExpresion exp : m.getExpresion()) {
			GC.print("\t' * Read\n");
			exp.aceptar(direccion, param);
			GC.in(exp.getTipo());
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
	public Object visitar(DefFuncion m, Object param) {
		GC.tag(m.getNombre());
		GC.parametros();
		for (DefVariable def : ((TipoFuncion) m.getTipoBase()).getArgumentos()) {
			def.aceptar(this, param);
		}
		GC.variablesLocales();
		int tamEnter = 0;
		for (DefVariable def : m.getVariablesLocales()) {
			def.aceptar(this, param);
			tamEnter += def.getTipoBase().getBits();
		}
		GC.enter(tamEnter);
		for (Sentencia sent : m.getLista_sentencias()) {
			GC.print("#line " + ((NodoASTAbstract) sent).getLinea() + "\n");
			sent.aceptar(this, m);
		}

		if (((TipoFuncion) m.getTipoBase()).getTipoRetorno() instanceof TipoVoid) {

			int tamVariablesLocales = 0;
			for (DefVariable def : ((DefFuncion) m).getVariablesLocales()) {
				tamVariablesLocales += def.getTipoBase().getBits();
			}
			int tamParametros = 0;
			for (DefVariable def : ((TipoFuncion) ((DefFuncion) m).getTipoBase()).getArgumentos()) {
				tamParametros += def.getTipoBase().getBits();
			}

			GC.ret(0, tamVariablesLocales, tamParametros);
		}
		return null;
	}

	@Override
	public Object visitar(DefVariable m, Object param) {

		GC.print("\t' var " + m.getNombre());
		m.getTipoBase().aceptar(this, param);
		GC.print(" ( offset " + m.getOffset() + " )\n");

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
		GC.print("[" + m.getTam() + "]");
		m.getDe().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(TipoStruct m, Object param) {
		GC.print(" struct{");
		for (Campo camp : m.getCampos()) {
			camp.aceptar(this, param);
			GC.print(",  ");
		}
		GC.print("}");
		return null;
	}

	@Override
	public Object visitar(Campo m, Object param) {
		GC.print(m.getNombre());
		m.getTipo().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(SentenciaWhile m, Object param) {
		String condicionWhile = GC.getFlag() + GC.getIndiceFlag();
		GC.aumentarFlag();
		String fin_while = GC.getFlag() + GC.getIndiceFlag();
		GC.aumentarFlag();
		GC.tag(condicionWhile);
		m.getCondicion().aceptar(valor, param);
		GC.jz(fin_while);
		for (Sentencia sent : m.getCuerpo()) {
			GC.print("#line " + ((NodoASTAbstract) sent).getLinea() + "\n");
			sent.aceptar(this, param);
		}
		GC.jmp(condicionWhile);
		GC.tag(fin_while);

		return null;
	}

	@Override
	public Object visitar(SentenciaIf m, Object param) {
		String cuerpo_else = GC.getFlag() + GC.getIndiceFlag();
		GC.aumentarFlag();
		String fin_if = GC.getFlag() + GC.getIndiceFlag();
		GC.aumentarFlag();
		m.getCondicion().aceptar(valor, param);
		GC.jz(cuerpo_else);
		for (Sentencia sent : m.getCuerpo_if()) {
			GC.print("#line " + ((NodoASTAbstract) sent).getLinea() + "\n");
			sent.aceptar(this, param);
		}
		GC.jmp(fin_if);
		GC.tag(cuerpo_else);
		for (Sentencia sent : m.getCuerpo_else()) {
			GC.print("#line " + ((NodoASTAbstract) sent).getLinea() + "\n");
			sent.aceptar(this, param);
		}
		GC.tag(fin_if);
		return null;
	}

	@Override
	public Object visitar(SentenciaFuncion m, Object param) {
		for (AbstractExpresion exp : m.getargumentos()) {
			exp.aceptar(valor, param);
		}
		GC.call(m.getIdentificador().getNombre());
		Tipo tipoRet = ((TipoFuncion) m.getIdentificador().getTipo()).getTipoRetorno();
		GC.pop(tipoRet);

		return null;
	}

	@Override
	public Object visitar(ExpresionFuncion m, Object param) {

		return null;
	}

	@Override
	public Object visitar(SentenciaReturn m, Object param) {
		m.getExp().aceptar(valor, param);
		Tipo tipoRet = ((TipoFuncion) ((DefFuncion) param).getTipoBase()).getTipoRetorno();
		int tamRet;
		if (tipoRet instanceof TipoEntero) {
			tamRet = 2;
		} else if (tipoRet instanceof TipoCaracter) {
			tamRet = 1;
		} else if (tipoRet instanceof TipoReal) {
			tamRet = 4;
		} else if (tipoRet instanceof TipoVoid) {
			tamRet = 0;
		} else {
			throw new RuntimeException("El parametro que se ha pasado no es un tipo que se pueda retornar");
		}
		int tamVariablesLocales = 0;
		for (DefVariable def : ((DefFuncion) param).getVariablesLocales()) {
			tamVariablesLocales += def.getTipoBase().getBits();
		}
		int tamParametros = 0;
		for (DefVariable def : ((TipoFuncion) ((DefFuncion) param).getTipoBase()).getArgumentos()) {
			tamParametros += def.getTipoBase().getBits();
		}
		GC.ret(tamRet, tamVariablesLocales, tamParametros);
		return null;
	}

}
