import java.sql.*;
import java.util.*;

class Department
{
public static void main(String args[])
{

Scanner input=new Scanner(System.in);

Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
//Statement st;


try
{
//to load and register driver
Class.forName("org.postgresql.Driver");

//Established a connection
con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");

//st=con.createStatement();



ps=con.prepareStatement("select * from emp where salary in(select max(salary) from emp where depart=?)");

System.out.println("enter department name");
String dep=input.next();
ps.setString(1,dep);


//Execute a query
 rs = ps.executeQuery();
        


while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("ename") +"\t"+rs.getString("depart")+"\t"+rs.getInt("salary"));
}


}//try


catch (Exception e)
{
System.out.println(e);
}

try
{
rs.close();
//stmt.close();
con.close();
ps.close();
}//try

catch (Exception e)
{
System.out.println(e);
}//catch

}//main
}//class

