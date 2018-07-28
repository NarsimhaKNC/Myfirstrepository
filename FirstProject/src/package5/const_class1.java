package package5;

public class const_class1 {
	/*const_class1(){
		//System.out.println("im in constructor");
	  System.out.println("am inconstructor without arguments");
	}
	const_class1(int a,int b){
		System.out.println("am in cinstructron with arguments");
	}
	public static void main(String[] args){
		const_class1 obj=new const_class1();
		const_class1 obj2=new const_class1(2,5);*/
	int a;
	String str;
	const_class1(){
		a=5;
		str="narsimha";
	}
	const_class1(int b,String s){
		b=6;
		s="tony";
	}
	void disc(){
		System.out.println(str+ "" +a);
	}
	public static void main(String[] args){
		const_class1 obj=new const_class1();
		const_class1 obj1=new const_class1(11,"naresh");
		//obj.disc();
		obj1.disc();
	}

}
