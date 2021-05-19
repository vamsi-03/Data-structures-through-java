import java.util.Scanner;
class LinearSearch1{
	public static void main(String args[]){
	int counter,num,item,array[];
	Scanner c = new Scanner(System.in);
	System.out.println("Enter number of elements:");
	num = c.nextInt();
	array = new int[num];
	System.out.println("Enter "+num+" integers");
	for(counter = 0;counter<num;counter++)
	   array[counter] = c.nextInt();
	System.out.println("Enter the search element");
	item = c.nextInt();
	for(counter=0;counter<num;counter++){
	if(array[counter] == item){
	System.out.println(item+" is found at index"+array[counter]+":");
	break;
	}
	}
	if(counter == num){
	System.out.println(item+" is not found in the array");
	}
	}
}