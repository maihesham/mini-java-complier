package pares;

public class nullstatment implements  Statement{
    String t;
	public nullstatment( String t) {
		// TODO Auto-generated constructor stub
		this.t=t;
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		return t;
	}

}
