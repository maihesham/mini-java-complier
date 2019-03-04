package pares;

public class Accesfunction implements Expression {
    Expression f;
	public Accesfunction(Expression f) {
		// TODO Auto-generated constructor stub
		this.f=f;
	}
	@Override
	public String Pretty_Prints() {
		String res="";
		if(f.Pretty_Prints().length()==0){
			return "";
		}
		if(f.Pretty_Prints().length()>0){
			res+=".";
			res+=f.Pretty_Prints();
		}
		
		return res;
	}
	

}
