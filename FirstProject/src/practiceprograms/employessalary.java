package practiceprograms;

public class employessalary {
	int i;
	String str;

public static void main(String[] args){
	employessalary e1=new employessalary();
	employessalary e2=new employessalary();
	employessalary e3=new employessalary();
	
	e1.i=2000;e1.str="narsimha";
	e2.i=3000;e2.str="KNC";
	e3.i=4000;e3.str="tony";
	
	System.out.println("e1 employee salary is:"+ e1.i + e1.str);
	System.out.println("e2 employee salary is:"+ e2.i + e2.str);
	System.out.println("e3 employee salary is:"+ e3.i + e3.str);
	

}
}