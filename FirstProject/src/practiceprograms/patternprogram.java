package practiceprograms;

public class patternprogram {
	public static void main(String args[]) {

		int n=5;
		int nc=0;
		//System.out.print("im in pattern program");
		//System.out.println("im in pattern program");
		//System.out.print("im in class");

		for (int i=0;i <=n; i++){ 
			//for (int j = 0; j <=i;j++){ 
			nc=1;
			while(nc<=i){
				System.out.print(nc);
				if(nc!=i)
				System.out.print("*");
			nc=nc+1;
			
			}
			System.out.println();
		}
		}
	}


