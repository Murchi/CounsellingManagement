/**
 * 
 */

/**
 * @author murchana
 *
 */
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.ArrayList;


public class CollegeCourse {
	int collegeid;
	HashMap<Integer,ArrayList> collegecourse = new HashMap<>();
	
	CollegeCourse(){
		ArrayList seats = new ArrayList ();
		seats.add("001");
		seats.add("RV7");
		seats.add(20);
		seats.add(20);
		collegecourse.put(001,seats);
		ArrayList seats9 = new ArrayList ();
		seats9.add("001");
		seats9.add("RV8");
		seats9.add(20);
		seats9.add(20);
		collegecourse.put(002,seats9);
		ArrayList seats1 = new ArrayList<>();
		seats1.add("002");
		seats1.add("TU1");
		seats1.add(30);
		seats1.add(30);
		collegecourse.put(003, seats1);
		ArrayList seats10 = new ArrayList ();
		seats10.add("002");
		seats10.add("TU2");
		seats10.add(20);
		seats10.add(20);
		collegecourse.put(004,seats10);
		ArrayList seats2 = new ArrayList<>();
		seats2.add("003");
		seats2.add("IITD1");
		seats2.add(25);
		seats2.add(25);
		collegecourse.put(005, seats2);
		ArrayList seats11 = new ArrayList ();
		seats11.add("003");
		seats11.add("IITD2");
		seats11.add(20);
		seats11.add(20);
		collegecourse.put(006,seats11);
		ArrayList seats3 = new ArrayList<>();
		seats3.add("004");
		seats3.add("IITK1");
		seats3.add(20);
		seats3.add(20);
		collegecourse.put(007, seats3);
		ArrayList seats12 = new ArrayList ();
		seats12.add("004");
		seats12.add("IITK2");
		seats12.add(20);
		seats12.add(20);
		collegecourse.put(1200,seats12);
		ArrayList seats4 = new ArrayList<>();
		seats4.add("005");
		seats4.add("BITS1");
		seats4.add(40);
		seats4.add(40);
		collegecourse.put(1201, seats4);
		ArrayList seats13 = new ArrayList ();
		seats13.add("005");
		seats13.add("BITS2");
		seats13.add(20);
		seats13.add(20);
		collegecourse.put(1202,seats13);
		ArrayList seats5 = new ArrayList<>();
		seats5.add("006");
		seats5.add("IITG1");
		seats5.add(30);
		seats5.add(30);
		collegecourse.put(1203, seats5);
		ArrayList seats14 = new ArrayList ();
		seats14.add("006");
		seats14.add("IITG2");
		seats14.add(20);
		seats14.add(20);
		collegecourse.put(1204,seats14);
		ArrayList seats6 = new ArrayList<>();
		seats6.add("007");
		seats6.add("NITW1");
		seats6.add(20);
		seats6.add(20);
		collegecourse.put(1205, seats6);
		ArrayList seats15 = new ArrayList ();
		seats15.add("007");
		seats15.add("NITW2");
		seats15.add(20);
		seats15.add(20);
		collegecourse.put(1206,seats15);
		ArrayList seats7 = new ArrayList<>();
		seats7.add("1200");
		seats7.add("IITH1");
		seats7.add(35);
		seats7.add(35);
		collegecourse.put(1207, seats7);
		ArrayList seats16 = new ArrayList ();
		seats16.add("1200");
		seats16.add("IITH2");
		seats16.add(20);
		seats16.add(20);
		collegecourse.put(1208,seats16);
		
	}
	CollegeCourse(int collegeid) {
		
		this.collegeid=collegeid;
		
	}
	Map<Integer,ArrayList> updateAvailableSeats(String courseid) {
		 
		 for(Entry<Integer, ArrayList> entry : collegecourse.entrySet()) {
			 ArrayList<Integer>getSeats = entry.getValue();
			 if(getSeats.contains(courseid)) {
				 int key= entry.getKey();
				 getSeats.set(3, getSeats.get(3)-1);
				 collegecourse.put(key, getSeats);
			 }
			
		 }
		 
		 
		 return collegecourse;
		 }
	Map<Integer,ArrayList> getCollegeCourse() {
		return collegecourse;
	}
	
	String displayData() {
		String college_course_data =" ";
		
		for(Entry<Integer, ArrayList> entry : collegecourse.entrySet()) {
			college_course_data = college_course_data+entry.getValue()+"\n";
			
			/*
			System.out.print(entry.getKey());
			 System.out.print("        ");
			 System.out.print(entry.getValue());
			 System.out.println();
			 */
		 }
		return college_course_data;
	}
		 
		 
	}

