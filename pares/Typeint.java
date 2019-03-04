package pares;

public  class Typeint implements Type {
	String t;
	public Typeint(String t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}
	@Override
	public String getvalue(){
		return t;
		
	}

}
