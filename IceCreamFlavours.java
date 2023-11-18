// SR_IceCreamFlavours

/*
 *  Program Name:    SR_IceCreamFlavours
 *  Purpose:         Randomly generate combinations of flavours and styles
 *  Coder:           Samuel Rincon Hernandez
 *  Date:            Friday, 17 November, 2023
 */

import java.util.Scanner;

public class SR_IceCreamFlavours {
    public static void main(String[] args) {

        // instantiate necessary Objects
        Scanner input = new Scanner(System.in);

        // declare and initialise constants
        final String LINEBREAK = "-----------------------------------";
        final String SHOPOWNER = "Sam Rincon";

        // declare Arrays, initialise using 'shortcut method'
        String[] flavoursArray = {"Amaretto", "Strawberry", "Bacon", "Blueberry", "Blackberry", "Bubblegum", "Butterscotch", "Caramel", "Mint", "Cherry", "Chocolate", "Brittle"};
        String[] stylesArray = {"Twist", "Bark", "Crunch", "Explosion", "Chunk", "Swirl", "Ripple", "Cream"};
        String[] flavourStylesArray;

        // declare other variables
        int numFlavourStyles;
        int randomFlavour;
        int randomStyle;
        int i;


        // adds a wee welcome message to let user know what the program does
        System.out.println("This is " + SHOPOWNER + "'s Ice Cream Flavour Programme!");
        System.out.println("Let's create new flavour-styles!");
        System.out.println(LINEBREAK);
        System.out.println();

        // requests user inputs to initialise variables, and validates answer
        do {
            System.out.print("How many flavour-styles would you like to see? ");
            numFlavourStyles = input.nextInt();

            if ((numFlavourStyles > 20) || (numFlavourStyles < 1)) {
                System.out.println("Invalid input.  Number of flavour-styles must be between 1 and 20.");
                continue;
            }
        }
        while (numFlavourStyles > 20 || numFlavourStyles < 1);

        // assign the chosen number of flavour-styles to flavourStylesArray
        flavourStylesArray = new String[numFlavourStyles];

        // Randomise index number of flavour and style Arrays to create combinations
        // use for loop to assign result flavourStylesArray
        for (i = 0; i < flavourStylesArray.length; i++) {
            randomFlavour = (int)(Math.random() * flavoursArray.length);
            randomStyle = (int)(Math.random() * stylesArray.length);

            flavourStylesArray[i] = flavoursArray[randomFlavour] + " " + stylesArray[randomStyle];
        }

        System.out.println("Here are your " + numFlavourStyles + " new flavour-styles:");

        for (i = 0; i < flavourStylesArray.length; i++) {
            System.out.println((i + 1) + ". " + flavourStylesArray[i]);
        }

        // let user know that program has ended
        System.out.println("\nEnjoy your new flavour-styles!");
        System.out.println(LINEBREAK);

        // close the Scanner
        input.close();

    } // end of main
} // end of class
