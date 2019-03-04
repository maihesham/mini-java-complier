package pares;

import java.util.ArrayList;

public class While_statment implements Statement {
/*"while" "(" Expression ")" Statement */
	Expression e;
	ArrayList<Statement> s=new ArrayList<Statement>();
	public While_statment(Expression ee,
			ArrayList<Statement> ss) {
		// TODO Auto-generated constructor stub
		e=ee;
		s=ss;
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		String res="";
		res+="while(";
		res+=e.Pretty_Prints();
		res+="){";
		for(int j=0;j<s.size();j++)
		       res+=s.get(j).Pretty_PrintsSt();
		res+="}";
		return res;
	}

}
