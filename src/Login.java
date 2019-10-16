//import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.*;

/**
 * 
 */

/**
 * @author murchana
 *
 */
public class Login {

	Map<Date,Integer>logindates = new HashMap<>();
	int score,studentScore;
	String name;
	Student studentobj;
	Login(String name) {
		this.name = name;
		studentobj =new Student();
		Date d1 = new Date(2019,9,2);
		logindates.put(d1,800);
		logindates.put(new Date(2019,9,4), 600);
		logindates.put(new Date(2019,9,15),500);
		logindates.put(new Date(2019,9,17),400);
		logindates.put(new Date(2019,9,19),200);
		logindates.put(new Date(2019,9,21),50);
	}
	int authorizeStudentData() {

		Map<String,ArrayList> studentData=studentobj.getData();
		for(Entry<String, ArrayList> entry : studentData.entrySet()) {
			ArrayList studentinfo = entry.getValue();
			if(studentinfo.get(0).equals(name)) {
				studentScore= (int)studentinfo.get(1);
			}

		}

		if(studentScore == 0) {
			//System.out.println("You Haven't registerd for the counselling. Please register !!");
			return 5;
			//java.lang.System.exit(0);
		}
		Date date = new Date();
		System.out.println(date);
		//LocalDate lt=LocalDate.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-LLLL-yyyy");
		//String formattedString = lt.format(formatter);
		
		for(Entry<Date, Integer> entry1 : logindates.entrySet()) {
			if(entry1.getKey().after(date)) {
				System.out.println("Inside date check");
			//if(entry1.getKey().equals(formattedString)) {
				//score = (int)logindates.get(formattedString);
				score = (int)entry1.getValue();

			}
				System.out.println(score);
		}
		if(score == 0) {
			//System.out.println("Wrong date. No counselling today!!!!");
			//java.lang.System.exit(0);
			return 4;
		}

		if(studentScore>=score) {
			return 3;
			//System.out.println("Login Successfull !!!!!");
		}
		else {
		//	System.out.println("You do not have enough marks for attending counselling today!!! Please try later. Good Luck !!!");
			//java.lang.System.exit(0);
			return 2;
		}
	}
}
