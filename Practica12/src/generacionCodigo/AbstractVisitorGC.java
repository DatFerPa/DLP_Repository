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
				"Plantilla de generaci�n de c�digo \"ExpresionAritmetica\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Comparacion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"ExpresionCast\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(AccesoACampo m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"AccesoACampo\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(AccesoArray m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"AccesoArray\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(MenosUnario m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"MenosUnario\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"ExpresionFuncion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"ExpresionLogica\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Negacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Negacion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Campo m, Object param) {
		throw new IllegalAccessError("Plantilla de generaci�n de c�digo \"Campo\" no definida para la funcion de c�digo"
				+ this.getClass().getName());
	}

	@Override
	public Object visitar(Variable m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Variable\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Caracter m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"CTE_Caracter\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Real m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"CTE_Real\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(CTE_Entera m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"CTE_Entera\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaWhile m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"SentenciaWhile\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaIf m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"SentenciaIf\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Asignacion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Asignacion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Escritura m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Escritura\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Lectura m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Lectura\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaReturn m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"SentenciaReturn\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(SentenciaFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"SentenciaFuncion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(Programa m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"Programa\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(DefFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"DefFuncion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(DefVariable m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"DefVariable\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoArray m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoArray\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoCaracter m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoCaracter\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoEntero m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoEntero\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoError m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoError\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoFuncion m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoFuncion\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoReal m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoReal\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoStruct m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoStruct\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

	@Override
	public Object visitar(TipoVoid m, Object param) {
		throw new IllegalAccessError(
				"Plantilla de generaci�n de c�digo \"TipoVoid\" no definida para la funcion de c�digo"
						+ this.getClass().getName());
	}

}
