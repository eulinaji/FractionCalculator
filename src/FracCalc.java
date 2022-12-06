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

        String userInput;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a fraction equation (type 'quit' to exit): ");
            userInput = in.next();

            if (userInput == "quit") {
                break;
            }
            // System.out.print(produceAnswer(userInput));
        }

        String finalFraction = " ";

        String[] equationParts;
        equationParts = splitEquation(userInput);

        if (equationParts[0] == "+") {
            finalFraction = addFractions(equationParts[1], equationParts[2]);
        }
        else if (equationParts[0] == "-") {
            finalFraction = subtractFractions(equationParts[1], equationParts[2]);
        }
        else if (equationParts[0] == "*") {
            finalFraction = multiplyFractions(equationParts[1], equationParts[2]);
        }
        else if (equationParts[0] == "/") {
            finalFraction = divideFractions(equationParts[1], equationParts[2]);
        }

        System.out.print(finalFraction);
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
    */


    // TODO: Fill in the space below with any helper methods that you think you will need


    public static String[] splitEquation (String input) {
        Scanner in = new Scanner(input);
        in.useDelimiter(" ");

        String firstFrac = "";
        String secondFrac = "";
        String operator = "";
        if (in.hasNext()) {
            firstFrac = in.next();
            operator = in.next();
            secondFrac = in.next();
        }

        String[] result = {operator, firstFrac, secondFrac};
        return result;
    }



    public static String[] getFractionParts (String fraction) {
        String whole = "";
        String frac = "";
        String numerator = "";
        String denominator = "";

        Scanner in = new Scanner(fraction);
        in.useDelimiter("_");
        if (in.hasNext()) {
            if ( fraction.contains("_") ) {
                whole = in.next();
                frac = in.next();

                Scanner in1 = new Scanner(fraction);
                in1.useDelimiter("/");
                numerator = in1.next();
                denominator = in1.next();
            }
            else if ( fraction.contains("/") == false ) {
                whole = in.next();
                numerator = "0";
                denominator = "1";
            }
            else {
                whole = "0";
                frac = in.next();
                Scanner in1 = new Scanner(fraction);
                in1.useDelimiter("/");
                numerator = in1.next();
                denominator = in1.next();
            }
        }

        else {
            throw new InputMismatchException("No input");
        }

        String[] result = {whole, numerator, denominator};
        return result;
    }


    public static String simplifyFractions(int improperNumer, int improperDenom) {


        String simpleAnswer = "";
        return simpleAnswer;    // "4_5/8"
    }

    public static String addFractions(String frac1, String frac2) {
        String[] parts1 = getFractionParts(frac1);
        int w1 = Integer.parseInt(parts1[0]);
        int n1 = Integer.parseInt(parts1[1]);
        int d1 = Integer.parseInt(parts1[2]);

        String[] parts2 = getFractionParts(frac2);
        int w2 = Integer.parseInt(parts2[0]);
        int n2 = Integer.parseInt(parts2[1]);
        int d2 = Integer.parseInt(parts2[2]);


        int n = (w1 * d1 + n1) * d2 + (w2 * d2 + n2) * d1;
        int d = d1 * d2;

        String finalAnswer = simplifyFractions(n,d);

        return finalAnswer;
    }

    public static String subtractFractions(String frac1, String frac2) {

    }

    public static String multiplyFractions(String frac1, String frac2) {

    }

    public static String divideFractions(String frac1, String frac2) {

    }


}