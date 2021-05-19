import java.util.Scanner;
class Node
{
	protected int data;
	protected Node link;

	public Node()
	{
		link = null;
		data = 0;
	}
	public Node(int d,Node n)
	{
		data = d;
		link = n;
	}
	public void setLink(Node n)
	{
		link = n;
	}
	public void  setData(int d)
	{
		data = d;
	}
	public Node getLink()
	{
		return link;
	}
	public int getData()
	{
		return data;
	}
}
class LinkedList
{
	protected Node start;
	protected Node end;
	public int size;

	public LinkedList()
	{
		start = null;
		end = null;
		size = 0;
	}
	public boolean isEmpty()
	{
		return start == null;
	}
	public int getSize()
	{
		return size;
	}
	public void insertAtStart(int val)
	{
		Node nptr = new Node(val,null);
		size++;
		if(start == null)
		{
			start = nptr;
			end = start;
		}
		else
		{
			nptr.setLink(start);
			start = nptr;
		}
	}
	public void insertAtEnd(int val)
	{
		Node nptr = new Node(val,null);
		size++;
		if(start == null)
		{
			start = nptr;
			end = start;
		}
		else
		{
			end.setLink(nptr);
			end = nptr;
		}

	}
	public void insertAtPos(int val,int pos)
	{
		Node nptr = new Node(val,null);
		Node ptr = start;
		pos = pos-1;
		for(int i = 1;i<size;i++)
		{
			if(i == pos)
			{
				Node tmp = ptr.getLink();
				ptr.setLink(nptr);
				nptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size++;
	}
	public void deleteAtPos(int pos)
	{
		if(pos == 1)
		{
			start = start.getLink();
			size--;
			return;
		}
		if(pos == size)
		{
			Node s = start;
			Node t = start;
			while(s != end)
			{
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		Node ptr = start;
		pos = pos-1;
		for(int i = 1;i<size;i++)
		{
			if(i == pos)
			{
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}
	public void display()
	{
		System.out.println("\n Singly Linked List=");
		if(size == 0)
		{
			System.out.println("empty\n");
			return;
		}
		if(start.getLink() == null)
		{
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.println(start.getData()+"->");
		ptr = start.getLink();
		while(ptr.getLink() != null)
		{
			System.out.println(ptr.getData()+"->");
			ptr = ptr.getLink();
		}
		System.out.println(ptr.getData()+"\n");
	}
}
class week3
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		System.out.println("Singly Linked List Test\n");
		char ch;
		do
		{
			System.out.println("\nSingly Linked List Operations:\n");
			System.out.println("1.Insert At Begining:");
			System.out.println("2.Insert At End:");
			System.out.println("3.Insert At Position:");
			System.out.println("4.Delete At Position:");
			System.out.println("5.Check Empty:");
			System.out.println("6.Get Size:");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
				    System.out.println("Enter integer element to insert");
				    list.insertAtStart(sc.nextInt());
				    break;
				case 2:
				    System.out.println("Enter integer element to insert");
				    list.insertAtEnd(sc.nextInt());
				    break;
				case 3:
				    System.out.println("Enter integer to insert");
				    int num = sc.nextInt();
				    System.out.println("Enter position");
				    int pos = sc.nextInt();
				    if(pos <= 1 || pos>list.getSize())
				    {
				    	System.out.println("Invalid Position:\n");
				    }
				    else
				    {
				    	list.insertAtPos(num,pos);
				    }
				    break;
				case 4:
				   System.out.println("Enter position");
				   int p = sc.nextInt();
				   if(p<1 || p>list.getSize())
				   {
				   	  System.out.println("Invalid Position\n");
				   } 
				   else
				   {
				   	list.deleteAtPos(p);
				   }
				   break;
				case 5:
				   System.out.println("Empty status="+list.isEmpty());
				   break;
				case 6:
				   System.out.println("size="+list.getSize()+"\n");
				   break;
				default:
				   System.out.println("Wrong Input\n");
				   break;
			}
			list.display();
			System.out.println("\nDo you want to continue(Type y or n)\n");
			ch = sc.next().charAt(0);
		}while(ch == 'Y' || ch == 'y');
	}
}