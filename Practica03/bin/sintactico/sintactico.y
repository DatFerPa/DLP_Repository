%{
// * Declaraciones de código Java
// * Se sitúan al comienzo del archivo generado
// * El package lo añade yacc si utilizamos la opción -Jpackage
import lexico.Lexico;
import java.io.Reader;
%}

// * Declaraciones Yacc
%token READ WRITE WHILE IF ELSE INT FLOAT32 CHAR VAR STRUCT RETURN FUNC 
%token MAIN VOID IDENT IGUAL_IGUAL MAYOR_IGUAL MENOR_IGUAL DISTINTO
%token CTE_ENTERA CTE_REAL CTE_CARACTER

%right '='
%left AND OR
%left IGUAL_IGUAL MAYOR_IGUAL MENOR_IGUAL DISTINTO '>' '<'
%left '+' '-'
%left '*' '/' '%'
%right '!'
%right MENOS_UNARIO
%nonassoc '[' ']'
%left '.'
%nonassoc '(' ')'

%%
// * Gramática y acciones Yacc


programa: lista_definicion_variables FUNC MAIN '(' ')' '{' '}'
		 ;

lista_definicion_variables: lista_definicion_variables definicion_variable 
		|
		;
		
definicion_variable: VAR variable ';'		
		;		

variable: variable_simple
		| variable_struct	
		;

variable_simple: identificadores tipo_variable
		;

variable_struct: IDENT STRUCT '{' registros_struct '}'
		;

registros_struct: registro_struct
		| registros_struct registro_struct
		;
		
registro_struct: IDENT tipo_variable ';'
		;		

tipo_variable: tipo
		| tipo_vector
		;

tipo: INT
	| FLOAT32
	| CHAR
	;
	
tipo_vector: corchetes_tam tipo
		;

corchetes_tam: '[' CTE_ENTERA ']'
	| corchetes_tam '[' CTE_ENTERA ']'
	;
		
identificadores: IDENT
		| identificadores ',' IDENT
		;





                 
//sentencia_if: IF expresion '{' lista_sentencia '}'
//al ser parentesis opcionales, no hace falta definir una con parentesis, ya que se saca de la anterior (expresion)


         
%%

// * Código Java
// * Se crea una clase "Parser", lo que aquí ubiquemos será:
//	- Atributos, si son variables
//	- Métodos, si son funciones
//   de la clase "Parser"

// * Estamos obligados a implementar:
//	int yylex()
//	void yyerror(String)

// * Referencia al analizador léxico
private Lexico lexico;

// * Llamada al analizador léxico
private int yylex () {
    int token=0;
    try { 
		token=lexico.yylex(); 	
		this.yylval = lexico.getYylval();
    } catch(Throwable e) {
	    System.err.println ("Error Léxico en línea " + lexico.getLinea()+
		" y columna "+lexico.getColumna()+":\n\t"+e); 
    }
    return token;
}

// * Manejo de Errores Sintácticos
public void yyerror (String error) {
    System.err.println ("Error Sintáctico en línea " + lexico.getLinea()+
		" y columna "+lexico.getColumna()+":\n\t"+error);
}

// * Constructor del Sintáctico
public Parser(Lexico lexico) {
	this.lexico = lexico;
}
