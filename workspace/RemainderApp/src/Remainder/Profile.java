package Remainder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Profile extends RemainderDetails
{
	void register()
	{
		System.out.println("Enter Your Name:");
        String name = sc.next();
        System.out.println("Enter Your Contact:");
        String contact = sc.next();
        System.out.println("Enter Your Email:");
        String eid = sc.next();
        System.out.println("Enter Your Password:");
        String password = sc.next();

        try {
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user_tbl WHERE uemail=?");
            ps1.setString(1, eid);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) 
            {
                System.out.println("User Already Exists!");
            } 
            else 
            {
                // Insert the user details into the table
                PreparedStatement ps2 = con.prepareStatement("INSERT INTO user_tbl (id, uname, umob, uemail, upass) VALUES (?, ?, ?, ?, ?)");
                ps2.setInt(1, 0);
                ps2.setString(2, name);
                ps2.setString(3, contact);
                ps2.setString(4, eid);
                ps2.setString(5, password);
                int i = ps2.executeUpdate();
                if (i > 0) 
                {
                    System.out.println("Registration Successful!");
                } 
                else 
                {
                    System.out.println("Failed to register the user.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

    boolean login() {
        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.println("Enter Your Email:");
            String eid = sc.next();
            System.out.println("Enter Your Password:");
            String password = sc.next();

            try {
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user_tbl WHERE uemail=? AND upass=?");
                ps1.setString(1, eid);
                ps1.setString(2, password);
                ResultSet rs = ps1.executeQuery();
                if (rs.next()) {
                    System.out.println("Login Successful!");
                    // Set the email in User object
                    user.setEmail(eid);
                    isLoggedIn = true;

                    System.out.println("------Reminder Details------");
                    System.out.println("1. Add Reminder");
                    System.out.println("2. View Reminders");
                    System.out.println("3. View All Reminders");
                    System.out.println("4. Delete Reminder");
                    System.out.println("Enter your choice:");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            addReminder();
                            break;
                        case 2:
                            viewReminders();
                            break;
                        case 3:
                        	viewReminderAll();
                        	break;
                        case 4:
                            deleteReminder();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } else {
                    System.out.println("Failed to Login.");
                    System.out.println("Please register first and try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isLoggedIn;
    }
}

