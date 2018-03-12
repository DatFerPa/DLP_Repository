//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";



package sintactico;



//#line 2 "../../src/sintactico/sintactico.y"
/* * Declaraciones de código Java*/
/* * Se sitúan al comienzo del archivo generado*/
/* * El package lo añade yacc si utilizamos la opción -Jpackage*/
import lexico.Lexico;
import java.io.Reader;
import java.util.*;
import ast.definiciones.*;
import ast.expresiones.*;
import ast.sentencias.*;
import ast.tipos.*;
import ast.*;
//#line 29 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:Object
String   yytext;//user variable to return contextual strings
Object yyval; //used to return semantic vals from action routines
Object yylval;//the 'lval' (result) I got from yylex()
Object valstk[] = new Object[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new Object();
  yylval=new Object();
  valptr=-1;
}
final void val_push(Object val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    Object[] newstack = new Object[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final Object val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final Object val_peek(int relative)
{
  return valstk[valptr-relative];
}
final Object dup_yyval(Object val)
{
  return val;
}
//#### end semantic value section ####
public final static short READ=257;
public final static short WRITE=258;
public final static short WHILE=259;
public final static short IF=260;
public final static short ELSE=261;
public final static short INT=262;
public final static short FLOAT32=263;
public final static short CHAR=264;
public final static short VAR=265;
public final static short STRUCT=266;
public final static short RETURN=267;
public final static short FUNC=268;
public final static short MAIN=269;
public final static short IDENT=270;
public final static short IGUAL_IGUAL=271;
public final static short MAYOR_IGUAL=272;
public final static short MENOR_IGUAL=273;
public final static short DISTINTO=274;
public final static short CTE_ENTERA=275;
public final static short CTE_REAL=276;
public final static short CTE_CARACTER=277;
public final static short AND=278;
public final static short OR=279;
public final static short MENOS_UNARIO=280;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    1,    2,    2,    4,    6,    8,    8,
    8,    9,    9,    9,   10,   11,   12,   12,    7,    7,
    5,   14,   14,   13,   13,   15,   15,   16,    3,    3,
   17,   17,   17,   17,   17,   17,   17,   17,   21,   19,
   19,   20,   20,   18,   18,   18,   18,   18,   18,   18,
   18,   18,   18,   18,   18,   18,   18,   18,   18,   18,
   18,   18,   18,   18,   18,   18,   18,
};
final static short yylen[] = {                            2,
    9,    2,    2,    0,    2,    0,    3,    2,    1,    1,
    1,    1,    1,    1,    4,    4,    4,    0,    1,    3,
   10,    1,    0,    1,    0,    3,    1,    2,    2,    0,
    4,    5,    9,    5,    5,    5,    5,    3,    4,    1,
    0,    3,    1,    3,    3,    3,    4,    3,    3,    1,
    2,    3,    4,    3,    3,    3,    3,    3,    3,    3,
    3,    2,    3,    1,    1,    1,    1,
};
final static short yydefred[] = {                         4,
    0,    0,    0,    0,    2,    3,   19,    0,    0,    0,
    0,    7,   12,   13,   14,    0,    0,    0,    8,    9,
   10,   11,    0,    0,   18,    0,   20,    0,    0,    0,
    0,   27,    0,    0,    6,   28,    0,    0,   16,    0,
   15,    0,   22,    0,   26,    0,    0,    5,    6,   17,
    0,    0,    0,    0,    0,    0,   64,   65,   66,    0,
    0,    0,    1,    0,   29,    0,   50,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   30,   30,   38,    0,    0,   52,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   63,   21,    0,    0,    0,    0,    0,    0,
    0,   39,   31,   53,   37,    0,   36,   47,   34,    0,
   35,    0,   30,    0,   33,
};
final static short yydgoto[] = {                          1,
    2,   42,   47,   48,    6,    8,    9,   19,   64,   21,
   22,   33,   30,   44,   31,   32,   65,   66,  104,  105,
   67,
};
final static short yysindex[] = {                         0,
    0, -257, -260, -256,    0,    0,    0,  -11,  189,   20,
   24,    0,    0,    0,    0, -103, -223, -205,    0,    0,
    0,    0,   25, -203,    0,  -24,    0,  -51, -219,   32,
   33,    0, -124,  -85,    0,    0, -219, -203,    0,  189,
    0, -191,    0,  -47,    0,   19,  -33,    0,    0,    0,
   39,   41,  102,  102,  102,   42,    0,    0,    0,  102,
  102,  102,    0,   43,    0,  477,    0, -191,  102,  102,
   45,  444,  499,  510,  102,  -44,  -44,  540,  102,  102,
  102,  102,  102,  102,  102,  102,  102,  102,  102,  102,
  102,  102,  102,  102, -184,  -12,  821,  -26,   12,  102,
    0,    0,    0,   46,   44,    0,  551,  -20,  -20,  -20,
  -20,  620, 1012, 1012,  -20,  -20,    4,    4,  -44,  -44,
  -44,  699,    0,    0,   31,  102,   34,   53,    9,   30,
   38,    0,    0,    0,    0,  821,    0,    0,    0, -162,
    0,  -23,    0,   51,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   60,    0,    0,    0,    0,    0,    0,
   61,    0,    0,    0,    0,    0,  -19,    0,    0,    0,
    0,   72,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  789,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   72,    0,    0,
  126,    0,    0,    0,   62,  347,  373,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   17,    0,    0,   62,
    0,    0,    0,    0,   65,    0,    0,  856,  891,  900,
  941,    0,  -25,   -4,  950,  978,  843,  865,  382,  417,
  456,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  810,    0,    0,    0,    0,   18,    0,    0,    0,   93,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,   58,  -63,  106,    0,    0,   76,  -31,   -5,    0,
    0,    0,    0,    0,    0,   73,    0, 1106,   10,  -39,
    0,
};
final static int YYTABLESIZE=1286;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         61,
   39,   95,   41,   20,   96,   17,   62,    3,   46,    7,
    4,   60,   10,   11,  125,   54,   93,  126,   54,   25,
   61,   91,   89,   36,   90,   95,   92,   62,   20,   98,
   99,   43,   60,   54,   20,   54,   55,  129,  130,   55,
   93,   61,   13,   14,   15,   91,   94,   12,   62,   95,
   92,   26,  127,   60,   55,  126,   55,   43,   42,   23,
   43,   42,   61,   24,   27,   28,   29,   54,   34,   62,
   94,   35,   37,    3,   60,   49,   38,   50,   69,  144,
   70,   75,   79,   61,  100,  123,  131,  126,   55,  135,
   62,   63,  137,  138,   94,   60,  141,   54,  142,  143,
   25,   24,   41,   23,   30,   40,   68,    5,   40,  128,
   45,   30,  124,    0,    0,    0,   30,    0,   55,    0,
    0,    0,    0,    0,    0,   32,    0,    0,    0,    0,
    0,    0,   32,  139,   61,    0,    0,   32,    0,    0,
    0,   62,    0,    0,    0,    7,   60,    0,    0,    0,
    0,    0,    0,    0,  140,    0,    0,    0,    0,    0,
    0,    0,   67,    0,    0,    0,   67,   67,   67,   67,
   67,   67,   67,    0,    0,  145,   13,   14,   15,    0,
   16,    0,    0,    0,   67,   67,   67,   67,    0,    0,
    0,    0,    0,    0,    0,    0,   30,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   67,   32,   67,    0,
    0,    0,    0,   51,   52,   53,   54,    0,   13,   14,
   15,    0,   18,   55,    0,    0,   56,    0,    0,    0,
    0,   57,   58,   59,   51,   52,   53,   54,   67,   13,
   14,   15,   54,   54,   55,    0,    0,   56,    0,    0,
    0,    0,   57,   58,   59,   51,   52,   53,   54,    0,
   13,   14,   15,   55,   55,   55,    0,    0,   56,   17,
    0,    0,    0,   57,   58,   59,   51,   52,   53,   54,
    0,   13,   14,   15,    0,    0,   55,    0,    0,   56,
    0,    0,    0,    0,   57,   58,   59,   51,   52,   53,
   54,    0,   13,   14,   15,    0,    0,   55,    0,    0,
   56,    0,    0,    0,    0,   57,   58,   59,   30,   30,
   30,   30,    0,   30,   30,   30,    0,    0,   30,    0,
    0,   30,    0,    0,    0,    0,   30,   30,   30,   32,
   32,   32,   32,    0,   32,   32,   32,    0,    0,   32,
    0,    0,   32,   13,   14,   15,    0,   32,   32,   32,
    0,   71,    0,    0,    0,    0,   57,   58,   59,    0,
    0,    0,    0,   51,    0,    0,    0,   51,   51,   51,
   51,   51,    0,   51,    0,    0,   67,   67,   67,   67,
    0,    0,    0,   67,   67,   51,   51,   51,   51,   62,
    0,    0,    0,   62,   62,   62,   62,   62,   45,   62,
    0,    0,   45,   45,   45,   45,   45,    0,   45,    0,
    0,   62,   62,   62,   62,    0,    0,    0,    0,   51,
   45,   45,   45,   45,    0,    0,    0,    0,    0,    0,
   13,   14,   15,   46,   16,    0,    0,   46,   46,   46,
   46,   46,    0,   46,    0,   62,    0,    0,    0,   51,
    0,    0,    0,    0,   45,   46,   46,   46,   46,    0,
   93,    0,    0,    0,    0,   91,   89,    0,   90,   95,
   92,    0,   48,    0,    0,   62,   48,   48,   48,   48,
   48,    0,   48,   88,   45,   87,    0,    0,    0,   46,
    0,    0,    0,   93,   48,   48,   48,   48,   91,   89,
    0,   90,   95,   92,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   94,   93,   88,   84,   87,   46,
   91,   89,    0,   90,   95,   92,   93,    0,   48,    0,
    0,   91,   89,    0,   90,   95,   92,    0,   88,    0,
   87,    0,    0,    0,    0,    0,  101,   94,  103,   88,
    0,   87,    0,    0,    0,    0,   93,    0,   48,    0,
  106,   91,   89,    0,   90,   95,   92,   93,    0,   94,
    0,  132,   91,   89,    0,   90,   95,   92,    0,   88,
   94,   87,    0,    0,    0,    0,    0,    0,    0,    0,
   88,    0,   87,    0,    0,    0,    0,   51,   51,   51,
   51,  102,    0,    0,   51,   51,    0,    0,    0,    0,
   94,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   94,    0,   62,   62,   62,   62,    0,    0,    0,
   62,   62,   45,   45,   45,   45,   93,    0,    0,   45,
   45,   91,   89,    0,   90,   95,   92,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  133,   88,
    0,   87,    0,    0,    0,    0,    0,   46,   46,   46,
   46,    0,    0,    0,   46,   46,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   94,    0,    0,    0,   80,   81,   82,   83,    0,    0,
    0,   85,   86,    0,    0,    0,   48,   48,   48,   48,
    0,    0,    0,   48,   48,   93,    0,    0,    0,    0,
   91,   89,    0,   90,   95,   92,    0,   80,   81,   82,
   83,    0,    0,    0,   85,   86,    0,    0,   88,    0,
   87,    0,    0,    0,    0,    0,    0,    0,    0,   80,
   81,   82,   83,    0,    0,    0,   85,   86,    0,    0,
   80,   81,   82,   83,    0,    0,    0,   85,   86,   94,
    0,  134,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   80,   81,   82,   83,    0,    0,    0,   85,   86,    0,
    0,   80,   81,   82,   83,   67,    0,    0,   85,   86,
   67,   67,    0,   67,   67,   67,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   47,    0,   67,   67,
   67,   47,   47,    0,   47,   47,   47,   93,    0,    0,
    0,    0,   91,   89,    0,   90,   95,   92,    0,   47,
   47,   47,    0,    0,    0,    0,    0,    0,    0,   67,
   88,    0,   87,   44,    0,   44,   44,   44,    0,    0,
   80,   81,   82,   83,    0,    0,   56,   85,   86,   56,
   47,   44,   44,   44,   44,   49,    0,   49,   49,   49,
    0,   94,    0,    0,   56,   56,   56,   56,    0,    0,
    0,    0,    0,   49,   49,   49,   49,    0,    0,    0,
    0,   57,    0,    0,   57,   44,    0,    0,    0,    0,
   58,    0,    0,   58,    0,    0,    0,    0,   56,   57,
   57,   57,   57,    0,    0,    0,    0,   49,   58,   58,
   58,   58,    0,    0,    0,   44,    0,    0,    0,   80,
   81,   82,   83,    0,    0,    0,   85,   86,   56,    0,
    0,   59,    0,   57,   59,    0,    0,   49,    0,    0,
   60,    0,   58,   60,    0,    0,    0,    0,    0,   59,
   59,   59,   59,    0,    0,    0,    0,    0,   60,   60,
   60,   60,    0,   57,    0,    0,    0,    0,   61,    0,
    0,   61,   58,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   59,    0,    0,   61,   61,   61,   61,
    0,    0,   60,    0,    0,    0,    0,    0,   93,    0,
    0,    0,    0,   91,   89,    0,   90,   95,   92,   67,
   67,   67,   67,   59,    0,    0,   67,   67,    0,    0,
   61,   88,   60,   87,    0,    0,    0,    0,    0,    0,
   47,   47,   47,   47,    0,    0,    0,   47,   47,    0,
    0,   80,   81,   82,   83,    0,    0,    0,   85,   86,
   61,    0,   94,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   44,   44,   44,   44,    0,    0,    0,
   44,   44,    0,    0,    0,    0,   56,   56,   56,   56,
    0,    0,    0,   56,   56,   49,   49,   49,   49,    0,
    0,    0,   49,   49,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   72,   73,
   74,   57,   57,   57,   57,   76,   77,   78,   57,   57,
   58,   58,   58,   58,   97,   97,    0,   58,   58,    0,
   97,    0,    0,    0,  107,  108,  109,  110,  111,  112,
  113,  114,  115,  116,  117,  118,  119,  120,  121,  122,
    0,    0,    0,    0,    0,   97,    0,    0,    0,    0,
    0,   59,   59,   59,   59,    0,    0,    0,   59,   59,
   60,   60,   60,   60,    0,    0,    0,   60,   60,    0,
    0,  136,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   61,   61,
   61,   61,    0,    0,    0,   61,   61,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   80,   81,   82,   83,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
  125,   46,   34,    9,   68,   91,   40,  265,   40,  270,
  268,   45,  269,  270,   41,   41,   37,   44,   44,  123,
   33,   42,   43,   29,   45,   46,   47,   40,   34,   69,
   70,   37,   45,   59,   40,   61,   41,  101,  102,   44,
   37,   33,  262,  263,  264,   42,   91,   59,   40,   46,
   47,  275,   41,   45,   59,   44,   61,   41,   41,   40,
   44,   44,   33,   40,  270,   41,  270,   93,   93,   40,
   91,  123,   41,  265,   45,  123,   44,   59,   40,  143,
   40,   40,   40,   33,   40,  270,   41,   44,   93,   59,
   40,  125,   59,   41,   91,   45,   59,  123,  261,  123,
   41,   41,   41,  123,   33,   41,   49,    2,   33,  100,
   38,   40,  125,   -1,   -1,   -1,   45,   -1,  123,   -1,
   -1,   -1,   -1,   -1,   -1,   33,   -1,   -1,   -1,   -1,
   -1,   -1,   40,  125,   33,   -1,   -1,   45,   -1,   -1,
   -1,   40,   -1,   -1,   -1,  270,   45,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,
   45,   46,   47,   -1,   -1,  125,  262,  263,  264,   -1,
  266,   -1,   -1,   -1,   59,   60,   61,   62,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   91,  125,   93,   -1,
   -1,   -1,   -1,  257,  258,  259,  260,   -1,  262,  263,
  264,   -1,   44,  267,   -1,   -1,  270,   -1,   -1,   -1,
   -1,  275,  276,  277,  257,  258,  259,  260,  123,  262,
  263,  264,  278,  279,  267,   -1,   -1,  270,   -1,   -1,
   -1,   -1,  275,  276,  277,  257,  258,  259,  260,   -1,
  262,  263,  264,  278,  279,  267,   -1,   -1,  270,   91,
   -1,   -1,   -1,  275,  276,  277,  257,  258,  259,  260,
   -1,  262,  263,  264,   -1,   -1,  267,   -1,   -1,  270,
   -1,   -1,   -1,   -1,  275,  276,  277,  257,  258,  259,
  260,   -1,  262,  263,  264,   -1,   -1,  267,   -1,   -1,
  270,   -1,   -1,   -1,   -1,  275,  276,  277,  257,  258,
  259,  260,   -1,  262,  263,  264,   -1,   -1,  267,   -1,
   -1,  270,   -1,   -1,   -1,   -1,  275,  276,  277,  257,
  258,  259,  260,   -1,  262,  263,  264,   -1,   -1,  267,
   -1,   -1,  270,  262,  263,  264,   -1,  275,  276,  277,
   -1,  270,   -1,   -1,   -1,   -1,  275,  276,  277,   -1,
   -1,   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,   -1,  271,  272,  273,  274,
   -1,   -1,   -1,  278,  279,   59,   60,   61,   62,   37,
   -1,   -1,   -1,   41,   42,   43,   44,   45,   37,   47,
   -1,   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,
   -1,   59,   60,   61,   62,   -1,   -1,   -1,   -1,   93,
   59,   60,   61,   62,   -1,   -1,   -1,   -1,   -1,   -1,
  262,  263,  264,   37,  266,   -1,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,   93,   -1,   -1,   -1,  123,
   -1,   -1,   -1,   -1,   93,   59,   60,   61,   62,   -1,
   37,   -1,   -1,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   -1,   37,   -1,   -1,  123,   41,   42,   43,   44,
   45,   -1,   47,   60,  123,   62,   -1,   -1,   -1,   93,
   -1,   -1,   -1,   37,   59,   60,   61,   62,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   91,   37,   60,   61,   62,  123,
   42,   43,   -1,   45,   46,   47,   37,   -1,   93,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   -1,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,  123,   91,   59,   60,
   -1,   62,   -1,   -1,   -1,   -1,   37,   -1,  123,   -1,
   41,   42,   43,   -1,   45,   46,   47,   37,   -1,   91,
   -1,   41,   42,   43,   -1,   45,   46,   47,   -1,   60,
   91,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   60,   -1,   62,   -1,   -1,   -1,   -1,  271,  272,  273,
  274,  123,   -1,   -1,  278,  279,   -1,   -1,   -1,   -1,
   91,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   91,   -1,  271,  272,  273,  274,   -1,   -1,   -1,
  278,  279,  271,  272,  273,  274,   37,   -1,   -1,  278,
  279,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   59,   60,
   -1,   62,   -1,   -1,   -1,   -1,   -1,  271,  272,  273,
  274,   -1,   -1,   -1,  278,  279,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   91,   -1,   -1,   -1,  271,  272,  273,  274,   -1,   -1,
   -1,  278,  279,   -1,   -1,   -1,  271,  272,  273,  274,
   -1,   -1,   -1,  278,  279,   37,   -1,   -1,   -1,   -1,
   42,   43,   -1,   45,   46,   47,   -1,  271,  272,  273,
  274,   -1,   -1,   -1,  278,  279,   -1,   -1,   60,   -1,
   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  271,
  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,   -1,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   91,
   -1,   93,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,
   -1,  271,  272,  273,  274,   37,   -1,   -1,  278,  279,
   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   37,   -1,   60,   61,
   62,   42,   43,   -1,   45,   46,   47,   37,   -1,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,   60,
   61,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   91,
   60,   -1,   62,   41,   -1,   43,   44,   45,   -1,   -1,
  271,  272,  273,  274,   -1,   -1,   41,  278,  279,   44,
   91,   59,   60,   61,   62,   41,   -1,   43,   44,   45,
   -1,   91,   -1,   -1,   59,   60,   61,   62,   -1,   -1,
   -1,   -1,   -1,   59,   60,   61,   62,   -1,   -1,   -1,
   -1,   41,   -1,   -1,   44,   93,   -1,   -1,   -1,   -1,
   41,   -1,   -1,   44,   -1,   -1,   -1,   -1,   93,   59,
   60,   61,   62,   -1,   -1,   -1,   -1,   93,   59,   60,
   61,   62,   -1,   -1,   -1,  123,   -1,   -1,   -1,  271,
  272,  273,  274,   -1,   -1,   -1,  278,  279,  123,   -1,
   -1,   41,   -1,   93,   44,   -1,   -1,  123,   -1,   -1,
   41,   -1,   93,   44,   -1,   -1,   -1,   -1,   -1,   59,
   60,   61,   62,   -1,   -1,   -1,   -1,   -1,   59,   60,
   61,   62,   -1,  123,   -1,   -1,   -1,   -1,   41,   -1,
   -1,   44,  123,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   93,   -1,   -1,   59,   60,   61,   62,
   -1,   -1,   93,   -1,   -1,   -1,   -1,   -1,   37,   -1,
   -1,   -1,   -1,   42,   43,   -1,   45,   46,   47,  271,
  272,  273,  274,  123,   -1,   -1,  278,  279,   -1,   -1,
   93,   60,  123,   62,   -1,   -1,   -1,   -1,   -1,   -1,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,
   -1,  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,
  123,   -1,   91,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  271,  272,  273,  274,   -1,   -1,   -1,
  278,  279,   -1,   -1,   -1,   -1,  271,  272,  273,  274,
   -1,   -1,   -1,  278,  279,  271,  272,  273,  274,   -1,
   -1,   -1,  278,  279,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   53,   54,
   55,  271,  272,  273,  274,   60,   61,   62,  278,  279,
  271,  272,  273,  274,   69,   70,   -1,  278,  279,   -1,
   75,   -1,   -1,   -1,   79,   80,   81,   82,   83,   84,
   85,   86,   87,   88,   89,   90,   91,   92,   93,   94,
   -1,   -1,   -1,   -1,   -1,  100,   -1,   -1,   -1,   -1,
   -1,  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,
   -1,  126,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  271,  272,
  273,  274,   -1,   -1,   -1,  278,  279,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  271,  272,  273,  274,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=280;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,null,
"';'","'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"READ","WRITE","WHILE","IF","ELSE",
"INT","FLOAT32","CHAR","VAR","STRUCT","RETURN","FUNC","MAIN","IDENT",
"IGUAL_IGUAL","MAYOR_IGUAL","MENOR_IGUAL","DISTINTO","CTE_ENTERA","CTE_REAL",
"CTE_CARACTER","AND","OR","MENOS_UNARIO",
};
final static String yyrule[] = {
"$accept : programa",
"programa : lista_definiciones FUNC MAIN '(' ')' '{' lista_definicion_variables lista_sentencias '}'",
"lista_definiciones : lista_definiciones definicion_variable",
"lista_definiciones : lista_definiciones definicion_funcion",
"lista_definiciones :",
"lista_definicion_variables : lista_definicion_variables definicion_variable",
"lista_definicion_variables :",
"definicion_variable : VAR variable ';'",
"variable : identificadores tipo_ampliado",
"tipo_ampliado : tipo",
"tipo_ampliado : tipo_vector",
"tipo_ampliado : tipo_struct",
"tipo : INT",
"tipo : FLOAT32",
"tipo : CHAR",
"tipo_vector : '[' CTE_ENTERA ']' tipo_ampliado",
"tipo_struct : STRUCT '{' registros_struct '}'",
"registros_struct : registros_struct identificadores tipo_ampliado ';'",
"registros_struct :",
"identificadores : IDENT",
"identificadores : identificadores ',' IDENT",
"definicion_funcion : FUNC IDENT '(' lista_parametros_opt ')' tipo_retorno '{' lista_definicion_variables lista_sentencias '}'",
"tipo_retorno : tipo",
"tipo_retorno :",
"lista_parametros_opt : lista_parametros",
"lista_parametros_opt :",
"lista_parametros : lista_parametros ',' parametro",
"lista_parametros : parametro",
"parametro : IDENT tipo",
"lista_sentencias : lista_sentencias sentencia",
"lista_sentencias :",
"sentencia : expresion '=' expresion ';'",
"sentencia : IF expresion '{' lista_sentencias '}'",
"sentencia : IF expresion '{' lista_sentencias '}' ELSE '{' lista_sentencias '}'",
"sentencia : WHILE expresion '{' lista_sentencias '}'",
"sentencia : IDENT '(' lista_expresiones_opt ')' ';'",
"sentencia : WRITE '(' lista_expresiones ')' ';'",
"sentencia : READ '(' lista_expresiones ')' ';'",
"sentencia : RETURN expresion ';'",
"cast : tipo '(' expresion ')'",
"lista_expresiones_opt : lista_expresiones",
"lista_expresiones_opt :",
"lista_expresiones : lista_expresiones ',' expresion",
"lista_expresiones : expresion",
"expresion : expresion '+' expresion",
"expresion : expresion '*' expresion",
"expresion : expresion '/' expresion",
"expresion : IDENT '(' lista_expresiones_opt ')'",
"expresion : expresion '%' expresion",
"expresion : expresion '-' expresion",
"expresion : cast",
"expresion : '-' expresion",
"expresion : '(' expresion ')'",
"expresion : expresion '[' expresion ']'",
"expresion : expresion AND expresion",
"expresion : expresion OR expresion",
"expresion : expresion IGUAL_IGUAL expresion",
"expresion : expresion MAYOR_IGUAL expresion",
"expresion : expresion MENOR_IGUAL expresion",
"expresion : expresion DISTINTO expresion",
"expresion : expresion '>' expresion",
"expresion : expresion '<' expresion",
"expresion : '!' expresion",
"expresion : expresion '.' IDENT",
"expresion : CTE_ENTERA",
"expresion : CTE_REAL",
"expresion : CTE_CARACTER",
"expresion : IDENT",
};

