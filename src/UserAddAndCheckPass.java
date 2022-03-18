import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.sql.ResultSet;


public class UserAddAndCheckPass {
	
	private static Connection con;
	private static PreparedStatement pst,pst1;
	private static Statement st;
	private static ResultSet rs,rs1,rs2;
	private static String str,str1,str2;
	
	//this methods inserts the new user entry into the table
	protected static boolean insertNewUser(String username,String password){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digibook","root","tywelcome@6");
			
			//checking wher user is present or not
			str1 = "select * from users_list where username=?";
			pst1 = con.prepareStatement(str1);
			pst1.setString(1, username);
			rs = pst1.executeQuery();
			if(rs.next()) {
				return true;
			}
			
			//inserting into list if not present
			str = "insert into users_list(username,password) values (?,?)";
			pst = con.prepareStatement(str);
			pst.setString(1,username);
			pst.setString(2,password);
			pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//this checks password correctness
	protected static boolean passValidator(String username,String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digibook","root","tywelcome@6");
			str = "select * from users_list where username=?";
			pst = con.prepareStatement(str);
			pst.setString(1, username);
			rs = pst.executeQuery();
			rs.next();
            if(rs.getString(2)==password) {
            	return true;
            }
            else{
            	return false;
            }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	protected static ResultSet DisplayList() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","tywelcome@6");
			str = "select doctor_name, doctor_timings, doctor_room_no, doctor_phone_no from doctor_list";
			st = con.createStatement();
			rs = st.executeQuery(str);
			rs.next();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	protected static void deleteRequiredDoctor(String name) throws SQLException {
		
		String a,b,c,d;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","tywelcome@6");
			Class.forName("com.mysql.cj.jdbc.Driver");
			str = "delete from doctor_list where doctor_name = ?";
			pst = con.prepareStatement(str);
			pst.setString(1, name);
			pst.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected static void trnct() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management","root","tywelcome@6");
				str = "truncate patient_list";
				st = con.createStatement();
				st.executeUpdate(str);
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
