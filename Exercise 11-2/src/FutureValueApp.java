import java.util.*;
import java.text.*;

public class FutureValueApp {

    public static class console {

        private static Scanner sc = new Scanner(System.in);

        public static String getString(String prompt) {
            System.out.print(prompt);
            String s = sc.next();
            sc.nextLine();
            return s;
        }

        public static int getInt(String prompt) {
            int i = 0;
            boolean isValid = false;
            while (!isValid) {
                System.out.print(prompt);
                if (sc.hasNextInt()) {
                    i = sc.nextInt();
                    isValid = true;
                } else {
                    System.out.println("Error! Invalid integer. Try again.");
                }
                sc.nextLine();
            }
            return i;
        }

        public static int getInt(String prompt, int min, int max) {
            int i = 0;
            boolean isValid = false;
            while (!isValid) {
                i = getInt(prompt);
                if (i <= min) {
                    System.out.println(
                            "Error! Number must be greater than " + min + ".");
                } else if (i >= max) {
                    System.out.println(
                            "Error! Number must be less than " + max + ".");
                } else {
                    isValid = true;
                }
            }
            return i;
        }

        public static double getDouble(String prompt) {
            double d = 0;
            boolean isValid = false;
            while (!isValid) {
                System.out.print(prompt);
                if (sc.hasNextDouble()) {
                    d = sc.nextDouble();
                    isValid = true;
                } else {
                    System.out.println("Error! Invalid number. Try again.");
                }
                sc.nextLine();
            }
            return d;
        }

        public static double getDouble(String prompt, double min, double max) {
            double d = 0;
            boolean isValid = false;
            while (!isValid) {
                d = getDouble(prompt);
                if (d <= min) {
                    System.out.println(
                            "Error! Number must be greater than " + min + ".");
                } else if (d >= max) {
                    System.out.println(
                            "Error! Number must be less than " + max + ".");
                } else {
                    isValid = true;
                }
            }
            return d;
        }
    }

    public static void main(String[] args) {
        int row = 0;
        String calculations[][] = new String[10][4];

        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        // perform 1 or more calculations
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = console.getDouble(
                    "Enter monthly investment: ", 0, 1000);
            double interestRate = console.getDouble(
                    "Enter yearly interest rate: ", 0, 30);
            int years = console.getInt(
                    "Enter number of years: ", 0, 100);

            //future value
            double monthlyInterestRate = interestRate / 12 / 100;
            int months = years * 12;
            double futureValue = calculateFutureValue(
                    monthlyInvestment, monthlyInterestRate, months);

            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // format the result as a single string
            String results
                    = "Monthly investment:\t"
                    + currency.format(monthlyInvestment) + "\n"
                    + "Yearly interest rate:\t"
                    + percent.format(interestRate / 100) + "\n"
                    + "Number of years:\t"
                    + years + "\n"
                    + "Future value:\t\t"
                    + currency.format(futureValue) + "\n";

            // print the results
            System.out.println();
            System.out.println("FORMATTED RESULTS");
            System.out.println(results);

            calculations[row][0] = currency.format(monthlyInvestment);
            calculations[row][1] = percent.format(interestRate / 100);
            calculations[row][2] = Integer.toString(years);
            calculations[row][3] = currency.format(futureValue);

            row++;

            // see if the user wants to continue
            choice = console.getString("Continue? (y/n): ");
            System.out.println();
        }

        // print the results
        System.out.println();
        System.out.println("Future Value Calculations");
        System.out.println();
        System.out.println("Inv/Mo.\tRate\tYears\tFuture Value");
        for (int i = 0; i < row; i++) {
            String message = "";
            for (int j = 0; j < 4; j++) {
                message += calculations[i][j] + "\t";
            }
            System.out.println(message);
        }
        System.out.println();
    }

    public static double calculateFutureValue(double monthlyInvestment,
                                              double monthlyInterestRate, int months) {
        double futureValue = 0;
        for (int i = 1; i <= months; i++) {
            futureValue
                    = (futureValue + monthlyInvestment)
                    * (1 + monthlyInterestRate);
        }
        return futureValue;
    }
}