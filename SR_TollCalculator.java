// SR_ProgramName.java

/*
 *  Program Name:    SR_ProgramName
 *  Purpose:         WHAT IS THE PURPOSE OF THIS THING?
 *  Coder:           Samuel Rincon Hernandez
 *  Date:            Friday, 13 October, 2023
 */


import java.util.Scanner;
import java.text.DecimalFormat;

public class SR_TollCalculator {  // SR_ProgramName
    public static void main(String[] args) {

        // instantiate necessary Objects
        Scanner input = new Scanner(System.in);
        DecimalFormat numform = new DecimalFormat("#,##0.00");


        // declare and initialise constants, the fees are fixed
        final double TRIP_TOLL_FEE = 0.8;
        final double REG_ZONE_FEE = 0.302;
        final double LIGHT_ZONE_FEE = 0.287;
        final double NO_TRANSPONDER_FEE = 3.95;
        final double ACCOUNT_FEE = 3.4;


        // declare variables
        double regZoneKm;
        double lightZoneKm;
        char hasTransponder;
        double regZoneFees;
        double lightZoneFees;
        double totalFees;


        // print out to tell the user what this program does on terminal
        System.out.println("407 ETR Toll Calculator \n");


        // ask user whether or not their vehicle has a transponder
        System.out.print("Does your vehicle carry a transponder? (Y/N): ");
        hasTransponder = input.next().charAt(0);


        // validate answer for question above
        if (Character.toUpperCase(hasTransponder) == 'Y') {
            totalFees = 0.0;
        }
        else if (Character.toUpperCase(hasTransponder) == 'N') {
            totalFees = NO_TRANSPONDER_FEE;
        }
        else {
            System.out.println("Invalid input. Please choose Y or N only.");
            totalFees = 0.0;
            return; // program will end if we don't get a valid answer
        }


        // ask user to submit kms travelled in each zone
        System.out.print("Enter the kilometres travelled in the regular zone: ");
        regZoneKm = input.nextDouble();

        System.out.print("Enter the kilometres travelled in the light zone: ");
        lightZoneKm = input.nextDouble();


        // calculate toll charges
        regZoneFees = regZoneKm * REG_ZONE_FEE;
        lightZoneFees = lightZoneKm * LIGHT_ZONE_FEE;
        totalFees = totalFees + regZoneFees + lightZoneFees + TRIP_TOLL_FEE;


        // output subtotal for each of the zones + trip toll charge
        System.out.println("Toll charge for travelling " + numform.format(regZoneKm) + " km in the regular zone: $" + numform.format(regZoneFees));
        System.out.println("Toll charge for travelling " + numform.format(lightZoneKm) + " km in the regular zone: $" + numform.format(lightZoneFees));
        System.out.println("Trip toll charge: $" + numform.format(TRIP_TOLL_FEE));

        // out subtotal if vehicle does not have a transponder
        if (hasTransponder == 'N' || hasTransponder == 'n') {
            System.out.println("Video toll charge: $" + numform.format(NO_TRANSPONDER_FEE));
        }

            // output total fees after totting up the above
        System.out.println("TOTAL TOLL CHARGE: $" + numform.format(totalFees));

        // only outputs if vehicle does not have a transponder
        if (hasTransponder == 'N' || hasTransponder == 'n') {
            System.out.println("\n Your monthly bill will also include a $" + numform.format(ACCOUNT_FEE) + " account fee.");
        }

        // close the Scanner
        input.close();

    } // end of main
} // end of class