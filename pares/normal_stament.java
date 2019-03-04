package pares;
import java.util.ArrayList;

public class normal_stament implements Statement{
   ArrayList<Statement> stam;  
	public normal_stament( ArrayList<Statement> s) {
		// TODO Auto-generated constructor stub
		stam=s;
	}

	@Override
	public String Pretty_PrintsSt() {
		// TODO Auto-generated method stub
		String res="";
		res+="{\n";
		for(int i=0;i<stam.size();i++){
			res+=stam.get(i).Pretty_PrintsSt();
			res+="";
		}
		res+="}";
		
		return res;
	}

}
