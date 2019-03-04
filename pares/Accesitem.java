package pares;

public class Accesitem  implements Expression{
	Identifier t;
    Expression e;
	public Accesitem( Identifier t,
    Expression e) {
		// TODO Auto-generated constructor stub
		this.t=t;
		this.e=e;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		if(t.Pretty_Prints().length()==0){
			return "";
		}
		res+=t.Pretty_Prints();
		res+="[";
		res+=e.Pretty_Prints();
		res+="]";
		
		return res;
	}

}
