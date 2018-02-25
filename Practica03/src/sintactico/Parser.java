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
public final static short VOID=270;
public final static short IDENT=271;
public final static short IGUAL_IGUAL=272;
public final static short MAYOR_IGUAL=273;
public final static short MENOR_IGUAL=274;
public final static short DISTINTO=275;
public final static short CTE_ENTERA=276;
public final static short CTE_REAL=277;
public final static short CTE_CARACTER=278;
public final static short AND=279;
public final static short OR=280;
public final static short MENOS_UNARIO=281;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    4,    2,    2,    6,    8,    8,    7,
    7,   10,   10,   11,    5,    5,   12,   13,   16,   16,
   17,   15,   15,    9,    9,    9,   18,   19,   19,   14,
   14,    3,    3,   21,   21,   21,   21,   21,   21,   21,
   21,   24,   22,   22,   23,   23,   20,   20,   20,   20,
   20,   20,   20,   20,   20,   20,   20,   20,   20,   20,
   20,   20,   20,   20,   20,   20,   20,   20,   20,   20,
   20,
};
final static short yylen[] = {                            2,
   10,    2,    0,    3,    2,    0,   10,    1,    0,    1,
    0,    3,    1,    2,    1,    1,    2,    5,    1,    2,
    3,    1,    1,    1,    1,    1,    2,    3,    4,    1,
    3,    2,    0,    4,    5,    9,    5,    5,    5,    5,
    3,    4,    1,    0,    3,    1,    3,    3,    3,    2,
    4,    3,    3,    1,    2,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    2,    3,    1,    1,    1,
    1,
};
final static short yydefred[] = {                         3,
    0,    0,    0,    0,    2,    0,    0,   15,   16,    0,
    0,    5,    0,    4,   24,   25,   26,    0,    0,   22,
   17,   23,    0,    0,    0,    0,    0,   68,   69,   70,
    0,    0,    0,    0,    0,    0,   54,   31,    0,   27,
    0,    0,    0,    0,   19,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   28,    0,    0,    0,    0,
    0,    0,   13,    0,   18,   20,    0,    0,    0,   57,
   56,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   67,   29,    3,   14,    0,
    0,   21,   51,    0,   42,    0,    0,    8,   12,    0,
    0,    3,    0,    0,    0,    0,    0,    0,    1,    0,
   32,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   33,   33,   41,    0,    0,    7,    0,    0,
    0,    0,    0,   34,   40,   39,   37,    0,   38,    0,
   33,    0,   36,
};
final static short yydgoto[] = {                          1,
    2,    4,  111,    5,    7,   12,   71,  107,   35,   72,
   73,    8,    9,   10,   21,   44,   45,   22,   23,  120,
  121,   78,   79,   37,
};
final static short yysindex[] = {                         0,
    0, -254, -251, -233,    0, -226,  -14,    0,    0,  -42,
 -223,    0,  -73,    0,    0,    0,    0,  117, -219,    0,
    0,    0,  -88,   15,   19, -208,  -31,    0,    0,    0,
  117,  117,  117,  117,   29,  494,    0,    0,  117,    0,
   24, -194,  -85, -120,    0,  117,  -10,   36,   36,  520,
  547,  117,  117,  117,  117,  117,  117,  117,  117,  117,
  117,  117,  117,  117,  117,    0,  117,  558,  -36, -178,
   48,   46,    0,   32,    0,    0,  897,   52,   50,    0,
    0,  613,   25,   25,   25,   25,  147,  147,   25,   25,
   -9,   -9,   36,   36,   36,    0,    0,    0,    0, -178,
 -194,    0,    0,  117,    0, -254,  -25,    0,    0,  897,
  -33,    0,   56,   57,  117,  117,  117,  -30,    0,  641,
    0, -254,  117,  117,  741,  799,  810,  117,  117,  -11,
  -26,   -5,    0,    0,    0,   60,  836,    0,   44,   47,
   11,   33,   49,    0,    0,    0,    0, -154,    0,  -12,
    0,   55,    0,
};
final static short yyrindex[] = {                         0,
    0, -159,    0,    0,    0,  -27,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  355,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   71,    0,    0,    0,   72,  366,  392,  420,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   74,    0,    0,    0,    0,   13,    0,   75,    0,
    0,    0,  930,  943,  965, 1000,  -40,  -18, 1167, 1189,
  908,  917,  449,  458,  485,    0,    0,    0,    0,   -4,
    0,    0,    0,    0,    0,   77,    0,    0,    0,   35,
    0,    0,    0,    0,    0,    0,    0,  857,    0,    0,
    0,   77,    0,    0,    0,    0,    0,   72,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  886,    0,    0,    0,    0,  107,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
  -82,    0, -109,    0,    0,    0,    0,    0,    4,    0,
   17,    0,    0,    0,   78,    0,   76,    0,  -19, 1263,
    0,   -3,  -92,    0,
};
final static int YYTABLESIZE=1469;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         32,
   58,   19,   39,   58,   75,   18,   34,   47,   46,  128,
    3,   31,  130,   20,  139,  106,   30,  104,   58,    6,
   58,   32,   59,  141,  142,   59,   40,   65,   34,  122,
  131,  132,   63,   31,   11,  140,   67,   64,  104,   13,
   59,  152,   59,   32,   14,   24,   20,   25,   18,   26,
   34,   38,   58,   46,   41,   31,   46,   33,   42,   18,
   18,   65,   43,   30,   69,   32,   63,   61,   52,   62,
   67,   64,   34,   99,   59,   45,   70,   31,   45,   33,
   39,   67,   58,   15,   16,   17,   98,   32,  100,  101,
  102,  119,  103,  104,   34,  123,  124,  112,   47,   31,
  143,   33,  145,  108,   59,  146,  150,  149,    6,   33,
  151,   11,   44,  138,   10,   43,   33,  109,    9,   76,
   74,   33,    0,   33,  136,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  147,    0,    0,    0,   35,
    0,    0,    0,    0,    0,   33,   35,    0,    0,   32,
   43,   35,    0,    0,    0,    0,   34,  148,    0,    0,
    0,   31,    0,    0,    0,    0,    0,   33,    0,    0,
    0,    0,    0,   15,   16,   17,   15,   16,   17,  153,
    0,    0,    0,   65,    0,    0,    0,    0,   63,   61,
    0,   62,   67,   64,    0,    0,    0,   35,    0,    0,
    0,   33,    0,    0,    0,    0,   60,   33,   59,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   15,
   16,   17,    0,  113,  114,  115,  116,    0,   15,   16,
   17,   35,    0,  117,   30,   30,   30,  118,   58,   58,
    0,    0,   28,   29,   30,  113,  114,  115,  116,    0,
   15,   16,   17,    0,    0,  117,    0,    0,    0,  118,
   59,   59,    0,    0,   28,   29,   30,  113,  114,  115,
  116,    0,   15,   16,   17,    0,    0,  117,    0,    0,
    0,  118,    0,    0,    0,    0,   28,   29,   30,  113,
  114,  115,  116,    0,   15,   16,   17,    0,    0,  117,
    0,    0,    0,  118,    0,    0,    0,    0,   28,   29,
   30,  113,  114,  115,  116,    0,   15,   16,   17,    0,
    0,  117,    0,    0,    0,  118,    0,    0,    0,    0,
   28,   29,   30,   33,   33,   33,   33,    0,   33,   33,
   33,    0,    0,   33,    0,    0,    0,   33,    0,    0,
    0,    0,   33,   33,   33,    0,    0,    0,    0,    0,
    0,    0,    0,   35,   35,   35,   35,    0,   35,   35,
   35,    0,    0,   35,    0,    0,    0,   35,   15,   16,
   17,    0,   35,   35,   35,    0,    0,   27,    0,    0,
    0,   71,   28,   29,   30,   71,   71,   71,   71,   71,
   71,   71,   50,    0,    0,    0,   50,   50,   50,   50,
   50,   50,   50,   71,   71,   71,   71,    0,   53,   54,
   55,   56,    0,    0,   50,   50,   50,   50,   55,    0,
    0,    0,   55,   55,   55,   55,   55,    0,   55,    0,
    0,    0,    0,    0,    0,    0,    0,   71,    0,    0,
   55,   55,   55,   55,    0,    0,   66,    0,   50,    0,
   66,   66,   66,   66,   66,    0,   66,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   71,   66,   66,
   66,   66,    0,    0,   55,   48,    0,    0,   50,   48,
   48,   48,   48,   48,   49,   48,    0,    0,   49,   49,
   49,   49,   49,    0,   49,    0,    0,   48,   48,   48,
   48,    0,   66,    0,   55,    0,   49,   49,   49,   49,
    0,   52,    0,    0,    0,   52,   52,   52,   52,   52,
   65,   52,    0,    0,    0,   63,   61,    0,   62,   67,
   64,   48,   66,   52,   52,   52,   52,    0,    0,    0,
   49,    0,    0,   60,    0,   59,   65,    0,    0,    0,
    0,   63,   61,    0,   62,   67,   64,    0,    0,    0,
    0,   48,    0,    0,    0,    0,    0,   52,    0,   60,
   49,   59,    0,   65,    0,    0,   66,   81,   63,   61,
    0,   62,   67,   64,   65,    0,    0,    0,    0,   63,
   61,    0,   62,   67,   64,    0,   60,   52,   59,    0,
    0,    0,   80,    0,    0,    0,    0,   60,    0,   59,
    0,    0,    0,    0,    0,    0,   71,   71,   71,   71,
    0,    0,    0,   71,   71,    0,    0,   50,   50,   50,
   50,    0,    0,    0,   50,   50,    0,    0,    0,   65,
   97,    0,    0,  105,   63,   61,    0,   62,   67,   64,
    0,    0,    0,   55,   55,   55,   55,    0,    0,    0,
   55,   55,   60,    0,   59,    0,    0,   65,    0,    0,
    0,    0,   63,   61,    0,   62,   67,   64,    0,    0,
    0,   66,   66,   66,   66,    0,    0,    0,   66,   66,
   60,  129,   59,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   48,   48,   48,   48,    0,    0,    0,   48,   48,   49,
   49,   49,   49,    0,    0,    0,   49,   49,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   52,   52,   52,   52,
    0,    0,    0,   52,   52,   53,   54,   55,   56,    0,
    0,    0,   57,   58,    0,    0,    0,   65,    0,    0,
    0,    0,   63,   61,    0,   62,   67,   64,    0,    0,
    0,   53,   54,   55,   56,    0,    0,    0,   57,   58,
   60,    0,   59,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   53,   54,
   55,   56,    0,    0,    0,   57,   58,    0,    0,   53,
   54,   55,   56,    0,    0,   65,   57,   58,    0,    0,
   63,   61,    0,   62,   67,   64,   65,    0,    0,    0,
    0,   63,   61,    0,   62,   67,   64,    0,   60,    0,
   59,    0,    0,  133,    0,    0,    0,    0,  135,   60,
    0,   59,   65,    0,    0,    0,    0,   63,   61,    0,
   62,   67,   64,    0,   53,   54,   55,   56,    0,    0,
    0,   57,   58,   71,  144,   60,    0,   59,   71,   71,
    0,   71,   71,   71,    0,    0,    0,    0,    0,    0,
    0,    0,   53,   54,   55,   56,   71,   71,   71,   57,
   58,  134,   51,    0,    0,    0,    0,   51,   51,    0,
   51,   51,   51,   65,    0,    0,    0,    0,   63,   61,
    0,   62,   67,   64,    0,   51,   51,   51,   47,    0,
   47,   47,   47,    0,    0,    0,   60,   53,   59,   53,
   53,   53,    0,    0,    0,    0,   47,   47,   47,   47,
   60,    0,    0,   60,    0,   53,   53,   53,   53,    0,
    0,    0,    0,   61,    0,    0,   61,    0,   60,   60,
   60,   60,    0,    0,    0,    0,    0,    0,    0,    0,
   47,   61,   61,   61,   61,   62,    0,    0,   62,   53,
    0,    0,   53,   54,   55,   56,    0,    0,    0,   57,
   58,    0,   60,   62,   62,   62,   62,    0,    0,    0,
   47,    0,    0,    0,    0,   61,    0,    0,    0,   53,
   63,    0,    0,   63,    0,    0,    0,    0,    0,    0,
    0,    0,   60,    0,    0,    0,    0,   62,   63,   63,
   63,   63,    0,    0,    0,   61,    0,    0,    0,    0,
   53,   54,   55,   56,    0,    0,    0,   57,   58,    0,
    0,   53,   54,   55,   56,    0,    0,   62,   57,   58,
    0,    0,   63,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   53,   54,   55,
   56,    0,    0,    0,   57,   58,    0,    0,    0,    0,
    0,    0,   63,    0,    0,    0,    0,    0,   71,   71,
   71,   71,    0,    0,    0,   71,   71,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   51,   51,   51,
   51,    0,    0,    0,   51,   51,    0,    0,   53,   54,
   55,   56,    0,    0,    0,   57,   58,    0,    0,   47,
   47,   47,   47,    0,    0,    0,   47,   47,   53,   53,
   53,   53,    0,    0,    0,   53,   53,    0,    0,    0,
    0,   60,   60,   60,   60,    0,    0,   64,   60,   60,
   64,    0,    0,    0,   61,   61,   61,   61,    0,    0,
    0,   61,   61,    0,    0,   64,   64,   64,   64,   65,
    0,    0,   65,    0,    0,    0,   62,   62,   62,   62,
    0,    0,    0,   62,   62,    0,    0,   65,   65,   65,
   65,    0,    0,    0,    0,    0,    0,    0,    0,   64,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   63,   63,   63,   63,    0,    0,    0,   63,   63,
   36,   65,    0,    0,    0,    0,    0,    0,    0,   64,
    0,    0,    0,   48,   49,   50,   51,    0,    0,    0,
    0,   68,    0,    0,    0,    0,    0,    0,   77,    0,
    0,   65,    0,    0,   82,   83,   84,   85,   86,   87,
   88,   89,   90,   91,   92,   93,   94,   95,    0,   96,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  110,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  125,  126,  127,
    0,    0,    0,    0,    0,   77,   77,    0,    0,    0,
   77,  137,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   64,   64,
   64,   64,    0,    0,    0,   64,   64,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   65,   65,   65,   65,    0,    0,    0,   65,   65,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   41,   44,   91,   44,  125,   91,   40,   27,   40,   40,
  265,   45,  122,   10,   41,   98,   44,   44,   59,  271,
   61,   33,   41,  133,  134,   44,   23,   37,   40,  112,
  123,  124,   42,   45,  268,   41,   46,   47,   44,  266,
   59,  151,   61,   33,   59,  269,   43,  271,   91,  123,
   40,  271,   93,   41,   40,   45,   44,   91,   40,   91,
   91,   37,  271,   91,   41,   33,   42,   43,   40,   45,
   46,   47,   40,   70,   93,   41,  271,   45,   44,   91,
   91,   46,  123,  262,  263,  264,  123,   33,   41,   44,
   59,  125,   41,   44,   40,   40,   40,  123,  118,   45,
   41,   91,   59,  100,  123,   59,  261,   59,  268,   33,
  123,   41,   41,  125,   41,   41,   40,  101,  123,   44,
   43,   45,   -1,   91,  128,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  125,   -1,   -1,   -1,   33,
   -1,   -1,   -1,   -1,   -1,   91,   40,   -1,   -1,   33,
  271,   45,   -1,   -1,   -1,   -1,   40,  125,   -1,   -1,
   -1,   45,   -1,   -1,   -1,   -1,   -1,   91,   -1,   -1,
   -1,   -1,   -1,  262,  263,  264,  262,  263,  264,  125,
   -1,   -1,   -1,   37,   -1,   -1,   -1,   -1,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   -1,   91,   -1,   -1,
   -1,  125,   -1,   -1,   -1,   -1,   60,   91,   62,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  262,
  263,  264,   -1,  257,  258,  259,  260,   -1,  262,  263,
  264,  125,   -1,  267,  262,  263,  264,  271,  279,  280,
   -1,   -1,  276,  277,  278,  257,  258,  259,  260,   -1,
  262,  263,  264,   -1,   -1,  267,   -1,   -1,   -1,  271,
  279,  280,   -1,   -1,  276,  277,  278,  257,  258,  259,
  260,   -1,  262,  263,  264,   -1,   -1,  267,   -1,   -1,
   -1,  271,   -1,   -1,   -1,   -1,  276,  277,  278,  257,
  258,  259,  260,   -1,  262,  263,  264,   -1,   -1,  267,
   -1,   -1,   -1,  271,   -1,   -1,   -1,   -1,  276,  277,
  278,  257,  258,  259,  260,   -1,  262,  263,  264,   -1,
   -1,  267,   -1,   -1,   -1,  271,   -1,   -1,   -1,   -1,
  276,  277,  278,  257,  258,  259,  260,   -1,  262,  263,
  264,   -1,   -1,  267,   -1,   -1,   -1,  271,   -1,   -1,
   -1,   -1,  276,  277,  278,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  257,  258,  259,  260,   -1,  262,  263,
  264,   -1,   -1,  267,   -1,   -1,   -1,  271,  262,  263,
  264,   -1,  276,  277,  278,   -1,   -1,  271,   -1,   -1,
   -1,   37,  276,  277,  278,   41,   42,   43,   44,   45,
   46,   47,   37,   -1,   -1,   -1,   41,   42,   43,   44,
   45,   46,   47,   59,   60,   61,   62,   -1,  272,  273,
  274,  275,   -1,   -1,   59,   60,   61,   62,   37,   -1,
   -1,   -1,   41,   42,   43,   44,   45,   -1,   47,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,   -1,
   59,   60,   61,   62,   -1,   -1,   37,   -1,   93,   -1,
   41,   42,   43,   44,   45,   -1,   47,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  123,   59,   60,
   61,   62,   -1,   -1,   93,   37,   -1,   -1,  123,   41,
   42,   43,   44,   45,   37,   47,   -1,   -1,   41,   42,
   43,   44,   45,   -1,   47,   -1,   -1,   59,   60,   61,
   62,   -1,   93,   -1,  123,   -1,   59,   60,   61,   62,
   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,   45,
   37,   47,   -1,   -1,   -1,   42,   43,   -1,   45,   46,
   47,   93,  123,   59,   60,   61,   62,   -1,   -1,   -1,
   93,   -1,   -1,   60,   -1,   62,   37,   -1,   -1,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,   -1,
   -1,  123,   -1,   -1,   -1,   -1,   -1,   93,   -1,   60,
  123,   62,   -1,   37,   -1,   -1,   93,   41,   42,   43,
   -1,   45,   46,   47,   37,   -1,   -1,   -1,   -1,   42,
   43,   -1,   45,   46,   47,   -1,   60,  123,   62,   -1,
   -1,   -1,   93,   -1,   -1,   -1,   -1,   60,   -1,   62,
   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,  274,  275,
   -1,   -1,   -1,  279,  280,   -1,   -1,  272,  273,  274,
  275,   -1,   -1,   -1,  279,  280,   -1,   -1,   -1,   37,
   93,   -1,   -1,   41,   42,   43,   -1,   45,   46,   47,
   -1,   -1,   -1,  272,  273,  274,  275,   -1,   -1,   -1,
  279,  280,   60,   -1,   62,   -1,   -1,   37,   -1,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,
   60,   61,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,  272,
  273,  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,  274,  275,
   -1,   -1,   -1,  279,  280,  272,  273,  274,  275,   -1,
   -1,   -1,  279,  280,   -1,   -1,   -1,   37,   -1,   -1,
   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,   -1,
   -1,  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,
   60,   -1,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,
  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,  272,
  273,  274,  275,   -1,   -1,   37,  279,  280,   -1,   -1,
   42,   43,   -1,   45,   46,   47,   37,   -1,   -1,   -1,
   -1,   42,   43,   -1,   45,   46,   47,   -1,   60,   -1,
   62,   -1,   -1,  123,   -1,   -1,   -1,   -1,   59,   60,
   -1,   62,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,  272,  273,  274,  275,   -1,   -1,
   -1,  279,  280,   37,   59,   60,   -1,   62,   42,   43,
   -1,   45,   46,   47,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  272,  273,  274,  275,   60,   61,   62,  279,
  280,  123,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   37,   -1,   -1,   -1,   -1,   42,   43,
   -1,   45,   46,   47,   -1,   60,   61,   62,   41,   -1,
   43,   44,   45,   -1,   -1,   -1,   60,   41,   62,   43,
   44,   45,   -1,   -1,   -1,   -1,   59,   60,   61,   62,
   41,   -1,   -1,   44,   -1,   59,   60,   61,   62,   -1,
   -1,   -1,   -1,   41,   -1,   -1,   44,   -1,   59,   60,
   61,   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   93,   59,   60,   61,   62,   41,   -1,   -1,   44,   93,
   -1,   -1,  272,  273,  274,  275,   -1,   -1,   -1,  279,
  280,   -1,   93,   59,   60,   61,   62,   -1,   -1,   -1,
  123,   -1,   -1,   -1,   -1,   93,   -1,   -1,   -1,  123,
   41,   -1,   -1,   44,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  123,   -1,   -1,   -1,   -1,   93,   59,   60,
   61,   62,   -1,   -1,   -1,  123,   -1,   -1,   -1,   -1,
  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,   -1,
   -1,  272,  273,  274,  275,   -1,   -1,  123,  279,  280,
   -1,   -1,   93,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,  274,
  275,   -1,   -1,   -1,  279,  280,   -1,   -1,   -1,   -1,
   -1,   -1,  123,   -1,   -1,   -1,   -1,   -1,  272,  273,
  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,  274,
  275,   -1,   -1,   -1,  279,  280,   -1,   -1,  272,  273,
  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,  272,
  273,  274,  275,   -1,   -1,   -1,  279,  280,  272,  273,
  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,   -1,
   -1,  272,  273,  274,  275,   -1,   -1,   41,  279,  280,
   44,   -1,   -1,   -1,  272,  273,  274,  275,   -1,   -1,
   -1,  279,  280,   -1,   -1,   59,   60,   61,   62,   41,
   -1,   -1,   44,   -1,   -1,   -1,  272,  273,  274,  275,
   -1,   -1,   -1,  279,  280,   -1,   -1,   59,   60,   61,
   62,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,
   18,   93,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  123,
   -1,   -1,   -1,   31,   32,   33,   34,   -1,   -1,   -1,
   -1,   39,   -1,   -1,   -1,   -1,   -1,   -1,   46,   -1,
   -1,  123,   -1,   -1,   52,   53,   54,   55,   56,   57,
   58,   59,   60,   61,   62,   63,   64,   65,   -1,   67,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  104,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  115,  116,  117,
   -1,   -1,   -1,   -1,   -1,  123,  124,   -1,   -1,   -1,
  128,  129,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  272,  273,
  274,  275,   -1,   -1,   -1,  279,  280,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  272,  273,  274,  275,   -1,   -1,   -1,  279,  280,
};
}
final static short YYFINAL=1;
final static short YYMAXTOKEN=281;
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
"INT","FLOAT32","CHAR","VAR","STRUCT","RETURN","FUNC","MAIN","VOID","IDENT",
"IGUAL_IGUAL","MAYOR_IGUAL","MENOR_IGUAL","DISTINTO","CTE_ENTERA","CTE_REAL",
"CTE_CARACTER","AND","OR","MENOS_UNARIO",
};
final static String yyrule[] = {
"$accept : programa",
"programa : lista_definicion_variables lista_definicion_funciones FUNC MAIN '(' ')' '{' lista_definicion_variables lista_sentencias '}'",
"lista_definicion_variables : lista_definicion_variables definicion_variable",
"lista_definicion_variables :",
"definicion_variable : VAR variable ';'",
"lista_definicion_funciones : lista_definicion_funciones definicion_funcion",
"lista_definicion_funciones :",
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
"registros_struct : registro_struct",
"registros_struct : registros_struct registro_struct",
"registro_struct : IDENT tipo_variable ';'",
"tipo_variable : tipo",
"tipo_variable : tipo_vector",
"tipo : INT",
"tipo : FLOAT32",
"tipo : CHAR",
"tipo_vector : corchetes_tam tipo",
"corchetes_tam : '[' expresion ']'",
"corchetes_tam : corchetes_tam '[' expresion ']'",
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
"expresion : IDENT corchetes_tam",
"expresion : IDENT '(' lista_expresiones_opt ')'",
"expresion : expresion '%' expresion",
"expresion : expresion '-' expresion",
"expresion : cast",
"expresion : '-' expresion",
"expresion : '(' expresion ')'",
"expresion : '[' expresion ']'",
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

//#line 169 "../../src/sintactico/sintactico.y"

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
//#line 646 "Parser.java"
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
