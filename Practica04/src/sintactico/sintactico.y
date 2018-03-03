%{
// * Declaraciones de código Java
// * Se sitúan al comienzo del archivo generado
// * El package lo añade yacc si utilizamos la opción -Jpackage
import lexico.Lexico;
import java.io.Reader;
import java.util.*;
import ast.definiciones.*;
import ast.expresiones.*;
import ast.sentencias.*;
import ast.tipos.*;
import ast.*;
%}

// * Declaraciones Yacc
%token READ WRITE WHILE IF ELSE INT FLOAT32 CHAR VAR STRUCT RETURN FUNC 
%token MAIN IDENT IGUAL_IGUAL MAYOR_IGUAL MENOR_IGUAL DISTINTO
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


programa: lista_definiciones FUNC MAIN '(' ')' '{' lista_definicion_variables lista_sentencias '}'
		 {
			this.ast = new Programa(lexico.getLinea(),lexico.getColumna(),(List<Definicion>)$1,(List<DefVariable>)$7,(List<Sentencia>)$8);
		 }
		 ;

lista_definiciones: lista_definiciones definicion_variable  {$$ = (List)$1; for(Definicion def:(List<Definicion>)$2){((List)$1).add(def);}}
		| lista_definiciones definicion_funcion 			{$$ = (List)$1; ((List)$$).add($2);}
		| 													{$$ = new ArrayList();}
		;
		
		
lista_definicion_variables: lista_definicion_variables definicion_variable {$$ = $1; for(Definicion def:(List<Definicion>)$2){((List)$1).add(def);}}	
		|													   {$$ = new ArrayList();}
		;
		
definicion_variable: VAR variable ';'		{ $$ = $2;}
		;
				
variable: identificadores tipo_ampliado 
		{
			$$ = new ArrayList();
			for(String nombre: (List<String>)$1){
				((List)$$).add(new DefVariable(nombre,(Tipo)$2));
			}
		}
		;
							
tipo_ampliado: tipo 	{$$ = $1;}
		| tipo_vector 	{$$ = $1;}
		| tipo_struct	{$$ = $1;}	
		;

tipo: INT			{$$ = TipoEntero.getInstancia();}	
	| FLOAT32		{$$ = TipoReal.getInstancia();} 	
	| CHAR 			{$$ = TipoCaracter.getInstancia();}
	;
	
tipo_vector: '[' CTE_ENTERA ']' tipo_ampliado	{$$ = new TipoArray(Integer.parseInt((String)$2),(Tipo)$4);} 
		;
		
tipo_struct: STRUCT '{' registros_struct '}'	{$$ = new TipoStruct((List<Campo>)$3);}	
		;

registros_struct: registros_struct identificadores tipo_ampliado ';'		{$$ = $1; for(String nombre: (List<String>)$2){((List)$$).add(new Campo(nombre,(Tipo)$3));}}		
		| 														{$$ = new ArrayList();}	
		;
		
//campo_struct: IDENT						{$$ = new ArrayList(); ((List)$$).add($1);}
//		| identificadores ',' IDENT		{$$ = $1; ((List)$$).add($3);}
//		;

identificadores: IDENT					{$$ = new ArrayList(); ((List)$$).add($1);}
		| identificadores ',' IDENT		{$$ = $1; ((List)$$).add($3);}
		;			
		
definicion_funcion: FUNC IDENT '(' lista_parametros_opt ')' tipo_retorno '{' lista_definicion_variables lista_sentencias '}'
		{
			$$ = new DefFuncion(lexico.getLinea(),lexico.getColumna(),(String)$2,new TipoFuncion((Tipo)$6,(List<DefVariable>)$4),(List<DefVariable>)$8,(List<Sentencia>)$9);
		}
		;
		
tipo_retorno: tipo  {$$ = $1;}
		|			{$$ = TipoVoid.getInstancia();}
		;
							
lista_parametros_opt: lista_parametros {$$ = $1;}
		|							   {$$ = new ArrayList();}
		;

lista_parametros: lista_parametros ',' parametro	{$$ = $1; ((List)$$).add($3);}
		| parametro									{$$ = new ArrayList(); ((List)$$).add($1);}
		;

parametro: IDENT tipo		{$$ = new DefVariable((String)$1,(Tipo)$2);}
		;		

