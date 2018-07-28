package polymorphism;

public class secondabstract extends firstabstract {
	 public void add() {
		System.out.println("im in method");
	}public void sub(){
		System.out.println("im in movie");
		
	}public void mul(){
		System.out.println();
	}
	
	public static void main(String[] args){
		firstabstract obj=new secondabstract();
		obj.add();
		obj.sub();
		
		
		
	}

}

