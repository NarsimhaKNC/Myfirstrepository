package package5;

public class block {

	{
		System.out.println("iam in second block");
	}
	static {
		System.out.println("iam in first static block");
	}
	static {
		System.out.println("iam in second static block");
	}

	public static void main(String[] args) {
		block obj = new block();
		
	}
}
