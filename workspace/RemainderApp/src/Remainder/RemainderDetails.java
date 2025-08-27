package Remainder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class RemainderDetails 
{
	Connection con=MysqlCon.getCon();
	Scanner sc = new Scanner(System.in);
	User user = new User();
	void addReminder() {
        try {
        	sc.nextLine();
            System.out.println("Enter Title:");
            String title = sc.nextLine();
            System.out.println("Enter Description:");
            String description = sc.nextLine();

            PreparedStatement ps3 = con.prepareStatement("INSERT INTO task_tbl (id,rtitle,rdesc,uemail) VALUES (?,?,?,?)");
            ps3.setInt(1, 0);
            ps3.setString(2, title);
            ps3.setString(3, description);
            ps3.setString(4, user.getEmail());

            int i = ps3.executeUpdate();
            if (i > 0) 
            {
                System.out.println("Reminder added successfully!");
            } 
            else 
            {
                System.out.println("Failed to add reminder.");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	void viewReminders() {
        try {
        	PreparedStatement ps4 = con.prepareStatement("SELECT * FROM task_tbl WHERE uemail=?");
            ps4.setString(1, user.getEmail());
            ResultSet rs1 = ps4.executeQuery();

            while (rs1.next()) 
            {
                int id = rs1.getInt("id");
                String title = rs1.getString("rtitle");
                String description = rs1.getString("rdesc");

                System.out.println("----------------------");
                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Email ID: " +user.getEmail());
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	void viewReminderAll() {
        try {
        	PreparedStatement ps4 = con.prepareStatement("SELECT * FROM task_tbl");
            ResultSet rs1 = ps4.executeQuery();

            while (rs1.next()) 
            {
                int id = rs1.getInt("id");
                String title = rs1.getString("rtitle");
                String description = rs1.getString("rdesc");
                String email = rs1.getString("uemail");

                System.out.println("----------------------");
                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Email ID: " +email);
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	void deleteReminder() 
	{
        System.out.println("Enter the ID of the reminder to delete:");
        int id = sc.nextInt();

        try {
            PreparedStatement ps5 = con.prepareStatement("DELETE FROM task_tbl WHERE id=? AND uemail=?");
            ps5.setInt(1, id);
            ps5.setString(2, user.getEmail());

            int i = ps5.executeUpdate();
            if (i > 0) 
            {
                System.out.println("Reminder deleted successfully!");
            } 
            else 
            {
                System.out.println("Failed to delete reminder. Make sure the ID is correct and belongs to your reminder.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
