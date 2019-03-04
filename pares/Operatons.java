package pares;

import java.util.ArrayList;

public class Operatons implements Expression{
	Expression  a;
	Tokenssigns g;
	Expression  a1;
	String y="";
	public Operatons(Expression  a,
	Tokenssigns g,Expression  a1) {
		// TODO Auto-generated constructor stub
		this.a=a;
		this.g=g;
		this.a1=a1;
		y+=a.Pretty_Prints();
		y+=g.Pretty_Prints();
		y+=a1.Pretty_Prints();
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		return y;
	}

}
