import java.util.*;
public class Treeset
{
public static void main(String args[])
{
Scanner input=new Scanner(System.in);

TreeSet ts=new TreeSet();

System.out.println("Enter how many colors:");
int n=input.nextInt();

System.out.println("Enter colors");
//input.next();

for(int i=0;i<n;i++)
{
String c=input.next();

ts.add(c);

}
System.out.println("colors are:"+ts);


input.close();
}

}
