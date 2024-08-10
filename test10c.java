// inserting a record into dept table
/*
| Field | Type | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| deptno | int(2) | NO | PRI | NULL | |
| dname | varchar(50) | NO | | NULL | |
| location | varchar(50) | NO | | NULL | |
+----------+-------------+------+-----+---------+-------+
* */
import java.sql.*;
import java.util.*;

public class test10c
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dept no. : ");
        int dno = sc.nextInt();
        System.out.print("Enter dept name : ");
        String dname = sc.next();
        System.out.print("Enter dept location : ");
        String dloc = sc.next();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:330/dbName","root","password");
        String sqlQuery = "insert into dept values(?,?,?);";
        PreparedStatement pstmt = con.prepareStatement(sqlQuery);
        pstmt.setInt(1,dno);
        pstmt.setString(2,dname);
        pstmt.setString(3,dloc);
        int status = pstmt.executeUpdate();
        if(status>0)
        {
            System.out.println("Record inserted successfully");
        }
        con.close();
    }
}