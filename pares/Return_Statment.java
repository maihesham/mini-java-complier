package pares;

public class Return_Statment implements Statement{
   Expression e;
	public Return_Statment(Expression e) {
		// TODO Auto-generated constructor stub
		this.e=e;
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		String r="";
		r+="return ";
		r+=e.Pretty_Prints();
		r+=";";
		return r;
	}

}
