package pares;

import java.util.ArrayList;

public class Accesobject implements Expression{
	Identifier i;
    Expression k;
	public Accesobject(Identifier i,
			 Expression k) {
		// TODO Auto-generated constructor stub
		this.i=i;
		this.k=k;
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		res+=i.Pretty_Prints();
		res+=".";
		res+=k.Pretty_Prints();
		return res;
	}

}
