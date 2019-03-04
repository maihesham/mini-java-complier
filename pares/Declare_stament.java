package pares;

public class Declare_stament implements Statement {
/*X Expression ";"
=>X::= Identifier Z "="  
=>Z::=  "[" Expression "]" | nothing
*/
	X x;
	Expression e;
	String res="";
	public Declare_stament(X x1,
	Expression ee) {
		// TODO Auto-generated constructor stub
		x=x1;
		e=ee;
		 res="";
		res+=x1.Pretty_Prints() ;
		res+=ee.Pretty_Prints();
		res+=";";
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		
		return res;
	}

}
