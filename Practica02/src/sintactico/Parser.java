
package sintactico;

import lexico.Lexico;

/**
 * Clase Analizador Sintáctico (Parser).<br/>
 * Diseño de Lenguajes de Programación.<br/>
 * Escuela de Ingeniería Informática.<br/>
 * Universidad de Oviedo.<br/>
 * 
 * @author Francisco Ortin
 */

public class Parser {

	// * Tokens
	public final static int CTE_ENTERA = 257;
	public final static int IDENT = 258;
	public final static int IGUAL_IGUAL = 259;
	public final static int MAYOR_IGUAL = 260;
	public final static int MENOR_IGUAL = 261;
	public final static int DISTINTO = 262;
	public final static int AND = 262;
	public final static int OR = 263;
	public final static int READ = 264;
	public final static int WRITE = 265;
	public final static int WHILE = 266;
	public final static int IF = 267;
	public final static int ELSE = 268;
	public final static int INT = 269;
	public final static int FLOAT32 = 270;
	public final static int CHAR = 271;
	public final static int VAR = 272;
	public final static int STRUCT = 273;
	public final static int RETURN = 274;
	public final static int FUNC = 275;
	public final static int MAIN = 276;
	public final static int VOID = 277;
	public final static int CTE_REAL = 278;
	public final static int CTE_CARACTER = 279;

	/**
	 * Referencia al analizador léxico
	 */
	private Lexico lexico;

	// * Constructor del Sintáctico
	public Parser(Lexico lexico) {
		// * El sintático conoce al léxico
		this.lexico = lexico;
	}

}