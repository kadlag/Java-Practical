import java.util.LinkedList;
import java.util.Scanner;

public class C2
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);

LinkedList ll=new LinkedList();

ll.add(1);
ll.add(2);
ll.add(3);

System.out.println("Elements in list:"+ll);
ll.addFirst(0);

System.out.println("After adding the elements at first position:"+ll);

ll.removeLast();

System.out.println("After deleting the element:"+ll);
System.out.println("Size of the list:"+ll.size());

sc.close();

}
}

