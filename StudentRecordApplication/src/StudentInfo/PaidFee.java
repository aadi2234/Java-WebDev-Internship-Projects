package StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PaidFee extends StudentDetails {
    int tfee, feespaid, remain;
    Scanner sc = new Scanner(System.in);

    public void payFees(int amt) {
        Connection con = MysqlCon.getCon();
        try {
            sc.nextLine();
            System.out.println("Enter Student ID:");
            sid = sc.nextLine();
            System.out.println("Enter Total Fees:");
            tfee = sc.nextInt();
            System.out.println("Total Fees = " + tfee);
            feespaid = fee + amt;
            System.out.println("Updated Paid Fees: " + feespaid);

            PreparedStatement ps1 = con.prepareStatement("select * from students where id=?");
            ps1.setString(1, sid);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                fee = rs.getInt("fees");
            }
            PreparedStatement ps2 = con.prepareStatement("update students set fees=? where id=?");
            ps2.setInt(1, feespaid);
            ps2.setString(2, sid);
            int i = ps2.executeUpdate();
            if (i > 0) {
                System.out.println("Fees Paid Successfully...");
            } else {
                System.out.println("Failed to update Fee...");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void getRemainingFee() {
        System.out.println("Enter Total Fees:");
        tfee = sc.nextInt();
        System.out.println("Total Fees = " + tfee);
        remain = tfee - feespaid;
        System.out.println("Remaining Fee/Fees to be Paid?: " + remain);
    }

    public void viewStud() {
        Connection con = MysqlCon.getCon();
        sc.nextLine();
        System.out.println("Enter Student ID: ");
        sid = sc.nextLine();

        try {
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from students where id='" + sid + "'");
            while (rs.next()) {
                System.out.println("------------------------------------------");
                System.out.println("Student ID=" + rs.getString(1));
                System.out.println("Student Name=" + rs.getString(2));
                System.out.println("Mobile Number=" + rs.getString(3));
                System.out.println("Email ID=" + rs.getString(4));
                System.out.println("Class of Student=" + rs.getString(5));
                System.out.println("Branch of Student=" + rs.getString(6));
                System.out.println("Fees paid=" + rs.getInt(7));
                feespaid = rs.getInt(7);
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void viewAllStud() {
        Connection con = MysqlCon.getCon();
        try {
            Statement st1 = con.createStatement();
            ResultSet rs = st1.executeQuery("select * from students");
            while (rs.next()) {
                System.out.println("------------------------------------------");
                System.out.println("Student ID=" + rs.getString(1));
                System.out.println("Student Name=" + rs.getString(2));
                System.out.println("Mobile Number=" + rs.getString(3));
                System.out.println("Email ID=" + rs.getString(4));
                System.out.println("Class of Student=" + rs.getString(5));
                System.out.println("Branch of Student=" + rs.getString(6));
                System.out.println("Fees paid=" + rs.getInt(7));
                System.out.println("------------------------------------------");
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
