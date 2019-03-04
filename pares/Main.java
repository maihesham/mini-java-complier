package pares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
	static Queue<fullqueueoftokens> Tokens = new LinkedList<fullqueueoftokens>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		fullqueue();
		 Parser_class p=new  Parser_class(Tokens);
		 p.gotoall();
		   

	}
	private static void fullqueue() throws IOException {
		// TODO Auto-generated method stub
		 File file = new File("C:/Users/BaZoOKa/Desktop/TESTCASE6_CLASS1_TOKENS.txt");
		 
		  BufferedReader br = new BufferedReader(new FileReader(file));
		 
		  String st;
		  while ((st = br.readLine()) != null){
			  fullqueueoftokens g=fullqueueoftokensfromfile(st);
			
			  if(!g.token.equals("EOL") && !g.token.equals("M_COMMENTS") && 
					  !g.token.equals("S_COMMENTS")){
				  Tokens.add(g);
			//	System.out.println(g.token+" "+g.value);
			  }
			  
		  }
		  fullqueueoftokens g1 = new fullqueueoftokens("EOL","End of line");
		  Tokens.add(g1);
		//  System.out.println(g1.token+" "+g1.value);
		  
	}
	private static fullqueueoftokens fullqueueoftokensfromfile(String st) {
		// TODO Auto-generated method stub
		
		String x="",y="";
		int i=1;
		while(true){
			x+=st.charAt(i);
			i++;
			if(st.charAt(i)=='>'){
				break;
			}
		}
		while(true){
			if(st.charAt(i)=='>'||st.charAt(i)==' '||st.charAt(i)==':'){
				i++;
			}else{break;}
		}
		while(true){
			y+=st.charAt(i);
			i++;
			if(i>=st.length() ){
				break;
			}
		}
		
		fullqueueoftokens l = new fullqueueoftokens(clean(x),clean(y));
	//	System.out.println("."+l.token+". ."+l.value+".");
		return l;
	}
	public static String clean(String x){
		String f="";
		for(int i=0;i<x.length();i++){
			if(x.charAt(i)==' '){
				continue;
			}
			f+=x.charAt(i);
		}
		return f;
	}
		
	

}
