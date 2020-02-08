import java.sql.*;

public class Lab4_pre1_1 {
	public static void main(String args[])throws Exception {
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dileep");
	Statement stmt=con.createStatement();
	stmt.executeUpdate("create table student(id number(10),name varchar2(10),age number(2))");
	stmt.executeUpdate("insert into student values(1,'Felix',20)");
	stmt.executeUpdate("insert into student values(2,'jack',19)");
	stmt.executeUpdate("insert into student values(3,'mark',21)");
	
	PreparedStatement psmt=con.prepareStatement("select *from student where age < 21");
	ResultSet rs=psmt.executeQuery();
	System.out.println("Name\t\t"+"Id\t\t"+"Age\t\t");
	while(rs.next()) {
		System.out.println(rs.getString(2)+"\t\t"+rs.getInt(1)+"\t\t"+rs.getInt(3));
	}
	
	con.close();	
}
}
