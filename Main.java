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
                PC pc=new PC();
                int user_score=0;
                int pc_score=0;
                Deck board = new Deck(0);
                Deck user_deck= new Deck(0);// hand
                Deck pc_deck= new Deck(0);//hand
                Deck user_cards= new Deck(0);// earned cards
                Deck pc_cards= new Deck(0);// earned cards
                Deck deck= new Deck(52);
                deck=deck.shuffle();
                boolean flag=true;
                System.out.println("who starts the game.( 1 for \"pc\" or 2 for \"user\")");
                int starts= sc.nextInt();

                if (starts==2){
                    System.out.println("Where to cut the deck.(Please write an intiger value.");
                    int cut_index= sc.nextInt();
                    deck=deck.cutdeck(cut_index);
                    flag=true;
                }else if (starts==1) {
                    int cut_index= r.nextInt(52);
                    deck=deck.cutdeck(cut_index);
                    flag=false;
                }

                board=deck.dealcard();
                for (int i=0;i<4;i++){   // first 4 cards deleted because they had been sended to the board.
                    deck=deck.delitem(0);
                }
                System.out.println("\nBoard:");
                board.cardindeck(3).seecard();

                while (deck.decklength()!=0){

                    pc_deck=deck.dealcard();
                    for (int i=0;i<4;i++){
                        deck=deck.delitem(0);
                    }
                    user_deck=deck.dealcard();
                    for (int i=0;i<4;i++){
                        deck=deck.delitem(0);
                    }
                    System.out.println("\nMy Cards:");
                    user_deck.seeDeck();


                    while (user_deck.decklength()!=0 || pc_deck.decklength()!=0){
                        if (flag){
                            int boardl= board.decklength();
                            System.out.println("\nWhich card would you like to discard?(0,1,2,3)");
                            int card= sc.nextInt();

                            if (board.decklength()!=0){
                                if(user_deck.cardindeck(card).getValue().equals(board.cardindeck(board.decklength()-1).getValue())){
                                    if(board.decklength()==1){
                                        System.out.println("\nPişti");
                                        user_score=user_score+10;
                                        board=board.delitem(board.decklength()-1);
                                    }else{
                                        System.out.println("\nYou got the cards on the board.");
                                        for (int i=0;i<boardl;i++){
                                            user_cards=user_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            board=board.delitem(0);
                                        }
                                    }
                                }else if(user_deck.cardindeck(card).getValue().equals("J")){
                                    System.out.println("\nYou got the cards on the board.");
                                    for (int i=0;i<boardl;i++){
                                        user_cards=user_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                        board=board.delitem(0);
                                    }

                                }else{
                                    board=board.additem(user_deck.cardindeck(card).getSuit(),user_deck.cardindeck(card).getValue());
                                }
                            }else{
                                board=board.additem(user_deck.cardindeck(card).getSuit(),user_deck.cardindeck(card).getValue());
                            }
                            user_deck=user_deck.delitem(card);
                            System.out.println("\nBoard:");
                            board.seeDeck();
                            System.out.println("\nMy Cards:");
                            user_deck.seeDeck();
                            flag=false;
                        }
                        else{
                            int boardl= board.decklength();
                            int card;
                            if (board.decklength()==0){
                                Card a = new Card("c","c");
                                card= pc.throwcard(pc_deck,a);
                            }else{
                                card= pc.throwcard(pc_deck,board.cardindeck((board.decklength()-1)));
                            }
                            if (board.decklength()!=0){
                                if(pc_deck.cardindeck(card).getValue().equals(board.cardindeck((board.decklength()-1)).getValue())){
                                    if(board.decklength()==1){
                                        System.out.println("\nComputer made Pişti");
                                        pc_score=pc_score+10;
                                        board=board.delitem((board.decklength()-1));
                                    }else{
                                        System.out.println("\ncomputer got the cards on the board.");
                                        for (int i=0;i<boardl;i++){
                                            pc_cards=pc_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            board=board.delitem(0);
                                        }
                                    }
                                }else if(pc_deck.cardindeck(card).getValue().equals("J")){
                                    System.out.println("\nComputer got the cards on the board.");
                                    for (int i=0;i<boardl;i++){
                                        pc_cards=pc_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                        board=board.delitem(0);
                                    }

                                }else{
                                    board=board.additem(pc_deck.cardindeck(card).getSuit(),pc_deck.cardindeck(card).getValue());
                                }
                            }else{
                                board=board.additem(pc_deck.cardindeck(card).getSuit(),pc_deck.cardindeck(card).getValue());
                            }
                            pc_deck=pc_deck.delitem(card);
                            System.out.println("\nBoard:");
                            board.seeDeck();
                            flag=true;
                        }

                    }


                }
                System.out.println("\nGame finished");
                if (user_cards.decklength()>pc_cards.decklength()){
                    user_score=user_score+3;
                }else if(pc_cards.decklength()>user_cards.decklength()){
                    pc_score=pc_score+3;
                }

                if (user_score>pc_score){
                    System.out.println("you win");
                    System.out.println("your score is"+ user_score);
                    System.out.println("pc's score is"+ pc_score);
                }else if (user_score<pc_score){
                    System.out.println("pc win");
                    System.out.println("your score is"+ user_score);
                    System.out.println("pc's score is"+ pc_score);
                }else{
                    System.out.println("draw");
                    System.out.println("your score is"+ user_score);
                    System.out.println("pc's score is"+ pc_score);
                }
                break;

        }

    }

}