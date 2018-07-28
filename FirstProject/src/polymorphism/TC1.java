package polymorphism;

public class TC1 {
	int a=20;
	int b=20;
	int c=45;
	void add(int a,int b){
		
		
		System.out.println(a+b);
	}
	void add(int a,int b,int c){
		System.out.println(a+b+c);
	}
		public static void main(String[] args){
			TC1 obj=new TC1();
			obj.add(obj.a,obj.b,obj.c);
			
			
		
			
			
		}
	}


