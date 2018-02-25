// ************  Código a incluir ********************

package lexico;
import sintactico.Parser;
import ast.*;

%%
// ************  Opciones ********************
// % debug // * Opción para depurar
%byaccj
%class Lexico
%public
%unicode
%line
%column

%{
// ************  Atributos y métodos ********************
// * Para acceder al número de línea (yyline es package)
public int getLinea() { 
	// * Flex empieza en cero
	return yyline+1;
}

// * Para acceder al número de columna (yycolumn es package)
public int getColumna() { 
	// * Flex empieza en cero
	return yycolumn+1;
}

// * Valor semantico del token
private Object yylval;
public Object getYylval() {
	return this.yylval;
}

public void error(String texto){
	System.err.println("Entrada erronea: "+texto +" linea: "+getLinea()+ " columna: "+getColumna());
}

%}

// ************  Patrones (macros) ********************
ConstanteEntera = [0-9]*
Identificador = [a-zA-ZñÑà-üÀ-Ü][a-zA-Z0-9ñÑà-üÀ-Ü]*
ConstanteReal = [0-9]+(\.[0-9]*)?((e|E)-?[0-9]+)?
ConstanteCaracter = "'"(.|(\\[0-9]+)|(\\[nt]))"'"

//[0-9a-zA-ZñÑà-üÀ-Ü]



%%
// ************  Acciones ********************


//Palabras reservadas
read {this.yylval = yytext(); return Parser.READ;}
write {this.yylval = yytext(); return Parser.WRITE;}
while {this.yylval = yytext(); return Parser.WHILE;}
if {this.yylval = yytext(); return Parser.IF;}
else {this.yylval = yytext(); return Parser.ELSE;}
int {this.yylval = yytext(); return Parser.INT;}
float32 {this.yylval = yytext(); return Parser.FLOAT32;}
char {this.yylval = yytext(); return Parser.CHAR;}
var {this.yylval = yytext(); return Parser.VAR;}
struct {this.yylval = yytext(); return Parser.STRUCT;}
return {this.yylval = yytext(); return Parser.RETURN;}
func {this.yylval = yytext(); return Parser.FUNC;}
main {this.yylval = yytext(); return Parser.MAIN;}
void {this.yylval = yytext(); return Parser.VOID;}



//constante entera
{ConstanteEntera}	{ this.yylval = new Integer(yytext());
         			  return Parser.CTE_ENTERA;  }
 
 //constante real
{ConstanteReal} {this.yylval = yytext();
					return Parser.CTE_REAL;}
 //Identificador        			  
{Identificador}	{this.yylval = yytext();
					return Parser.IDENT;}
					
//Constante caracter
{ConstanteCaracter} {this.yylval = yytext();
						return Parser.CTE_CARACTER;}					


//Comentarios
"/*"~"*/" {}
"//".* {}

//operadores logicos
"=="	{this.yylval = yytext();return Parser.IGUAL_IGUAL;}
">="	{this.yylval = yytext();return Parser.MAYOR_IGUAL;}
"<="	{this.yylval = yytext();return Parser.MENOR_IGUAL;}	
"!="	{this.yylval = yytext();return Parser.DISTINTO;}
"&&"	{this.yylval = yytext();return Parser.AND;}
"||"	{this.yylval = yytext();return Parser.OR;}




//Operadores simples
									
"+"|
"-"|
"<"|
">"|
"*"|
"%"|
"!"|
")"|
"("|
";"|
","|
"."|
"["|
"]"|
"/"|
"{"|
"}"|
"="		{this.yylval = yytext();return yytext().charAt(0);}



								
[ \n\t\r] {}															
.	{error(yytext());}

									


