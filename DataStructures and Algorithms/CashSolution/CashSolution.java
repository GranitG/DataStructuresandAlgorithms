package Project;

import java.util.Arrays;
import java.util.Scanner;
/*
    Granit Gashi

 */
public class CashSolution
{
    private static boolean contains=false;



    /*
    The Search function is used for only one part of the code and that is when the user inserts their bills,
        this allows us to check if there is a duplicate value in the Bills ARRAY, so we cannot have the same bill in one array.
     */
    private static void search(int[] numbers, int key)
    {
        for (int number : numbers) {
            if (number == key) {
                contains = true;
            }
        }

    }


    /*
    Solution check is called instantly after entering the bills and the total amount of money, what it does is, it checks if the total mod of the first bill is not equal to zero
        and if its not equal to zero then that means there is no solution and it will return -1 && there is no need to run other code.
        But if the total mod first bill is equal to zero then there is a  solution and continues to run the code.
     */
    private static boolean solutionCheck(int[] bills, int total) // Checks if solution is possible
    {
        boolean solutionCheck = false;

        for (int i=0; i<bills.length;i++)
        {
            if (bills[i]!=0)
            {
                if (total%bills[i]!=0)
                {
                    solutionCheck = false;
                    i=bills.length-1;
                }
                else
                {
                    solutionCheck = true;
                    i=bills.length-1;
                }
            }

        }
        return solutionCheck;
    }


    /*
    This is the bread and butter of the program, it allows us to do the main function. So if the solution is true it will run this code and what it does is
        it stores the value of the money for every certain bill EX: So for the total money of $25 and the bills array contains {1,5,10} $1-$4 it will store $1 bills in each value from 1-4
        once it gets to 5 dollars to 9 dollars it will store $5 bills
     */

    private static void getSolution(int[] bills, int[] money, int total) //Main function
    {

        int[] n = new int[total + 1];

        for (int i = 1; i < n.length; i++)
        {
            int min = Integer.MAX_VALUE;

            for (int j = bills.length - 1; j >= 0; j--)
            {
                if (bills[j] <= i)
                {
                    if (min >= 1 + n[i - bills[j]])
                    {
                        min = 1 + n[i - bills[j]];
                        money[i] = bills[j];
                    }
                }

                n[i] = min;
            }
        }
    }

    /*
    Once the getSolution method is done the program will run this function and all it does is get the total amount of money and it will subtract the last bill inserted in the money array from the previous function.

        So for example: total money of $25 and the bills array contains {1,5,10} the bills entered in the money array should be {0,1,1,1,1,5,5,5,5,5,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10}
        So the length is about 25 so the last value store is $10
        so we get the total $25 -$10=$15 and it prints out the first $10bill
        then the new total is $15 so it goes to array index of 15 and it grabs the next bill and subtracts it from the total
        $15-$10=5$ prints out the current used bill witch is $10
        and $5-$5=0 and it uses the last $5 bill and prints it

        and done the solution would be {5,10,10}
     */

    private static String printSolution(int[] money, int total)
    {

        int[] temparray = new int[total + 2];
        temparray[0] = money[total];
        //counters.
        int count = 1;
        int count1=0;
        int count5=0;
        int count10=0;
        int count20=0;
        int count50=0;
        int count100=0;



        while (total > 0)
        {
            total = total - money[total];
            temparray[count] = money[total];
            count++;
        }

        System.out.print("\nThese are all the bills you will need and the solution is: ");

        for (int aTemparray : temparray) {
            if (aTemparray == 0) {
                break;
            }

            System.out.print("\t" + aTemparray);
            if (aTemparray == 1) {
                count1++;
            } else if (aTemparray == 5) {
                count5++;
            } else if (aTemparray == 10) {
                count10++;
            } else if (aTemparray == 20) {
                count20++;
            } else if (aTemparray == 50) {
                count50++;
            } else if (aTemparray == 100) {
                count100++;
            }
        }


        return "\nThe number of $1 bills is: "+count1 +"\nThe number of $5 bills is: "+count5+
                "\nThe number of $10 bills is: "+count10+ "\nThe number of $20 bills is: "+count20+
                "\nThe number of $50 bills is: "+count50+"\nThe number of $100 bills is: "+count100;


    }


    /*
    This is the main function it just makes all the values we need and arrays. It asks the user to enter their bills and their total amount of money and it jumps to different part
        of the program based on if there is a solution or not.
     */
    public static void main(String[] args)
    {

        /*This function allows the user to enter the different bills they have either $1, $5, $10, $20, $50, or $100
            if the user enters a duplicate value it will notify them and ask for another value
            if the user enters a value other than the listed ones then they will be asked to reenter a value or end inputing.
        */

        Scanner scan = new Scanner(System.in);
        int temp = 0;
        int sc;
        int total;
        int[] bills = new int[6];


        do
        {
            System.out.print("Please enter the different kind of bills you have: ");
            sc = scan.nextInt();
            if (sc == 1 || sc == 5 || sc == 10 || sc == 20 || sc == 50 || sc == 100)
            {
                search(bills,sc);
                if (!contains)
                {
                    bills[temp]=sc;
                }
                else
                {
                    System.out.println("You have entered a duplicate value!");
                    temp--;
                }

                contains=false;
            }
            else
            {
                System.out.println("Only accepts $1, $5, $10, $20, $50, $100 enter another bill: ");
                temp--;
            }
            temp++;
            if (temp == 6)
            {
                System.out.print("You entered enough bills!");
                break;
            }
            System.out.print("Would you like to enter another bill? yes or no: ");
        }
        while (scan.next().equalsIgnoreCase("yes") && temp < 6);

        Arrays.sort(bills);
        System.out.print("\nPlease enter the total amount of money you are being charged: ");
        total = scan.nextInt();
        int[] money = new int[total + 1];

        if(solutionCheck(bills, total))
        {
            getSolution(bills, money, total);
            System.out.print(printSolution(money,total));
        }
        else
        {
            System.out.println("There is no solution sorry: -1");
        }

    }
}

