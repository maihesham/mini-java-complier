package pares;

public class Makearray implements Expression{
   Type t;
   Expression p;
	public Makearray(  Type t,
	   Expression p) {
		// TODO Auto-generated constructor stub
		this.t=t;
		this.p=p;
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		res+="new ";
		res+=t.getvalue();
		res+="[";
		res+=p.Pretty_Prints();
		res+="]";
		return res;
	}

}
