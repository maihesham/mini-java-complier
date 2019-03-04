package pares;

public class STRING_LITERAL implements Expression{
	String g;
	   String res=""; 
	public STRING_LITERAL(String f) {
		// TODO Auto-generated constructor stub
		this.g=f;
	    res=f;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		return res;
	}

}
