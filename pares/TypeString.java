package pares;

public class TypeString implements Type {
	String t;
	public TypeString(String t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}

	@Override
	public String getvalue() {
		// TODO Auto-generated method stub
		return t;
	}

}
