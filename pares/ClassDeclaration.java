package pares;

import java.util.ArrayList;

public class ClassDeclaration implements Classs{
	Identifier name;
	Identifier inh;
	ArrayList<VarDeclaration> V=new ArrayList<VarDeclaration>();
	ConstructorDeclaration C;
	ArrayList<MethodDeclaration> M =new ArrayList<MethodDeclaration>();
	public ClassDeclaration(Identifier n, Identifier i , ArrayList<VarDeclaration> v ,ConstructorDeclaration c , ArrayList<MethodDeclaration >m ) {
		// TODO Auto-generated constructor stub
		this.name=n;
		this.inh=i;
		this.V=v;
		this.C=c;
		this.M=m;
		
	}
/*"class" Identifier ( "extends" Identifier )? 
 * "{" ( VarDeclaration )* ( ConstructorDeclaration )* ( MethodDeclaration )* "}" */
	
	@Override
	public String Pretty_Prints() {
		String res="";
		res+="class   ";
		res+=name.Pretty_Prints();		
		res+="{  ";
		for(int i=0;i<V.size();i++){
			res+=V.get(i).getvalue();
			res+=" , ";
		}
	    res+=C.Pretty_Prints();
		res+="";
		for(int i=0;i<M.size();i++){
			res+=M.get(i).Pretty_Prints();
			res+=" , ";
		}
		res+="}";
		return res;
		// TODO Auto-generated method stub
		
	}
}
