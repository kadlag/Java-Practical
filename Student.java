import java.sql.*;
class Student
{
public static void main(String args[])
{
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

try
{
//load a driver 
Class.forName("org.postgresql.Driver");

//Established a connection
con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");

//create a statement and execute queries
stmt=con.createStatement();

//rs=stmt.executeQuery("select * from students");
int ans=stmt.executeUpdate("insert into students values(13,'sakshi',98.25)");
System.out.println(ans+"record inserted successfully");

//int ans=stmt.executeUpdate("delete from students where rno=1");
//System.out.println(ans+"record deleted successfully");

//int ans=stmt.executeUpdate("update students set per= 85.32 where rno=11");
//System.out.println(ans+"record updated successfully");

//while(rs.next())
//{
//System.out.println(rs.getInt(1)+"\t"+rs.getString("sname") +"\t"+rs.getFloat("per"));
//}

//close resultset ,statement and connection object
rs.close();
stmt.close();
con.close();
}//try

catch (Exception e)
{
System.out.println(e);
}
}//main
}//class

