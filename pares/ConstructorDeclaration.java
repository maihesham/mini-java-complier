package pares;

import java.util.ArrayList;

public class ConstructorDeclaration extends MethodDeclarationforall implements Node {
/*Identifier 
"(" ( Type Identifier ( "," Type Identifier )*)? ")" 
"{" ( VarDeclaration )* ( Statement )* "}" 
*/
	ArrayList<Statement> s;
	ArrayList<Varwithouttype> V=new ArrayList<Varwithouttype>();
	public ConstructorDeclaration(Identifier n, ArrayList<Type> T ,ArrayList<Identifier>  D ,ArrayList<Varwithouttype> V ,  ArrayList<Statement> S  ) {
		// TODO Auto-generated constructor stub
		this.name=n;
		this.t=T;
		this.d=D;
		this.V=V;
		this.s=S;
	}
	public String Pretty_Prints(){
		if(name.Pretty_Prints().length()==0){
			return "";
			}
		String res="";
		res+=name.Pretty_Prints();
		res+="(";
		for(int i=0;i<t.size();i++){
			res+=t.get(i).getvalue();
			res+=" ";
			res+=d.get(i).Pretty_Prints();
			if(i+1<t.size()){
				res+="( , ";
			}
		}
		if(t.size()>0){
			res+=")";
		}
		res+=")  {";
		for(int i=0;i<V.size();i++){
			res+=V.get(i).getvalue();
			res+=" , ";
		}
		for(int i=0;i<s.size();i++){
			res+=s.get(i).Pretty_PrintsSt();
		}
		
		res+="};";
	//	System.out.println(res);
		return res;
		
	}
	public String getvlaue() {
		// TODO Auto-generated method stub
		return null;
	}

}
