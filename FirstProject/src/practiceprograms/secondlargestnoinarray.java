package practiceprograms;

public class secondlargestnoinarray {
	public static void main(String[] args) {
		int arr[] = { 20, 33, 41, 97,55, 89, 66 };
		int largest = arr[0];
		int secondlargest = arr[0];
		System.out.println("given array is:");
		{
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + "\t");
			}
			{
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] >largest) {
					    secondlargest = secondlargest;
						largest = arr[i];
					}else if(arr[i]>secondlargest)
						secondlargest=arr[i];
					}

				}
			}
			System.out.println("\n second largest num is:" + secondlargest);
		}

	}

