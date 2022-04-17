import java.sql.*;
class Exam
{
public static void main(String args[])
{



try
{
Class.forName("org.postgresql.Driver");

Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/exam","postgres","sakshi");


Statement stmt=null;

stmt=con.createStatement();


ResultSet rs=stmt.executeQuery("select * from stud");
ResultSetMetaData rsmd=rs.getMetaData();

int noOFColumns=rsmd.getColumnCount();

System.out.println("Number of columns=" +noOFColumns);

for(int i=1;i<=noOFColumns;i++)
{
System.out.println("Column No:"+i);
System.out.println("Column Name:"+rsmd.getColumnName(i));
System.out.println("Column Type:"+rsmd.getColumnTypeName(i));
System.out.println("Column display size:"+rsmd.getColumnDisplaySize(i));
}//for




con.close();
}//try

catch(Exception e)
{
System.out.println(e);
}

}//main
}//class

