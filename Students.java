import java.sql.*;
import java.util.*;

class Students
{
public static void main(String args[])
{

Scanner input=new Scanner(System.in);

Connection con=null;
PreparedStatement ps=null;
Statement stmt=null;
ResultSet rs=null;

int ch;

try
{
//to load and register driver
Class.forName("org.postgresql.Driver");

//Established a connection
con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");

do
{
System.out.println("1.Insert 2.Update 3.Delete 4.Display 0.Exit");
System.out.println("enter a menu");
 ch=input.nextInt();

switch(ch)
{
case 1: 
ps=con.prepareStatement("insert into students values(?,?,?)");

System.out.println("enter roll no");
int rno=input.nextInt();
ps.setInt(1,rno);

System.out.println("enter name");
String sname=input.next();
ps.setString(2,sname);

System.out.println("enter percentage");
Float per=input.nextFloat();
ps.setFloat(3,per);

//execute a sql query

int ans=ps.executeUpdate();
System.out.println(ans + "Record Inserted");
break;


case 2:
ps=con.prepareStatement("update students set sname =? , per=? where rno=?");



System.out.println("enter roll no for update");
int rno1=input.nextInt();
ps.setInt(3,rno1);


System.out.println("enter updated name");
String sname1=input.next();
ps.setString(1,sname1);

System.out.println("enter update percentage");
Float per1=input.nextFloat();
ps.setFloat(2,per1);

//execute a sql query

int ans1=ps.executeUpdate();
System.out.println(ans1 + "Record updated");
break;


case 3:
ps=con.prepareStatement("delete from students where rno=?");

System.out.println("enter roll no for Deleted");
int rno2=input.nextInt();
ps.setInt(1,rno2);

//execute a sql query

int ans2=ps.executeUpdate();
System.out.println(ans2 + "Record Deleted");
break;

case 4:

stmt=con.createStatement();

rs=stmt.executeQuery("select * from students");
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("sname") +"\t"+rs.getFloat("per"));
}

break;

case 0:
System.out.println("Exit");
break;

}//switch
}while(ch!=0);
}//try

catch (Exception e)
{
System.out.println(e);
}

try{

rs.close();
stmt.close();
con.close();
ps.close();
}//try

catch (Exception e)
{
System.out.println(e);
}//catch

}//main
}//class

