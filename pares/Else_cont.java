package pares;

public class Else_cont implements Statement{
	Statement s;
	public Else_cont(Statement ss) {
		// TODO Auto-generated constructor stub
		s=ss;
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		String res="";
		res+="else  ";
		res+=s.Pretty_PrintsSt();
		
		return res;
	}

}
