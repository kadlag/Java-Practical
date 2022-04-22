import java.util.HashMap;
import java.util.TreeMap;

public class B2
{
public static void main(String args[])
{

HashMap map=new HashMap();


map.put("Sakshi",2002);
map.put("Gauri",2002);
map.put("Kalyani",2001);
map.put("Akshaksha",2002);
map.put("Prajkta",2003);


System.out.println("Hashmap details before sorting "+map);

TreeMap tm = new TreeMap(map);

System.out.println("Hashmap details After sorting "+tm);
}

}
