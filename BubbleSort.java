import java.util.*;
class BubbleSort{
	public static void main(String args[]){
		int n,i;
		int arr[];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements in the array:");
		n = sc.nextInt();
		arr = new int[n];
		System.out.println("Enter "+n+" integers:");
		for(i = 0;i<n;i++){
			System.out.println("Enter "+(i+1)+"th element in the array:");
			arr[i] = sc.nextInt();
		}
		for(i = 0;i<n;i++){
			for(int j = 0;j<n-(i+1);j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("Printing the sorted array:");
		for(i = 0;i<n;i++){
			System.out.println(arr[i]);
		}
	}
}