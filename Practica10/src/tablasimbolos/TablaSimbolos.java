package tablasimbolos;

import java.util.*;

import ast.definiciones.Definicion;
import ast.definiciones.DefinicionAbstracta;

public class TablaSimbolos {

	int i;
	private int ambito = 0;
	private List<Map<String, Definicion>> tabla;

	public TablaSimbolos() {
		this.tabla = new ArrayList<Map<String, Definicion>>();
		tabla.add(new HashMap<String, Definicion>());
	}

	public void set() {
		ambito++;
		tabla.add(new HashMap<String, Definicion>());
	}

	public void reset() {
		tabla.remove(ambito);
		ambito--;
	}

	// no simbolos repetidos en el ambito
	public boolean insertar(Definicion simbolo) {
		if(buscarAmbitoActual(((DefinicionAbstracta) simbolo).getNombre())==null) {
			((DefinicionAbstracta) simbolo).setAmbito(ambito);
			tabla.get(ambito).put(((DefinicionAbstracta) simbolo).getNombre(), simbolo);
			return true;
		}else {
			return false;
		}
	}

	public Definicion buscar(String id) {
		int i = ambito;
		while (i >= 0) {
			if (tabla.get(i).containsKey(id)) {
				return tabla.get(i).get(id);
			}
			i--;
		}
		return null;
	}

	public Definicion buscarAmbitoActual(String id) {
		return tabla.get(ambito).get(id);
	}
	

}
