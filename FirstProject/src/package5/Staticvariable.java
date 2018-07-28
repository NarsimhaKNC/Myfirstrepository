package package5;

public class Staticvariable {
	public void m1() {
		System.out.println("iam in method1");
	}

	public int m2() {
		System.out.println("aim in method2");
		return 4;
	}

	static int a = 10;
	int b = 20;

	static int add(int a, int b) {
		return a + b;
	}

	public String m3() {
		System.out.println("iam in method3");
		return "narsimha";
	}

	public boolean m4() {
		System.out.println("iam in method4");
		return true;
	}

	public static void main(String[] args) {
		Staticvariable obj = new Staticvariable();
		obj.m1();
		System.out.println(obj.m2());
		String st = obj.m3();
		System.out.println(st);
		boolean flag = true;
		obj.m4();
		System.out.println(obj.a);
		System.out.println(obj.b);
		int a = obj.a++;
		int b = obj.b++;

	}

}
