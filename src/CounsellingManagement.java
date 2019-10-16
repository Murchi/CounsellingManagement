/**
 * 
 */

/**
 * @author murchana
 *
 */

import java.util.*;
import java.util.Map.Entry;
public class CounsellingManagement {

	/**
	 * @param args
	 */

	College collegeObj = new College();
	CollegeCourse objcollegecourse = new CollegeCourse();
	Course courseObj = new Course();
	String courseid;
	
	
	//Map<Integer,ArrayList> displayData = new HashMap<>();

	
	void displayCourse(String collegeid) {
		System.out.print("Courseid"+"    "+"courseName");
		System.out.println();
		for (Map.Entry<Integer, ArrayList> entry : objcollegecourse.collegecourse.entrySet()) {

			ArrayList list = new ArrayList(); 
			list=entry.getValue();

			int isAvailable = (int)list.get(3);
			if(list.get(0).equals(collegeid) && isAvailable !=0 ) {


				courseid =(String) list.get(1);

				for (Map.Entry<String, String> courseiterator : courseObj.course.entrySet()) {
					if(courseiterator.getKey().equals(courseid)) {
						System.out.print(courseiterator.getKey());
						System.out.print("        ");
						System.out.print(courseiterator.getValue());
						System.out.println();
					}
				}

			}
		}
	}
	

	void displayCollege(Map<Integer,ArrayList>collegecourse) { 
		
		System.out.println("***********************List of Colleges**************************");
		System.out.println(String.format("%30s %25s %10s %25s %10s %20s %20s %20s %20s %20s %20s", "Rank", "|", "CollegeId", "|", "CollegeName", "|", "Courseid", "|", "CourseName", "|", "AvailableSeat"));
	    System.out.println(String.format("%s", "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"));
		for (Map.Entry<Integer, ArrayList> collegeiterator : collegeObj.college_names.entrySet()) {
			ArrayList collegeinfo =collegeiterator.getValue();
			String collegeid = (String)collegeinfo.get(0);
			for (Map.Entry<Integer, ArrayList> entry : collegecourse.entrySet()) {
				
				
				ArrayList list = new ArrayList(); 
				list=entry.getValue();

				int isAvailable = (int)list.get(3);
				
				if(list.get(0).equals(collegeid) && isAvailable !=0 ) {

				
					courseid =(String) list.get(1);
				
					for (Map.Entry<String, String> courseiterator : courseObj.course.entrySet()) {
						if(courseiterator.getKey().equals(courseid)) {
							
							 System.out.println(String.format("%30s %25s %10s %25s %10s %20s %20s %20s %20s %20s %20s", collegeiterator.getKey(), "|", collegeinfo.get(0), "|", collegeinfo.get(1), "|", courseiterator.getKey(), "|", courseiterator.getValue(), "|", list.get(3)));
							
						}
						
					}
					
				}
				
			}
			System.out.println();
		}

		 
	}
	boolean validateCollegeData(String Key) {

		Map<Integer,ArrayList> collegeData=collegeObj.getData();
		for(Entry<Integer,ArrayList> entry : collegeData.entrySet()) {
			ArrayList collegedata= entry.getValue();
			if(collegedata.get(0).equals(Key))
				return true;

		}
		return false;
	}

	boolean validateCourseData(String Key,String Collegeid) {
		Map<String,String>courseData = courseObj.getData();
		
		Map<Integer,ArrayList>collegecourseData = objcollegecourse.getCollegeCourse();
		ArrayList list = new ArrayList();
		for(Entry<Integer,ArrayList> entry : collegecourseData.entrySet()) {
			list=entry.getValue();
			if(list.get(0).equals(Collegeid) && list.get(1).equals(Key))
				return true;
			

		}
		return false;
	}
}
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {
			
			String StudentName,collegeid,courseid;
			CounsellingManagement objCounsellingManagement = new CounsellingManagement();
			Student studentObjdefault = new Student();
			CollegeCourse objcollegecourse = new CollegeCourse();
			Map<Integer,ArrayList> collegeCourse= objcollegecourse.getCollegeCourse();
			int type;
			while(true) {
				System.out.println("***********ENTER THE NUMBER SELECTED*********");
				System.out.println("1. ADMIN LOGIN");
				System.out.println("2. STUDENT LOGIN");
				System.out.println("3. STOP");
				type = sc.nextInt();
				sc.nextLine();
				
				switch(type) {
				case  1 :
					System.out.println("************ENTER THE NUMBER SELECTED***************");
					System.out.println("1. Display Student Data");
					System.out.println("2. Display College Data");
					int adminInput = sc.nextInt();
					switch(adminInput) {
						case 1: 
								studentObjdefault.displayData();
								break;
						case 2:
							objcollegecourse.displayData();
							break;
					}
					break;
				

			case 2 :	
			System.out.println("Enter your name or type stop to exit");
			StudentName = sc.nextLine();
			if(StudentName.equals("stop")) {
				java.lang.System.exit(0);
			}
			else {
				
			
			studentObjdefault.validateStudent(StudentName);
			Login login  = new Login(StudentName);
			login.authorizeStudentData();
			objCounsellingManagement.displayCollege (collegeCourse);

			
			System.out.println("Select College Id");
			collegeid = sc.nextLine();
		
			
			while(!objCounsellingManagement.validateCollegeData(collegeid)) {
				System.out.println("Wrong Collegeid Enter correct ID");
				collegeid = sc.nextLine();
				
			}
			
			
			System.out.println("Successfully Selected College !!!!");
			
			//objCounsellingManagement.displayCourse(collegeid);
			System.out.println("Select course of your choice");
			courseid = sc.nextLine();
			while(!objCounsellingManagement.validateCourseData(courseid,collegeid)) {
				System.out.println("Wrong courseId please Enter a Valid One");
				courseid = sc.nextLine();
				
			}
			
			System.out.println("Successfully Selected Course !!!!!!");
			
			
			Student studentObj = new Student(StudentName,collegeid,courseid);
			studentObjdefault.updateStudentData(collegeid,courseid, StudentName);

			
			collegeCourse=objcollegecourse.updateAvailableSeats(courseid);
			
			}
			break;
			
			case 3 :
				java.lang.System.exit(0);
				break;
				
			default: 
				System.out.println("WRONG CHOICE!!!!!");
				
			}
				
			}
}

		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			sc.close();
		}


	}

}
*/



