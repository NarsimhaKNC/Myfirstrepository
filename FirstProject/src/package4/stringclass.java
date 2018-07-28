package package4;

public class stringclass {
	void disp(){
		System.out.println("welcome");
	}
	public static void main(String[] args){
		stringclass obj=new stringclass();
		obj.disp();
		System.out.println();//
		
     String str="welcome to nalgonda";{
     String str1=str.substring(0);
     String str2=str.substring(3,5);{
     System.out.println(str1);
     System.out.println(str2);
    	System.out.println(str);
    	 System.out.println(str.toLowerCase());
    	 System.out.println(str.toUpperCase());
    	 System.out.println(str.replace("nalgonda", "hyderabad"));
		String name="narsimha";
		//System.out.println(name.startsWith("nArsi"));
		boolean flag=name.startsWith("narsi");{
		boolean flag1=name.startsWith("i",5);{
		System.out.println(flag);
		System.out.println(flag1);
		int index=name.indexOf("i");
		System.out.println(index);
		char ch=name.charAt(7);
		System.out.println(ch);
		/*}if(name.contains("narsiMha")){
			System.out.println("true");
		}else{
			System.out.println("fail");*/
		}if(name.toLowerCase().contains("naRsiMha".toLowerCase()))
		{System.out.println("true");
		}else{
			System.out.println("fail");
		}
		String str3="NARSIMHA";
		if(str3.equals("NARsIMHA")){
			System.out.println("true");
		}else{
			System.out.println("fail");
			
		
     }
	
     }
	}
	}

	}
}
