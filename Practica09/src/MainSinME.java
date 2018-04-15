import java.io.FileReader;
import java.io.IOException;

import ast.NodoAST;
import introspector.model.IntrospectorModel;
import introspector.view.IntrospectorTree;
import lexico.Lexico;
import semantico.VisitorIdentificacion;
import semantico.VisitorSemantico;
import sintactico.Parser;
import visitor.Visitor;

/**
 * Prueba del analizador léxico.<br/>
 * Diseño de Lenguajes de Programación.<br/>
 * Escuela de Ingeniería Informática.<br/>
 * Universidad de Oviedo <br/>
 * 
 * @author Francisco Ortin
 */
 
public class MainSinME {

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
		
		// * Mostramos el AST
		IntrospectorModel modelo=new IntrospectorModel("Programa",parser.getAST());
		new IntrospectorTree("Introspector", modelo);
	}

}