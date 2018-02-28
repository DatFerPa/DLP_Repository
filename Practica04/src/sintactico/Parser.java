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
    0,    1,    1,    1,    2,    2,    4,    5,    8,    8,
    7,    7,   10,   10,   11,    6,    6,   12,   13,   16,
   16,   17,   15,   15,    9,    9,    9,   18,   14,   14,
    3,    3,   19,   19,   19,   19,   19,   19,   19,   19,
   23,   21,   21,   22,   22,   20,   20,   20,   20,   20,
   20,   20,   20,   20,   20,   20,   20,   20,   20,   20,
   20,   20,   20,   20,   20,   20,   20,   20,   20,
};
final static short yylen[] = {                            2,
    9,    2,    2,    0,    2,    0,    3,   10,    1,    0,
    1,    0,    3,    1,    2,    1,    1,    2,    5,    2,
    0,    3,    1,    1,    1,    1,    1,    4,    1,    3,
    2,    0,    4,    5,    9,    5,    5,    5,    5,    3,
    4,    1,    0,    3,    1,    3,    3,    3,    4,    3,
    3,    1,    2,    3,    4,    3,    3,    3,    3,    3,
    3,    3,    3,    2,    3,    1,    1,    1,    1,
};
final static short yydefred[] = {                         4,
    0,    0,    0,    0,    2,    3,    0,    0,   16,   17,
    0,    0,    0,    0,    7,   25,   26,   27,    0,    0,
   23,   18,   24,    0,    0,   21,    0,   30,    0,    0,
    0,    0,   14,    0,    0,    6,   15,    0,    0,    0,
   19,   20,   28,    0,    0,    9,   13,    0,    0,    5,
    6,   22,    0,    0,    0,    0,    0,    0,   66,   67,
   68,    0,    0,    0,    1,    0,   31,    0,   52,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   32,   32,   40,    0,    0,   54,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   65,    8,    0,    0,    0,    0,
    0,    0,    0,   41,   33,   55,   39,    0,   38,   49,
   36,    0,   37,    0,   32,    0,   35,
};
final static short yydgoto[] = {                          1,
    2,   44,   49,   50,    6,    8,   31,   45,   66,   32,
   33,    9,   10,   11,   22,   34,   42,   23,   67,   68,
  106,  107,   69,
};
final static short yysindex[] = {                         0,
    0, -257, -266, -225,    0,    0, -252,  -50,    0,    0,
  -41,  -16,   -5,  -82,    0,    0,    0,    0, -229, -212,
    0,    0,    0,   19, -208,    0,  -21,    0,  -49, -233,
   36,   34,    0, -124, -233,    0,    0, -233, -208,  -85,
    0,    0,    0, -186,  -42,    0,    0,   23,  -33,    0,
    0,    0,   43,   45,  102,  102,  102,   46,    0,    0,
    0,  102,  102,  102,    0,   47,    0,  477,    0, -186,
  102,  102,   48,  444,  499,  510,  102,  -44,  -44,  540,
  102,  102,  102,  102,  102,  102,  102,  102,  102,  102,
  102,  102,  102,  102,  102,  102,  102,  -12,  821,  -31,
  -26,  102,    0,    0,    0,   49,   50,    0,  551,  -20,
  -20,  -20,  -20,  620, 1012, 1012,  -20,  -20,    6,    6,
  -44,  -44,  -44,  699,    0,    0,   40,  102,   41,   52,
    9,   30,   42,    0,    0,    0,    0,  821,    0,    0,
    0, -166,    0,  -19,    0,   51,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,  -24,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   61,    0,    0,    0,    0,    0,
    0,   62,    0,    0,    0,    0,    0,  -17,    0,    0,
    0,    0,    0,   72,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  789,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   72,
    0,    0,  126,    0,    0,    0,   66,  347,  373,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   25,    0,
    0,   66,    0,    0,    0,    0,   67,    0,    0,  856,
  891,  900,  941,    0,  -25,   -4,  950,  978,  843,  865,
  382,  417,  456,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  810,    0,    0,    0,    0,   32,    0,    0,
    0,   93,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,   58,  -65,  108,    0,    0,    0,    0,   21,    0,
   75,    0,    0,    0,   71,    0,    0,    0,    0, 1104,
   13,   -7,    0,
};
final static int YYTABLESIZE=1286;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         63,
   41,   97,   20,    7,   98,   19,   64,    3,   15,  127,
    4,   62,  128,   14,  129,   56,   95,  128,   56,   29,
   63,   93,   91,   24,   92,   97,   94,   64,   16,   17,
   18,   21,   62,   56,   25,   56,   57,  131,  132,   57,
   26,   63,   95,   12,   13,   27,   96,   93,   64,   19,
   37,   97,   94,   62,   57,   43,   57,   28,   46,   29,
   21,   30,   63,  100,  101,   45,   29,   56,   45,   64,
   96,   35,   44,   36,   62,   44,   38,   39,    3,  146,
   51,   52,   71,   63,   72,   77,   81,  102,   57,  133,
   64,   65,  140,  128,  144,   62,   96,   56,  137,  139,
  143,   12,   11,  145,   32,   10,   43,   42,   70,    5,
   48,   32,  126,   47,  130,    0,   32,    0,   57,    0,
    0,    0,    0,    0,    0,   34,    0,    0,    0,    0,
    0,    0,   34,  141,   63,    0,    0,   34,    0,    0,
    0,   64,    0,    0,    0,   40,   62,    0,    0,    0,
    0,    0,    0,    0,  142,    0,    0,    0,    0,    0,
    0,    0,   69,    0,    0,    0,   69,   69,   69,   69,
   69,   69,   69,    0,    0,  147,   16,   17,   18,    0,
    0,    0,    0,    0,   69,   69,   69,   69,    0,    0,
    0,    0,    0,    0,    0,    0,   32,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   69,   34,   69,    0,
   16,   17,   18,   53,   54,   55,   56,    0,   16,   17,
   18,    0,    0,   57,    0,    0,   58,   29,   29,   29,
    0,   59,   60,   61,   53,   54,   55,   56,   69,   16,
   17,   18,   56,   56,   57,    0,    0,   58,    0,    0,
    0,    0,   59,   60,   61,   53,   54,   55,   56,    0,
   16,   17,   18,   57,   57,   57,    0,    0,   58,    0,
    0,    0,    0,   59,   60,   61,   53,   54,   55,   56,
    0,   16,   17,   18,    0,    0,   57,    0,    0,   58,
    0,    0,    0,    0,   59,   60,   61,   53,   54,   55,
   56,    0,   16,   17,   18,    0,    0,   57,    0,    0,
   58,    0,    0,    0,    0,   59,   60,   61,   32,   32,
   32,   32,    0,   32,   32,   32,    0,    0,   32,    0,
    0,   32,    0,    0,    0,    0,   32,   32,   32,   34,
   34,   34,   34,    0,   34,   34,   34,    0,    0,   34,
    0,    0,   34,   16,   17,   18,    0,   34,   34,   34,
    0,   73,    0,    0,    0,    0,   59,   60,   61,    0,
    0,    0,    0,   53,    0,    0,    0,   53,   53,   53,
   53,   53,    0,   53,    0,    0,   69,   69,   69,   69,
    0,    0,    0,   69,   69,   53,   53,   53,   53,   64,
    0,    0,    0,   64,   64,   64,   64,   64,   47,   64,
    0,    0,   47,   47,   47,   47,   47,    0,   47,    0,
    0,   64,   64,   64,   64,    0,    0,    0,    0,   53,
   47,   47,   47,   47,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   48,    0,    0,    0,   48,   48,   48,
   48,   48,    0,   48,    0,   64,    0,    0,    0,   53,
    0,    0,    0,    0,   47,   48,   48,   48,   48,    0,
   95,    0,    0,    0,    0,   93,   91,    0,   92,   97,
   94,    0,   50,    0,    0,   64,   50,   50,   50,   50,
   50,    0,   50,   90,   47,   89,    0,    0,    0,   48,
    0,    0,    0,   95,   50,   50,   50,   50,   93,   91,
    0,   92,   97,   94,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   96,   95,   90,   86,   89,   48,
   93,   91,    0,   92,   97,   94,   95,    0,   50,    0,
    0,   93,   91,    0,   92,   97,   94,    0,   90,    0,
   89,    0,    0,    0,    0,    0,  103,   96,  105,   90,
    0,   89,    0,    0,    0,    0,   95,    0,   50,    0,
  108,   93,   91,    0,   92,   97,   94,   95,    0,   96,
    0,  134,   93,   91,    0,   92,   97,   94,    0,   90,
   96,   89,    0,    0,    0,    0,    0,    0,    0,    0,
   90,    0,   89,    0,    0,    0,    0,   53,   53,   53,
   53,  104,    0,    0,   53,   53,    0,    0,    0,    0,
   96,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   96,    0,   64,   64,   64,   64,    0,    0,    0,
   64,   64,   47,   47,   47,   47,   95,    0,    0,   47,
   47,   93,   91,    0,   92,   97,   94,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  135,   90,
    0,   89,    0,    0,    0,    0,    0,   48,   48,   48,
   48,    0,    0,    0,   48,   48,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   96,    0,    0,    0,   82,   83,   84,   85,    0,    0,
    0,   87,   88,    0,    0,    0,   50,   50,   50,   50,
    0,    0,    0,   50,   50,   95,    0,    0,    0,    0,
   93,   91,    0,   92,   97,   94,    0,   82,   83,   84,
   85,    0,    0,    0,   87,   88,    0,    0,   90,    0,
   89,    0,    0,    0,    0,    0,    0,    0,    0,   82,
   83,   84,   85,    0,    0,    0,   87,   88,    0,    0,
   82,   83,   84,   85,    0,    0,    0,   87,   88,   96,
    0,  136,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   82,   83,   84,   85,    0,    0,    0,   87,   88,    0,
    0,   82,   83,   84,   85,   69,    0,    0,   87,   88,
   69,   69,    0,   69,   69,   69,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   49,    0,   69,   69,
   69,   49,   49,    0,   49,   49,   49,   95,    0,    0,
    0,    0,   93,   91,    0,   92,   97,   94,    0,   49,
   49,   49,    0,    0,    0,    0,    0,    0,    0,   69,
   90,    0,   89,   46,    0,   46,   46,   46,    0,    0,
   82,   83,   84,   85,    0,    0,   58,   87,   88,   58,
   49,   46,   46,   46,   46,   51,    0,   51,   51,   51,
    0,   96,    0,    0,   58,   58,   58,   58,    0,    0,
    0,    0,    0,   51,   51,   51,   51,    0,    0,    0,
    0,   59,    0,    0,   59,   46,    0,    0,    0,    0,
   60,    0,    0,   60,    0,    0,    0,    0,   58,   59,
   59,   59,   59,    0,    0,    0,    0,   51,   60,   60,
   60,   60,    0,    0,    0,   46,    0,    0,    0,   82,
   83,   84,   85,    0,    0,    0,   87,   88,   58,    0,
    0,   61,    0,   59,   61,    0,    0,   51,    0,    0,
   62,    0,   60,   62,    0,    0,    0,    0,    0,   61,
   61,   61,   61,    0,    0,    0,    0,    0,   62,   62,
   62,   62,    0,   59,    0,    0,    0,    0,   63,    0,
    0,   63,   60,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   61,    0,    0,   63,   63,   63,   63,
    0,    0,   62,    0,    0,    0,    0,    0,   95,    0,
    0,    0,    0,   93,   91,    0,   92,   97,   94,   69,
   69,   69,   69,   61,    0,    0,   69,   69,    0,    0,
   63,   90,   62,   89,    0,    0,    0,    0,    0,    0,
   49,   49,   49,   49,    0,    0,    0,   49,   49,    0,
    0,   82,   83,   84,   85,    0,    0,    0,   87,   88,
   63,    0,   96,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   46,   46,   46,   46,    0,    0,    0,
   46,   46,    0,    0,    0,    0,   58,   58,   58,   58,
    0,    0,    0,   58,   58,   51,   51,   51,   51,    0,
    0,    0,   51,   51,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   74,   75,
   76,   59,   59,   59,   59,   78,   79,   80,   59,   59,
   60,   60,   60,   60,   99,   99,    0,   60,   60,    0,
   99,    0,    0,    0,  109,  110,  111,  112,  113,  114,
  115,  116,  117,  118,  119,  120,  121,  122,  123,  124,
  125,    0,    0,    0,    0,   99,    0,    0,    0,    0,
    0,   61,   61,   61,   61,    0,    0,    0,   61,   61,
   62,   62,   62,   62,    0,    0,    0,   62,   62,    0,
    0,  138,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   63,   63,
   63,   63,    0,    0,    0,   63,   63,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   82,   83,   84,   85,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
  125,   46,   44,  270,   70,   91,   40,  265,   59,   41,
  268,   45,   44,  266,   41,   41,   37,   44,   44,   44,
   33,   42,   43,   40,   45,   46,   47,   40,  262,  263,
  264,   11,   45,   59,   40,   61,   41,  103,  104,   44,
  123,   33,   37,  269,  270,  275,   91,   42,   40,   91,
   30,   46,   47,   45,   59,   35,   61,  270,   38,   41,
   40,  270,   33,   71,   72,   41,   91,   93,   44,   40,
   91,   93,   41,  123,   45,   44,   41,   44,  265,  145,
  123,   59,   40,   33,   40,   40,   40,   40,   93,   41,
   40,  125,   41,   44,  261,   45,   91,  123,   59,   59,
   59,   41,   41,  123,   33,  123,   41,   41,   51,    2,
   40,   40,  125,   39,  102,   -1,   45,   -1,  123,   -1,
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
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   55,   56,
   57,  271,  272,  273,  274,   62,   63,   64,  278,  279,
  271,  272,  273,  274,   71,   72,   -1,  278,  279,   -1,
   77,   -1,   -1,   -1,   81,   82,   83,   84,   85,   86,
   87,   88,   89,   90,   91,   92,   93,   94,   95,   96,
   97,   -1,   -1,   -1,   -1,  102,   -1,   -1,   -1,   -1,
   -1,  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,
  271,  272,  273,  274,   -1,   -1,   -1,  278,  279,   -1,
   -1,  128,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
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
"definicion_funcion : FUNC IDENT '(' lista_parametros_opt ')' tipo_retorno '{' lista_definicion_variables lista_sentencias '}'",
"tipo_retorno : tipo",
"tipo_retorno :",
"lista_parametros_opt : lista_parametros",
"lista_parametros_opt :",
"lista_parametros : lista_parametros ',' parametro",
"lista_parametros : parametro",
"parametro : IDENT tipo",
"variable : variable_simple",
"variable : variable_struct",
"variable_simple : identificadores tipo_variable",
"variable_struct : IDENT STRUCT '{' registros_struct '}'",
"registros_struct : registros_struct registro_struct",
"registros_struct :",
"registro_struct : IDENT tipo_variable ';'",
"tipo_variable : tipo",
"tipo_variable : tipo_vector",
"tipo : INT",
"tipo : FLOAT32",
"tipo : CHAR",
"tipo_vector : '[' CTE_ENTERA ']' tipo",
"identificadores : IDENT",
"identificadores : identificadores ',' IDENT",
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

//#line 165 "../../src/sintactico/sintactico.y"

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
//#line 602 "Parser.java"
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
