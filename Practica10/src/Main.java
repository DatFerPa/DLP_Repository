import java.io.FileReader;
import java.io.IOException;

import ast.NodoAST;
import generacionCodigo.VisitorOffset;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import lexico.Lexico;
import manejadorDeErrores.ME;
import semantico.VisitorIdentificacion;
import semantico.VisitorSemantico;
import sintactico.Parser;
import visitor.Visitor;

public class Main {
	public static void main(String args[]) throws IOException {
	    if (args.length<1) {
	        System.err.println("Necesito el archivo de entrada.");
	        return;
	    }
	        
		FileReader fr=null;
		try {
			fr=new FileReader(args[0]);
		} catch(IOException io) {
			System.err.println("El archivo "+args[0]+" no se ha podido abrir.");
			return;
		}
		
		// * Creamos léxico y sintáctico
		Lexico lexico = new Lexico(fr);
		Parser parser = new Parser(lexico);
		// * "Parseamos"
		parser.run();	
		NodoAST nodoRaiz = parser.getAST();
		
		Visitor vIdent = new VisitorIdentificacion();
		nodoRaiz.aceptar(vIdent, null);
		
		Visitor v = new VisitorSemantico();
		nodoRaiz.aceptar(v, null);
		
		Visitor vOffset = new VisitorOffset();
		nodoRaiz.aceptar(vOffset,null);
				
		// * Comprobamos si hubo errores
		if(ME.getME().huboErrores()){
			// * Mostramos los errores
			ME.getME().mostrarErrores(System.err);
		}
		else{			
			// * Mostramos el AST
			IntrospectorModel modelo=new IntrospectorModel("Programa",nodoRaiz);
			new IntrospectorTree("Introspector", modelo);
		}
	}

}