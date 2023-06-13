package cgg.sma.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cgg.sma.manage.ConnectionProvider;
import cgg.sma.model.Student;

public class StudentDAO {

	//write methods for all
	Connection conn;

	public StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
		conn=ConnectionProvider.createConnection();
	}
	
	public boolean insertStudentToDb(Student st) {
		boolean f=false;
		try {
			String q= "insert into students(student_name,student_phone,student_city) values(?,?,?)";
			//PreparedStatement
			PreparedStatement ps = conn.prepareStatement(q);
			
			//set the values of parameters
			ps.setString(1,st.getsName());
			ps.setString(2, st.getsPhone());
			ps.setString(3, st.getsCity());
			
			//execute..
			ps.executeUpdate();
			
			f=true;
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return f;
	}
	public boolean updateStudent(Student std) {
		boolean f=false;
		try {
			String q="update students set student_name=?,student_phone=?,student_city=? where studentid=?";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setString(1,std.getsName());
			ps.setString(2,std.getsPhone());
			ps.setString(3,std.getsCity());
			ps.setInt(4, std.getStudentId());
			ps.executeUpdate();
		//	System.out.println("rows updated");
			f=true;

		}catch(SQLException e) {
			System.out.println(e);
		
	}
		return f;
}
	public boolean deleteStudent(int userId) {
		boolean f=false;
		try {
			String q = "delete from students where studentid=?";
			//PreparedStatement
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, userId);
			ps.executeUpdate();
			
			f=true;
		}catch(SQLException e) {
			System.out.println(e);
		}
		return f;
	}
	public void showALLStudents() {
		try {
			String q = "select * from students";
			//PreparedStatement
			Statement stm = conn.createStatement();
			ResultSet rs=stm.executeQuery(q);
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString(4);
				
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);
				System.out.println("phone : "+phone);
				System.out.println("city : "+city);
				System.out.println("____________________________");
				
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
