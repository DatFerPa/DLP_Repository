package visitor;

import ast.AbstractExpresion;
import ast.Expresion;
import ast.Programa;
import ast.Sentencia;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.expresiones.AccesoACampo;
import ast.expresiones.AccesoArray;
import ast.expresiones.CTE_Caracter;
import ast.expresiones.CTE_Entera;
import ast.expresiones.CTE_Real;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionCompuesta;
import ast.expresiones.ExpresionFuncion;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.sentencias.Asignacion;
import ast.sentencias.Escritura;
import ast.sentencias.Lectura;
import ast.sentencias.SentenciaFuncion;
import ast.sentencias.SentenciaIf;
import ast.sentencias.SentenciaReturn;
import ast.sentencias.SentenciaWhile;
import ast.tipos.Campo;
import ast.tipos.TipoArray;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoError;
import ast.tipos.TipoFuncion;
import ast.tipos.TipoReal;
import ast.tipos.TipoStruct;
import ast.tipos.TipoVoid;

public abstract class VisitorAbstracto implements Visitor{
	
	@Override
	public Object visitar(Programa m , Object param) {
		for(Definicion def: m.getDefiniciones()) {
			def.aceptar(this, param);
		}		
		return null;
		
	}
	
	@Override
	public Object visitar(ExpresionAritmetica m, Object param) {
		//operando 1 aceptar
		m.getOperando1().aceptar(this, param);
		//operando 2 aceptar
		m.getOperando2().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		m.getOperando1().aceptar(this, param);
		m.getOperando2().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		m.getExpresion().aceptar(this, param);
		m.getTipo().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(AccesoACampo m, Object param) {
		m.getIzq().aceptar(this, param);
		m.setLvalue(true);
		return null;
	}

	@Override
	public Object visitar(AccesoArray m, Object param) {
		m.getDentro_corchetes().aceptar(this, param);
		m.getFuera_corchetes().aceptar(this, param);
		m.setLvalue(true);
		return null;
	}

	@Override
	public Object visitar(MenosUnario m, Object param) {
		m.getOperando().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(ExpresionFuncion m, Object param) {
		m.getIdentificador().aceptar(this, param);
		for(Expresion ex:m.getArgumentos()) {
			ex.aceptar(this, param);
		}
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		m.getOperando1().aceptar(this, param);
		m.getOperando2().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(Negacion m, Object param) {
		m.getExpresion().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(Campo m, Object param) {
		m.getTipo().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(SentenciaWhile m, Object param) {
		m.getCondicion().aceptar(this, param);
		for(Sentencia sn:m.getCuerpo()) {
			sn.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(SentenciaIf m, Object param) {
		m.getCondicion().aceptar(this, param);
		for(Sentencia sn:m.getCuerpo_if()) {
			sn.aceptar(this, param);
		}
		for(Sentencia sn:m.getCuerpo_else()) {
			sn.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(Asignacion m, Object param) {
		m.getDerecha().aceptar(this, param);
		m.getIzquierda().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(Escritura m, Object param) {
		for(Expresion ex : m.getExpresion()) {
			ex.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		for(AbstractExpresion ex : m.getExpresion()) {
			ex.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(SentenciaReturn m, Object param) {
		m.getExp().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(SentenciaFuncion m, Object param) {
		m.getIdentificador().aceptar(this, param);
		for(AbstractExpresion ex: m.getCuerpo()) {
			ex.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {
		for(DefVariable dfv:m.getVariablesLocales()) {
			dfv.aceptar(this, param);
		}
		for(Sentencia s: m.getLista_sentencias()) {
			s.aceptar(this, param);
		}
		m.getTipoBase().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(DefVariable m, Object param) {
		m.getTipoBase().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(TipoArray m, Object param) {
		m.getDe().aceptar(this, param);
		return null;
	}

	@Override
	public Object visitar(TipoCaracter m, Object param) {
		
		return null;
	}

	@Override
	public Object visitar(TipoEntero m, Object param) {
		
		return null;
	}

	@Override
	public Object visitar(TipoError m, Object param) {
		
		return null;
	}

	@Override
	public Object visitar(TipoFuncion m, Object param) {
		m.getTipoRetorno().aceptar(this, param);
		for(DefVariable dfv: m.getArgumentos()) {
			dfv.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(TipoReal m, Object param) {
		
		return null;
	}

	@Override
	public Object visitar(TipoStruct m, Object param) {
		for(Campo c: m.getCampos()) {
			c.aceptar(this, param);
		}
		return null;
	}

	@Override
	public Object visitar(TipoVoid m, Object param) {

		return null;
	}

	@Override
	public Object visitar(Variable m, Object param) {
		m.setLvalue(true);
		return null;
	}

	@Override
	public Object visitar(CTE_Caracter m, Object param) {
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(CTE_Real m, Object param) {
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(ExpresionCompuesta m, Object param) {
		m.getExpresionCompuesta().aceptar(this, param);
		m.getExpresionPrincipal().aceptar(this, param);
		m.setLvalue(false);
		return null;
	}

	@Override
	public Object visitar(CTE_Entera m, Object param) {
		m.setLvalue(false);
		return null;
	}


}
