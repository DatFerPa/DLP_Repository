package generacionCodigo;

import ast.AbstractExpresion;
import ast.definiciones.DefinicionAbstracta;
import ast.expresiones.CTE_Caracter;
import ast.expresiones.CTE_Entera;
import ast.expresiones.CTE_Real;
import ast.expresiones.Comparacion;
import ast.expresiones.ExpresionAritmetica;
import ast.expresiones.ExpresionCast;
import ast.expresiones.ExpresionLogica;
import ast.expresiones.MenosUnario;
import ast.expresiones.Negacion;
import ast.expresiones.Variable;
import ast.tipos.TipoCaracter;
import ast.tipos.TipoEntero;
import ast.tipos.TipoReal;

public class VisitorGCValor extends VisitorOffset{
	
	private VisitorGCEjecutor ejecutar;
	private VisitorGCDireccion direccion;
	private GeneradorDeCodigo GC;
	
	public VisitorGCValor(VisitorGCEjecutor ejecutar,GeneradorDeCodigo GC) {
		this.ejecutar = ejecutar;
		this.GC = GC;
	}

	public void setDireccion(VisitorGCDireccion direccion) {
		this.direccion = direccion;
	}
	

	@Override
	public Object visitar(ExpresionCast m, Object param) {
		m.getExpresion().aceptar(ejecutar, param);
		return null;
	}

	@Override
	public Object visitar(ExpresionAritmetica m, Object param) {
		//m.getOperando1().aceptar(ejecutar, param);
		//m.getOperando2().aceptar(ejecutar, param);
		m.aceptar(ejecutar, param);
		return null;
	}

	@Override
	public Object visitar(Comparacion m, Object param) {
		//m.getOperando1().aceptar(ejecutar, param);
		//m.getOperando2().aceptar(ejecutar, param);
		m.aceptar(ejecutar, param);
		return null;
	}
	
	
	@Override
	public Object visitar(MenosUnario m, Object param) {
		//m.getOperando().aceptar(ejecutar, param);
		m.aceptar(ejecutar, param);
		return null;
	}
	
	@Override
	public Object visitar(ExpresionLogica m, Object param) {
		//m.getOperando1().aceptar(ejecutar, param);
		//m.getOperando2().aceptar(ejecutar, param);
		m.aceptar(ejecutar, param);
		return null;
	}
	
	
	@Override
	public Object visitar(Negacion m, Object param) {
		//m.getExpresion().aceptar(ejecutar, param);
		m.aceptar(ejecutar, param);
		return null;
	}
	
	@Override
	public Object visitar(CTE_Caracter m, Object param) {
		GC.pushValor(m.getTipo(),m.getValor());		
		return null;
	}

	@Override
	public Object visitar(CTE_Real m, Object param) {
		GC.pushValor(m.getTipo(),m.getValor());		
		return null;
	}

	@Override
	public Object visitar(CTE_Entera m, Object param) {
		GC.pushValor(m.getTipo(),m.getValor());			
		return null;
	}
	
	@Override
	public Object visitar(Variable m, Object param) {
		m.aceptar(direccion, param);
		GC.load(m.getTipo());
		return null;
	}
	
}
