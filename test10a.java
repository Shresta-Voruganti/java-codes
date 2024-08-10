// display emp names of a dept in ascending order, when dept no. is given as an input
/* Demonstrate with a Java Program (using JDBC) to display all the employees who are
working in the given department. Read department number from the user. Also display records in
the ascending order of "employee name"
* */
import java.util.*;
import java.sql.*;

public class test10a
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter department number : ");
        int deptNum = sc.nextInt();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName","root","password");
        Statement stmt = con.createStatement();
        String sqlQuery = "select eName from emp where deptNo = " + deptNum + "order by eName asc;";
        ResultSet rs = stmt.executeQuery(sqlQuery);
        System.out.println("Employee Names : ");
        while(rs.next())
        {
            System.out.println(rs.getString(1));
        }
        con.close();
    }
}