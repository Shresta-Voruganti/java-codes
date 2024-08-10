/* Demonstrate with a Java program(use JDBC) to display all the employees who are working in
"Dallas" in ascending order of their names
* */
import java.sql.*;

public class test10b
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName","root","password");
        Statement stmt = con.createStatement();
        String loc = "Dallas";
        String sqlQuery = "select e.eName from emp e, dept d where e.deptNo=d.deptNo and d.location=" + loc + ";";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        System.out.println("Employee Names : ");
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
        con.close();
    }
}