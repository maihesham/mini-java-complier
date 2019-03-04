package pares;

public class NotExpression  implements Expression{
	Expression t;
	public  NotExpression(Expression t){
		this.t=t;
	}
	@Override
	public String Pretty_Prints() {
		// TODO Auto-generated method stub
		String f="";
		f+="!(";
		f+=t.Pretty_Prints();
		f+=")";
		return f;
	}
	

}
