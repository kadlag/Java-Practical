import java.util.*;
public class B1
{
public static void main(String args[])
{
Scanner input=new Scanner(System.in);

TreeSet ts=new TreeSet();

System.out.println("Enter how many Integers:");
int n=input.nextInt();

System.out.println("Enter numbers");

//input.next();

for(int i=0;i<n;i++)
{
int c=input.nextInt();

ts.add(c);

}
System.out.println("Numbers are:"+ts);


input.close();
}

}
