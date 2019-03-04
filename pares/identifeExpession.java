package pares;

public class identifeExpession implements Expression{
   String t;
	public identifeExpession(String t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		return t;
	}

}
