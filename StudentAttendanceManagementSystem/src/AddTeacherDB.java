import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddTeacherDB {
	AddTeacherDB() throws SQLException{
		AddTeacher at = new AddTeacher();
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Vatsav333");
			/*String query="insert into teacher(id,name,gender,dob,branch, email,password) values("+at.textField
					+","+at.textField_1+","+at.rdbtn+","+at.date+","+at.textField_3+","+at.textField_4+","
					+at.passwordField+")";*/
			String query="insert into teacher(id,name,dob,branch,email,pass) values(?,?,?,?,?,?)";
			System.out.println("Id: "+at.strtextField);
			pst=con.prepareStatement(query);
			pst.setString(1, "vidya");
			pst.setString(2, "vidya");
			pst.setString(3, "vidya");
			pst.setString(4, "vidya");
			pst.setString(5, "vidya");
			pst.setString(6, "zfs");
			
			rs=pst.executeQuery();
			
		}catch(Exception e){
			System.out.println("Exception"+e);
		}
		finally{
			
			con.close();
		}}
	public static void main(String[] args) throws SQLException{
		AddTeacherDB a = new AddTeacherDB();
	}
}
