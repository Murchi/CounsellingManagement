/**
 * 
 */

/**
 * @author murchana
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class Student {

	String collegeid,courseid;
	String name,id;
	Map<String,ArrayList>studentData = new HashMap<>();
	Student() {
		ArrayList list= new ArrayList();
		list.add("ABC");
		list.add(800);
		studentData.put("1", list);
		ArrayList list1 =new ArrayList();
		list1.add("DEF");
		list1.add(800);
		studentData.put("2", list1);
		ArrayList list2 = new ArrayList();
		list2.add("Ram");
		list2.add(50);
		studentData.put("3", list2);
	}
	Map<String,ArrayList> getData() {
		return studentData;
	}
	Student(String name) {
		this.name =name;
	}
	Student(String name, String collegeid, String courseid){
		
		this.name = name;
		this.collegeid= collegeid;
		this.courseid = courseid;
	}
	
	
	void updateStudentData(String collegeid,String courseid,String name) {
	
		for(Entry<String, ArrayList> entry : studentData.entrySet()) {
		ArrayList studentinfo = entry.getValue();
		
		if(studentinfo.get(0).equals(name) && studentinfo.size()<3) {
		String key= entry.getKey();
		studentinfo.add(2,collegeid);
		studentinfo.add(3,courseid);
		studentData.put(key, studentinfo);
		
		
		}
		
		
		
		}
		
		
		
	}
	
	String displayData() {
		String student=" ";
		System.out.println("#############Studentinfo updated successfully########");
		for(Map.Entry<String, ArrayList> entry1 :studentData.entrySet() ) {
			
		//	student = student+entry1.getValue()+",  ";
			student = student+entry1.getValue()+"\n";
			/*
			System.out.print(entry1.getKey());
			System.out.print(" "+" "+" "+" "+" "+" "+" "+" ");
			System.out.print(entry1.getValue());
			System.out.println();
			*/
			
			
		}
		return student;
	}
	
	int validateStudent(String name) {
		ArrayList list= new ArrayList();
		for(Map.Entry<String, ArrayList> entry1 :studentData.entrySet() ) {
			list= entry1.getValue();
			if(list.get(0).equals(name) && list.size()>2) {
				//System.out.println("Course Selection already done");
		//		java.lang.System.exit(0);
				return 6;
			}
		}
		return 7;
	}

}

