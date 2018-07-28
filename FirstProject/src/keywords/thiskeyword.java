package keywords;

public class thiskeyword {
	int b=22;

	thiskeyword(int b) {
		this.b = b;
		System.out.println(b);
	}

	void m1() {
		System.out.println(b);
	}

	public static void main(String[] args) {
		thiskeyword obj = new thiskeyword(1);
		obj.m1();

	}

}
