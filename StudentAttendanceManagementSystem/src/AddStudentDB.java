import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddStudentDB {
	AddStudentDB() throws SQLException
	{
	AddStudent as = new AddStudent();
	Connection con=null;
	PreparedStatement pst = null;
	ResultSet rs=null;
	try{
		Class.forName("oracle.jbdc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe", "system", "Vatsav333");
		String query="Insert into student(id, name,gender,dob,branch, email,password) values("+as.textField
				+","+as.textField_1+","+as.rdbtn+","+as.date+","+as.textField_3+","+as.textField_4+","
				+as.passwordField+")";
		pst=con.prepareStatement(query);
		rs=pst.executeQuery();
		if(!rs.wasNull()){
			System.out.println("lecturer has been added to Database Successfully");
		}
	}catch(Exception e){
		System.out.println("Exception occured");
	}
	finally{
		
		con.close();
	}
	}
	

}
