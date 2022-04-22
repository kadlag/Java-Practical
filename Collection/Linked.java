import java.util.*;
public class Linked
{
public static void main(String args[])
{
Scanner input=new Scanner(System.in);

LinkedList al=new LinkedList();

System.out.println("Enter how many friends:");
int n=input.nextInt();

System.out.println("Enter friend names");
//input.next();

for(int i=0;i<n;i++)
{
String c=input.next();

al.add(c);

}
System.out.println("Friends are:"+al);


input.close();
}

}
