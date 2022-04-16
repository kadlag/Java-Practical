import java.sql.*;
class Dbmd
{
public static void main(String args[])
{
try
{
Class.forName("org.postgresql.Driver");

Connection con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");

DatabaseMetaData dbmd=con.getMetaData();

System.out.println("Driver Name: "+dbmd.getDriverName());
System.out.println("Driver Version: "+dbmd.getDriverVersion());
System.out.println("UserName: "+dbmd.getUserName());
System.out.println("Driver Product Name: "+dbmd.getDatabaseProductName());
System.out.println("Driver Product Version: "+dbmd.getDatabaseProductVersion());

String table[]={"TABLE"};
ResultSet rs=dbmd.getTables(null,null,null,table);

while(rs.next())
{
System.out.println(rs.getString("TABLE_NAME"));

}

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}


