import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;
import java.lang.*;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation

        String userInput;

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a fraction equation (type 'quit' to exit): ");
            userInput = in.next();

            if (userInput == "quit") {
                break;
            }
            System.out.print(produceAnswer(userInput));
        }

    }


        // TODO: Implement this function to produce the solution to the input

        /**
         * method that gets an equation, calls splitEquation(), determines which operator to use
         * @param input user's inputted equation
         * @return finalFraction final, simplified answer
         */
        public static String produceAnswer(String input) {
            String finalFraction = " ";

            String[] equationParts;
            equationParts = splitEquation(input);

            if (equationParts[0].equals("+")) {
                finalFraction = addFractions(equationParts[1], equationParts[2]);
            }
            else if (equationParts[0].equals("-")) {
                finalFraction = subtractFractions(equationParts[1], equationParts[2]);
            }
            else if (equationParts[0].equals("*")) {
                finalFraction = multiplyFractions(equationParts[1], equationParts[2]);
            }
            else if (equationParts[0].equals("/")) {
                finalFraction = divideFractions(equationParts[1], equationParts[2]);
            }

            System.out.print(finalFraction);
            return finalFraction;
        }


        // TODO: Fill in the space below with any helper methods that you think you will need

        /**
         * method that gets an equation, and splits it into parts
         * @param input user's inputted equation
         * @return result array with operator, first fraction, second fraction
         */
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


    /**
     * method that gets a fraction, and splits it into parts
     * @param fraction fraction from user's equation
     * @return result array with whole number, numerator, denominator
     */
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

                Scanner in1 = new Scanner(frac);
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


    /**
     * @return greatest common denominator
     */
    public static int GCD(int a, int b){
        if (b==0) return a;
        return GCD(b,a%b);
    }


    /**
     * method that reduces the fraction answer into simplified form
     * @param improperNumer numerator after calculations
     * @param improperDenom denominator after calculations
     * @return simpleAnswer simplified (mixed) answer
     */
    public static String simplifyFractions(int improperNumer, int improperDenom) {
        int n = improperNumer;
        int d = improperDenom;
        int w;

        w = n/d;
        n = n%d;

        if (w < 0) {
            n = -n;
        }

        int gcd = GCD(n,d);

        n = n / gcd;
        d = d / gcd;

        String simpleAnswer = "";

        if (w == 0) {
            if (n == 0) {
                simpleAnswer = "0";
            }
            else {
                simpleAnswer =  n + "/" + d;
            }
        }
        else if (n%d == 0) {
            simpleAnswer = "" + w;
        }
        else {
            simpleAnswer = w + "_" + n + "/" + d;
        }

        return simpleAnswer;
    }


    /**
     * method that takes two fractions and adds them together
     * @param frac1 first fraction of equation
     * @param frac2 second fraction of equation
     * @return finalAnswer unsimplified answer after addition
     */
    public static String addFractions(String frac1, String frac2) {
        String[] parts1 = getFractionParts(frac1);
        int w1 = Integer.parseInt(parts1[0]);
        int n1 = Integer.parseInt(parts1[1]);
        int d1 = Integer.parseInt(parts1[2]);

        String[] parts2 = getFractionParts(frac2);
        int w2 = Integer.parseInt(parts2[0]);
        int n2 = Integer.parseInt(parts2[1]);
        int d2 = Integer.parseInt(parts2[2]);

        // handles negative numbers
        if (w1 < 0) {
            n1 = -n1;
        }
        if (w2 < 0) {
            n2 = -n2;
        }

        int n = (w1 * d1 + n1) * d2 + (w2 * d2 + n2) * d1;
        int d = d1 * d2;

        String finalAnswer = simplifyFractions(n,d);

        return finalAnswer;
    }


    /**
     * method that takes two fractions and subtracts one from the other
     * @param frac1 first fraction of equation
     * @param frac2 second fraction of equation
     * @return finalAnswer unsimplified answer after subtraction
     */
    public static String subtractFractions(String frac1, String frac2) {
        String[] parts1 = getFractionParts(frac1);
        int w1 = Integer.parseInt(parts1[0]);
        int n1 = Integer.parseInt(parts1[1]);
        int d1 = Integer.parseInt(parts1[2]);

        String[] parts2 = getFractionParts(frac2);
        int w2 = Integer.parseInt(parts2[0]);
        int n2 = Integer.parseInt(parts2[1]);
        int d2 = Integer.parseInt(parts2[2]);

        if (w1 < 0) {
            n1 = -n1;
        }
        if (w2 < 0) {
            n2 = -n2;
        }

        int n = (w1 * d1 + n1) * d2 - (w2 * d2 + n2) * d1;
        int d = d1 * d2;

        String finalAnswer = simplifyFractions(n,d);

        return finalAnswer;
    }


    /**
     * method that takes two fractions and multiplies them together
     * @param frac1 first fraction of equation
     * @param frac2 second fraction of equation
     * @return finalAnswer unsimplified answer after multiplication
     */
    public static String multiplyFractions(String frac1, String frac2) {
        String[] parts1 = getFractionParts(frac1);
        int w1 = Integer.parseInt(parts1[0]);
        int n1 = Integer.parseInt(parts1[1]);
        int d1 = Integer.parseInt(parts1[2]);

        String[] parts2 = getFractionParts(frac2);
        int w2 = Integer.parseInt(parts2[0]);
        int n2 = Integer.parseInt(parts2[1]);
        int d2 = Integer.parseInt(parts2[2]);

        if (w1 < 0) {
            n1 = -n1;
        }
        if (w2 < 0) {
            n2 = -n2;
        }

        int n = (w1 * d1 + n1) * (w2 * d2 + n2);
        int d = d1 * d2;

        String finalAnswer = simplifyFractions(n,d);

        return finalAnswer;
    }


    /**
     * method that takes two fractions and divides one from the other
     * @param frac1 first fraction of equation
     * @param frac2 second fraction of equation
     * @return finalAnswer unsimplified answer after division
     */
    public static String divideFractions(String frac1, String frac2) {
        String[] parts1 = getFractionParts(frac1);
        int w1 = Integer.parseInt(parts1[0]);
        int n1 = Integer.parseInt(parts1[1]);
        int d1 = Integer.parseInt(parts1[2]);

        String[] parts2 = getFractionParts(frac2);
        int w2 = Integer.parseInt(parts2[0]);
        int n2 = Integer.parseInt(parts2[1]);
        int d2 = Integer.parseInt(parts2[2]);

        if (w1 < 0) {
            n1 = -n1;
        }
        if (w2 < 0) {
            n2 = -n2;
        }

        int n = (w1 * d1 + n1) * d2;
        int d = d1 * (w2 * d2 + n2);

        String finalAnswer = simplifyFractions(n,d);

        return finalAnswer;
    }


}