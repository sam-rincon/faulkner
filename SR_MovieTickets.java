// SR_ProgramName.java

/*
 * Program Name:    SR_ProgramName
 * Purpose:         WHAT IS THE PURPOSE OF THIS THING?
 * Coder:           Samuel Rincon Hernandez
 * Date:            Friday, 13 October, 2023
 */


import java.util.Scanner;
import java.text.DecimalFormat;

public class SR_MovieTickets {  // SR_ProgramName
    public static void main(String[] args) {

        // instantiate necessary Objects
        Scanner input = new Scanner(System.in);
        DecimalFormat numform = new DecimalFormat("#,##0.00");


        // declare ticket prices, fixed prices
        final double CHILD_FEE = 10.0;
        final double ADULT_FEE = 12.25;
        final double SENIOR_FEE = 11.5;
        final String LINE_BREAK = "________________________________________________\n";

        // declare and initialising variables
        int numChildren = 0;
        int numAdults = 0;
        int numSeniors = 0;
        int totalPeople;
        double totalFees;
        char categoryChar;

        // print out welcome message to terminal for user
        System.out.println("Welcome to the Movie Theatre Admission Calculator!");
        System.out.println(LINE_BREAK);
        System.out.println("This application calculates the Total Admission Price for a group of any size and of varying ages.");
        System.out.println(LINE_BREAK);

        // ask user for total number of people
        System.out.print("How many people are in your group? ");
        totalPeople = input.nextInt();

        int people = 1; // can't have person 0
        while (people < (totalPeople + 1)) {
            System.out.print("Enter age category for person " + people + " (C = Child, A = Adult, S = Senior): ");
            categoryChar = input.next().charAt(0);
            people++;

            // categorises and increments variables depending on user answer
            switch (Character.toUpperCase(categoryChar)) {
                case 'C' -> numChildren++;
                case 'A' -> numAdults++;
                case 'S' -> numSeniors++;
                default -> {System.out.println("That is not a valid option; please try again");
                            people--;
                           } // if the choice is invalid, counter goes back 1.
            }
        }

        // read back the number of people, categorised, to the user
        System.out.println("Your group consists of " + numChildren + " child(ren), " + numAdults + " adult(s), and " + numSeniors + " senior(s).");

        // calculates admission price
        totalFees = (numChildren * CHILD_FEE) + (numAdults * ADULT_FEE) + (numSeniors * SENIOR_FEE);
        System.out.println("The total admission charge for your group is $" + numform.format(totalFees));

        // close the Scanner
        input.close();

    } // end of main
} // end of class

