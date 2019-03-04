package pares;

public class accesLenght  implements Expression {
	Identifier i;
	Tokenssigns p ; Expression t;
	public accesLenght( Identifier i , Tokenssigns p , Expression t) {
		// TODO Auto-generated constructor stub
		this.i=i;
		this.p=p;
		this.t=t;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String res="";
		if(i.Pretty_Prints().length()==0){
			return "";
		}
		res+=i.Pretty_Prints();
		res+=".Lenght";
		res+=p.Pretty_Prints();
		res+=t.Pretty_Prints();
		return res;
	}

}
