package package4;

public class fibinacciseries {
	public static void main(String[] args){
		int a=0,b=1;
		int temp=0;
		for(int i=0;i<10;i++){
			System.out.println(a+ " ");
			temp=a+b;
			a=b;
			b=temp;
		}
		
	}

}
