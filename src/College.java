import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author murchana
 *
 */
public class College {
	
	
	TreeMap<Integer,ArrayList>college_names = new TreeMap<Integer,ArrayList>();
	
	
	College() {
	
			ArrayList college_list = new ArrayList();
			college_list.add("001");
			college_list.add("RVCol");
			college_names.put(1, college_list);
			
			ArrayList college_list1 = new ArrayList();
			college_list1.add("003");
			college_list1.add("IITD");
			college_names.put(2, college_list1);
			
			ArrayList college_list2= new ArrayList();
			college_list2.add("002");
			college_list2.add("TezpurU");
			college_names.put(3,college_list2);
			
			ArrayList college_list3 = new ArrayList();
			college_list3.add("004");
			college_list3.add("IITK");
			college_names.put(4,college_list3);
			
			ArrayList college_list4 = new ArrayList();
			college_list4.add("005");
			college_list4.add("BITSP");
			college_names.put(6,college_list4);
			
			ArrayList college_list5 = new ArrayList();
			college_list5.add("006");
			college_list5.add("IITG");
			college_names.put(5, college_list5);
			
			ArrayList college_list6 = new ArrayList();
			college_list6.add("007");
			college_list6.add("NITW");
			college_names.put(120,college_list6 );
			
			ArrayList college_list7 = new ArrayList();
			college_list7.add("1200");
			college_list7.add("IIITH");
			college_names.put(500, college_list7);
			
			
	}
	
	Map<Integer,ArrayList> getData() {
		return college_names;
	}

}
