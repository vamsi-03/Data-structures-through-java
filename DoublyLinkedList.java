import java.util.Scanner;
class Node
{
	protected int data;
	protected Node next,prev;

	public Node()
	{
		next = null;
		prev = null;
		data = 0;
	}
	public Node(int d,Node n,Node p)
	{
		data = d;
		next = n;
		prev = p;
	}
	public void setLinkNext(Node n)
	{
		next = n;
	}
	public void setLinkPrev(Node p)
	{
        prev = p;
	}
	public Node getLinkNext()
	{
		return next;
	}
	public Node getLinkPrev()
	{
		return prev;
	}
	public void  setData(int d)
	{
		data = d;
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
		Node nptr = new Node(val,null,null);
		//size++;
		if(start == null)
		{
			start = nptr;
			end = start;
		}
		else
		{
			start.setLinkPrev(nptr);
			nptr.setLinkNext(start);
			start = nptr;
		}
		size++;
	}
	public void insertAtEnd(int val)
	{
		Node nptr = new Node(val,null,null);
		//size++;
		if(start == null)
		{
			start = nptr;
			end = start;
		}
		else
		{
			nptr.setLinkPrev(end);
			end.setLinkNext(nptr);
			end = nptr;
		}
        size++;
	}
	public void insertAtPos(int val,int pos)
	{
		Node nptr = new Node(val,null,null);
		if(pos == 1)
		{
			insertAtStart(val);
		    return;
		}
		Node ptr = start;
		for(int i = 2;i<=size;i++)
		{
			if(i == pos)
			{
				Node tmp = ptr.getLinkNext();
				ptr.setLinkNext(nptr);
				nptr.setLinkPrev(ptr);
				nptr.setLinkNext(tmp);
				tmp.setLinkPrev(nptr);
			}
			ptr = ptr.getLinkNext();
		}
		size++;
	}
	public void deleteAtPos(int pos)
	{
		if(pos == 1)
		{
			if(size == 1)
			{
				start = null;
				end = null;
				size = 0;
				return;
			}
			start = start.getLinkNext();
            start.setLinkPrev(null);
			size--;
			return;
		}
		if(pos == size)
		{
			end = end.getLinkPrev();
			end.setLinkNext(null);
			size--;
		}
		Node ptr = start.getLinkNext();
		//pos = pos-1;
		for(int i = 2;i<=size;i++)
		{
			if(i == pos)
			{
				Node p = ptr.getLinkPrev();
				Node n = ptr.getLinkNext();

				p.setLinkNext(n);
				n.setLinkPrev(p);
				size--;
				return;
			}
			ptr = ptr.getLinkNext();
		}
	}
	public void display()
	{
		System.out.println("\n Doubly Linked List=");
		if(size == 0)
		{
			System.out.println("empty\n");
			return;
		}
		if(start.getLinkNext() == null)
		{
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.println(start.getData()+"->");
		ptr = start.getLinkNext();
		while(ptr.getLinkNext() != null)
		{
			System.out.println(ptr.getData()+"->");
			ptr = ptr.getLinkNext();
		}
		System.out.println(ptr.getData()+"\n");
	}
}
class DoublyLinkedList
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		System.out.println("Doubly Linked List Test\n");
		char ch;
		do
		{
			System.out.println("\nDoubly Linked List Operations:\n");
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