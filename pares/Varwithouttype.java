package pares;

public class Varwithouttype implements VarDeclaration{
    Identifier i;
    String th;
    String y;
    String t;
	public Varwithouttype( String th,Identifier i,String y,
    String t) {
		// TODO Auto-generated constructor stub
		this.i=i;
		this.t=t;
		this.y=y;
		this.th=th;
		
	}

	@Override
	public String getvalue() {
		// TODO Auto-generated method stub
		String res="";
		res+=th;
		res+=i.Pretty_Prints();
		res+=y;
		res+="=";
		res+=t;
		return res;
	}

}
