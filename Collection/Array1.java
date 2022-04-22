import java.util.*;
public class Array1
{
public static void main(String args[])
{
Scanner input=new Scanner(System.in);

ArrayList al=new ArrayList();

System.out.println("Enter how many cities:");
int n=input.nextInt();

System.out.println("Enter the cities");
//input.next();

for(int i=0;i<n;i++)
{
String c=input.next();

al.add(c);

}
System.out.println("Cities:"+al);
System.out.println("ArrayList after removing the elements");
al.clear();

input.close();
}

}
