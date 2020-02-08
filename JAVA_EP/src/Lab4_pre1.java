import java.sql.*;
class Lab4_pre1
{
public static void main(String args[]) throws Exception
{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Dileep	");
	Statement stmt=con.createStatement();
	stmt.executeUpdate("create table student1455(id number(20) primary key,name varchar(30),age number)");
	stmt.executeUpdate("insert into student1455 values (1,'Felix',20)");
                stmt.executeUpdate("insert into student1455 values (2,'jack',19)");
	stmt.executeUpdate("insert into student1455 values (3,'mark',21)");
	PreparedStatement pstmt=con.prepareStatement("select * from student1455 where age<21");
                ResultSet rs =pstmt.executeQuery();
               while(rs.next())

               {    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                  }
             

	con.close();
}
}