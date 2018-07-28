package polymorphism;

public class CC extends PC {
	void add(){
		System.out.println("im in child class");
	}
	public static void main(String[] args){
		CC obj=new CC();
		obj.add();

}
}
