package StudentInfo;

import java.sql.*;
import java.util.Scanner;

public class StudentDetails {
    String sid, sname, smob, semail, sclass, sbranch;
    int fee;
    Scanner sc = new Scanner(System.in);

    public void addStud() {
        Connection con = MysqlCon.getCon();
        System.out.println("Enter Student ID:");
        sid = sc.next();
        sc.nextLine();
        System.out.println("Enter Student Name:");
        sname = sc.nextLine();
        System.out.println("Enter Mobile Number:");
        smob = sc.nextLine();
        System.out.println("Enter Email ID:");
        semail = sc.nextLine();
        System.out.println("Enter Class of Student:");
        sclass = sc.nextLine();
        System.out.println("Enter Branch of Student:");
        sbranch = sc.nextLine();
        System.out.println("Enter Fees paid by Student:");
        fee = sc.nextInt();
        try {
            Statement st = con.createStatement();
            int i = st.executeUpdate("insert into students values('" + sid + "','" + sname + "','" + smob + "','" + semail + "','" + sclass + "','" + sbranch + "','" + fee + "')");
            if (i > 0) {
                System.out.println("Student Record Saved Successfully...!!");
            } else {
                System.err.println("Failed to Save record of Student...!!");
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
