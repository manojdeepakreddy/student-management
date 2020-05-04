import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Vatsav333");
			if(con!=null){
				System.out.println("Connected Succesfully");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
