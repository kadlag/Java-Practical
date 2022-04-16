import java.sql.*;
import java.util.*;

class Mobile
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
System.out.println("1.Insert 2.Update 3.Delete 4.Display 5.Search 0.Exit");
System.out.println("enter a menu");
 ch=input.nextInt();

switch(ch)
{
case 1: 
ps=con.prepareStatement("insert into mobile values(?,?,?,?,?,?,?,?,?)");

System.out.println("enter model no");
int mno=input.nextInt();
ps.setInt(1,mno);

System.out.println("enter model name");
String mname=input.next();
ps.setString(2,mname);

System.out.println("enter model color");
String mcolor=input.next();
ps.setString(3,mcolor);


System.out.println("enter sim type");
String stype=input.next();
ps.setString(4,stype);

System.out.println("enter network type");
String ntype=input.next();
ps.setString(5,ntype);

System.out.println("enter battery capacity");
String bcapacity=input.next();
ps.setString(6,mname);

System.out.println("enter Internal Storage");
String istorage=input.next();
ps.setString(7,istorage);

System.out.println("enter ram");
String ram=input.next();
ps.setString(8,ram);


System.out.println("enter processor type");
String ptype=input.next();
ps.setString(9,ptype);


//execute a sql query

int ans=ps.executeUpdate();
System.out.println(ans + "Record Inserted");
break;


case 2:
ps=con.prepareStatement("update mobile set model_name =? , model_color=?,sim_type=?,network_type=?, battery_capacity=?, internal_storage=?, ram=?, processor_type=? where model_no=?");



System.out.println("enter modelno for update");
int mno1=input.nextInt();
ps.setInt(9,mno1);


System.out.println("enter updated name");
String mname1=input.next();
ps.setString(1,mname1);

System.out.println("enter updated color");
String mcolor1=input.next();
ps.setString(2,mcolor1);

System.out.println("enter updated sim type");
String stype1=input.next();
ps.setString(3,stype1);

System.out.println("enter updated network type");
String ntype1=input.next();
ps.setString(4,ntype1);

System.out.println("enter updated battery capacity");
String bcapacity1=input.next();
ps.setString(5,bcapacity1);

System.out.println("enter updated internal storage");
String istorage1=input.next();
ps.setString(6,istorage1);


System.out.println("enter updated ram");
String ram1=input.next();
ps.setString(7,ram1);

System.out.println("enter updated processor type");
String ptype1=input.next();
ps.setString(8,ptype1);


//execute a sql query

int ans1=ps.executeUpdate();
System.out.println(ans1 + "Record updated");
break;


case 3:
ps=con.prepareStatement("delete from mobile where model_no=?");

System.out.println("enter model no for Deleted");
int mno2=input.nextInt();
ps.setInt(1,mno2);

//execute a sql query

int ans2=ps.executeUpdate();
System.out.println(ans2 + "Record Deleted");
break;

case 4:

stmt=con.createStatement();

rs=stmt.executeQuery("select * from mobile");
while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("model_name") +"\t"+rs.getString("model_color") +"\t"+rs.getString("sim_type") +"\t"+rs.getString("network_type") +"\t"+rs.getString("battery_capacity")+"\t"+rs.getString("internal_storage")+"\t"+rs.getString("ram")+"\t"+rs.getString("processor_type") );
}

break;


case 5:

ps=con.prepareStatement("select * from mobile where model_no=?");

System.out.println("enter model no for search record");
int mno3=input.nextInt();
ps.setInt(1,mno3);

//execute a query

rs=ps.executeQuery();

while(rs.next())
{
System.out.println(rs.getInt(1)+"\t"+rs.getString("model_name") +"\t"+rs.getString("model_color") +"\t"+rs.getString("sim_type") +"\t"+rs.getString("network_type") +"\t"+rs.getString("battery_capacity")+"\t"+rs.getString("internal_storage")+"\t"+rs.getString("ram")+"\t"+rs.getString("processor_type") );
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

