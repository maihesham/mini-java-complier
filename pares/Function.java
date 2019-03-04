package pares;

import java.util.ArrayList;

public class Function implements Expression{
    Identifier i;
    ArrayList<Expression> send;
	public Function(Identifier i1,
    ArrayList<Expression> send1) {
		// TODO Auto-generated constructor stub
		i=i1;
		send=send1;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		res+=i.Pretty_Prints();
		res+="(";
		for(int j=0;j<send.size();j++){
			res+=send.get(j).Pretty_Prints();
			if(j+1<send.size()){
				res+=",";
			}
		}
		res+=")";
		return res;
	}

}
