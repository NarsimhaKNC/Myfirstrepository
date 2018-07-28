package keywords;

public class superkeyword {
	int a = 25;

	superkeyword() {
		super();
		System.out.println("im in parent class" + a);
	}

	void m1() {
		System.out.println("im in parent class" + a);
	}
	

	public static void main(String[] args) {
		superkeyword obj = new superkeyword();
		obj.m1();

	}

}
