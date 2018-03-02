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
//#line 23 "Parser.java"




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
    0,    1,    1,    1,    2,    2,    4,    6,    6,    7,
    8,   11,   11,   10,   10,   12,   12,   12,   13,    9,
    9,    5,   15,   15,   14,   14,   16,   16,   17,    3,
    3,   18,   18,   18,   18,   18,   18,   18,   18,   22,
   20,   20,   21,   21,   19,   19,   19,   19,   19,   19,
   19,   19,   19,   19,   19,   19,   19,   19,   19,   19,
   19,   19,   19,   19,   19,   19,   19,   19,
};
final static short yylen[] = {                            2,
    9,    2,    2,    0,    2,    0,    3,    1,    1,    2,
    5,    3,    0,    1,    1,    1,    1,    1,    4,    1,
    3,   10,    1,    0,    1,    0,    3,    1,    2,    2,
    0,    4,    5,    9,    5,    5,    5,    5,    3,    4,
    1,    0,    3,    1,    3,    3,    3,    4,    3,    3,
    1,    2,    3,    4,    3,    3,    3,    3,    3,    3,
    3,    3,    2,    3,    1,    1,    1,    1,
};
final static short yydefred[] = {                         4,
    0,    0,    0,    0,    2,    3,    0,    0,    8,    9,
    0,    0,    0,    0,    7,   16,   17,   18,    0,    0,
   10,   14,   15,    0,    0,   13,    0,   21,    0,    0,
    0,    0,   28,    0,    0,    6,   29,    0,    0,   20,
   11,    0,   19,    0,   23,    0,   27,   12,    0,    5,
    6,    0,    0,    0,    0,    0,    0,   65,   66,   67,
    0,    0,    0,    1,    0,   30,    0,   51,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   31,   31,   39,    0,    0,   53,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   64,   22,    0,    0,    0,    0,    0,
    0,    0,   40,   32,   54,   38,    0,   37,   48,   35,
    0,   36,    0,   31,    0,   34,
};
final static short yydgoto[] = {                          1,
    2,   44,   49,   50,    6,    8,    9,   10,   11,   21,
   34,   65,   23,   31,   46,   32,   33,   66,   67,  105,
  106,   68,
};
final static short yysindex[] = {                         0,
    0, -257, -266, -225,    0,    0, -252,  -50,    0,    0,
  -41,  -16,   -5,  -82,    0,    0,    0,    0, -229, -210,
    0,    0,    0,   31, -208,    0,  -19,    0,  -47, -233,
   32,   33,    0, -124,  -85,    0,    0, -233, -208,    0,
    0,   19,    0, -186,    0,  -42,    0,    0,  -33,    0,
    0,   42,   43,  102,  102,  102,   45,    0,    0,    0,
  102,  102,  102,    0,   46,    0,  477,    0, -186,  102,
  102,   47,  444,  499,  510,  102,  -44,  -44,  540,  102,
  102,  102,  102,  102,  102,  102,  102,  102,  102,  102,
  102,  102,  102,  102,  102,  102,  -12,  821,  -31,  -26,
  102,    0,    0,    0,   49,   44,    0,  551,  -20,  -20,
  -20,  -20,  620, 1012, 1012,  -20,  -20,    6,    6,  -44,
  -44,  -44,  699,    0,    0,   34,  102,   35,   54,    9,
   30,   40,    0,    0,    0,    0,  821,    0,    0,    0,
 -161,    0,  -22,    0,   51,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,  -24,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   61,    0,    0,    0,    0,    0,
    0,   62,    0,    0,    0,    0,    0,  -17,    0,    0,
    0,    0,    0,   72,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  789,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   72,    0,
    0,  126,    0,    0,    0,   63,  347,  373,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   17,    0,    0,
   63,    0,    0,    0,    0,   66,    0,    0,  856,  891,
  900,  941,    0,  -25,   -4,  950,  978,  843,  865,  382,
  417,  456,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  810,    0,    0,    0,    0,   25,    0,    0,    0,
   93,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,   57,  -64,  107,    0,    0,   76,    0,    0,   79,
    0,   21,    0,    0,    0,    0,   77,    0, 1105,   10,
   -6,    0,
};
final static int YYTABLESIZE=1286;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   41,   96,   20,    7,   97,   19,   63,    3,   15,  126,
    4,   61,  127,   14,  128,   55,   94,  127,   55,   20,
   62,   92,   90,   24,   91,   96,   93,   63,   16,   17,
   18,   22,   61,   55,   25,   55,   56,  130,  131,   56,
   26,   62,   94,   12,   13,   27,   95,   92,   63,   19,
   37,   96,   93,   61,   56,   22,   56,   44,   45,   28,
   44,   30,   62,   99,  100,   43,   20,   55,   43,   63,
   95,   29,   38,   35,   61,   36,   39,   48,    3,  145,
   51,   70,   71,   62,   76,   80,  101,  127,   56,  132,
   63,   64,  136,  138,  139,   61,   95,   55,  142,  143,
  144,   26,   25,   42,   31,   24,   41,   69,    5,   42,
  129,   31,  125,   43,    0,   47,   31,    0,   56,    0,
    0,    0,    0,    0,    0,   33,    0,    0,    0,    0,
    0,    0,   33,  140,   62,    0,    0,   33,    0,    0,
    0,   63,    0,    0,    0,   40,   61,    0,    0,    0,
    0,    0,    0,    0,  141,    0,    0,    0,    0,    0,
    0,    0,   68,    0,    0,    0,   68,   68,   68,   68,
   68,   68,   68,    0,    0,  146,   16,   17,   18,    0,
    0,    0,    0,    0,   68,   68,   68,   68,    0,    0,
    0,    0,    0,    0,    0,    0,   31,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   68,   33,   68,    0,
   16,   17,   18,   52,   53,   54,   55,    0,   16,   17,
   18,    0,    0,   56,    0,    0,   57,   20,   20,   20,
    0,   58,   59,   60,   52,   53,   54,   55,   68,   16,
   17,   18,   55,   55,   56,    0,    0,   57,    0,    0,
    0,    0,   58,   59,   60,   52,   53,   54,   55,    0,
   16,   17,   18,   56,   56,   56,    0,    0,   57,    0,
    0,    0,    0,   58,   59,   60,   52,   53,   54,   55,
    0,   16,   17,   18,    0,    0,   56,    0,    0,   57,
    0,    0,    0,    0,   58,   59,   60,   52,   53,   54,
   55,    0,   16,   17,   18,    0,    0,   56,    0,    0,
   57,    0,    0,    0,    0,   58,   59,   60,   31,   31,
   31,   31,    0,   31,   31,   31,    0,    0,   31,    0,
    0,   31,    0,    0,    0,    0,   31,   31,   31,   33,
   33,   33,   33,    0,   33,   33,   33,    0,    0,   33,
    0,    0,   33,   16,   17,   18,    0,   33,   33,   33,
    0,   72,    0,    0,    0,    0,   58,   59,   60,    0,
    0,    0,    0,   52,    0,    0,    0,   52,   52,   52,
   52,   52,    0,   52,    0,    0,   68,   68,   68,   68,
    0,    0,    0,   68,   68,   52,   52,   52,   52,   63,
    0,    0,    0,   63,   63,   63,   63,   63,   46,   63,
    0,    0,   46,   46,   46,   46,   46,    0,   46,    0,
    0,   63,   63,   63,   63,    0,    0,    0,    0,   52,
   46,   46,   46,   46,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   47,    0,    0,    0,   47,   47,   47,
   47,   47,    0,   47,    0,   63,    0,    0,    0,   52,
    0,    0,    0,    0,   46,   47,   47,   47,   47,    0,
   94,    0,    0,    0,    0,   92,   90,    0,   91,   96,
   93,    0,   49,    0,    0,   63,   49,   49,   49,   49,
   49,    0,   49,   89,   46,   88,    0,    0,    0,   47,
    0,    0,    0,   94,   49,   49,   49,   49,   92,   90,
    0,   91,   96,   93,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   95,   94,   89,   85,   88,   47,
   92,   90,    0,   91,   96,   93,   94,    0,   49,    0,
    0,   92,   90,    0,   91,   96,   93,    0,   89,    0,
   88,    0,    0,    0,    0,    0,  102,   95,  104,   89,
    0,   88,    0,    0,    0,    0,   94,    0,   49,    0,
  107,   92,   90,    0,   91,   96,   93,   94,    0,   95,
    0,  133,   92,   90,    0,   91,   96,   93,    0,   89,
   95,   88,    0,    0,    0,    0,    0,    0,    0,    0,
   89,    0,   88,    0,    0,    0,    0,   52,   52,   52,
   52,  103,    0,    0,   52,   52,    0,    0,    0,    0,
   95,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   95,    0,   63,   63,   63,   63,    0,    0,    0,
   63,   63,   46,   46,   46,   46,   94,    0,    0,   46,
   46,   92,   90,    0,   91,   96,   93,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  134,   89,
    0,   88,    0,    0,    0,    0,    0,   47,   47,   47,
   47,    0,    0,    0,   47,   47,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   95,    0,    0,    0,   81,   82,   83,   84,    0,    0,
    0,   86,   87,    0,    0,    0,   49,   49,   49,   49,
    0,    0,    0,   49,   49,   94,    0,    0,    0,    0,
   92,   90,    0,   91,   96,   93,    0,   81,   82,   83,
   84,    0,    0,    0,   86,   87,    0,    0,   89,    0,
   88,    0,    0,    0,    0,    0,    0,    0,    0,   81,
   82,   83,   84,    0,    0,    0,   86,   87,    0,    0,
   81,   82,   83,   84,    0,    0,    0,   86,   87,   95,
    0,  135,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   81,   82,   83,   84,    0,    0,    0,   86,   87,    0,
    0,   81,   82,   83,   84,   68,    0,    0,   86,   87,
   68,   68,    0,   68,   68,   68,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   48,    0,   68,   68,
   68,   48,   48,    0,   48,   48,   48,   94,    0,    0,
    0,    0,   92,   90,    0,   91,   96,   93,    0,   48,
   48,   48,    0,    0,    0,    0,    0,    0,    0,   68,
   89,    0,   88,   45,    0,   45,   45,   45,    0,    0,
   81,   82,   83,   84,    0,    0,   57,   86,   87,   57,
   48,   45,   45,   45,   45,   50,    0,   50,   50,   50,
    0,   95,    0,    0,   57,   57,   57,   57,    0,    0,
    0,    0,    0,   50,   50,   50,   50,    0,    0,    0,
    0,   58,    0,    0,   58,   45,    0,    0,    0,    0,
   59,    0,    0,   59,    0,    0,    0,    0,   57,   58,
   58,   58,   58,    0,    0,    0,    0,   50,   59,   59,
   59,   59,    0,    0,    0,   45,    0,    0,    0,   81,
   82,   83,   84,    0,    0,    0,   86,   87,   57,    0,
    0,   60,    0,   58,   60,    0,    0,   50,    0,    0,
   61,    0,   59,   61,    0,    0,    0,    0,    0,   60,
   60,   60,   60,    0,    0,    0,    0,    0,   61,   61,
   61,   61,    0,   58,    0,    0,    0,    0,   62,    0,
    0,   62,   59,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   60,    0,    0,   62,   62,   62,   62,
    0,    0,   61,    0,    0,    0,    0,    0,   94,    0,
    0,    0,    0,   92,   90,    0,   91,   96,   93,   68,
   68,   68,   68,   60,    0,    0,   68,   68,    0,    0,
   62,   89,   61,   88,    0,    0,    0,    0,    0,    0,
   48,   48,   48,   48,    0,    0,    0,   48,   48,    0,
    0,   81,   82,   83,   84,    0,    0,    0,   86,   87,
   62,    0,   95,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   45,   45,   45,   45,    0,    0,    0,
   45,   45,    0,    0,    0,    0,   57,   57,   57,   57,
    0,    0,    0,   57,   57,   50,   50,   50,   50,    0,
    0,    0,   50,   50,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   73,   74,
   75,   58,   58,   58,   58,   77,   78,   79,   58,   58,
   59,   59,   59,   59,   98,   98,    0,   59,   59,    0,
   98,    0,    0,    0,  108,  109,  110,  111,  112,  113,
  114,  115,  116,  117,  118,  119,  120,  121,  122,  123,
  124,    0,    0,    0,    0,   98,    0,    0,    0,    0,
    0,   60,   60,   60,   60,    0,    0,    0,   60,   60,
   61,   61,   61,   61,    0,    0,    0,   61,   61,    0,
    0,  137,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   62,   62,
   62,   62,    0,    0,    0,   62,   62,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   81,   82,   83,   84,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
  125,   46,   44,  270,   69,   91,   40,  265,   59,   41,
  268,   45,   44,  266,   41,   41,   37,   44,   44,   44,
   33,   42,   43,   40,   45,   46,   47,   40,  262,  263,
  264,   11,   45,   59,   40,   61,   41,  102,  103,   44,
  123,   33,   37,  269,  270,  275,   91,   42,   40,   91,
   30,   46,   47,   45,   59,   35,   61,   41,   38,  270,
   44,  270,   33,   70,   71,   41,   91,   93,   44,   40,
   91,   41,   41,   93,   45,  123,   44,   59,  265,  144,
  123,   40,   40,   33,   40,   40,   40,   44,   93,   41,
   40,  125,   59,   59,   41,   45,   91,  123,   59,  261,
  123,   41,   41,   41,   33,  123,   41,   51,    2,   34,
  101,   40,  125,   35,   -1,   39,   45,   -1,  123,   -1,
   -1,   -1,   -1,   -1,   -1,   33,   -1,   -1,   -1,   -1,
   -1,   -1,   40,  125,   33,   -1,   -1,   45,   -1,   -1,
   -1,   40,   -1,   -1,   -1,  270,   45,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,
   45,   46,   47,   -1,   -1,  125,  262,  263,  264,   -1,
   -1,   -1,   -1,   -1,   59,   60,   61,   62,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   91,  125,   93,   -1,
  262,  263,  264,  257,  258,  259,  260,   -1,  262,  263,
  264,   -1,   -1,  267,   -1,   -1,  270,  262,  263,  264,
   -1,  275,  276,  277,  257,  258,  259,  260,  123,  262,
  263,  264,  278,  279,  267,   -1,   -1,  270,   -1,   -1,
   -1,   -1,  275,  276,  277,  257,  258,  259,  260,   -1,
  262,  263,  264,  278,  279,  267,   -1,   -1,  270,   -1,
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
   -1,   -1,   -1,   37,   -1,   -1,   -1,   41,   42,   43,
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
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   54,   55,
   56,  271,  272,  273,  274,   61,   62,   63,  278,  279,
  271,  272,  273,  274,   70,   71,   -1,  278,  279,   -1,
   76,   -1,   -1,   -1,   80,   81,   82,   83,   84,   85,
   86,   87,   88,   89,   90,   91,   92,   93,   94,   95,
   96,   -1,   -1,   -1,   -1,  101,   -1,   -1,   -1,   -1,
   -1,  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,
   -1,  127,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
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
"variable : variable_simple",
"variable : variable_struct",
"variable_simple : identificadores tipo_variable",
"variable_struct : IDENT STRUCT '{' registros_struct '}'",
"registros_struct : registros_struct variable_simple ';'",
"registros_struct :",
"tipo_variable : tipo",
"tipo_variable : tipo_vector",
"tipo : INT",
"tipo : FLOAT32",
"tipo : CHAR",
"tipo_vector : '[' CTE_ENTERA ']' tipo_variable",
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
"expresion : expresion '.' expresion",
"expresion : CTE_ENTERA",
"expresion : CTE_REAL",
"expresion : CTE_CARACTER",
"expresion : IDENT",
};

//#line 160 "../../src/sintactico/sintactico.y"

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
//#line 601 "Parser.java"
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
