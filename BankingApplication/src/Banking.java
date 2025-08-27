import java.sql.Connection;
import java.util.Scanner;

class Banking {
    public static void main(String[] args) {
    	Connection con= MysqlCon.getCon();
        Scanner sc = new Scanner(System.in);
        int ch;
        AmountWithdraw aw = new AmountWithdraw();

        do {
            System.out.println("\n------Menu------");
            System.out.println("1] Add New User");
            System.out.println("2] View User Information");
            System.out.println("3] Deposit");
            System.out.println("4] Withdraw");
            System.out.println("5] View all User Information & Check Balance");
            System.out.println("6] Exit");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    aw.addUser();
                    break;
                case 2:
                    aw.viewUser();
                    break;
                case 3:
                    aw.deposit();
                    aw.currentBal();
                    break;
                case 4:
                    aw.withdraw();
                    aw.currentBalance();
                    break;
                case 5:
                    aw.checkBalance();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (ch != 6);
        sc.close();
    }
}