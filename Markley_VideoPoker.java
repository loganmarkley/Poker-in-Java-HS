import java.util.*;
import java.text.*;

public class Markley_VideoPoker
{
    static Scanner s = new Scanner(System.in);
    static Random r=new Random(); 

    static int money;
    static int bet;
    static int cardcount = 1;

    static String[] cards = new String[52];
    static int[] cardSuitValue = new int[5];
    static int[] cardFaceValue = new int[5];

    static boolean pair;
    static boolean twopair;
    static boolean threeofakind;
    static boolean straight;
    static boolean flush;
    static boolean fullhouse;
    static boolean fourofakind;
    static boolean straightflush;
    static boolean royalflush;

    public static void main (String args[])
    {
        //initializing all the cards 
        cards[0] = "2 of Spades"; //2s
        cards[1] = "2 of Clubs";
        cards[2] = "2 of Hearts";
        cards[3] = "2 of Diamonds";

        cards[4] = "3 of Spades"; //3s
        cards[5] = "3 of Clubs";
        cards[6] = "3 of Hearts";
        cards[7] = "3 of Diamonds";

        cards[8] = "4 of Spades"; //4s
        cards[9] = "4 of Clubs";
        cards[10] = "4 of Hearts";
        cards[11] = "4 of Diamonds";

        cards[12] = "5 of Spades"; //5s
        cards[13] = "5 of Clubs";
        cards[14] = "5 of Hearts";
        cards[15] = "5 of Diamonds";

        cards[16] = "6 of Spades"; //6s
        cards[17] = "6 of Clubs";
        cards[18] = "6 of Hearts";
        cards[19] = "6 of Diamonds";

        cards[20] = "7 of Spades"; //7s
        cards[21] = "7 of Clubs";
        cards[22] = "7 of Hearts";
        cards[23] = "7 of Diamonds";

        cards[24] = "8 of Spades"; //8s
        cards[25] = "8 of Clubs";
        cards[26] = "8 of Hearts";
        cards[27] = "8 of Diamonds";

        cards[28] = "9 of Spades"; //9s
        cards[29] = "9 of Clubs";
        cards[30] = "9 of Hearts";
        cards[31] = "9 of Diamonds";

        cards[32] = "10 of Spades"; //10s
        cards[33] = "10 of Clubs";
        cards[34] = "10 of Hearts";
        cards[35] = "10 of Diamonds";

        cards[36] = "Jack of Spades"; //Jacks
        cards[37] = "Jack of Clubs";
        cards[38] = "Jack of Hearts";
        cards[39] = "Jack of Diamonds";

        cards[40] = "Queen of Spades"; //Queens
        cards[41] = "Queen of Clubs";
        cards[42] = "Queen of Hearts";
        cards[43] = "Queen of Diamonds";

        cards[44] = "King of Spades"; //Kings
        cards[45] = "King of Clubs";
        cards[46] = "King of Hearts";
        cards[47] = "King of Diamonds";

        cards[48] = "Ace of Spades"; //Aces
        cards[49] = "Ace of Clubs";
        cards[50] = "Ace of Hearts";
        cards[51] = "Ace of Diamonds";

        //--------------------------------------------------------------

        System.out.println("Welcome to (Video Poker)!");
        money();
    } 

    public static void money () //asks user how much money they got
    {
        System.out.println("\n$$$$$\nHow much money do you have?\n$$$$$");
        try  {money = s.nextInt(); } 
        catch (Exception e)
        {
            System.out.println("Something went wrong.  Try Again");
            s.nextLine();
            money();
        }
        if (money <= 0)
        {
            System.out.println("You cannot play without any money!!!");
            money();
        }
        bet();
    }

    public static void bet () //asks user to bet
    {
        System.out.println("\n$$$$$\nHow much do you want to bet? (you cannot bet more than $5)\n$$$$$");
        try  {bet = s.nextInt(); } 
        catch (Exception e)
        {
            System.out.println("Something went wrong.  Try Again");
            s.nextLine();
            bet();
        }
        if (bet > 5 || bet < 1)
        {
            System.out.println("That bet amount is not accepted in this game!");
            bet();
        }
        if (bet > money)
        {
            System.out.println("You cannot bet more than you have!");
            bet();
        }
        shuffle();
    }

