package pares;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Parser_class {
	
static Queue<fullqueueoftokens> Tokens = new LinkedList<fullqueueoftokens>();
public fullqueueoftokens q(){return Tokens.peek();}
public void d(){Tokens.poll();}
public Parser_class(Queue<fullqueueoftokens> pq) {this.Tokens=pq;}
public Goal gotoall(){
	     ArrayList<ClassDeclaration>  C=new ArrayList<ClassDeclaration>();
	     Main_class M=mainclass();
    	 C=ClassDelare();
    	
    	 Goal G=new Goal(C,M);
    	 G.Pretty_Prints();
    	return G;
    }
public Identifier identefier(){
    	//Done
    	fullqueueoftokens t=q();
    	if (t.token.equals("ID")){
    		d();
    		Identifier i=new identiferDeclare(t.value);
    		return i;
    	}
		return null;
    }
   
 public void error(){
		System.out.println("erorr");

 }
 public  Main_class mainclass(){
		//Done
	 Identifier name = null;
		 if(q().token.equals("CLASS")){
			 d();
		   name=identefier();
		 }
		 if(q().token.equals("LEFT_CURLY_B")){
			 d();
		 }
				if (q().token.equals("PUBLIC")) {
					Tokens.poll();
					if (q().token.equals("STATIC")) {
						Tokens.poll();
						if (q().token.equals("VOID")) {
							Tokens.poll();	
							if (q().token.equals("MAIN")) {
								Tokens.poll();
								if (q().token.equals("LEFT_ROUND_B")) {
									Tokens.poll();
									
									if (q().token.equals("STRING")) {
										Tokens.poll();
										
										if (q().token.equals("LEFT_SQUARE_B")) {
											Tokens.poll();
											if (q().token.equals("RIGHT_SQUARE_B")) {
												Tokens.poll();
												Identifier arg = identefier();
												if (q().token.equals("RIGHT_ROUND_B")) {
													Tokens.poll();
													if (q().token.equals("LEFT_CURLY_B")) {
														Tokens.poll();
														ArrayList<Statement> s=new ArrayList<Statement>();
														s=stmentsinconcstruct("RIGHT_CURLY_B");
														
														 if (q().token.equals("SEMICOLON")){
															 d();
														 }
														if (q().token.equals("RIGHT_CURLY_B")) {
															Tokens.poll();
															if(q().token.equals("EOL")){d();}
															if (q().token.equals("RIGHT_CURLY_B")) {
																Tokens.poll();
																if (q().token.equals("SEMICOLON")){
																	 d();
																 }
																if(q().token.equals("EOL")){d();}
																
																return new Main_class(name,arg,s);
																
															}
														}

													}
													
												}
											}
										}
									}
								}
							}
						}
					}
				}
				return null;
		}
 public ArrayList<ClassDeclaration> ClassDelare() {
		
	    ArrayList<ClassDeclaration> C=new ArrayList<ClassDeclaration>();
	    while(true){
	    	//System.out.println("start while " + q().token);
	    	
	    	if(Tokens.isEmpty()){break; }
	    	if(q().token.equals("EOL") ){d();}
	    	if(Tokens.isEmpty()){break; }
	    	if(q().token.equals("RIGHT_CURLY_B")){d();}
	    	if(Tokens.isEmpty()){break; }
	    	if(q().token.equals("SEMICOLON") ){d();}
	    	if(Tokens.isEmpty()){break; }
	    	Identifier i=null;
	    	Identifier i2=null;
	    	ArrayList<VarDeclaration> v=new ArrayList<VarDeclaration>();
	    	ConstructorDeclaration c=null;
	    	ArrayList<MethodDeclaration> M = new ArrayList<MethodDeclaration>();
	    	//System.out.println("LO");
	    	if(q().token.equals("CLASS")){
	    	//	System.out.println(q().token);
	    		d();
	    		 
	    		if(q().token.equals("ID")){
	    		//	System.out.println(q().token);
	    			 i=identefier();
	    			 
	    			 if(q().token.equals("EXTENDS")){
	    				d();
	    				i2=identefier();
	    			}
	    			 
	    			if(q().token.equals("LEFT_CURLY_B")){
	    				
	    			//	System.out.println(q().token);
	    				d();
	    				v=VarDeclarations();///////////////////
	    			//	System.out.println("backfrom varDeclartion");
	    				c=ConstructorDeclarations();
	    				//System.out.println(c.Pretty_Prints());
	    			//	System.out.println("backfrom ConstructorDeclarations");
	    				M=MethodDeclarations();
	    			//	System.out.println("backfrom MethodDeclarations");
	    			}
	    			if(q().token.equals("RIGHT_CURLY_B")){
	    				d();
	    				//System.out.println(")");
	    			}
	    		//	System.out.println("ddddd" +q().token);
	    			ClassDeclaration l=new ClassDeclaration(i,i2,v,c,M);
	    		    C.add(l);		 
	    			
	    		}else{
	    			error();
	    		}
	    	}
	    
 	
 		
 	}
	//    System.out.println(C.size());
		return C;
	}
public ArrayList<Varwithouttype> VarDeclarationswithouttypr(){
	 ArrayList<Varwithouttype> V=new ArrayList<Varwithouttype>();
	// System.out.println("from function ");
	 while(true){
		 if(q().token.equals("RIGHT_CURLY_B")){
			 break;
		 }
		 String th="";
		 String y="";
		 String f="";
		 if(q().token.equals("THIS")){
			 th+=q().value;
			 th+=".";
			 d();
			 d();
		 }
		 Identifier i=identefier();
	//	 System.out.println(i.Pretty_Prints());
		 if(q().token.equals("LEFT_SQUARE_B")){d();y+="["; y+=q().value; d();d();y+="]";}
		 if(q().token.equals("ASSIGNMENT")){
			 d();
		 }
		
		 while(!q().token.equals("SEMICOLON")){
			 f+=q().value;
			 d();
		 }
		 d();
		 
		 Varwithouttype s=new Varwithouttype(th,i,y,f);
		 V.add(s);
		 
	 }
	 return V;
 }
 public ArrayList<VarDeclaration> VarDeclarations(){
	   ArrayList<VarDeclaration> V=new ArrayList<VarDeclaration>();
	   String x="",y="";
	   while(true){
		  // 
		   if(notype()==false){System.out.println(q().token);break;}
		   Type t=type();
		   Identifier i=identefier();
		   if(q().token.equals("SEMICOLON")){
			   d();
			   VarDeclaration c=new VarDeclarationthis(t,i , "", "");
			   V.add(c);
		   }else{
			   if(q().token.equals("ASSIGNMENT")){
				   x=q().value;
				   d();
				   if(q().token.equals("INTEGER_LITERAL")||q().token.equals("STRING_LITERAL")
						   || q().token.equals("FLOAT_LITERAL")){
					     y=q().value;
					     d();
					   //  System.out.println(x+" "+y+" "+t.getvalue()+" "+i.Pretty_Prints());
					      VarDeclaration c=new VarDeclarationthis(t,i , x, y);
					     // System.out.println("c   ");  
						   V.add(c);
						 //  V.get(0).getvalue();
						 //  System.out.println(V.size());
						   if(q().token.equals("SEMICOLON")){
							   d();
						}
						 //  System.out.println("after one "+q().token);
				   }
			   }
		   }
		  
		   
		  // System.out.println("after one "+q().token);
	   }
	 //  System.out.println(q().token);
	   return V;
	
}
 public boolean notype(){
		if(q().token.equals("INT") || q().token.equals("FLOAT")||q().token.equals("STRING")
				||q().token.equals("CHARACTER")||q().token.equals("BOOLEAN")){
			return true;
		}
		return false;
	}

public Type typetodeclare(){
	 if(q().token.equals("INT")){
		 return new Typeint("int");
	 }else if(q().token.equals("FLOAT")){
		 return new Typefloat("float");
	 }else if(q().token.equals("STRING")){
		 return new TypeString("String");
	 }else {
		 return new Typechar("char");
	 }
}
 public Type type(){
		   if(q().token.equals("INT")){
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   return new Typeintarr("int[]");
				   }else{error();return null;}
			   }else{
				   return new Typeint("int");
			   }
		   }else  if(q().token.equals("FLOAT")){
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   return new Typefloatarr("float[]");
				   }else{error();return null;}
			   }else{
				   return new Typefloat("float");
			   }
		   }else  if(q().token.equals("STRING")){
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   return new TypeStringarr("String[]");
				   }else{error();return null;}
			   }else{
				   return new TypeString("String");
			   }
		   }else  if(q().token.equals("BOOLEAN")){
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   return new Typebooleanarr();
				   }else{error();return null;}
			   }else{
				   return new Typeboolean();
			   }
			   
		   }else if(q().token.equals("CHARACTER")){
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   return new Typechararr("char[]");
				   }else{error();return null;}
			   }else{
				   return new Typechar("char");
			   }
		   }
		   d();
		return new Typevoid();
		   
	 }
	 public ConstructorDeclaration ConstructorDeclarations(){

		 Identifier i =new identiferDeclare("");
		 ArrayList<Type> T = new ArrayList<Type>();
		 ArrayList<Identifier>  D = new ArrayList<Identifier>();
		 ArrayList<Varwithouttype> V=new ArrayList<Varwithouttype>();
		 ArrayList<Statement> s=new ArrayList<Statement>();
		// System.out.println("inside function "+q().token);
		
		   if(q().token.equals("ID")){
			    i=identefier();
			   if(q().token.equals("LEFT_ROUND_B")){
				   d();
				   GetTypes(T,D);
				 //  System.out.println("here  "+q().token);
				   if(q().token.equals("RIGHT_ROUND_B")){
					   d();
					//   System.out.println("here  "+q().token);
					   if(q().token.equals("LEFT_CURLY_B")){
						//  System.out.println("sizes "+T.size()+" "+D.size());
						   d();
						//   V=VarDeclarationswithouttypr();
						 // System.out.println("hello   "+V.get(0).getvalue());
						    s=stmentsinconcstruct("RIGHT_CURLY_B");
						   if(q().token.equals("RIGHT_CURLY_B")){
							   d();
							   return new ConstructorDeclaration(i,T,D,V,s);
						   }
						   
					   }
				   }
			   }
		   }
		 //  System.out.println("inside function "+q().token);
		   return new ConstructorDeclaration(i,T,D,V,s);
		   
	 }
	 public void GetTypes( ArrayList<Type> T , ArrayList<Identifier>  D){
		   while(true){
			 //  System.out.println("e  "+q().token);
			   if(!notype()){break;}
			   Type t=type();
			   Identifier i=identefier();
			//   System.out.println("from gesend "+t.getvalue() +" "+ i.Pretty_Prints());
			   T.add(t);
			    D.add(i);
			   if(q().token.equals("COMMA")){
				   d();
				   if(q().token.equals("RIGHT_ROUND_B")){
					    break;
				   }
			   }
			   if(q().token.equals("RIGHT_ROUND_B")){
				   break;
			   }
			 
		   }
		   
	 }

	public  ArrayList<Statement> stmentsinconcstruct(String tokenstop){
		 ArrayList<Statement> s=new  ArrayList<Statement>();
		
		 while(true){
			// System.out.println( " next "+q().value);
			 if(q().token.equals(tokenstop)){
				 break;
			 }
			
			 Statement s1=statement();
		   
			 s.add(s1);
			
		 }
		
		 return s;
		
	}
	 public Declare_stament declare_stament() {
			X x=null;
			Expression e1=new nullexpression();
			Expression e=new nullexpression() ;
			 Z  z=new Z (e,false);
			if(q().token.equals("ID")){
				Identifier i=identefier();
				
				if(q().token.equals("LEFT_SQUARE_B")){
					  d();
					  e=getexpressions();
					   z=new Z(e,true);
					 
					  if(q().token.equals("RIGHT_SQUARE_B")){
						  d();
					  }else{
						  error();
					  }	    
					   
				}
				x=new X(i,z);
				boolean m=false;
			//	System.out.println("from x this "+x.Pretty_Prints());
				if(q().token.equals("ASSIGNMENT")){
					Tokens.poll();
					m=true;
					
					e1=getexpressions();
				//	System.out.println("after assement  "+e1.Pretty_Prints());
					
				}
			   if(q().token.equals("SEMICOLON")){
						Tokens.poll();
					}
				}
			
			Declare_stament D= new Declare_stament(x,e1);
		//	System.out.println("from x "+q().token + " "+ D.Pretty_PrintsSt());
			return D;
		       
		}
    public   ArrayList<MethodDeclaration> MethodDeclarations(){
			ArrayList<MethodDeclaration> p=new ArrayList<MethodDeclaration>();
			
		 	while(true){
		 		if(q().token.equals("PUBLIC")||q().token.equals("PRIVATE")
		 				||q().token.equals("PROTECTED")){
		 			d();
		 			
		 			Type t=type();
		 			//System.out.println("l  "+q().token +" "+t.getvalue());
		 			Identifier i=identefier();
		 		//	System.out.print("f "+t.getvalue() + " "+i.Pretty_Prints());
		 			if(q().token.equals("LEFT_ROUND_B")){
		 				d();
		 				ArrayList<Type> T = new ArrayList<Type> () ;
		 			    ArrayList<Identifier>  D = new ArrayList<Identifier> ();
		 				GetTypes(T,D);
		 			//	System.out.println("send items "+T.size()+ " "+ D.size());
		 				   if(q().token.equals("RIGHT_ROUND_B")){
		 					//  System.out.println(" ( "+q().token);
		 					   d();
		 					   if(q().token.equals("LEFT_CURLY_B")){
		 						  
		 						   d();
		 						 ArrayList<VarDeclaration> x =new ArrayList<VarDeclaration>();
		 						 x=VarDeclarations();
		 						
		 						ArrayList<Statement> s=new ArrayList<Statement>();
		 					//	System.out.println(" } "+q().token+" "+s.size());
		 						s=stmentsinconcstruct("RIGHT_CURLY_B");
		 						
		 					
		 						if(q().token.equals("RIGHT_CURLY_B")){
		 								   d();
		 						}
		 					 MethodDeclaration m=new MethodDeclaration(t,i,T,D,x,s);
		 					  p.add(m);
		 						//System.out.println("add in array " + m.Pretty_Prints());
		 							   }
		 						   }
		 					   }
		 		}else{
		 			//System.out.println("m "+q().token);
		 			return p;
		 		}
		 	}
		 	
		 }

 public  normal_stament normal_Statment() {
		// TODO Auto-generated method stub
		//done
		ArrayList<Statement> q=new ArrayList<Statement>();
		Tokens.poll();
		
		while(!q().token.equals("RIGHT_CURLY_B")){
			Statement s=statement();
			q.add(s);
		}
		Tokens.poll();
		return new normal_stament(q);
		
		
	}
 public Print_statment print_Statment() {
		// TODO Auto-generated method stub
			if(q().token.equals("LEFT_ROUND_B")){
				d();
				
			 
				//System.out.println("from print expression "+q().token +" "+q().value);
				Expression e= getexpressions();
				
			  if(q().token.equals("RIGHT_ROUND_B")){
					d();
				  if(q().token.equals("SEMICOLON")){
							d();
							//System.out.println("from print expression "+e.Pretty_Prints() + 
								//	" "+ q().token);
								return new Print_statment(e);
								
								}
							
						}}
			return null;
 }		
 public While_statment while_statment() {
		// TODO Auto-generated method stub
		//done
	
		if(q().token.equals("WHILE")){
			d();
			if(q().token.equals("LEFT_ROUND_B")){
				d();
				Expression e=getexpressions();
				if(q().token.equals("RIGHT_ROUND_B")){
					d();
					if(q().token.equals("LEFT_CURLY_B")){d();}
					ArrayList<Statement>  s=stmentsinconcstruct("RIGHT_CURLY_B");
					if(q().token.equals("RIGHT_CURLY_B")){
						d();
					}
					//System.out.println("afete hile "+ s.size() + " "+q().value);
					return new While_statment(e,s);
				}else{
					error();
				}
			}else{error();}
		}else{error();}
		return null;
		
	}
 public IFstatment if_stament() {
		//done
		Statement s =new nullstatment("");
		if(q().token.equals("IF")){
			d();
			//System.out.println("in if ");
			if(q().token.equals("LEFT_ROUND_B")){
				d();
				//System.out.println("from if " + q().value);
				Expression e= getexpressions();
				
				if(q().token.equals("RIGHT_ROUND_B")){
					
					d();
					if(q().token.equals("LEFT_CURLY_B")){
						 d();
						
					}
					
					s= statement();
					Statement d=new nullstatment(""); 
					Else_cont t=new Else_cont(d);
					boolean tt=false;
					if(q().token.equals("ELSE")){
						 d();
					     t=else_stament();
					     tt=true;
					     
					}
					//System.out.println("g " + t.Pretty_PrintsSt());
					IFstatment B=new  IFstatment(e,s,t,tt);
					//System.out.println(B.Pretty_PrintsSt() +"from if ");
					return B;
				}else{error();}
			}else{error();}
		}
		return null;
		
	}
 public Else_cont else_stament() {
		// TODO Auto-generated method stub
		//done
		if(q().token.equals("IF")){
			return new Else_cont(if_stament());
		}else{
			
			Statement s= statement();
			
			return new Else_cont(s);
		}
	}
 public Return_Statment return_stament(){
	 if(q().token.equals("RETURN")){
		 d();
		 Expression e=getexpressions();
		 if(q().token.equals("SEMICOLON")){d();}
		 return new Return_Statment(e);
	 }
	return null;
	 
 }
 public ArrayList<Expression> somesendExpression(){
	 ArrayList<Expression> t=new ArrayList<Expression>();
	 while(!q().token.equals("RIGHT_ROUND_B")){
		 Expression r=getexpressions();
		 t.add(r);
	 }
	 return t;
 }
 public Statement statement(){
 	//done
 	
 	if(q().token.equals("LEFT_CURLY_B")){
 	    d();
 	    return normal_Statment();
 	}else if(q().token.equals("SYSTEM.OUT.PRINTLN")){
 		d();
 		return print_Statment();
 	}else if(q().token.equals("WHILE")){
 		return while_statment();
 	}else if(q().token.equals("IF")){
 		return if_stament();
 	}else if(q().token.equals("ID")){
 		//System.out.println("Declare ");
 		return declare_stament();
 	}else if(q().token.equals("ELSE")){
 	    Tokens.poll(); 
 		return else_stament();
 	}else if(q().token.equals("RETURN")){
 		return return_stament();
 	}
	nullstatment s=new nullstatment("");
	return s;
 	
 }
 public Expression getexpressions(){
	 Expression e=new nullexpression();
	 if(q().token.equals("NOT")){
		 d();
		 if(q().token.equals("LEFT_ROUND_B")){
			 d();
		 }
		Expression t=getexpressions();
		if(q().token.equals("RIGHT_ROUND_B")){
			d();
		}
		NotExpression n=new NotExpression(t);
		return n;
	 }
	 if(q().token.equals("LEFT_ROUND_B")){
		 d();
		// System.out.println(q().token);
		Expression u=getexpressions();
		if(q().token.equals("RIGHT_ROUND_B")){
			d();
		}
		return u;
	 }
	 if(q().token.equals("TRUE")){
		 d();
		 if(q().token.equals("SEMICOLON")){
			 d();
		 }
		 Expression t=new True();
		 return t;
	 }
	 if(q().token.equals("FALSE")){
		 Expression t=new False();
		 d();
		 if(q().token.equals("SEMICOLON")){
			 d();
		 }
		 return t;
	 }
	 if(q().token.equals("INTEGRAL_LITERAL")){
		 Expression t=new INTEGRAL_LITERAL(q().value);
		 d();
		 if(isop()==  false){
			 return  t;
		 }
		 
	 }
	 if(q().token.equals("FLOAT_LITERAL")){
		 Expression t=new FLOAT_LITERAL(q().value);
		 d();
		 if(isop()==  false){
			 return  t;
		 }
		 
	 }
	 if(q().token.equals("STRING_LITERAL")){
		 Expression t=new STRING_LITERAL(q().value);
		 d();
		 if(isop()==  false){
			 return  t;
		 }
	 }
	 if(q().token.equals("A_CHAR")){
		 Expression t=new A_CHAR(q().value);
		 d();
		 if(isop()==  false){
			 return  t;
		 }
	 }
	 if(q().token.equals("ID")){
		 Expression c=new identifeExpession(q().value);
		 Identifier x=identefier();
		 if( q().token.equals("DOT")){
			 d();
			 if(q().token.equals("LENGTH")){
				 d();
				if( isop()==  false){
					Expression e2=new nullexpression();
					Tokenssigns k=new tokensignull();
					Expression t=new accesLenght(x ,  k , e2);
					return t;
			     }else {
			    	 Tokenssigns p=makesigns();
			    	 Expression e1=getexpressions();
			    	 Expression t=new accesLenght(x , p , e1);
			    	 return t;
			    	 
			     }
		 }else if(q().token.equals("ID")){
			 // x . id acces object 
			 Expression p=getexpressions();
			 Accesobject l=new Accesobject(x,p);
			 return l;
		 }
	 }else if(q().token.equals("LEFT_SQUARE_B")){
		 
		 d();
		 Expression r=getexpressions();
		 
		 if(q().token.equals("RIGHT_SQUARE_B")){
			 d();
			 Expression t=new Accesitem(x,r);
			 if( isop()==  false){
				//	System.out.println("enter ger "+q().value);
					return t;
			     }else {
			    	 Tokenssigns p=makesigns();
					 Expression y=getexpressions();
					 
					 Expression op=new Operatons(t, p, y);
					// System.out.println(op.Pretty_Prints());
					 return  op ;
			     }
			 
		 }
		 
	 }else if(isop()){
		
		 Tokenssigns p=makesigns();
	//	 System.out.println("from get expression "+ x.Pretty_Prints() + p.Pretty_Prints());
		 Expression y=getexpressions();
		 Expression op=new Operatons(c, p, y);
		 return op;
		 
	 }else if(q().token.equals("LEFT_ROUND_B")){
		 d();
		 ArrayList<Expression > t=new ArrayList<Expression >();
		 
		 t=somesendExpression();
		
		 if(q().token.equals("RIGHT_ROUND_B")){
			 d();
			 if(q().token.equals("SEMICOLON")){
				 d();
			 }
		 }
		 Expression f=new Function(x, t);
		 
		 return f;
		 
	 }else {
		 return c;
	 }
	 }
	 if(q().token.equals("NEW")){
		 d();
		 if(q().token.equals("ID")){
			 Expression c=new identifeExpession(q().value);
			 Identifier x=identefier();
			 
			 if(q().token.equals("LEFT_ROUND_B")){
				 d();
				//send some expression 
				 ArrayList<Expression > Y=new  ArrayList<Expression >();
				 Y=somesendExpression();
				 
				 if(q().token.equals("RIGHT_ROUND_B")){
					 d();
					
					 if(q().token.equals("DOT")){
						 d();
						
						 Expression f=getexpressions();
						// System.out.println("from new get function  ");
						 Accesfunction c1=new Accesfunction(f);
						// System.out.println("from new acess function "+ c1.Pretty_Prints());
						 createbject r=new createbject(x,Y,c1);
						 return r;
					 }
					 else{
						 d();
						 Expression t=new nullexpression();
						 createbject r=new createbject(x,Y,t);
						 return r;
					 } 
				 }
				 
			 }
		 }else if(notype()){
			   Type t=typetodeclare();
			   d();
			   if(q().token.equals("LEFT_SQUARE_B")){
				   d();
				   Expression r=getexpressions();
				 //  System.out.println("from type "+ r.Pretty_Prints());
				   if(q().token.equals("RIGHT_SQUARE_B")){
					   d();
					   if(q().token.equals("SEMICOLON")){
						   d();
					   }
				   }
				   Expression Z1=new Makearray(t, r);
				  // System.out.println(Z1.Pretty_Prints());
				   return Z1;
				   
			   }
		 }
		 
	 }
	 if(q().token.equals("THIS")){
		 d();
		 if(q().token.equals("DOT")){
			 d();
			 if(q().token.equals("ID")){
				 Expression s=getexpressions();
				 Accesbythis g=new Accesbythis(s);
				// System.out.println("from this "+g.Pretty_Prints());
		
				 return g;
				 
			 }
		 }
	 }
	 return e;
 }
 public Tokenssigns makesigns(){
		Tokenssigns w=null;
		if(q().token.equals("PLUS")){
			d();
			w=new Plus();
			
		}else if(q().token.equals("MINUS")){
			d();
			w=new MINUS();
			
		}else if(q().token.equals("MULTIPLY")){
			d();
			w=new Multiply();
		}else if(q().token.equals("DIV")){
			d();
			w=new Divide();
		}else if(q().token.equals("AND")){
			d();
			w=new And();
		}else if(q().token.equals("OR")){
			d();
			w=new Or();
			
		}else if(q().token.equals("EQUAL")){
			d();
			w=new Equal();
		}else if(q().token.equals("GREATERTHAN" )){
			d();
			w=new Lessthan();
		}else if(q().token.equals("GREATER_EQ")){
			d();
			w=new  Lesstnaorequal();
		}else if(q().token.equals("LESSTHAN" )){
			d();
			w=new  Greatertnan();
		}else if(q().token.equals("LESS_EQ")){
			d();
			w=new Greaterthanorequal();
		}else if(q().token.equals("NOT")){
			d();
			if(q().token.equals("ASSIGNMENT")){
				d();
			//	System.out.println("from sign "+q().value);
			}
			w=new NotEqual();
		}
		return w;}
 public boolean isop(){
		if(q().token.equals("PLUS")||q().token.equals("MINUS")||
				q().token.equals("MULTIPLY")||q().token.equals("DIV")||
				q().token.equals("GREATERTHAN" )||
				q().token.equals("LESSTHAN" )||q().token.equals("LESS_EQ")
				|| q().token.equals("GREATER_EQ") ||
				q().token.equals("EQUAL") || q().token.equals("NOT")
				|| q().token.equals("OR") || q().token.equals("AND")){
				return true;
			}
			return false;
		}
 /*
 
 
 
 public Makearray makenewarray()	{
		Type t=type();
		if(q().token.equals("LEFT_SQUARE_B")){
			d();
			Avabltoken1 at=Avabltokensto();
			if(q().token.equals("RIGHT_SQUARE_B")){
				d();
				return new  Makearray(t,at);
			}else{
				error();
			}
		}else{
			error();
		}
		return null;
		
	}
 public tokenIdentifer tokenIdentiferidentefier(){
 	if (q().token.equals("ID")){
 		tokenIdentifer i=new tokenIdentifer(q().value);
 		d();
 		return i;
 	}
		return null;
 }	
 public Avabltoken1 Avabltokensto(){
		//done
		if(q().token.equals("ID")){
			return new tokenIdentifer(q().value);
		}else if(q().token.equals("INTEGER_LITERAL")){
			return new tokenInt(q().value);
		}else if(q().token.equals("THIS")){
			d();
			if(q().token.equals("DOT")){
				tokenDot d=new tokenDot(q().value);
				if(q().token.equals("ID")){
					tokenIdentifer i=tokenIdentiferidentefier();
					return new tokenthis(d,i);
				}else{
					error();
				}
			}else{
				error();
			}
			
		}else{
			error();
		}
		return null;
		
	}
 public createbject createbjectnew(){
	 if(q().token.equals("ID")){
		 Identifier i=identefier();
		 Accesfunction a =null;
		 ArrayList<MinExpression>x= whatsend("RIGHT_ROUND_B");
		 if(q().token.equals("RIGHT_ROUND_B")){
			 d();
			 if(q().token.equals("DOT")){
				   d();
				   if(q().token.equals("ID")){
					   Identifier z=identefier();
					  a= accesfunction(z);
					  if(q().token.equals("SEMICOLON")){
						  d();
					  }
					  return new createbject(i,x,a);
				   }
			 }else{
				 if(q().token.equals("SEMICOLON")){
					  d();
				  }
				 return new createbject(i,x,a);
			 }
		 }
	 }
	 error();
	return null;
 }
 public Function functionit(Identifier i){
		//done
		ArrayList<MinExpression> r=null;
		if(q().token.equals("LEFT_ROUND_B")){
			d();
		   r=whatsend("RIGHT_ROUND_B");
		   if(q().token.equals("RIGHT_ROUND_B")){
				 d();
		}
		}
		return new Function(i,r);
	}
	public Accesfunction accesfunction(Identifier i){
		//Donr
		Function f=functionit(i);
		return new Accesfunction(f);
	}
 public ArrayList<MinExpression> whatsend(String stop){
		//done
		ArrayList<MinExpression> w=null;
		while(true){
			if(q().token.equals(stop)){
				break;
			}
			MinExpression m=MinExpressionthis();
			//System.out.println("hee");
			if(q().token.equals("COMMA")){
				d();
			}
			
			w.add(m);
		}
		return w;
	}
 public Expression expression() {
		// TODO Auto-generated method stub
		if(q().token.equals("NEW")){
			//done
			d();
			if(notype()){
				Makearray e=makenewarray();
				return e;
			}else if(q().token.equals("ID")){
				createbject e=createbjectnew();
				return e;
			}
		}
		
		return MinExpressionthis();
	
	}  
 

 public MinExpression MinExpressionthis(){
		//function expession
		if(q().token.equals("NOT")){
			d();
			if(q().token.equals("LEFT_ROUND_B")){
				NotExpression n=(NotExpression) MinExpressionthis();
				if(q().token.equals("RIGHT_ROUND_B")){
					d();
					return n;
				}
			}
		}
		if(q().token.equals("INT")||q().token.equals("FLOAT")
				||q().token.equals("TRUE")||q().token.equals("FALSE")){
			AvExpression t = null;
			if(q().token.equals("INT")){
				t=new tokenInt(q().value);
			}else if(q().token.equals("FLOAT")){
				t=new Tokenfloat(q().value);
			}else if(q().token.equals("TRUE")){
				t=new True(q().value);
			}else if(q().token.equals("FALSE")){
				t=new False(q().value);
			}
			String y=q().token;
			d();
			Operatons  e=make_operations(t,y);
			return e;
		}
		if(q().token.equals("THIS")){
			d();
			if(q().token.equals("DOT")){
				d();
				if(q().token.equals("ID")){
					String o=q().value;
					Identifier i=identefier();
					if(q().token.equals("LEFT_ROUND_B")){
						Function f=functionit(i);
						accesfunctionbythis s=new accesfunctionbythis(f);
						if(q().token.equals("RIGHT_ROUND_B")){d();}
						if(anysign()){
							AvExpression t = null;
							t=s;
							Operatons  e=make_operations(t,"");
							return e;
						}else{
							return s;
						}
					}else if(anysign()){
						tokenDot z=new tokenDot(".") ;
						tokenIdentifer b=new tokenIdentifer(o);
						tokenthis p=new tokenthis(z,b);
						AvExpression t = null;
						t=p;
						Expression e=make_operations(t,"this.ide");
						
					}else if(q().token.equals("LEFT_SQUARE_B")){
						tokenDot z=new tokenDot(".") ;
						tokenIdentifer b=new tokenIdentifer(o);
						TokenArray p=new tokenthis(z,b);
						Avabltoken1 x=Avabltokensto();
						if(q().token.equals("RIGHT_SQUARE_B")){
							d();
						}
						Accesitem k=new Accesitem(p,x);
						if(anysign()){
							AvExpression t = null;
							t=k;
							Operatons  e=make_operations(t,"this.itemofarray");
							return e;
						}else{
							return k;
						}
					}else if(q().token.equals("DOT")){
						d();
						if(q().token.equals("LENGTH")){
							tokenDot z=new tokenDot(".") ;
							tokenIdentifer b=new tokenIdentifer(o);
							TokenArray p=new tokenthis(z,b);
							d();
							accesLenght r=new accesLenght(p);
							if(anysign()){
								AvExpression t = null;
								t=r;
								Operatons  e=make_operations(t,"this.lenght");
								return e;
							}else{
								return r;
							}
							
						}
					}
				}
			}
		}
		if(q().token.equals("ID")){
			String y=q().value;//id name 
			TokenArray p=new  tokenIdentifer(q().value);
			Identifier i=identefier(); // id identifer 
			if(q().token.equals("LEFT_ROUND_B")){
				Function f=functionit(i);
				if(q().token.equals("RIGHT_ROUND_B")){d();}
				if(anysign()){
					AvExpression t = null;
					t=f;
					Operatons  e=make_operations(t,"function");
					return e;
				}else{
					if(q().token.equals("SEMICOLON")){
						d();
					}
					return f;
				}
			}else if(q().token.equals("DOT")){
				d();
				if(q().token.equals("ID")){
					Accesobject a=acccessobject(i);
					return a;
				}else if(q().token.equals("LENGTH")){
					d();
					accesLenght r=new accesLenght(p);
					if(anysign()){
						AvExpression t = null;
						t=r;
						Operatons  e=make_operations(t,".lenght");
						return e;
					}else{
						return r;
					}
					
				}
			}else if(q().token.equals("LEFT_SQUARE_B")){
				TokenArray a=new tokenIdentifer(y);
				Avabltoken1 x=Avabltokensto();
				if(q().token.equals("RIGHT_SQUARE_B")){
					d();
				}else{
					error();
					return null;
				}
				Accesitem k=new Accesitem(a,x);
				if(anysign()){
					AvExpression t = null;
					t=k;
					Operatons  e=make_operations(t,"itemarray");
					return e;
				}else{
					return k;
				}
			}
		}
		Expression e=new nullexpression();
		return (MinExpression) e;
		
	}
	
 
	public Accesobject acccessobject(Identifier i){
		//done
			if(q().token.equals("ID")){
				Identifier ii=identefier();
				ArrayList<MinExpression> r=whatsend("RIGHT_ROUND_B");
                if(q().token.equals("RIGHT_ROUND_B")){
                	d();
                	if(q().token.equals("SEMICOLON")){d();}
                	return new Accesobject(i,ii,r);
                }
			}
		
		error();
		return null;
	}
	public boolean checkvalid(String y){
		if(y=="true"||y=="flase"){
			if(q().token.equals("AND") || q().token.equals("OR")
					|| q().token.equals("EQUAL") ||q().token.equals("NOT_EQUAL")){
				 return true;			
				 }
		}
		return false;
		
	}
	
	public Operatons make_operations(AvExpression t,String y){
		if(!checkvalid(y)){
			error();
			return null;
		}
		ArrayList<Group>g=null;
		while(true){
			Tokenssigns c=makesigns();
			if(c==null){
				error();
				break;
			}
			if(q().token.equals("LEFT_ROUND_B" )||q().token.equals("RIGHT_ROUND_B" )){d();}
			String v=q().value;
			AvExpression a = makeAvaExpression();
			if(!checkvalid(v) ||a==null){
				error();
				return null;
			}
			Group x=new Group (c,a);
			g.add(x);
			if(q().token.equals("LEFT_ROUND_B" )||q().token.equals("SEMICOLON")){
				break;
			}
		}
		Operatons o=new Operatons(t,g);
		return o;

	}
public AvExpression makeAvaExpression(){
	if(q().token.equals("INT")||q().token.equals("FLOAT")
			||q().token.equals("TRUE")||q().token.equals("FALSE")){
		AvExpression t = null;
		if(q().token.equals("INT")){
			t=new tokenInt(q().value);
		}else if(q().token.equals("FLOAT")){
			t=new Tokenfloat(q().value);
		}else if(q().token.equals("TRUE")){
			t=new True(q().value);
		}else if(q().token.equals("FALSE")){
			t=new False(q().value);
		}
		String y=q().token;
		d();
		Operatons  e=make_operations(t,y);
		return t;
	}
	if(q().token.equals("THIS")){
		d();
		if(q().token.equals("DOT")){
			d();
			if(q().token.equals("ID")){
				String o=q().value;
				Identifier i=identefier();
				if(q().token.equals("LEFT_ROUND_B")){
					Function f=functionit(i);
					accesfunctionbythis s=new accesfunctionbythis(f);
					if(q().token.equals("RIGHT_ROUND_B")){d();}
					AvExpression t = null;
					t=s;
					return t;
				}else if(q().token.equals("LEFT_SQUARE_B")){
					tokenDot z=new tokenDot(".") ;
					tokenIdentifer b=new tokenIdentifer(o);
					TokenArray p=new tokenthis(z,b);
					Avabltoken1 x=Avabltokensto();
					if(q().token.equals("RIGHT_SQUARE_B")){
						d();
					}
					Accesitem k=new Accesitem(p,x);
					AvExpression t = null;
					t=k;
					return t;
				}else if(q().token.equals("LENGTH")){
					   d();
						tokenDot z=new tokenDot(".") ;
						tokenIdentifer b=new tokenIdentifer(o);
						TokenArray p=new tokenthis(z,b);
						d();
						accesLenght r=new accesLenght(p);
						AvExpression t = null;
						t=r;
						return t;
						
					
				}else{
					tokenDot z=new tokenDot(".") ;
					tokenIdentifer ip=new tokenIdentifer(o) ;
					tokenthis f=new tokenthis(z,ip);
				}
			}
		}
	}
	if(q().token.equals("ID")){
		String y=q().value;//id name 
		TokenArray p=new  tokenIdentifer(q().value);
		Identifier i=identefier(); // id identifer 
		if(q().token.equals("LEFT_ROUND_B")){
			Function f=functionit(i);
			if(q().token.equals("RIGHT_ROUND_B")){d();}
			
				AvExpression t = null;
				t=f;
				return t;
		}else if(q().token.equals("DOT")){
			d();
		      if(q().token.equals("LENGTH")){
				d();
				 accesLenght r=new accesLenght(p);
				
					AvExpression t = null;
					t=r;
					return t;
				
			}
		}else if(q().token.equals("LEFT_SQUARE_B")){
			TokenArray a=new tokenIdentifer(y);
			Avabltoken1 x=Avabltokensto();
			if(q().token.equals("RIGHT_SQUARE_B")){
				d();
			}else{
				error();
				return null;
			}
			Accesitem k=new Accesitem(a,x);
			
				AvExpression t = null;
				t=k;
				return t;
		}
	}
	return null;
}*/
///////////////////////////////////////////////////////////Done 
}