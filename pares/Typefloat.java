package pares;

public class Typefloat  implements Type{
	String t;
	public Typefloat(String t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}
	@Override
	public String getvalue(){
		return t;
		
	}

}
