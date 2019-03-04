package pares;

public class Print_statment implements Statement{
/*::="system.out.println" "(" Expression ")" ";"*/
	Expression e;
	public Print_statment(Expression v) {
		// TODO Auto-generated constructor stub
		e=v;
	}

	@Override
	public String Pretty_PrintsSt() {
		String res="";
		res+="system.out.println(";
		res+=e.Pretty_Prints();
		res+=");";
		return res;
	}

}
