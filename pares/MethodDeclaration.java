package pares;

import java.util.ArrayList;

public class  MethodDeclaration extends MethodDeclarationforall{
    Type type;
	Expression e;
	ArrayList<Statement> s= new ArrayList<Statement>();
    /*("public" | "private" | "protected") Type Identifier 
"(" ( Type Identifier ( "," Type Identifier )*)? ")" 
"{" ( VarDeclaration )* ( Statement )* "return" Expression ";" "}"
*/
	public MethodDeclaration(Type r,Identifier n,ArrayList<Type> Ts,ArrayList<Identifier> id, 
			ArrayList<VarDeclaration> v, ArrayList<Statement> S ) {
		// TODO Auto-generated constructor stub
		this.type=r;
		this.name=n;
		this.t=Ts;
		this.d=id;
		this.v=v;
	
		this.s=S;
	}

	@Override
	public String Pretty_Prints() {
		String res="";
		res+=type.getvalue();
		res+=" ";
		res+=name.Pretty_Prints();
		res+="(";
		for(int i=0;i<t.size();i++){
			res+=t.get(i).getvalue();
			res+=" ";
			res+=d.get(i).Pretty_Prints();
			if(i+1<t.size()){
				res+=" , ";
			}
		}
		if(t.size()>0){
			res+=")";
		}
		res+=")  {";
		for(int i=0;i<v.size();i++){
			res+=v.get(i).getvalue();
		}
		for(int i=0;i<s.size();i++){
			res+=s.get(i).Pretty_PrintsSt();
		}
		
		res+="}";
		// TODO Auto-generated method stub
		return res;
	}

	@Override
	public boolean checkvalid() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
