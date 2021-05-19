import java.util.Scanner;  
   
class week2a   
{  
  public static void main(String args[])  
  {  
    int c, n, search, array[];  
   
    Scanner in = new Scanner(System.in);  
    System.out.println("Enter number of elements");  
    n = in.nextInt();   
    array = new int[n];  
   
    System.out.println("Enter those " + n + " students rollNumbers:");  
   
    for (c = 0; c < n; c++)  
      array[c] = in.nextInt();  
   
    System.out.println("Enter the students rollNumber whose presence to find");  
    search = in.nextInt();  
   
    for (c = 0; c < n; c++)  
    {  
      if (array[c] == search)     /* Searching element is present */  
      {  
         System.out.println("The student is present for the class");  
          break;  
      }  
   }  
   if (c == n)  /* Element to search isn't present */  
      System.out.println(" isn't present for the class");  
  }  
}  