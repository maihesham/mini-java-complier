package pares;

import java.util.ArrayList;

public class createbject implements Expression{
	Identifier i;
    ArrayList<Expression> send;
    Expression a;
	public createbject(Identifier i1,
    ArrayList<Expression> send1,
    Expression a1) {
		// TODO Auto-generated constructor stub
		i=i1;
		send=send1;
		a=a1;
	}
/*::="new" Identifier "(" (MinExpression ( "," MinExpression)*)? ")" accessfunction*/
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		res+="new";
		res+=i.Pretty_Prints();
		res+="(";
		for(int j=0;j<send.size();j++){
			res+=send.get(j).Pretty_Prints();
			if(j+1<send.size()){
				res+=",";
			}
		}
		res+=")";
		res+=a.Pretty_Prints();
		return res;
	}

}
