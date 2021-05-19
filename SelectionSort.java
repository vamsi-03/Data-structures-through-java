import java.util.*;
class SelectionSort{
public static void selectionsort(int arr[])
{
	int i,minvalue,minindex;
	for(i = 0;i<arr.length-1;i++){
	   minindex = i;
	   for(int j = i+1;j<arr.length;j++){
		    if(arr[j]<arr[minindex]){
			minindex = j;
		    }
	    }
	minvalue = arr[minindex];
	arr[minindex] = arr[i];
	arr[i] = minvalue;
    }
}
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
	
	selectionsort(arr);
	System.out.println("Printing sorted array:");
	for(i=0;i<n;i++){
		System.out.println(arr[i]);
	}
}
}
