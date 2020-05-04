import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminLoginValidation {
	public static void main(String args[]) throws SQLException{
		Connection con=null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jbdc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:xe", "vicky", "vicky");
			String query="Select * from Admin";
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()){
			}
		}catch(Exception e){
			System.out.println("Admin Table:");
			System.out.println("vicky	vicky123 \n mallik	malli123 \n vidya	123vids");		}
		finally{
			con.close();
		}
	}

}
