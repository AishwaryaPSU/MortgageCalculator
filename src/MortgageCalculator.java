import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
*
* //M = monthly payment
        //P = Principal amount
        //i = Annual interest rate
        //n = number of years
        //formula to calculate the monthly mortgage payment is : P((i((1+i)^n))/(((1+i)^n))-1)
*
* */
public class MortgageCalculator {
    private static final Integer MONTHS_IN_A_YEAR = 12;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter the principal amount that you want to borrow:");
            int principal = sc.nextInt();

            System.out.println("Enter the annual interest rate :");
            float annualInterest = sc.nextFloat();

            System.out.println("Enter the term in years :");
            int termInYears = sc.nextInt();

            mortgageCalc(principal,annualInterest,termInYears);

        }catch(InputMismatchException ime){
            System.out.println("Please enter right input format!");
        }finally{
            System.out.println("In finally...");
            sc.close();
        }

    }

    private static void mortgageCalc(int principal, float annualInterest, int termInYears) {
        int termInMonths = termInYears* MONTHS_IN_A_YEAR;
        float monthlyInterestRate = annualInterest/ MONTHS_IN_A_YEAR;
        double monthlyMortgage = calculateMonthlyMortgage(principal,monthlyInterestRate,termInMonths);
        System.out.println("Monthly mortgage to be paid is : "
                + NumberFormat.getCurrencyInstance().format(monthlyMortgage));
        System.out.println("Total payback amount is : "
                + NumberFormat.getCurrencyInstance().format(monthlyMortgage*termInMonths));
    }

    private static double calculateMonthlyMortgage(int principal, float interest, int numOfMonths) {
        double mortgageCalNeumerator = (Math.pow((1+interest),numOfMonths))*interest;
        double mortgageCalDenominator = (Math.pow(1+interest,numOfMonths))-1;
        return (mortgageCalNeumerator/mortgageCalDenominator)*principal;
    }
}
