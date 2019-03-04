package pares;

public class X implements Node{
/*X::= Identifier   Z  "="
=>Z::=  "[" Expression "]" | nothing*/
	Identifier id;
	Z z;
	String t="";
	public X(Identifier id1,Z z1) {
		// TODO Auto-generated constructor stub
		id=id1;
		z=z1;
		t+=id1.Pretty_Prints();
		t+=" ";
		t+=z.Pretty_Prints();
		t+=" = ";
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		
		return t;
	}

	@Override
	public boolean checkvalid() {
		// TODO Auto-generated method stub
		return false;
	}

}
