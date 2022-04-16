import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;


public class CowinFrame extends JFrame implements ActionListener
{

Connection con;
ResultSet rs;
Statement st;


static JTable table;
String[] columnNames={"adharno","byear","mobno","age","hos","vaccines","timeslot"};
String adharno = "",byear = "",mobno= "",age = "",hos="",vaccines="",timeslot="";


JFrame frm;
JTextField adhar,biyear,phone;
JComboBox hname;
JPanel p1,p2,p3,p4,p5;
JButton add,update,delete,view,search;
JRadioButton r1,r2,r3,r4,r5,r6,r7,r8;

CowinFrame()
{
setTitle("Co-WIN Registration");

setSize(600,600);
setVisible(true);
setLayout(new GridLayout(8,2,40,40));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel adharno=new JLabel("AdharCard No");
add(adharno);
adhar=new JTextField(10);
add(adhar);

JLabel Byear=new JLabel("Birth Year");
add(Byear);
biyear=new JTextField(10);
add(biyear);

JLabel phoneno=new JLabel("Mobile No.");
add(phoneno);
phone=new JTextField(10);
add(phone);

//Age Radio Button

p1=new JPanel();
p1.setLayout(new FlowLayout());

JLabel age=new JLabel("Age Group");
add(age);
r1=new JRadioButton("18 & above");
p1.add(r1);

r2=new JRadioButton("45 & above");
p1.add(r2);
add(p1);

//select hospital

p5=new JPanel();
p5.setLayout(new FlowLayout());

JLabel hosname=new JLabel("Select Hospital");
add(hosname);

String hospital[]={"Medicover","Tambe","satpute","Nighute"};
hname=new JComboBox(hospital);
p5.add(hname);

add(p5);

//Vaccines Radio Button

p2=new JPanel();
p2.setLayout(new FlowLayout());

JLabel vaccines=new JLabel("Vaccines");
add(vaccines);
r3=new JRadioButton("Covishield");
p2.add(r3);

r4=new JRadioButton("Covaxin");
p2.add(r4);

r5=new JRadioButton("Sputnik V");
p2.add(r5);
add(p2);


//Time slot radio button

p3=new JPanel();
p3.setLayout(new FlowLayout());

JLabel time=new JLabel("Time Slot");
add(time);
r6=new JRadioButton("Morning");
p3.add(r6);

r7=new JRadioButton("Afternoon");
p3.add(r7);

r8=new JRadioButton("Evening");
p3.add(r8);
add(p3);


//Adding Button

p4=new JPanel();
p4.setLayout(new FlowLayout());

add=new JButton("ADD");
p4.add(add);

update=new JButton("UPDATE");
p4.add(update);

delete=new JButton("DELETE");
p4.add(delete);

view=new JButton("VIEW");
p4.add(view);

search=new JButton("SEARCH");
p4.add(search);

add(p4);



try{
Class.forName("org.postgresql.Driver");

con=DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");
}

catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

add.addActionListener(this);
update.addActionListener(this);
delete.addActionListener(this);
view.addActionListener(this);
search.addActionListener(this);



}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==add)
{
frm=new JFrame("ADD");


try{

st=con.createStatement();
PreparedStatement ps=null;

ps=con.prepareStatement("insert into cowin values(?,?,?,?,?,?,?)");

long adharno=Long.parseLong(adhar.getText());
int birthyear=Integer.parseInt(biyear.getText());
int mobno=Integer.parseInt(phone.getText());

String age=null;
if(r1.isSelected()==true)
   age=r1.getText();

if(r2.isSelected()==true)
   age=r2.getText();



String hosname=(String)hname.getSelectedItem();


String vaccines=null;
if(r3.isSelected()==true)
   vaccines=r3.getText();



if(r4.isSelected()==true)
  vaccines =r4.getText();


if(r5.isSelected()==true)
   vaccines=r5.getText();


String tslot=null;
if(r6.isSelected()==true)
 tslot=r6.getText();

if(r7.isSelected()==true)
  tslot =r7.getText();


if(r8.isSelected()==true)
   tslot=r8.getText();



try
{    
if(birthyear==0000)
{
throw new adharnumber("Invalid birth year");
}

else
{



   
                  ps.setLong(1,adharno);
                  ps.setInt(2,birthyear);
                  ps.setInt(3,mobno);
                  ps.setString(4,age);
                  ps.setString(5,hosname);
                  ps.setString(6,vaccines);
                  ps.setString(7,tslot);
 

          
            //execute a sql query

           int ans=ps.executeUpdate();
           System.out.println(ans + "Record Inserted");
            JOptionPane.showMessageDialog(frm,"Record Inserted Successfully");


//String hname=(String)cmbhosp.getSelectedItem();

//ps.setInt(1,adhar);
}
}//try


catch(adharnumber e)
{
System.out.println("ERROR:"+e);
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}//if

if(ae.getSource()==update)
{
frm=new JFrame("UPDATE");


try{

st=con.createStatement();
PreparedStatement ps=null;

ps=con.prepareStatement("update cowin set byear=?,mobno=?,age=?,hos=?,vaccines=?,timeslot=? where adharno=?");


int adharno=Integer.parseInt(adhar.getText());
int birthyear=Integer.parseInt(biyear.getText());
int mobno=Integer.parseInt(phone.getText());

String age=null;
if(r1.isSelected()==true)
   age=r1.getText();

if(r2.isSelected()==true)
   age=r2.getText();



String hosname=(String)hname.getSelectedItem();


String vaccines=null;
if(r3.isSelected()==true)
   vaccines=r3.getText();



if(r4.isSelected()==true)
  vaccines =r4.getText();


if(r5.isSelected()==true)
   vaccines=r5.getText();


String tslot=null;
if(r6.isSelected()==true)
 tslot=r6.getText();

if(r7.isSelected()==true)
  tslot =r7.getText();


if(r8.isSelected()==true)
   tslot=r8.getText();






   
                  ps.setInt(7,adharno);
                  ps.setInt(1,birthyear);
                  ps.setInt(2,mobno);
                  ps.setString(3,age);
                  ps.setString(4,hosname);
                  ps.setString(5,vaccines);
                  ps.setString(6,tslot);

       


          
            //execute a sql query

           int ans=ps.executeUpdate();
           System.out.println(ans + "Record Updated");
            JOptionPane.showMessageDialog(frm,"Record Updated Successfully");


//String hname=(String)cmbhosp.getSelectedItem();

//ps.setInt(1,adhar);
}//try

catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}//if


if(ae.getSource()==delete)
{
frm=new JFrame("DELETE");



try{

st=con.createStatement();
PreparedStatement ps=null;

ps=con.prepareStatement("delete from cowin where adharno=?");

int adharno=Integer.parseInt(adhar.getText());

ps.setInt(1,adharno);


            //execute a sql query

           int ans=ps.executeUpdate();
           System.out.println(ans + "Record Deleted");
          JOptionPane.showMessageDialog(frm,"Record Deleted Successfully");


}

catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}//if


if(ae.getSource()==view)
{
frm=new JFrame("VIEW");
frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frm.setLayout(new BorderLayout());
DefaultTableModel model = new DefaultTableModel();

model.setColumnIdentifiers(columnNames);
table = new JTable();

table.setModel(model);

table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);

JScrollPane scroll = new JScrollPane(table);

scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       
scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        

try
{

 rs = st.executeQuery("select * from cowin");
                
                while(rs.next())
{
                adharno = rs.getString(1);
                byear = rs.getString(2);
                mobno = rs.getString(3);
                age = rs.getString(4);
                hos = rs.getString(5);
                vaccines = rs.getString(6);
                timeslot = rs.getString(7);


                model.addRow(new Object[]{adharno,byear,mobno,age,hos,vaccines,timeslot});

}//while

                frm.add(scroll);
                
                frm.setVisible(true);
                frm.setSize(400,400);
}//try

catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}//if

if(ae.getSource()==search)
{
frm=new JFrame("SEARCH");
frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frm.setLayout(new BorderLayout());
DefaultTableModel model = new DefaultTableModel();

model.setColumnIdentifiers(columnNames);
table = new JTable();

table.setModel(model);

table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);

JScrollPane scroll = new JScrollPane(table);

scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       
scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        

try
{

st=con.createStatement();
PreparedStatement ps=null;


ps=con.prepareStatement("select * from cowin where adharno=?");


int adhar1=Integer.parseInt(adhar.getText());

ps.setInt(1,adhar1);



//Execute a query
 rs = ps.executeQuery();
        
                while(rs.next())
{
                adharno = rs.getString(1);
                byear = rs.getString(2);
                mobno = rs.getString(3);
                age = rs.getString(4);
                hos = rs.getString(5);
                vaccines = rs.getString(6);
                timeslot = rs.getString(7);


                model.addRow(new Object[]{adharno,byear,mobno,age,hos,vaccines,timeslot});



}//while

                frm.add(scroll);
                
                frm.setVisible(true);
                frm.setSize(400,400);
}//try

catch(Exception e)
{
JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
}

}//if




}
public static void main(String[] args)
{
CowinFrame fr=new CowinFrame();
}
}//class end


class adharnumber extends Exception
{
String msg;

adharnumber(String msg)
{
this.msg=msg;

}

public String toString()
{

return msg;
}
}