    public static void shuffle ()
    {
        Collections.shuffle(Arrays.asList(cards)); //shuffles the cards
        for (int x = 0; x<5; x++)
        {
            System.out.print(" "+ cards[x]+", ");
            try {
                Thread.sleep(750);                 //this is a .75 second delay
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
        cardkeep();
    }

    public static void cardkeep ()
    {
        while (cardcount < 6)
        {
            int answerforwithdraw = 0;
            System.out.println("Would you like to withdraw the card at position "+cardcount+"? (1 for yes)");
            try  {answerforwithdraw = s.nextInt(); } 
            catch (Exception e)
            {
                System.out.println("Something went wrong.  Try Again");
                s.nextLine();
                cardkeep();
            }
            if (answerforwithdraw == 1)
            {
                if (cardcount == 1)
                {
                    cards[0] = cards[5];
                }
                if (cardcount == 2)
                {
                    cards[1] = cards[6];
                }
                if (cardcount == 3)
                {
                    cards[2] = cards[7];
                }
                if (cardcount == 4)
                {
                    cards[3] = cards[8];
                }
                if (cardcount == 5)
                {
                    cards[4] = cards[9];
                }
            }
            cardcount++;
        }
        System.out.println("Your new cards: ");
        for (int x = 0; x<5; x++)
        {
            System.out.print(" "+ cards[x]+", ");
            try {
                Thread.sleep(500);                 //this is a .5 second delay
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        population();
    }

    public static void population ()
    {
        for (int x=0; x<5; x++) //card suit
        {
            if (cards[x].equals("2 of Spades") || cards[x].equals("3 of Spades") || cards[x].equals("4 of Spades") || cards[x].equals("5 of Spades") || cards[x].equals("6 of Spades") || cards[x].equals("7 of Spades") || cards[x].equals("8 of Spades") || cards[x].equals("9 of Spades") || cards[x].equals("10 of Spades") || cards[x].equals("Jack of Spades") || cards[x].equals("Queen of Spades") || cards[x].equals("King of Spades") || cards[x].equals("Ace of Spades") )
            {
                cardSuitValue[x] = 1;
            }
            if (cards[x].equals("2 of Clubs") || cards[x].equals("3 of Clubs") || cards[x].equals("4 of Clubs") || cards[x].equals("5 of Clubs") || cards[x].equals("6 of Clubs") || cards[x].equals("7 of Clubs") || cards[x].equals("8 of Clubs") || cards[x].equals("9 of Clubs") || cards[x].equals("10 of Clubs") || cards[x].equals("Jack of Clubs") || cards[x].equals("Queen of Clubs") || cards[x].equals("King of Clubs") || cards[x].equals("Ace of Clubs") )
            {
                cardSuitValue[x] = 2;
            }
            if (cards[x].equals("2 of Hearts") || cards[x].equals("3 of Hearts") || cards[x].equals("4 of Hearts") || cards[x].equals("5 of Hearts") || cards[x].equals("6 of Hearts") || cards[x].equals("7 of Hearts") || cards[x].equals("8 of Hearts") || cards[x].equals("9 of Hearts") || cards[x].equals("10 of Hearts") || cards[x].equals("Jack of Hearts") || cards[x].equals("Queen of Hearts") || cards[x].equals("King of Hearts") || cards[x].equals("Ace of Hearts") )
            {
                cardSuitValue[x] = 3;
            }
            if (cards[x].equals("2 of Diamonds") || cards[x].equals("3 of Diamonds") || cards[x].equals("4 of Diamonds") || cards[x].equals("5 of Diamonds") || cards[x].equals("6 of Diamonds") || cards[x].equals("7 of Diamonds") || cards[x].equals("8 of Diamonds") || cards[x].equals("9 of Diamonds") || cards[x].equals("10 of Diamonds") || cards[x].equals("Jack of Diamonds") || cards[x].equals("Queen of Diamonds") || cards[x].equals("King of Diamonds") || cards[x].equals("Ace of Diamonds") )
            {
                cardSuitValue[x] = 4;
            }
        }

        for (int x=0; x<5; x++) //card face
        {
            if (cards[x].equals("2 of Spades") || cards[x].equals("2 of Clubs") || cards[x].equals("2 of Hearts") || cards[x].equals("2 of Diamonds") )
            {
                cardFaceValue[x] = 2;
            }
            if (cards[x].equals("3 of Spades") || cards[x].equals("3 of Clubs") || cards[x].equals("3 of Hearts") || cards[x].equals("3 of Diamonds") )
            {
                cardFaceValue[x] = 3;
            }
            if (cards[x].equals("4 of Spades") || cards[x].equals("4 of Clubs") || cards[x].equals("4 of Hearts") || cards[x].equals("4 of Diamonds") )
            {
                cardFaceValue[x] = 4;
            }
            if (cards[x].equals("5 of Spades") || cards[x].equals("5 of Clubs") || cards[x].equals("5 of Hearts") || cards[x].equals("5 of Diamonds") )
            {
                cardFaceValue[x] = 5;
            }
            if (cards[x].equals("6 of Spades") || cards[x].equals("6 of Clubs") || cards[x].equals("6 of Hearts") || cards[x].equals("6 of Diamonds") )
            {
                cardFaceValue[x] = 6;
            }
            if (cards[x].equals("7 of Spades") || cards[x].equals("7 of Clubs") || cards[x].equals("7 of Hearts") || cards[x].equals("7 of Diamonds") )
            {
                cardFaceValue[x] = 7;
            }
            if (cards[x].equals("8 of Spades") || cards[x].equals("8 of Clubs") || cards[x].equals("8 of Hearts") || cards[x].equals("8 of Diamonds") )
            {
                cardFaceValue[x] = 8;
            }
            if (cards[x].equals("9 of Spades") || cards[x].equals("9 of Clubs") || cards[x].equals("9 of Hearts") || cards[x].equals("9 of Diamonds") )
            {
                cardFaceValue[x] = 9;
            }
            if (cards[x].equals("10 of Spades") || cards[x].equals("10 of Clubs") || cards[x].equals("10 of Hearts") || cards[x].equals("10 of Diamonds") )
            {
                cardFaceValue[x] = 10;
            }
            if (cards[x].equals("Jack of Spades") || cards[x].equals("Jack of Clubs") || cards[x].equals("Jack of Hearts") || cards[x].equals("Jack of Diamonds") )
            {
                cardFaceValue[x] = 11;
            }
            if (cards[x].equals("Queen of Spades") || cards[x].equals("Queen of Clubs") || cards[x].equals("Queen of Hearts") || cards[x].equals("Queen of Diamonds") )
            {
                cardFaceValue[x] = 12;
            }
            if (cards[x].equals("King of Spades") || cards[x].equals("King of Clubs") || cards[x].equals("King of Hearts") || cards[x].equals("King of Diamonds") )
            {
                cardFaceValue[x] = 13;
            }
            if (cards[x].equals("Ace of Spades") || cards[x].equals("Ace of Clubs") || cards[x].equals("Ace of Hearts") || cards[x].equals("Ace of Diamonds") )
            {
                cardFaceValue[x] = 14;
            }
        }
        Arrays.sort(cardSuitValue); //sorts both suit and face arrays
        Arrays.sort(cardFaceValue);
        checking();
    }

    public static void checking ()
    {
        //pair
        if ( cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[1] >= 11)
        {
            pair = true;
        }
        if ( cardFaceValue[1] == cardFaceValue[2] && cardFaceValue[2] >= 11)
        {
            pair = true;
        }
        if ( cardFaceValue[2] == cardFaceValue[3] && cardFaceValue[3] >= 11)
        {
            pair = true;
        }
        if ( cardFaceValue[3] == cardFaceValue[4] && cardFaceValue[4] >= 11)
        {
            pair = true;
        }

        //twopair
        if ( cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[2] == cardFaceValue[3])
        {
            twopair = true;
        }
        if ( cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[3] == cardFaceValue[4])
        {
            twopair = true;
        }
        if ( cardFaceValue[1] == cardFaceValue[2] && cardFaceValue[3] == cardFaceValue[4])
        {
            twopair = true;
        }

        //three of a kind
        if ( cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[1] == cardFaceValue[2])
        {
            threeofakind = true;
        }
        if ( cardFaceValue[1] == cardFaceValue[2] && cardFaceValue[2] == cardFaceValue[3])
        {
            threeofakind = true;
        }
        if ( cardFaceValue[2] == cardFaceValue[3] && cardFaceValue[3] == cardFaceValue[4])
        {
            threeofakind = true;
        }

        //straight
        int difference = cardFaceValue[4] - cardFaceValue [0];
        if ( (cardFaceValue[0] != cardFaceValue[1] && cardFaceValue[1] != cardFaceValue[2] && cardFaceValue[2] != cardFaceValue[3] && cardFaceValue[3] != cardFaceValue[4]) && difference == 4)
        {
            straight = true;
        }

        //flush
        if ( cardSuitValue[0] == cardSuitValue[4])
        {
            flush = true;
        }

        //full house
        if ( (cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[1] == cardFaceValue[2]) && (cardFaceValue[3] == cardFaceValue[4]) )
        {
            fullhouse = true;
        }
        if ( (cardFaceValue[2] == cardFaceValue[3] && cardFaceValue[3] == cardFaceValue[4]) && (cardFaceValue[0] == cardFaceValue[1]) )
        {
            fullhouse = true;
        }

        //four of a kind
        if ( cardFaceValue[0] == cardFaceValue[1] && cardFaceValue[1] == cardFaceValue[2] && cardFaceValue[2] == cardFaceValue[3] )
        {
            fourofakind = true;
        }
        if ( cardFaceValue[1] == cardFaceValue[2] && cardFaceValue[2] == cardFaceValue[3] && cardFaceValue[3] == cardFaceValue[4] )
        {
            fourofakind = true;
        }

        //straight flush
        if ( straight == true && flush == true )
        {
            straightflush = true;
        }

        //royal flush
        if ( straight == true && flush == true && cardFaceValue[4] == 14 )
        {
            royalflush = true;
        }

        winnings();
    }

    public static void winnings ()
    {
        System.out.println();
        System.out.println();
        if (bet != 5)
        {
            if (royalflush == true)
            {
                System.out.println("You got a royal flush!!!");
                System.out.println("You earned 250x your bet!!!");
                money = money + (bet * 250); 
                again();
            }
            if (straightflush == true)
            {
                System.out.println("You got a straight flush!!!");
                System.out.println("You earned 50x your bet!!!");
                money = money + (bet * 50); 
                again();
            }
            if (fourofakind == true)
            {
                System.out.println("You got four of a kind!!!");
                System.out.println("You earned 25x your bet!!!");
                money = money + (bet * 25); 
                again();
            }
            if (fullhouse == true)
            {
                System.out.println("You got a full house!!!");
                System.out.println("You earned 9x your bet!!!");
                money = money + (bet * 9); 
                again();
            }
            if (flush == true)
            {
                System.out.println("You got a flush!!!");
                System.out.println("You earned 6x your bet!!!");
                money = money + (bet * 6); 
                again();
            }
            if (straight == true)
            {
                System.out.println("You got a straight!!!");
                System.out.println("You earned 4x your bet!!!");
                money = money + (bet * 4); 
                again();
            }
            if (threeofakind == true)
            {
                System.out.println("You got threeofakind!!!");
                System.out.println("You earned 3x your bet!!!");
                money = money + (bet * 3); 
                again();
            }
            if (twopair == true)
            {
                System.out.println("You got two pairs!!!");
                System.out.println("You earned 2x your bet!!!");
                money = money + (bet * 2); 
                again();
            }
            if (pair == true)
            {
                System.out.println("You got a pair!!!");
                System.out.println("You earned your bet back!!!");
                again();
            }
            else
            {
                System.out.println("You lost your bet!!!");
                money = money - bet;
                again();
            }
        }

        if (bet == 5) //the royalflush payout changes if you bet 5
        {
            if (royalflush == true)
            {
                System.out.println("You got a royal flush!!!");
                System.out.println("You earned 800x your bet!!!");
                money = money + (bet * 800); 
                again();
            }
            if (straightflush == true)
            {
                System.out.println("You got a straight flush!!!");
                System.out.println("You earned 50x your bet!!!");
                money = money + (bet * 50); 
                again();
            }
            if (fourofakind == true)
            {
                System.out.println("You got four of a kind!!!");
                System.out.println("You earned 25x your bet!!!");
                money = money + (bet * 25); 
                again();
            }
            if (fullhouse == true)
            {
                System.out.println("You got a full house!!!");
                System.out.println("You earned 9x your bet!!!");
                money = money + (bet * 9); 
                again();
            }
            if (flush == true)
            {
                System.out.println("You got a flush!!!");
                System.out.println("You earned 6x your bet!!!");
                money = money + (bet * 6); 
                again();
            }
            if (straight == true)
            {
                System.out.println("You got a straight!!!");
                System.out.println("You earned 4x your bet!!!");
                money = money + (bet * 4); 
                again();
            }
            if (threeofakind == true)
            {
                System.out.println("You got three of a kind!!!");
                System.out.println("You earned 3x your bet!!!");
                money = money + (bet * 3); 
                again();
            }
            if (twopair == true)
            {
                System.out.println("You got two pairs!!!");
                System.out.println("You earned 2x your bet!!!");
                money = money + (bet * 2); 
                again();
            }
            if (pair == true)
            {
                System.out.println("You got a pair!!!");
                System.out.println("You earned your bet back!!!");
                again();
            }
            else
            {
                System.out.println("You lost your bet!!!");
                money = money - bet;
                again();
            }
        }
    }

    public static void again ()
    {
        int add = 0;
        System.out.println("You now have $"+money);
        if (money == 0)
        {
            System.out.println("You have run out of money!");
            System.out.println("Would you like to add more money? (1 for yes)");
            try  {add = s.nextInt(); } 
            catch (Exception e)
            {
                System.out.println("Something went wrong.  Try Again");
                s.nextLine();
                again();
            } 
            if (add == 1)
            {
                pair = false;
                twopair = false;
                threeofakind = false;
                straight = false;
                flush = false;
                fullhouse = false;
                fourofakind = false;
                straightflush = false;
                royalflush = false;

                cardcount = 1;

                main(null);
            }
            else
            {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
        int answerforagain = 0;
        System.out.println("Would you like to play again? (1 for yes)");
        try  {answerforagain = s.nextInt(); } 
        catch (Exception e)
        {
            System.out.println("Something went wrong.  Try Again");
            s.nextLine();
            again();
        }
        if (answerforagain == 1)
        {
            cards[0] = "2 of Spades"; //2s
            cards[1] = "2 of Clubs";
            cards[2] = "2 of Hearts";
            cards[3] = "2 of Diamonds";

            cards[4] = "3 of Spades"; //3s
            cards[5] = "3 of Clubs";
            cards[6] = "3 of Hearts";
            cards[7] = "3 of Diamonds";

            cards[8] = "4 of Spades"; //4s
            cards[9] = "4 of Clubs";
            cards[10] = "4 of Hearts";
            cards[11] = "4 of Diamonds";

            cards[12] = "5 of Spades"; //5s
            cards[13] = "5 of Clubs";
            cards[14] = "5 of Hearts";
            cards[15] = "5 of Diamonds";

            cards[16] = "6 of Spades"; //6s
            cards[17] = "6 of Clubs";
            cards[18] = "6 of Hearts";
            cards[19] = "6 of Diamonds";

            cards[20] = "7 of Spades"; //7s
            cards[21] = "7 of Clubs";
            cards[22] = "7 of Hearts";
            cards[23] = "7 of Diamonds";

            cards[24] = "8 of Spades"; //8s
            cards[25] = "8 of Clubs";
            cards[26] = "8 of Hearts";
            cards[27] = "8 of Diamonds";

            cards[28] = "9 of Spades"; //9s
            cards[29] = "9 of Clubs";
            cards[30] = "9 of Hearts";
            cards[31] = "9 of Diamonds";

            cards[32] = "10 of Spades"; //10s
            cards[33] = "10 of Clubs";
            cards[34] = "10 of Hearts";
            cards[35] = "10 of Diamonds";

            cards[36] = "Jack of Spades"; //Jacks
            cards[37] = "Jack of Clubs";
            cards[38] = "Jack of Hearts";
            cards[39] = "Jack of Diamonds";

            cards[40] = "Queen of Spades"; //Queens
            cards[41] = "Queen of Clubs";
            cards[42] = "Queen of Hearts";
            cards[43] = "Queen of Diamonds";

            cards[44] = "King of Spades"; //Kings
            cards[45] = "King of Clubs";
            cards[46] = "King of Hearts";
            cards[47] = "King of Diamonds";

            cards[48] = "Ace of Spades"; //Aces
            cards[49] = "Ace of Clubs";
            cards[50] = "Ace of Hearts";
            cards[51] = "Ace of Diamonds";

            pair = false;
            twopair = false;
            threeofakind = false;
            straight = false;
            flush = false;
            fullhouse = false;
            fourofakind = false;
            straightflush = false;
            royalflush = false;

            cardcount = 1;

            System.out.println("Welcome back to (Video Poker)!");
            bet();
        }
        else
        {
            System.exit(0);
        }
    }
}
