import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Hi. Welcome to the Pişti. Please write 1 to start new game ," +
                " 2 for leaderboard, 3 to see the game rules , 4 to exit game.\n");
        int process= sc.nextInt();
        switch(process){
            case 4:
                System.out.print("exiting...");
                System.exit(0);
                break;
            case 3:
                //Codes related to game rules will be added here
                break;
            case 2:
                // scoreboard codes will be added here
                break;
            case 1:

        }

    }

}