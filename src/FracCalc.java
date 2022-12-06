import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;
import java.lang.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation

        // CHECKPOINT 1
        /*
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a fraction equation: ");
        String userInput = in.next();
        System.out.print(produceAnswer(userInput));
        */


        // CHECKPOINT 2
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a fraction equation (type 'quit' to exit): ");
            String userInput = in.next();

            if (userInput == "quit") {
                break;
            }

            System.out.print(produceAnswer(userInput));
        }

    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"


    // CHECKPOINT 1
    /*
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input

        Scanner in = new Scanner(input);
        in.useDelimiter(" ");

        String secondFrac = "error";
        if (in.hasNext()) {
            String firstFrac = in.next();
            String operator = in.next();
            secondFrac = in.next();
        }
        return secondFrac;
    }
     */


    // CHECKPOINT 2
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        Scanner in = new Scanner(input);
        in.useDelimiter(" ");

        String secondFrac = "error";
        if (in.hasNext()) {
            String firstFrac = in.next();
            String operator = in.next();
            secondFrac = in.next();
        }
        System.out.print(secondFrac);

        String whole = "";
        String fraction = "";
        String numerator = "";
        String denominator = "";

        Scanner in2 = new Scanner(secondFrac);
        in2.useDelimiter("_");
        if (in2.hasNext()) {
            if ( secondFrac.contains("_") ) {
                whole = in2.next();
                fraction = in2.next();

                Scanner in3 = new Scanner(fraction);
                in3.useDelimiter("/");
                numerator = in3.next();
                denominator = in3.next();
            }
            else if ( secondFrac.contains("/") == false ) {
                whole = in2.next();
                numerator = "0";
                denominator = "1";
            }
            else {
                whole = "0";
                fraction = in2.next();
                Scanner in3 = new Scanner(fraction);
                in3.useDelimiter("/");
                numerator = in3.next();
                denominator = in3.next();
            }
        }

        else {
            throw new InputMismatchException("No input");
        }


        String result = "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;

        return result;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
}