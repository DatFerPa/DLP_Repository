package generacionCodigo;

import ast.Programa;
import ast.definiciones.DefFuncion;
import ast.definiciones.DefVariable;
import ast.definiciones.Definicion;
import ast.tipos.TipoFuncion;
import visitor.VisitorAbstracto;

public class VisitorOffset extends VisitorAbstracto{
	
	
	@Override
	public Object visitar(Programa m,Object param) {
		
		//vamos a definir el offset para las variables globales
		int offset = 0;
		for(Definicion def :m.getDefiniciones()) {
			if(def instanceof DefVariable) {
				((DefVariable) def).setOffset(offset);
				offset += ((DefVariable) def).getTipoBase().getBits();
			}
		}
		super.visitar(m, param);
		return null;
	}
	
	@Override
	public Object visitar(DefFuncion m, Object param) {
		int offset = 0;
		for(DefVariable def: m.getVariablesLocales()) {
			def.setOffset(offset);
			offset = def.getOffset();
		}
		
		
		super.visitar(m, param);
		return null;		
	}
	
	@Override
	public Object visitar(TipoFuncion m,Object param) {
		//vamos a tener en cuenta el +4 que se le añadae al bp
		int offset = 4;
		for(DefVariable def: m.getArgumentos()){
			def.setParametro(true);
			def.setOffset(offset);
			offset += def.getTipoBase().getBits();
		}
		return null;
	}
	
	
	

}
