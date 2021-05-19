import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
class BinarySearch{
	public static void main(String args[]){
      ArrayList<Integer> a = new ArrayList<Integer>();
      Scanner sc = new Scanner(System.in);
      //System.out.println("enter an integer;");
      //a.add(sc.nextInt());
      a.add(1);
      a.add(3);
      a.add(65);
      a.add(450);
      a.add(68);
      int res = Collections.binarySearch(a,23);
      if(res>=0){
      	System.out.println("Element found at index:"+res);
      }
      else{
      	System.out.println("Element not found ");
      }
      res = Collections.binarySearch(a,898);
      if(res>=0){
      	System.out.println("Element found at index:"+res);
      }
       else{
      	System.out.println("Element not found ");
     }
    }
 }

 /*  output:
 E:\DSA>javac BinarySearch.java

E:\DSA>java BinarySearch
Element found at index:1
Element not found
*/