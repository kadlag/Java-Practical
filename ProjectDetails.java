import java.sql.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ProjectDetails extends JFrame implements ActionListener
{
Connection con;
ResultSet rs;
Statement st;

static JTable table;
String[] columnNames={"p_id","p_name","p_description","p_status"};
JFrame frm;
JPanel p1;
String p_id = "",p_name = "",p_description = "",p_status = "";

JTextField txtid,txtname,txtdesc,textstatus;
JButton b1,b2,b3,b4;

ProjectDetails(){
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("STUDENT PROJECT INFO");
p1=new JPanel();

p1.setLayout(new GridLayout(5,5,10,10));

Label l1 = new Label("P-ID");
p1.add(l1);
txtid = new JTextField(20);
p1.add(txtid);

Label l2 = new Label("P-NAME");
p1.add(l2);
txtname = new JTextField(20);
p1.add(txtname);

Label l3 = new Label("P-DESCRIPTION");
p1.add(l3);
txtdesc = new JTextField(20);
p1.add(txtdesc);

Label l4 = new Label("P-STATUS");
p1.add(l4);
textstatus = new JTextField(20);
p1.add(textstatus);

b1 = new JButton("Display");
p1.add(b1);


b2 = new JButton("Add");
p1.add(b2);


b1.addActionListener(this);
b2.addActionListener(this);


add(p1,BorderLayout.WEST);

setVisible(true);
setSize(400,400);

}//ProjectDetails()
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)//display
{
frm = new JFrame("Display");
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
        
        
        
       try{
                Class.forName("org.postgresql.Driver");
                
                con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");
                st = con.createStatement();
                rs = st.executeQuery("select * from projects");
                
                while(rs.next()){
                p_id = rs.getString(1);
                p_name = rs.getString(2);
                p_description = rs.getString(3);
                p_status = rs.getString(4);
                model.addRow(new Object[]{p_id,p_name,p_description,p_status});
                
                
                }//while
                frm.add(scroll);
                
                frm.setVisible(true);
                frm.setSize(400,400);
       }//try
       
       catch(Exception e){
       JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
       }
}//if


if(ae.getSource()==b2)//add
{
frm = new JFrame("Add");

        
       try{
                Class.forName("org.postgresql.Driver");
                
                con = DriverManager.getConnection("jdbc:postgresql://localhost/postgres","postgres","sakshi");
                st = con.createStatement(); 
                PreparedStatement ps=null;
               
                ps=con.prepareStatement("insert into projects values(?,?,?,?)");

               //int pid=Integer.parseInt(txtnum1
                
                
                 // int id=txtid.getText();
                  int id=Integer.parseInt(txtid.getText());
                  String name=txtname.getText();
                  String desc=txtdesc.getText();
                  String status=textstatus.getText();
                    
                  ps.setInt(1,id);
                  ps.setString(2,name);
                  ps.setString(3,desc);
                  ps.setString(4,status);
       

                    
            //execute a sql query

           int ans=ps.executeUpdate();
           System.out.println(ans + "Record Inserted");


        
       }//try
       
       catch(Exception e){
       JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
       }
}//if
}

public static void main(String args[])
{
ProjectDetails pd = new ProjectDetails();
}//main
}//class