lista_sentencias: lista_sentencias sentencia	{$$ = $1; ((List)$$).add($2);}
		 | 										{$$ = new ArrayList<Sentencia>();}
		 ;

sentencia: 	expresion '=' expresion ';'											{$$ = new Asignacion(lexico.getLinea(),lexico.getColumna(),$1,$3);}
		| IF expresion '{' lista_sentencias '}'									{$$ = new SentenciaIf(lexico.getLinea(),lexico.getColumna(),$2,$4, new ArrayList<Sentencia>());}
		| IF expresion '{' lista_sentencias '}' ELSE '{' lista_sentencias '}'	{$$ = new SentenciaIf(lexico.getLinea(),lexico.getColumna(),$2,$4,$8);}
		| WHILE expresion '{' lista_sentencias '}'								{$$ = new SentenciaWhile(lexico.getLinea(),lexico.getColumna(),$2,$4);}	
		| IDENT '(' lista_expresiones_opt ')' ';'								{$$ = new SentenciaFuncion(lexico.getLinea(),lexico.getColumna(),new Variable(lexico.getLinea(),lexico.getColumna(),$1),$3);}	
		| WRITE '(' lista_expresiones ')' ';'											{$$ = new Escritura(lexico.getLinea(),lexico.getColumna(),$3);}
		| READ '(' lista_expresiones ')' ';'											{$$ = new Lectura(lexico.getLinea(),lexico.getColumna(),$3);}
		| RETURN expresion ';'													{$$ = new SentenciaReturn(lexico.getLinea(),lexico.getColumna(),$2);}
		; 	 
	
cast: tipo '(' expresion ')'		{$$ = new ExpresionCast(lexico.getLinea(),lexico.getColumna(),$1,$3);}
	;		 

lista_expresiones_opt: lista_expresiones		{$$ = $1;}
		|										{$$ = new ArrayList<Expresion>();}
		;

lista_expresiones: lista_expresiones ',' expresion		{$$ = $1; ((List)$$).add($3);}
		| expresion										{$$ = new ArrayList(); ((List)$$).add($1);}
		;

expresion: expresion '+' expresion					{$$ = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion '*' expresion					{$$ = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion '/' expresion        			{$$ = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | IDENT '(' lista_expresiones_opt ')'		{$$ = new ExpresionFuncion(lexico.getLinea(),lexico.getColumna(),new Variable(lexico.getLinea(),lexico.getColumna(),$1),$3);}
         | expresion '%' expresion					{$$ = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion '-' expresion					{$$ = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | cast										{$$ = $1;}
         | '-' expresion %prec MENOS_UNARIO			{$$ = new MenosUnario(lexico.getLinea(),lexico.getColumna(),$2);}
         | '(' expresion ')'						{$$ = $2;}	    
         | expresion '[' expresion ']'				{$$ = new AccesoArray(lexico.getLinea(),lexico.getColumna(),$1,$3);}
         | expresion AND expresion					{$$ = new ExpresionLogica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion OR expresion					{$$ = new ExpresionLogica(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion IGUAL_IGUAL expresion			{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion MAYOR_IGUAL expresion			{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion MENOR_IGUAL expresion			{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion DISTINTO expresion				{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion '>' expresion					{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | expresion '<' expresion					{$$ = new Comparacion(lexico.getLinea(),lexico.getColumna(),$1,$2,$3);}
         | '!' expresion							{$$ = new Negacion(lexico.getLinea(),lexico.getColumna(),$2);}
         | expresion '.' IDENT						{$$ = new AccesoACampo(lexico.getLinea(),lexico.getColumna(),$1,$3);}
         | CTE_ENTERA								{$$ = new CTE_Entera(lexico.getLinea(),lexico.getColumna(),$1);}
         | CTE_REAL									{$$ = new CTE_Real(lexico.getLinea(),lexico.getColumna(),$1);}
         | CTE_CARACTER								{$$ = new CTE_Caracter(lexico.getLinea(),lexico.getColumna(),$1);}
         | IDENT									{$$ = new Variable(lexico.getLinea(),lexico.getColumna(),$1);}
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

private NodoAST ast;
public NodoAST getAST() { return ast; }
