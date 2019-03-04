package pares;

public class IFstatment implements Statement{
/*if_statment::= "if" "(" Expression ")" statement Else_cont*/
	/*cont::= "else" Statement | nothing*/
	Expression e;
	Statement s;
	Else_cont els;
	String res="";
	boolean f;
	public IFstatment(	Expression ee,
	Statement ss,
	Else_cont el , boolean f) {
		// TODO Auto-generated constructor stub
		e=ee;
		s=ss;
		els=el;
		
		res+="if(";
		res+=ee.Pretty_Prints();
		//System.out.println("from if construct "+ res );
		res+="){";
		res+=ss.Pretty_PrintsSt();
		res+="}";
		if(f==true)
		       res+=el.Pretty_PrintsSt();
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		
		
		return res;
	}

}
