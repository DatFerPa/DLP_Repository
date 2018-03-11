package manejadorDeErrores;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ast.tipos.TipoError;

public class ME {

	List<TipoError> errores;
	private static ME instancia;

	private ME() {
		errores = new ArrayList<TipoError>();
	}

	public static ME getME() {
		if (instancia == null) {
			instancia = new ME();
		}

		return instancia;
	}
	
	public void addError(TipoError error) {
		this.errores.add(error);
	}

	public boolean huboErrores() {
		return (errores.size() == 0) ? true : false;
	}

	public void mostrarErrores(PrintStream err) {
		err.println("Errores detectados: ");
		for (TipoError error : errores) {
			err.println("\t Mensaje: " + error.getmsg() + " - linea: " + error.getNodo().getLinea() + " - columna: "
					+ error.getNodo().getColumna());
		}
	}

}
