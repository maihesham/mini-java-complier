

package pares;

public class Z implements Node{
	Expression e; 
	String res=" ";
	boolean d;
	public Z(Expression e , boolean d) {
		// TODO Auto-generated constructor stub
		if(d==true){
			res+="[";
			res+=e.Pretty_Prints();
			res+="]";
		}
		
		
	}

	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		
		return res;
	}

	@Override
	public boolean checkvalid() {
		// TODO Auto-generated method stub
		return false;
	}

}
