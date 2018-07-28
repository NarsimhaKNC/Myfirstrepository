package package5;

public class Stringsplit {
	public static void main(String[] args){
		String str="today is good day";
		String[] st=str.split("od");
		for(int i=0;i<st.length;i++){
			System.out.println(st[i]);
		/*for(String s:st){
			System.out.println(s);*/
			
		}
	}

}
