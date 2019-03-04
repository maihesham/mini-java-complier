package pares;

import java.util.ArrayList;

public class Goal implements Node {
	 ArrayList<ClassDeclaration>  C;
	 Main_class m;
	public Goal(  ArrayList<ClassDeclaration> temp2 ,Main_class m) {
		// TODO Auto-generated constructor stub
		this.m=m;
		C=temp2;
		
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
	    String res="";
		res+=m.Pretty_Prints();
		for(int i=0;i<C.size();i++)
		      res+=C.get(i).Pretty_Prints() ;
		System.out.println(res);
		return res;
		
		
	}

	@Override
	public boolean checkvalid() {
		// TODO Auto-generated method stub
		return false;
	}

}
