package pares;

public class Accesbythis implements Expression{
    Expression e;
    String res="";;
	public Accesbythis(Expression e) {
		// TODO Auto-generated constructor stub
		this.e=e;
	}	
         @Override
  public String Pretty_Prints() {
        	 if(e.Pretty_Prints().length()==0){
        		 return "";
        	 }
	res+="this.";
	res+=e.Pretty_Prints();
	return res;
}
         }