//#line 181 "../../src/sintactico/sintactico.y"

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
//#line 609 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 36 "../../src/sintactico/sintactico.y"
{
			this.ast = new Programa(lexico.getLinea(),lexico.getColumna(),(List<Definicion>)val_peek(8),(List<DefVariable>)val_peek(2),(List<Sentencia>)val_peek(1));
		 }
break;
case 2:
//#line 41 "../../src/sintactico/sintactico.y"
{yyval = (List)val_peek(1); for(Definicion def:(List<Definicion>)val_peek(0)){((List)val_peek(1)).add(def);}}
break;
case 3:
//#line 42 "../../src/sintactico/sintactico.y"
{yyval = (List)val_peek(1); ((List)yyval).add(val_peek(0));}
break;
case 4:
//#line 43 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList();}
break;
case 5:
//#line 47 "../../src/sintactico/sintactico.y"
{yyval = val_peek(1); for(Definicion def:(List<Definicion>)val_peek(0)){((List)val_peek(1)).add(def);}}
break;
case 6:
//#line 48 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList();}
break;
case 7:
//#line 51 "../../src/sintactico/sintactico.y"
{ yyval = val_peek(1);}
break;
case 8:
//#line 55 "../../src/sintactico/sintactico.y"
{
			yyval = new ArrayList();
			
			for(String nombre: (List<String>)val_peek(1)){
				((List)yyval).add(new DefVariable(lexico.getLinea(),lexico.getColumna(),nombre,(Tipo)val_peek(0)));
			}
			
			for(int i = 0; i< ((List<String>)val_peek(1)).size();i++){
				for(int j = 0 ;j< ((List<String>)val_peek(1)).size();j++){
					if(i!=j && i<j && ((List<String>)val_peek(1)).get(i).equals(((List<String>)val_peek(1)).get(j))){
						new TipoError((NodoASTAbstract)((List)yyval).get(i),"Variable duplicada");
					}
				}
			}			
		}
