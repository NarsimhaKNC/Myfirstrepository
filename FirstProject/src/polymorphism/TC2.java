package polymorphism;

public class TC2 extends TC1 {
	int x=12;
	int y=34;
	void add(int x,int y){
		System.out.println("im in TC2");
		System.out.println(x+y);
	}
	void sub(int x,int y){
		System.out.println(y-x);
	}
	public static void main(String[] args){
		TC2 obj1=new TC2();
		obj1.add(obj1.x,obj1.y,obj1.c);
		obj1.sub(obj1.y, obj1.b);
		obj1.add(5,6);
		
		
	}

}
