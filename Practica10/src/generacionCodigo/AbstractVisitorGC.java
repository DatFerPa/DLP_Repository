package generacionCodigo;

import ast.Programa;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
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
import visitor.Visitor;

public abstract class AbstractVisitorGC implements Visitor {

	@Override
	public Object visitar(ExpresionAritmetica m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"ExpresionAritmetica\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Comparacion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"ExpresionCast\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(AccesoACampo m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"AccesoACampo\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(AccesoArray m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"AccesoArray\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(MenosUnario m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"MenosUnario\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"ExpresionFuncion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"ExpresionLogica\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Negacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Negacion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Campo m, Object param) {
		throw new IllegalAccessError("Plantilla de generación de código \"Campo\" no definida para la funcion de código"
				+ this.getClass().getName());
	}

	@Override
	public Object visitar(Variable m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Variable\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Caracter m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"CTE_Caracter\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Real m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"CTE_Real\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Entera m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"CTE_Entera\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaWhile m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"SentenciaWhile\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaIf m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"SentenciaIf\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Asignacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Asignacion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Escritura m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Escritura\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Lectura\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaReturn m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"SentenciaReturn\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"SentenciaFuncion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Programa m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"Programa\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"DefFuncion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(DefVariable m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"DefVariable\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoArray m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoArray\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoCaracter m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoCaracter\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoEntero m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoEntero\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoError m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoError\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoFuncion\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoReal m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoReal\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoStruct m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoStruct\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoVoid m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generación de código \"TipoVoid\" no definida para la funcion de código"
						+ this.getClass().getName());
	}

}
