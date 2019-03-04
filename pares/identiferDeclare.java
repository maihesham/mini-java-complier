package pares;

public class identiferDeclare  implements Identifier  , AvExpression{
    String token;
	public identiferDeclare(String t) {
		// TODO Auto-generated constructor stub
		token=t;
	}

	@Override
	public String Pretty_Prints() {
		String r="";
		r+=token;
		return r;
	}

}