break;
case 9:
//#line 72 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 10:
//#line 73 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 11:
//#line 74 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 12:
//#line 77 "../../src/sintactico/sintactico.y"
{yyval = TipoEntero.getInstancia();}
break;
case 13:
//#line 78 "../../src/sintactico/sintactico.y"
{yyval = TipoReal.getInstancia();}
break;
case 14:
//#line 79 "../../src/sintactico/sintactico.y"
{yyval = TipoCaracter.getInstancia();}
break;
case 15:
//#line 82 "../../src/sintactico/sintactico.y"
{yyval = new TipoArray(Integer.parseInt((String)val_peek(2)),(Tipo)val_peek(0));}
break;
case 16:
//#line 85 "../../src/sintactico/sintactico.y"
{yyval = new TipoStruct((List<Campo>)val_peek(1));}
break;
case 17:
//#line 88 "../../src/sintactico/sintactico.y"
{yyval = val_peek(3); for(String nombre: (List<String>)val_peek(2)){((List)yyval).add(new Campo(nombre,(Tipo)val_peek(1)));}}
break;
case 18:
//#line 89 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList();}
break;
case 19:
//#line 96 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList(); ((List)yyval).add(val_peek(0));}
break;
case 20:
//#line 97 "../../src/sintactico/sintactico.y"
{yyval = val_peek(2); ((List)yyval).add(val_peek(0));}
break;
case 21:
//#line 101 "../../src/sintactico/sintactico.y"
{
			yyval = new DefFuncion(lexico.getLinea(),lexico.getColumna(),(String)val_peek(8),new TipoFuncion((Tipo)val_peek(4),(List<DefVariable>)val_peek(6)),(List<DefVariable>)val_peek(2),(List<Sentencia>)val_peek(1));
		}
