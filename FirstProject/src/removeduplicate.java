
public class removeduplicate {
 public static void main(String[] args){
	 int arr[]={10,21,3,10,66,21,66,7,7,};
	 int remdup=arr[0];
	 System.out.println("given array is:" +arr);
	 for(int i=0;i<arr.length;i++){
		 System.out.println(arr[i]);
		 for(int j=0;j<=i;j++){
			 if(arr[i]!=arr[j]){
				 remdup=arr[j];
			 }else if(arr[j]==arr[i])
				 arr[i]=remdup;
				 
			 }{
		 int j = 0;
		System.out.println("removed duplicate array is:" +arr[j]);
		 }
		 
	 }
	 }
}


