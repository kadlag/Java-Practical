import java.sql.*;
import java.util.*;

class Element
{
public static void main(String args[])
{

Scanner input=new Scanner(System.in);

Connection con=null;
PreparedStatement ps=null;
Statement stmt=null;
ResultSet rs=null;


try
{
//to load and register driver
Class.forName("org.postgresql.Driver");

//Established a connection
con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");


String mode=args[0];
System.out.println("mode==>"+mode);


if(args[0].equals("R"))
{
stmt=con.createStatement();

rs=stmt.executeQuery("select * from element");
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("name") +"\t"+rs.getInt("chem_symbol"));
}

}




if(args[0].equals("U"))
{

ps=con.prepareStatement("update element set name=? , chem_symbol=? where atomic_weight=?");

int weight=Integer.parseInt(args[1]);
ps.setInt(3,weight);

String name=args[2];
ps.setString(1,name);

int chem=Integer.parseInt(args[3]);
ps.setInt(2,chem);

//execute a sql query

int ans1=ps.executeUpdate();
System.out.println(ans1 + "Record updated");
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



