package StudentInfo;

import java.util.Scanner;

public class StudentRecord {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch, amt, tfee;
        PaidFee obj1 = new PaidFee();

        do {
            System.out.println("\n---------------Menu---------------");
            System.out.println("1] Add New Student");
            System.out.println("2] View Student Information");
            System.out.println("3] Show Unpaid Fee");
            System.out.println("4] Pay Unpaid Fee");
            System.out.println("5] View all Student Information");
            System.out.println("6] Exit");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    obj1.addStud();
                    break;
                case 2:
                    obj1.viewStud();
                    break;
                case 3:
                    obj1.getRemainingFee();
                    break;
                case 4:
                    System.out.print("Enter the amount to be paid: ");
                    amt = sc.nextInt();
                    obj1.payFees(amt);
                    obj1.getRemainingFee(); // Display remaining fee after payment
                    break;
                case 5:
                    obj1.viewAllStud();
                    break;
                default:
                    System.out.println("Invalid Choice...!! Plz try again..!");
                    break;
            }
        } while (ch != 6);
    }
}
