package pares;

public class VarDeclarationthis implements VarDeclaration {
    Type t;
    Identifier d;
    String x;
    String y;
	public VarDeclarationthis(Type T , Identifier D ,String x, String y) {
		// TODO Auto-generated constructor stub
		this.t=T;
		this.d=D;
		this.x=x;
		this.y=y;
	}

	@Override
	public String getvalue() {
		String res="";
		res+=t.getvalue();
		res+=" ";
		res+=d.Pretty_Prints();
		res+=x;
		res+=y;
		res+=" ; ";
	//	System.out.println(res);
		// TODO Auto-generated method stub
		return res;
	}

}
