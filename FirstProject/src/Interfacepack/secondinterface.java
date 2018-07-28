import.java.lang;
package Interfacepack;


/*public class secondinterface implements firstinterface{
	public void add(){
		System.out.println(5+1);
	}
   public void sub(){
	   System.out.println();
   }public void mul(){
	   System.out.println(5/2);
   }public void some(){
	   System.out.println();
   }
   public static void main(String[] args){
	   secondinterface obj=new secondinterface();
	   
	   obj.add();
	   obj.mul();
	   
	   
	   
   }
   
}*/

thirdinterface extends firstinterface{
	public void add(){
		System.out.println("im in abstract interface");
	}
}
class secondinterface implements thirdinterface{
	public void some(){
		System.out.println("say something");
	}

	public static void main(String args[]){  
		// TODO Auto-generated method stub
		secondinterface obj=new secondinterface();
		obj.some();
		
		
	}

	
	}

