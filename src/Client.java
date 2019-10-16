// Java implementation for a client 
// Save file as Client.java 

import java.io.*; 
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner; 

// Client class 
public class Client 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		CounsellingManagement objCounsellingManagement = new CounsellingManagement();
		try
		{ 
			Scanner scn = new Scanner(System.in); 
			
			// getting localhost ip 
			InetAddress ip = InetAddress.getByName("localhost"); 
	
			// establish the connection with server port 5056 
			Socket s = new Socket(ip, 6000); 
	
			// obtaining input and out streams 
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
	
			// the following loop performs the exchange of 
			// information between client and client handler 
			outer:
			while (true) 
			{ 
			//	System.out.println("Inside While");
				System.out.println(dis.readUTF()); 
				String tosend = scn.nextLine(); 
				dos.writeUTF(tosend); 
				
				// If client sends exit,close this connection 
				// and then break from the while loop 
				if(tosend.equals("Exit")) 
				{ 
					System.out.println("Closing this connection : " + s); 
					s.close(); 
					System.out.println("Connection closed"); 
					break; 
				} 
				
				
				switch(tosend) {
				
				case "1" :
					
					
					String received = dis.readUTF(); 
					
					
					
					String [] received_data= received.split(" ");
					
					
					for (String a : received_data) { 
			            System.out.print(a);
			           
			            
			            
			           
					}
					System.out.println();
					
					
					 received = dis.readUTF(); 
					
					
					
					String [] received_data1= received.split(" ");
					
					
					for (String a : received_data1) { 
			            System.out.print(a);
			            
			           
					}
					
					
						break;
					
				case "2" :
					//String received_name =  dis.readUTF();
					
					System.out.println(dis.readUTF()); 
					String send_name = scn.nextLine(); 
					dos.writeUTF(send_name);
					/*
					String received_name = dis.readUTF();

					String [] received_name_arr= received_name.split(" ");
					
					
					for (String a : received_name_arr) { 
			            System.out.print(a);
			           
					}
					
					System.out.println();
					*/
					
					int name_validation = dis.read();
					if(name_validation == 6) {
						System.out.println("Course Selection Already done");
						dos.writeInt(10);
						break outer;
						//java.lang.System.exit(0);
					}
					else {
						dos.writeInt(11);
					}
					
					
					int data = dis.read();
					
					if(data==2) {
						System.out.println("You do not have enough marks for attending counselling today!!! Please try later. Good Luck !!!");
						dos.writeInt(12);
						break outer;
					}
					
					else if (data==4){
						System.out.println("Wrong date. No counselling today!!!!");
						dos.writeInt(13);
						break outer;
					}
					
					else if(data == 5) {
						System.out.println("You haven't registered for counselling.Please register ");
						dos.writeInt(15);
						break outer;
					}
					else  {
						dos.writeInt(14);
						System.out.println("Login Successfull !!!!!");
						
					}
					
					 final InputStream yourInputStream = s.getInputStream();
					 final ObjectInputStream mapInputStream = new ObjectInputStream(yourInputStream);
					 final Map<Integer,ArrayList> yourMap = (Map) mapInputStream.readObject();
					 objCounsellingManagement.displayCollege(yourMap);
					
					
					System.out.println(dis.readUTF()); 
					String collegeid = scn.nextLine();
					dos.writeUTF(collegeid);
				//	String college_validate = dis.readUTF();
					/*while(college_validate.equals("5")) {
						System.out.println("Wrong college id Enter correct id");
						collegeid = scn.nextLine();
						dos.writeUTF(collegeid);
						college_validate = dis.readUTF();
					}
					*/
					System.out.println(dis.readUTF());
					System.out.println(dis.readUTF());
					//System.out.println("Enter course id");
					String courseid = scn.nextLine();
					dos.writeUTF(courseid);
					/*
					String course_validate = dis.readUTF();
					while(course_validate.equals("5")) {
						System.out.println("Wrong course id choose correct one");
						courseid = scn.nextLine();
						dos.writeUTF(courseid);
						course_validate = dis.readUTF();
					}
					*/
					System.out.println(dis.readUTF());
					break;
					
				}
				
				// printing date or time as requested by client 
				
				
				
			} 
			
			// closing resources 
			scn.close(); 
			dis.close(); 
			dos.close(); 
		}catch(Exception e){ 
			e.printStackTrace(); 
		} 
	} 
} 
