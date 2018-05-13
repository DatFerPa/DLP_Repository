package generacionCodigo;

import java.io.FileWriter;
import java.io.IOException;

import ast.tipos.Tipo;
import ast.tipos.TipoEntero;
import ast.tipos.TipoReal;

public class GeneradorDeCodigo {

	private FileWriter fw;
	// una instruccion
	private String flag ="flag-";
	private int indiceFlag;

	public GeneradorDeCodigo() {

	}
	
	
	public String getFlag() {
		return flag;
	}


	public void aumentarFlag() {
		indiceFlag++;
	}
			
	public int getIndiceFlag() {
		return indiceFlag;
	}

	public void source(String nombreEntrada, String nombreSalida) {

		try {
			fw = new FileWriter(nombreSalida);
			fw.write("#source \"" + nombreEntrada + "\"");
			saltoLinea();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void closeprogram() {
		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void print(String string) {
		try {
			fw.write(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void parametros() {
		try {
			fw.write("\t' * Parameters");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void variablesLocales() {
		try {
			fw.write("\t' * Local variables");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/*
	 * instrucciones
	 */
	

	public void call(String nombre) {
		try {
			fw.write("\t");
			fw.write("call " + nombre);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saltoLinea() {
		try {
			fw.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void halt() {
		try {
			fw.write("\t");
			fw.write("halt");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void jz(String tag) {
		try {
			fw.write("\t");
			fw.write("jz "+ tag);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void jmp(String tag) {
		try {
			fw.write("\t");
			fw.write("jmp "+ tag);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void out(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("outf");
			} else if (tipo instanceof TipoEntero) {
				fw.write("outi");
			} else {
				fw.write("outb");
			}
			
			
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void in(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("inf");
			} else if (tipo instanceof TipoEntero) {
				fw.write("ini");
			} else {
				fw.write("inb");
			}
			saltoLinea();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void store(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("storef");
			} else if (tipo instanceof TipoEntero) {
				fw.write("storei");
			} else {
				fw.write("storeb");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void f2i() {
		try {
			fw.write("\t");
			fw.write("f2i");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void i2b() {
		try {
			fw.write("\t");
			fw.write("i2b");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void i2f() {
		try {
			fw.write("\t");
			fw.write("i2f");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void b2i() {
		try {
			fw.write("\t");
			fw.write("b2i");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("addf");
			} else {
				fw.write("addi");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mul(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("mulf");
			} else {
				fw.write("muli");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sub(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("subf");
			} else {
				fw.write("subi");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void div(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("divf");
			} else {
				fw.write("divi");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mod(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("modf");
			} else {
				fw.write("modi");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void gt(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("gtf");
			} else {
				fw.write("gti");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void lt(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("ltf");
			} else {
				fw.write("lti");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ge(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("gef");
			} else {
				fw.write("gei");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void le(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("lef");
			} else {
				fw.write("lei");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void eq(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("eqf");
			} else {
				fw.write("eqi");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ne(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoReal) {
				fw.write("nef");
			} else {
				fw.write("nei");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pushf(String string) {
		try {
			fw.write("\t");
			fw.write("pushf " + string);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pushi(String string) {
		try {
			fw.write("\t");
			fw.write("pushi " + string);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void and() {
		try {
			fw.write("\t");
			fw.write("and");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void or() {
		try {
			fw.write("\t");
			fw.write("or");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void not() {
		try {
			fw.write("\t");
			fw.write("not");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void tag(String nombre) {
		try {
			fw.write(" "+nombre + ":");
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	
	public void enter(int tamEnter) {
		try {
			fw.write("\t");
			fw.write("enter " + tamEnter);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	public void pushValor(Tipo tipo, String valor) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoEntero) {
				fw.write("pushi " + valor);
			} else if (tipo instanceof TipoReal) {
				fw.write("pushf " + valor);
			} else {
				fw.write("pushb " + valor);
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void pusha(String valor) {
		try {
			fw.write("\t");
			fw.write("pusha " + valor);
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void load(Tipo tipo) {
		try {
			fw.write("\t");
			if (tipo instanceof TipoEntero) {
				fw.write("loadi");
			} else if (tipo instanceof TipoReal) {
				fw.write("loadf");
			} else {
				fw.write("loadb");
			}
			saltoLinea();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bp() {
		pusha("bp");
	}



}
