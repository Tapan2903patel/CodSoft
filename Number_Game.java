import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Number_Game
{

    public static int rndm()
    {
        Random rand = new Random();
        return rand.nextInt(    100)+1;
    }
    public static void main(String[] args)
    {
        Scanner Sc= new Scanner(System.in);
        Random rand = new Random();

        int round=1;
        int game_status=0;

        while(game_status!=1)
        {
            int c=0;
            int score=0;
            System.out.print("Enter the Limit the number of attempts : ");
            int att=Sc.nextInt();
            while (c!=att )
            {
                System.out.print("Guess the Number : ");
                int gus=Sc.nextInt();
                int rand_temp=rndm();
                if(gus==rand_temp)
                {
                    System.out.println("Correct (Generated no:"+rand_temp +" )");
                    score+=5;
                    //break;
                }
                else if (gus>rand_temp)
                {
                    System.out.println("Too High (Generated no:"+rand_temp + ")" );
                }
                else
                {
                    System.out.println("Too Low (Generated no:"+ rand_temp + ")" );
                }
                c+=1;
            }

            System.out.println("\n\nYour Score of Round "+round+" is :" + score );
            System.out.println("\nEnter \n\t1 for Play Again\n\t2 for Exit\n");
            game_status=Sc.nextInt();
//            System.out.println(game_status);
            if (game_status!= 1 && game_status!=2)
            {
                System.out.println("\nPlease Enter valid choise...");
            }
            if(game_status==2)
            {
                System.out.println("Thanks for Playing...");
                break;
            }
            round+=1;
        }

//        System.out.println("Correct");

    }
}
