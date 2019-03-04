package pares;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {
    
    EOL ("\\z"),
    INT ("(?<![a-zA-Z0-9])(int)(?![a-zA-Z0-9])"),
    LEFT_CURLY_B ("\\{"),
    RIGHT_CURLY_B ("\\}"),
    LEFT_SQUARE_B ("\\["),
    RIGHT_SQUARE_B ("\\]"),
    LEFT_ROUND_B ("\\("),
    RIGHT_ROUND_B ("\\)"),
    COMMA (","),
    SEMICOLON (";"),
    NOT ("!"),
    EQUAL("=="),
    ASSIGNMENT ("="),
    AND ("&&"),
    PLUS ("\\+"),
    DOT ("\\."),
    MINUS ("-"),
    MULTIPLY ("\\*"),
    GREATERTHAN (">"),
    LESSTHAN ("<"),
    IF  ("(?<![a-zA-Z0-9])(if)(?![a-zA-Z0-9])"),
    ELSE  ("(?<![a-zA-Z0-9])(else)(?![a-zA-Z0-9])"),
    MAIN  ("(?<![a-zA-Z0-9])(main)(?![a-zA-Z0-9])"),
    THIS  ("(?<![a-zA-Z0-9])(this)(?![a-zA-Z0-9])"),
    TRUE  ("(?<![a-zA-Z0-9])(true)(?![a-zA-Z0-9])"),
    VOID  ("(?<![a-zA-Z0-9])(void)(?![a-zA-Z0-9])"),
    CLASS  ("(?<![a-zA-Z0-9])(class)(?![a-zA-Z0-9])"),
    STRING  ("(?<![a-zA-Z0-9])(string)(?![a-zA-Z0-9])"),
    FALSE  ("(?<![a-zA-Z0-9])(false)(?![a-zA-Z0-9])"),
    WHILE  ("(?<![a-zA-Z0-9])(while)(?![a-zA-Z0-9])"),
    LENGTH  ("(?<![a-zA-Z0-9])(length)(?![a-zA-Z0-9])"),
    PUBLIC  ("(?<![a-zA-Z0-9])(public)(?![a-zA-Z0-9])"),
    PRIVATE  ("(?<![a-zA-Z0-9])(private)(?![a-zA-Z0-9])"),
    PROTECTED  ("(?<![a-zA-Z0-9])(protected)(?![a-zA-Z0-9])"),
    RETURN  ("(?<![a-zA-Z0-9])(return)(?![a-zA-Z0-9])"),
    STATIC  ("(?<![a-zA-Z0-9])(static)(?![a-zA-Z0-9])"),
    FLOAT  ("(?<![a-zA-Z0-9])(float)(?![a-zA-Z0-9])"),
    CHARACTER  ("(?<![a-zA-Z0-9])(char)(?![a-zA-Z0-9])"),
    BOOLEAN  ("(?<![a-zA-Z0-9])(boolean)(?![a-zA-Z0-9])"),
    EXTENDS  ("(?<![a-zA-Z0-9])(extends)(?![a-zA-Z0-9])"),
    NULL  ("(?<![a-zA-Z0-9])(null)(?![a-zA-Z0-9])"),
    ABSTRACT  ("(?<![a-zA-Z0-9])(abstract)(?![a-zA-Z0-9])"),
    ASSERT  ("(?<![a-zA-Z0-9])(assert)(?![a-zA-Z0-9])"),
    BREAK  ("(?<![a-zA-Z0-9])(break)(?![a-zA-Z0-9])"),
    CONTINUE  ("(?<![a-zA-Z0-9])(continue)(?![a-zA-Z0-9])"),
    BYTE  ("(?<![a-zA-Z0-9])(byte)(?![a-zA-Z0-9])"),
    CASE  ("(?<![a-zA-Z0-9])(case)(?![a-zA-Z0-9])"),
    CATCH  ("(?<![a-zA-Z0-9])(catch)(?![a-zA-Z0-9])"),
    CONST  ("(?<![a-zA-Z0-9])(const)(?![a-zA-Z0-9])"),
    DEFAULT  ("(?<![a-zA-Z0-9])(default)(?![a-zA-Z0-9])"),
    DO  ("(?<![a-zA-Z0-9])(do)(?![a-zA-Z0-9])"),
    DOUBLE  ("(?<![a-zA-Z0-9])(double)(?![a-zA-Z0-9])"),
    ENUM  ("(?<![a-zA-Z0-9])(ENUM)(?![a-zA-Z0-9])"),
    FINAL  ("(?<![a-zA-Z0-9])(final)(?![a-zA-Z0-9])"),
    FINALLY ("(?<![a-zA-Z0-9])(finally)(?![a-zA-Z0-9])"),
    FOR  ("(?<![a-zA-Z0-9])(for)(?![a-zA-Z0-9])"),
    GOTO  ("(?<![a-zA-Z0-9])(goto)(?![a-zA-Z0-9])"),
    IMPLEMENTS  ("(?<![a-zA-Z0-9])(implements)(?![a-zA-Z0-9])"),
    IMPORT  ("(?<![a-zA-Z0-9])(import)(?![a-zA-Z0-9])"),
    INSTANCEOF ("(?<![a-zA-Z0-9])(instanceof)(?![a-zA-Z0-9])"),
    INTERFACE  ("(?<![a-zA-Z0-9])(interface)(?![a-zA-Z0-9])"),
    SHORT  ("(?<![a-zA-Z0-9])(short)(?![a-zA-Z0-9])"),
    SUPER  ("(?<![a-zA-Z0-9])(super)(?![a-zA-Z0-9])"),   
    SWITCH  ("(?<![a-zA-Z0-9])(switch)(?![a-zA-Z0-9])"),
    THROW ("(?<![a-zA-Z0-9])(throw)(?![a-zA-Z0-9])"),
    TRY ("(?<![a-zA-Z0-9])(try)(?![a-zA-Z0-9])"),
    SYSTEM_OUT_PRINTLN ("System.out.println"),
    FLOAT_LITERAL("[0-9]\\d*\\.[0-9]\\d*"),
    INTEGRAL_LITERAL("[1-9]\\d*"),
    STRING_LITERAL ("\"[^\"]+\""),
    S_COMMENTS ("//"),
    M_COMMENTS ("(/\\*.*?\\*/)"),
    ID ("\\w+");    
    private final Pattern pattern;
    	
    
    Map<Token,String> full_map(){
	   Map<Token,String> x=new HashMap<Token,String>();
	   x.put(EOL,"EOL");
	   x.put(STATIC ,"STATIC");
	   x.put(FLOAT ,"FLOAT");
	   x.put(CHARACTER,"CHARACTER");
	   x.put(BOOLEAN ,"BOOLEAN");
	   x.put(EXTENDS,"EXTENDS");
	   x.put(NULL,"NULL");
	   x.put(ABSTRACT ,"ABSTRACT");
	   x.put(ASSERT ,"ASSERT");
	   x.put(BREAK ,"BREAK");
	   x.put(INT,"INT"); 
	   x.put(LEFT_CURLY_B ,"LEFT_CURLY_B");
	   x.put(RIGHT_CURLY_B,"RIGHT_CURLY_B");
	   x.put( LEFT_SQUARE_B," LEFT_SQUARE_B");
	   x.put(RIGHT_SQUARE_B ,"RIGHT_SQUARE_B");
	   x.put(LEFT_ROUND_B,"LEFT_ROUND_B");
	   x.put( RIGHT_ROUND_B ,"RIGHT_ROUND_B");
	   x.put(COMMA,"COMMA");
	   x.put(SEMICOLON ,"SEMICOLON ");
	   x.put(NOT,"NOT");
	   x.put(ASSIGNMENT, "ASSIGNMENT");
	   x.put(EQUAL,"EQUAL");
	   x.put(AND,"AND");
	   x.put(PLUS,"PLUS");
	   x.put(DOT,"DOT");
	   x.put(MINUS,"MINUS");
	   x.put(MULTIPLY,"MULTIPLY");
	   x.put(GREATERTHAN,"GREATERTHAN");
	   x.put(LESSTHAN,"LESSTHAN");
	   x.put(IF,"IF");
	   x.put(ELSE ,"ELSE");
	   x.put(MAIN,"MAIN");
	   x.put(THIS ,"THIS");
	   x.put(TRUE,"TRUE");
	   x.put(VOID ,"VOID");
	   x.put(CLASS,"CLASS");
	   x.put(STRING,"STRING");
	   x.put(FALSE ,"FALSE");
	   x.put(WHILE ,"WHILE");
	   x.put(LENGTH,"LENGTH");
	   x.put(PUBLIC,"PUBLIC");
	   x.put(PRIVATE,"PRIVATE");
	   x.put(PROTECTED,"PROTECTED");
	   x.put(RETURN ,"RETURN");
	   x.put(CONTINUE,"CONTINUE");  
	   x.put( BYTE  ,"BYTE");
	   x.put( CASE ,"CASE"); 
	   x.put( CATCH  ,"CATCH");
	x.put( CONST  ,"CONST");
	x.put( DEFAULT ,"DEFAULT"); 
	x.put( DO  ,"DO");
 x.put( DOUBLE  ,"DOUBLE");
x.put( ENUM  ,"ENUM");
 x.put( FINAL  ,"FINAL");
x.put( FINALLY ,"FINALLY");
	    x.put(FOR  ,"FOR");
	    x.put(GOTO  ,"GOTO");
	    x.put(IMPLEMENTS  ,"IMPLEMENTS");
	    x.put(IMPORT  ,"MPORT");
	    x.put(INSTANCEOF ,"INSTANCEOF");
	    x.put(INTERFACE  ,"INTERFACE");
	    x.put(SHORT ,"SHORT");
	    x.put(SUPER  ,"SUPER"); 
	    x.put(SWITCH  ,"SWITCH");
	    x.put(THROW ,"THROW");
	    x.put(TRY ,"TRY");
	    x.put(SYSTEM_OUT_PRINTLN ,"SYSTEM_OUT_PRINTLN");
	    x.put(FLOAT_LITERAL,"FLOAT_LITERAL");
	    x.put(INTEGRAL_LITERAL,"INTEGRAL_LITERAL");
	    x.put(STRING_LITERAL ,"STRING_LITERAL");
	    x.put(S_COMMENTS ,"S_COMMENTS");
	    x.put(M_COMMENTS ,"M_COMMENTS");
	    x.put(ID ,"ID"); 
	   
	   
	   return x;
   }
    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    int endOfMatch(String s) {
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }

        return -1;
    }
}