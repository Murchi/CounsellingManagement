import java.util.HashMap;
import java.util.Map;

/**
 * 
 */

/**
 * @author murchana
 *
 */
public class Course {
	

	Map<String,String>course = new HashMap<String,String>();
	Course(){
		course.put("RV7", "CSE");
		course.put("RV8","ECE");
		course.put("TU1", "Bio");
		course.put("TU2","Mech");
		course.put("IITD1","IT");
		course.put("IITD2", "CSE");
		course.put("IITK1", "ECE");
		course.put("IITK2", "Mech");
		course.put("BITS1","CSE");
		course.put("BITS2", "Bio");
		course.put("IITG1", "Mech");
		course.put("IITG2", "CSE");
		course.put("NITW1", "ECE");
		course.put("NITW2", "CSE");
		course.put("IITH1", "CSE");
		course.put("IITH2", "ECE");
		
	}
	
	Map<String,String> getData() {
		return course;
	}


}
