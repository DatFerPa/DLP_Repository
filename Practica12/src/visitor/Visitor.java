package visitor;

import ast.*;
import ast.definiciones.*;
import ast.expresiones.*;
import ast.sentencias.*;
import ast.tipos.*;

public interface Visitor {
	
	//Expresiones
	public Object visitar(ExpresionAritmetica m , Object param);
	public Object visitar(Comparacion m , Object param);	
	public Object visitar(ExpresionCast m , Object param);
	public Object visitar(AccesoACampo m , Object param);
	public Object visitar(AccesoArray m , Object param);
	public Object visitar(MenosUnario m , Object param);
	public Object visitar(ExpresionFuncion m , Object param);
	public Object visitar(ExpresionLogica m , Object param);
	public Object visitar(Negacion m , Object param);
	public Object visitar(Campo m , Object param);
	public Object visitar(Variable m, Object param);
	public Object visitar(CTE_Caracter m, Object param);
	public Object visitar(CTE_Real m, Object param);
	public Object visitar(CTE_Entera m, Object param);



	
	//Sentencias
	public Object visitar(SentenciaWhile m , Object param);
	public Object visitar(SentenciaIf m , Object param);
	public Object visitar(Asignacion m , Object param);
	public Object visitar(Escritura m , Object param);
	public Object visitar(Lectura m , Object param);
	public Object visitar(SentenciaReturn m , Object param);
	public Object visitar(SentenciaFuncion m , Object param);
	
	//Otros
	public Object visitar(Programa m , Object param);
	public Object visitar(DefFuncion m , Object param);
	public Object visitar(DefVariable m , Object param);
	
	//Tipos
	public Object visitar(TipoArray m , Object param);
	public Object visitar(TipoCaracter m , Object param);
	public Object visitar(TipoEntero m , Object param);
	public Object visitar(TipoError m , Object param);
	public Object visitar(TipoFuncion m , Object param);
	public Object visitar(TipoReal m , Object param);
	public Object visitar(TipoStruct m , Object param);
	public Object visitar(TipoVoid m , Object param);





	
}
