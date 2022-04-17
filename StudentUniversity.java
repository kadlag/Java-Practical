import java.sql.*;
import java.util.*;

class StudentUniversity
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


ps=con.prepareStatement("insert into student values(?,?,?)");

System.out.println("enter roll no");
int rno=input.nextInt();
ps.setInt(1,rno);

System.out.println("enter name");
String sname=input.next();
ps.setString(2,sname);

System.out.println("enter marks");
float marks=input.nextFloat();
ps.setFloat(3,marks);

//execute a sql query

int ans=ps.executeUpdate();
System.out.println(ans + "Record Inserted");


//Display
stmt=con.createStatement();

rs=stmt.executeQuery("select * from student");
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("name") +"\t"+rs.getFloat("marks"));
}


}


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

