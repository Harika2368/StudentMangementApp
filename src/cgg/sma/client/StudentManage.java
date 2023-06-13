package cgg.sma.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cgg.sma.dao.StudentDAO;
import cgg.sma.model.Student;

public class StudentManage {
	static StudentDAO studentDAO = new StudentDAO();

	public static void main(String[] args) {
		System.out.println("Welcome to Student Management Application");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add student");
			System.out.println("Press 2 to Update");
			System.out.println("Press 3 to Delete Student");
			System.out.println("Press 4 to Display All Students");
			System.out.println("Press 5 to Exit");
			
			System.out.println("Enter your choice");
			
			int ch;
			try {
				ch = Integer.parseInt(br.readLine());
			
			if(ch==1) {
				//add student
				System.out.println("Enter Student name : ");
				String name= br.readLine();
				System.out.println("Enter Student Phone number : ");
				String phone= br.readLine();
				System.out.println("Enter Student City : ");
				String city = br.readLine();
				
				//cretae student object to store
				Student student = new Student(name,phone,city);
				boolean answer = studentDAO.insertStudentToDb(student);
				if(answer) {
					System.out.println("Student Data Added Successfully..");
				}
				else {
					System.out.println("Not Added..");
				}
				System.out.println(student);
			}
			else if(ch==2) {
				//update student
				System.out.println("Enter studentId to Update..");
				int userId= Integer.parseInt(br.readLine());
				System.out.println("Enter studentname to Update..");
				String uname = br.readLine();
				System.out.println("Enter studentPhone to Update..");
				String uphone=br.readLine();
				System.out.println("Enter studentcity to Update..");
				String ucity=br.readLine();
				Student std= new Student(userId,uname,uphone,ucity);
				boolean answer =studentDAO.updateStudent(std);
				if(answer) {
					System.out.println("Student Data Updated Successfully..");
				}
				else {
					System.out.println("Not Deleted..");
				}
			}
			else if(ch==3) {
				//delete student
				System.out.println("Enter studentId to delete..");
				int userId= Integer.parseInt(br.readLine());
				boolean answer = studentDAO.deleteStudent(userId);
				if(answer) {
					System.out.println("Student Data Deleted Successfully..");
				}
				else {
					System.out.println("Not Deleted..");
				}
				
			}else if(ch==4) {
				//display all students
				System.out.println("ALL STUDENTS DATA \n ______________________________");
				studentDAO.showALLStudents();
				
			}else if(ch==5) {
				//exit
				break;
			}
			} 
			catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thank you for using this app..");
		System.out.println("see you soon....bye bye");

	}

}
