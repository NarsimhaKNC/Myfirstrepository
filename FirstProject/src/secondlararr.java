
public class secondlararr {
	public static void main(String[] args){
		int arr[]={22,44,11,50,97,86,91};
		int lar=arr[0];
		int seclar=arr[0];
		System.out.println("given array is:");
		{
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i] + "\t");}{
				for(int i=0;i<arr.length;i++){
					if(arr[i]>lar){
						seclar=seclar;
						lar=arr[i];
					}else if(arr[i]>seclar)
						seclar=arr[i];
					}
					
					
				}
			}
	System.out.println("\n second largest num is:" + seclar);
}
}