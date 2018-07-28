package keywords;

public class superkeywordchild extends superkeyword {
	int a = 30;

	superkeywordchild(int a) {
		super();
	}

	void m2() {
		super.m1();
		System.out.println(super.a);
		System.out.println("im in child class" + a);
	}

	public static void main(String[] args) {

		superkeywordchild obj1 = new superkeywordchild(30);
		//obj1.m1();
		obj1.m2();

	}

}
