// Java implementation of Server side 
// It contains two classes : Server and ClientHandler 
// Save file as Server.java 

import java.io.*; 
import java.text.*; 
import java.util.*;

import java.net.*; 


// Server class 
public class Server 
{ 
	
	public static void main(String[] args) throws IOException 
	{ 
		
		// server is listening on port 5056 
		ServerSocket ss = new ServerSocket(6000); 
		Student studentObjdefault = new Student();
		CollegeCourse objcollegecourse = new CollegeCourse();
		CounsellingManagement objCounsellingManagement = new CounsellingManagement();
		Map<Integer,ArrayList> collegeCourse= objcollegecourse.getCollegeCourse();
		// running infinite loop for getting 
		// client request 
		while (true) 
		{ 
			Socket s = null; 
			
			try
			{ 
				// socket object to receive incoming client requests 
				s = ss.accept(); 
				
				System.out.println("A new client is connected : " + s); 
				
				// obtaining input and out streams 
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				
				System.out.println("Assigning new thread for this client"); 

				// create a new thread object 
				Thread t = new ClientHandler(collegeCourse,objCounsellingManagement,objcollegecourse,studentObjdefault,s, dis, dos); 

				// Invoking the start() method 
				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 

// ClientHandler class 
class ClientHandler extends Thread 
{ 
	
	DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
	DateFormat fortime = new SimpleDateFormat("hh:mm:ss"); 
	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
	//static int marks =0;
	
	ArrayList student_list;
	Student studentObjdefault;
	CollegeCourse objcollegecourse;
	CounsellingManagement objCounsellingManagement;
	Map<Integer,ArrayList> collegeCourse;
	
	// Constructor 
	public ClientHandler(Map<Integer,ArrayList> collegeCourse,CounsellingManagement objCounsellingManagement,CollegeCourse objcollegecourse,Student studentObjdefault,Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
		this.studentObjdefault=studentObjdefault;
		this.objcollegecourse=objcollegecourse;
		this.objCounsellingManagement=objCounsellingManagement;
		this.collegeCourse=collegeCourse;
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		outer:
		while (true) 
		{ 
			try { 

				// Ask user what he wants 
			//	System.out.println("Inside While");
				
				dos.writeUTF("****Login Menu****\n"+ "1.Admin\n"+"2.Student\n"+
							"Type Exit to terminate connection");
				
				// receive the answer from client 
				received = dis.readUTF(); 
				
				if(received.equals("Exit")) 
				{ 
					System.out.println("Client " + this.s + " sends exit..."); 
					System.out.println("Closing this connection."); 
					this.s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} 
				
				
				
				// creating Date object 
				Date date = new Date(); 
				
				// write on output stream based on the 
				// answer from the client
				
				switch (received) { 
				
					case "1" : 
							
							dos.writeUTF(studentObjdefault.displayData());
							dos.writeUTF(objcollegecourse.displayData());
							break; 
						
						
					case "2" : 
					
						dos.writeUTF("Enter you name");
						String name = dis.readUTF();
						int student_validation = studentObjdefault.validateStudent(name);
						dos.write(student_validation);
						int validation_response=dis.readInt();
						
						if(validation_response==10) {
							break outer;
						}
						
						Login login  = new Login(name);
						int login_authorization=login.authorizeStudentData();
						dos.write(login_authorization);
						
						int login_validation_reply = dis.readInt();
						if(login_validation_reply==12) {
							break outer;
						}
						else if (login_validation_reply==13) {
							break outer;
						}
						else if(login_validation_reply==15) {
							break outer;
						}
						else {
						final OutputStream yourOutputStream =s.getOutputStream();
						final ObjectOutputStream mapOutputStream = new ObjectOutputStream(yourOutputStream);
						mapOutputStream.writeObject(collegeCourse);
						
						dos.writeUTF("Select College id");
						String collegeid = dis.readUTF();
						while(!objCounsellingManagement.validateCollegeData(collegeid)) {
							System.out.println("Inside CollegeValiation while");
						//	dos.writeUTF("5");
							collegeid = dis.readUTF();
							
						}
						dos.writeUTF("Successfully Selected College !!!!");
						dos.writeUTF("Select course of your choice");
						String courseid = dis.readUTF();
						while(!objCounsellingManagement.validateCourseData(courseid,collegeid)) {
							dos.writeUTF("5");
							courseid = dis.readUTF();
							
						}
						dos.writeUTF("Successfully Selected Course !!!!!!");
						synchronized(this) {
							studentObjdefault.updateStudentData(collegeid,courseid, name);
							collegeCourse=objcollegecourse.updateAvailableSeats(courseid);
						}
					
						break; 
						}
						
					default: 
						dos.writeUTF("Invalid input"); 
						break; 
				} 
				
			} catch (IOException e) { 
				e.printStackTrace();
				
			} 
			
			
		} 
		
		try
		{ 
			// closing resources 
			this.dis.close(); 
			this.dos.close(); 
			
		}catch(IOException e){ 
			e.printStackTrace(); 
		} 
	} 
} 
