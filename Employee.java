import java.sql.*;
import java.util.*;

class Employee
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

System.out.println("enter how many records");
int n=input.nextInt();

for(int i=0;i<n;i++)
{

ps=con.prepareStatement("insert into employee values(?,?,?)");

System.out.println("enter emp no");
int eno=input.nextInt();
ps.setInt(1,eno);

System.out.println("enter employee name");
String ename=input.next();
ps.setString(2,ename);

System.out.println("enter salary");
int salary=input.nextInt();
ps.setInt(3,salary);

//execute a sql query

int ans=ps.executeUpdate();
System.out.println(ans + "Record Inserted");

}//for

stmt=con.createStatement();

rs=stmt.executeQuery("select * from employee");
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("emp_name") +"\t"+rs.getInt("salary"));
}

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