break;
case 22:
//#line 106 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 23:
//#line 107 "../../src/sintactico/sintactico.y"
{yyval = TipoVoid.getInstancia();}
break;
case 24:
//#line 110 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 25:
//#line 111 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList();}
break;
case 26:
//#line 114 "../../src/sintactico/sintactico.y"
{yyval = val_peek(2); ((List)yyval).add(val_peek(0));}
break;
case 27:
//#line 115 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList(); ((List)yyval).add(val_peek(0));}
break;
case 28:
//#line 118 "../../src/sintactico/sintactico.y"
{yyval = new DefVariable(lexico.getLinea(),lexico.getColumna(),(String)val_peek(1),(Tipo)val_peek(0));}
break;
case 29:
//#line 121 "../../src/sintactico/sintactico.y"
{yyval = val_peek(1); ((List)yyval).add(val_peek(0));}
break;
case 30:
//#line 122 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList<Sentencia>();}
break;
case 31:
//#line 125 "../../src/sintactico/sintactico.y"
{yyval = new Asignacion(lexico.getLinea(),lexico.getColumna(),val_peek(3),val_peek(1));}
break;
case 32:
//#line 126 "../../src/sintactico/sintactico.y"
{yyval = new SentenciaIf(lexico.getLinea(),lexico.getColumna(),val_peek(3),val_peek(1), new ArrayList<Sentencia>());}
break;
case 33:
//#line 127 "../../src/sintactico/sintactico.y"
{yyval = new SentenciaIf(lexico.getLinea(),lexico.getColumna(),val_peek(7),val_peek(5),val_peek(1));}
break;
case 34:
//#line 128 "../../src/sintactico/sintactico.y"
{yyval = new SentenciaWhile(lexico.getLinea(),lexico.getColumna(),val_peek(3),val_peek(1));}
break;
case 35:
//#line 129 "../../src/sintactico/sintactico.y"
{yyval = new SentenciaFuncion(lexico.getLinea(),lexico.getColumna(),new Variable(lexico.getLinea(),lexico.getColumna(),val_peek(4)),val_peek(2));}
break;
case 36:
//#line 130 "../../src/sintactico/sintactico.y"
{yyval = new Escritura(lexico.getLinea(),lexico.getColumna(),val_peek(2));}
break;
case 37:
//#line 131 "../../src/sintactico/sintactico.y"
{yyval = new Lectura(lexico.getLinea(),lexico.getColumna(),val_peek(2));}
break;
case 38:
//#line 132 "../../src/sintactico/sintactico.y"
{yyval = new SentenciaReturn(lexico.getLinea(),lexico.getColumna(),val_peek(1));}
break;
case 39:
//#line 135 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionCast(lexico.getLinea(),lexico.getColumna(),val_peek(3),val_peek(1));}
break;
case 40:
//#line 138 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 41:
//#line 139 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList<Expresion>();}
break;
case 42:
//#line 142 "../../src/sintactico/sintactico.y"
{yyval = val_peek(2); ((List)yyval).add(val_peek(0));}
break;
case 43:
//#line 143 "../../src/sintactico/sintactico.y"
{yyval = new ArrayList(); ((List)yyval).add(val_peek(0));}
break;
case 44:
//#line 146 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 45:
//#line 147 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 46:
//#line 148 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 47:
//#line 149 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionFuncion(lexico.getLinea(),lexico.getColumna(),new Variable(lexico.getLinea(),lexico.getColumna(),val_peek(3)),val_peek(1));}
break;
case 48:
//#line 150 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 49:
//#line 151 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionAritmetica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 50:
//#line 152 "../../src/sintactico/sintactico.y"
{yyval = val_peek(0);}
break;
case 51:
//#line 153 "../../src/sintactico/sintactico.y"
{yyval = new MenosUnario(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
case 52:
//#line 154 "../../src/sintactico/sintactico.y"
{yyval = val_peek(1);}
break;
case 53:
//#line 155 "../../src/sintactico/sintactico.y"
{yyval = new AccesoArray(lexico.getLinea(),lexico.getColumna(),val_peek(3),val_peek(1));}
break;
case 54:
//#line 156 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionLogica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 55:
//#line 157 "../../src/sintactico/sintactico.y"
{yyval = new ExpresionLogica(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 56:
//#line 158 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 57:
//#line 159 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 58:
//#line 160 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 59:
//#line 161 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 60:
//#line 162 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 61:
//#line 163 "../../src/sintactico/sintactico.y"
{yyval = new Comparacion(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(1),val_peek(0));}
break;
case 62:
//#line 164 "../../src/sintactico/sintactico.y"
{yyval = new Negacion(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
case 63:
//#line 165 "../../src/sintactico/sintactico.y"
{yyval = new AccesoACampo(lexico.getLinea(),lexico.getColumna(),val_peek(2),val_peek(0));}
break;
case 64:
//#line 166 "../../src/sintactico/sintactico.y"
{yyval = new CTE_Entera(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
case 65:
//#line 167 "../../src/sintactico/sintactico.y"
{yyval = new CTE_Real(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
case 66:
//#line 168 "../../src/sintactico/sintactico.y"
{yyval = new CTE_Caracter(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
case 67:
//#line 169 "../../src/sintactico/sintactico.y"
{yyval = new Variable(lexico.getLinea(),lexico.getColumna(),val_peek(0));}
break;
//#line 1044 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
