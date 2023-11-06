// SR_BusTour.java

/*
 *  Program Name:    SR_BusTour
 *  Purpose:         Calculates the number of coaches, passengers, and seats, as operated by CPA Tours
 *  Coder:           Samuel Rincon Hernandez
 *  Date:            Friday, 13 October, 2023
 */


import java.util.Scanner;

public class SR_BusTour {
    public static void main(String[] args) {

        // instantiate necessary Objects
        Scanner input = new Scanner(System.in);

        // declare and initialise constants
        final double ROUNDING_FACTOR = 0.5;
        final String BUS_COMPANY = "Canadian Premium Adventure";
        final String BUS_COMPANY_LACONIC = "CPA";

        // declare variables
        int passengersWaiting;
        int numPassengers;
        int totalSeats;
        int numSeats;
        int numDrivers;
        int numCoaches;
        double passengersPerCoach;
        String tourGuide;


        // adds a wee welcome message to let user know what the program does
        System.out.println("Welcome to " + BUS_COMPANY + "'s Bus Tour Calculator");
        System.out.println("This program will calculate the number of coaches that will be operated,");
        System.out.println("the number of available seats, and the number of passengers for a " + BUS_COMPANY_LACONIC + " Tours excursion.");
        System.out.println("___________________________________________\n");

        // requests user inputs to initialise variables
        System.out.print("Enter the number of people on the waiting list: ");
        passengersWaiting = input.nextInt();

        System.out.print("Enter the seats on a coach: ");
        numSeats = input.nextInt();

        System.out.print("Enter the number of available drivers: ");
        numDrivers = input.nextInt();

        // validates inputs; e.g., you can't have negative passengers/seats/drivers. Program exits due to user error.
        if (passengersWaiting < 0 || numSeats < 0 || numDrivers < 0) {
            System.out.println("Negative people or seats are impossible! Please try again.");
            return;
        }

        input.nextLine(); // buffer flush...

        // requests the name of the tour guide
        System.out.print("Enter the name of the company tour guide for this tour: ");
        tourGuide = input.nextLine();


        // calculates number of coaches
        passengersPerCoach = (double) passengersWaiting / numSeats;
        passengersPerCoach += ROUNDING_FACTOR;

        // casting to round off number of coaches
        numCoaches = (int) passengersPerCoach;

        // checking to see if the number of coaches is higher than available drivers
        if (numCoaches > numDrivers) {
            numCoaches = numDrivers;
        }

        // determines number of passengers
        totalSeats = numCoaches * numSeats;

        // if there's more passengers than seats, limit numPassengers, otherwise all passengers will alight on tour
        if (passengersWaiting > totalSeats) {
            numPassengers = totalSeats;
        }
        else {
            numPassengers = passengersWaiting;
        }

        // reports the number of coaches that will be operator, total number of seats, and total passengers
        System.out.println(" "); // to separate line aesthetically
        System.out.println("This tour will require " + numCoaches + " coaches with " + numSeats + " seats each.");
        System.out.println("There is a total of " + totalSeats + " seats available.");
        System.out.println("There will be a total of " + numPassengers + " passengers on the tour led by " + tourGuide);


        // close the Scanner
        input.close();

    } // end of main
} // end of class