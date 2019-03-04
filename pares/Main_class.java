package pares;

import java.util.ArrayList;

public class Main_class implements Node{
	Identifier name;
	Identifier arg;
	ArrayList<Statement> s=new ArrayList<Statement>();
	public Main_class(Identifier n,Identifier arg, ArrayList<Statement> s) {
		// TODO Auto-generated constructor stub
		this.name=n;
		this.s=s;
		this.arg=arg;
	}
	
/*"class" Identifier 
 * "{" "public" "static" "void" "main" "(" "String" "[" "]" Identifier ")" "{" Statement "}" "}" */
	

@Override
public String Pretty_Prints() {
	// TODO Auto-generated method stub
	String res="";
	res+="Class ";
	res+=name.Pretty_Prints();
	res+="{";
	String z="    public static void main ( String[ ]  ";
	res+=z;
	res+=arg.Pretty_Prints();
	res+=") {";
	for(int j=0;j<s.size();j++)
	    res+=s.get(j).Pretty_PrintsSt();
	res+="}";
//	System.out.println(res);
	return res;
	
}

@Override
public boolean checkvalid() {
	// TODO Auto-generated method stub
	return false;
}

}
