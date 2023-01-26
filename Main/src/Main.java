import java.util.Scanner;

public class Main {

    // passwords for recursion story
    private static final String[] ENTRANCE_PASSWORDS = {
            "j2o4df",
            "4df896",
            "dj0386",
            "k38fw0",
            "jordan53"
    };

    private static final String[] EXIT_PASSWORDS = {
            "vfndjk",
            "jo8afi",
            "fd9lkd",
            "0df2df"
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        recursion(scan);
    }

    // The method that is going to be called in the main function.
    // This contains the main story line for recursion.
    private static void recursion(Scanner scan) {

        // start - telling story
        System.out.println("Your goal is to rescue your best friend, who is held captive in a cabin in the mountains.\n" +
                "However, after a long way to the top of the mountain where the cabin is located, you face\n" +
                "the most difficult part of this journey: entering the cabin. Each time you enter the cabin, you\n" +
                "will see two locked doors, one is the entrance to another cabin, where your destination cabin is located in,\n" +
                "and another one is the exit that you will use when returning from the destination cabin.\n" +
                "Your destination cabin, that is, the cabin in which your best friend is, is the most inner cabin. Now\n" +
                "you have the passwords for the entrance doors, but the passwords for the exits are unknown. You\n" +
                "have to continue using the passwords you have to enter the cabin using the entrance door until\n" +
                "you reach the most inner cabin. And once you get there, you can save your friend and also get the\n" +
                "password set for the exits. Good luck!");

        // password set
        System.out.println("**********************************************************************");
        System.out.println("[Password Set for Entrances]\n" +
                "1st Cabin: j2o4df\n" +
                "2nd Cabin: (1st Cabin’s Password).subString(3) + “896”\n" +
                "3rd Cabin: (2st Cabin’s Password)[1] + (1st Cabin’s Password)[0] + “038” + (2st Cabin’s Password)[(2st Cabin’s Password).length - 1]\n" +
                "4th Cabin: “k38fw” + ((int) 5 / 6)\n" +
                "5th Cabin: (3rd Cabin’s Password)[1] + (1st Cabin’s Password)[2] + “r” + (2nd Cabin’s Password)[1] + “an” + 53");
        System.out.println("**********************************************************************");
        recursiveMethod(scan, 1);
    }

    // This is the actual recursive method - it calls itself
    // This method will be called in the recursion() method.
    private static void recursiveMethod(Scanner scan, int doorNumber) {
        if (doorNumber <= 5) {
            String password = "";
            System.out.println("You're standing in front of Cabin " + doorNumber + ".");
            System.out.print("Enter the password for the entrance: ");
            password = scan.nextLine();
            while (true) {
                if (password.equals(ENTRANCE_PASSWORDS[doorNumber - 1])) {
                    System.out.println("Door opens successfully!");
                    break;
                } else {
                    System.out.println("Wrong password! Please Try again!");
                    System.out.print("Enter the password: ");
                    password = scan.nextLine();
                }
            }
            System.out.println();
            recursiveMethod(scan, doorNumber + 1);
        } else {
            System.out.println("You've successfully entered the destination cabin!");
            System.out.println("You see your best friend there and immediately go and untie the ropes on his/her hands and feet.");
            System.out.println("Nice job!");
            System.out.println("On the table next to where your friend was laying at, you find the passwords for the exits:");
            System.out.println("**********************************************************************");
            System.out.println("[Password Set for Exits]\n" +
                    "1st Cabin: " +EXIT_PASSWORDS[0] + "\n" +
                    "2nd Cabin: " +EXIT_PASSWORDS[1] + "\n" +
                    "3rd Cabin: " +EXIT_PASSWORDS[2] + "\n" +
                    "4th Cabin: " +EXIT_PASSWORDS[3] + "\n");
            System.out.println("**********************************************************************");
            System.out.println("Pay attention to the order of the cabins!\n" +
                    "You are now in the 5th cabin and is trying to exit through the 1st cabin!");
            System.out.println();
            System.out.println();
        }

        if (doorNumber - 2 >= 1)  {
            String password = "";
            System.out.println("You're standing in front the exit that leads to Cabin " + (doorNumber - 2) + ".");
            System.out.print("Enter the password for the exit: ");
            password = scan.nextLine();
            while (true) {
                if (password.equals(EXIT_PASSWORDS[doorNumber - 3])) {
                    System.out.println("Door opens successfully!");
                    break;
                } else {
                    System.out.println("Wrong password! Please Try again!");
                    System.out.print("Enter the password: ");
                    password = scan.nextLine();
                }
            }
            System.out.println();
        } else {
            System.out.println("Congrats! You have just escaped from the cabin series!!!!!!!");
            System.out.println("Now you and your best can go back home together!");
            System.out.println("NICE JOB!!");
        }
    }
}