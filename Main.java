import java.util.Random;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
		
        Random r = new Random();
        Scanner sc= new Scanner(System.in);
		
		System.out.println("Welcome to Pişti game.Please enter your name");
        String name= sc.nextLine();
		
        while (true) {
			int process;
			
            Swhile(true){
                System.out.print("\nHi "+name+". Please write 1 to start New Game ," +
                        " 2 for Leaderboard, 3 to see the Game Rules , 4 to Exit game.\n");
                process = sc.nextInt();
                if (process==1||process==2||process==3||process==4){
                    break;
                }
            }
			
            switch (process) {
                case 4:
				
                    System.out.print("exiting...");
                    System.exit(0);
                    break;
					
                case 3:
                    
                    break;
					
                case 2:
				
				    ScoreTable scoretable= new ScoreTable();
                    scoretable.readtable();
                    
                    break;
					
                case 1:
				
                    PC pc = new PC();
                    int user_score = 0;
                    int pc_score = 0;
                    Deck board = new Deck(0);
                    Deck user_deck = new Deck(0);// hand
                    Deck pc_deck = new Deck(0);//hand
                    Deck user_cards = new Deck(0);// earned cards
                    Deck pc_cards = new Deck(0);// earned cards
                    Deck deck = new Deck(52);
                    deck = deck.shuffle();
                    boolean flag=true;
                    boolean last=true;
                    int sign=1;// if it is one this means wehave deal card to the board.
					Deck released_cards= new Deck(0);
					

                    System.out.println("The game begins...");
                    System.out.println("who starts the game.( 1 for \"pc\" or 2 for \"user\")");
                    int starts = sc.nextInt();
					
                    if (starts == 2) {
                        System.out.println("Where to cut the deck.(Please write an intiger value.)");
                        int cut_index = sc.nextInt();
                        deck = deck.cutdeck(cut_index);
                        flag = true;
                    } else if (starts == 1) {
                        int cut_index = r.nextInt(52);
                        deck = deck.cutdeck(cut_index);
                        flag = false;
                    }

                    while (deck.decklength() != 0) {
                        System.out.println("\nCards are dealt.");
                        if (sign==1){
                            for (int a=0;a<4;a++){ // repeat the loop under this line 4 times
                                for (int i=1;i<4;i++){
                                    if(i==1){
                                        board=board.additem(deck.cardindeck(0).getSuit(),deck.cardindeck(0).getValue());
                                        deck=deck.delitem(0);
                                    }else if(i==2){
                                        user_deck=user_deck.additem(deck.cardindeck(0).getSuit(),deck.cardindeck(0).getValue());
                                        deck=deck.delitem(0);
                                    }else{
                                        pc_deck=pc_deck.additem(deck.cardindeck(0).getSuit(),deck.cardindeck(0).getValue());
                                        deck=deck.delitem(0);
                                    }
                                }
                            }
                            sign=sign+1;
                        }else{
                            for (int a=0;a<4;a++) { // repeat the loop under this line 4 times
                                for (int i=1;i<3;i++) {
                                    if(i==1){
                                        user_deck=user_deck.additem(deck.cardindeck(0).getSuit(),deck.cardindeck(0).getValue());
                                        deck=deck.delitem(0);
                                    }else{
                                        pc_deck=pc_deck.additem(deck.cardindeck(0).getSuit(),deck.cardindeck(0).getValue());
                                        deck=deck.delitem(0);
                                    }
                                }
                            }
                        }

                        System.out.println("Board:");
                        board.showboard();
                 
                        while (user_deck.decklength() != 0 || pc_deck.decklength() != 0) {
							
                            if (flag) {
								
                                System.out.println("\nYour turn");
                                System.out.println("My Cards:");
                                user_deck.seeDeck();
                                int boardl = board.decklength();
                                int card ;
                                
								while(true){
                                    System.out.println("\nWhich card would you like to discard?(1,2,3,4)");
                                    card = sc.nextInt();
                                    if ((card<=user_deck.decklength())&&(card==1||card==2||card==3||card==4)){
                                        card = card - 1;
                                        break;
                                    }
                                }

                                if (board.decklength() != 0) {
                                    if (user_deck.cardindeck(card).getValue().equals(board.cardindeck(board.decklength() - 1).getValue())) {
                                        if (board.decklength() == 1) {
                                            System.out.println("Pişti");
                                            user_score = user_score + 10;
											released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            released_cards=released_cards.additem(user_deck.cardindeck(card).getSuit(),user_deck.cardindeck(card).getValue());
                                            board = board.delitem(board.decklength() - 1);
                                            last = true;
                                        } else {
                                            System.out.println("You got the cards on the board.");
                                            for (int i = 0; i < boardl; i++) {
                                                user_cards = user_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
												released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                                board = board.delitem(0);
                                                last = true;
                                            }
											user_cards = user_cards.additem(user_deck.cardindeck(card).getSuit(), user_deck.cardindeck(card).getValue());
                                            released_cards=released_cards.additem(user_deck.cardindeck(card).getSuit(),user_deck.cardindeck(card).getValue());
                                        }
                                    } else if (user_deck.cardindeck(card).getValue().equals("J")) {
                                        System.out.println("You got the cards on the board.");
                                        for (int i = 0; i < boardl; i++) {
                                            user_cards = user_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
											released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            board = board.delitem(0);
                                            last = true;
                                        }
										user_cards = user_cards.additem(user_deck.cardindeck(card).getSuit(), user_deck.cardindeck(card).getValue());
                                        released_cards=released_cards.additem(user_deck.cardindeck(card).getSuit(),user_deck.cardindeck(card).getValue());

                                    } else {
                                        board = board.additem(user_deck.cardindeck(card).getSuit(), user_deck.cardindeck(card).getValue());
                                    }
                                } else {
                                    board = board.additem(user_deck.cardindeck(card).getSuit(), user_deck.cardindeck(card).getValue());
                                }
                                user_deck = user_deck.delitem(card);
                                System.out.println("Board:");
                                board.showboard();
                            
                                flag = false;
                            } else {
                                System.out.println("\nComputers turn");
                                System.out.println("The computer makes its move...");
                                int boardl = board.decklength();
                                int card;
                                if (board.decklength() == 0) {
                                    Card a = new Card("c", "c");
                                    card = pc.throwcard(pc_deck, a);
                                } else {
                                    card = pc.throwcard(pc_deck, board.cardindeck((board.decklength() - 1)));
                                }
                                System.out.println("The computer plays");
                                pc_deck.cardindeck(card).seecard();
                                if (board.decklength() != 0) {
                                    if (pc_deck.cardindeck(card).getValue().equals(board.cardindeck((board.decklength() - 1)).getValue())) {
                                        if (board.decklength() == 1) {
                                            System.out.println("\nComputer made Pişti");
                                            pc_score = pc_score + 10;
											released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            released_cards=released_cards.additem(pc_deck.cardindeck(card).getSuit(),pc_deck.cardindeck(card).getValue());
                                            board = board.delitem((board.decklength() - 1));
                                            last = false;
                                        } else {
                                            System.out.println("\nComputer got the cards on the board.");
                                            for (int i = 0; i < boardl; i++) {
                                                pc_cards = pc_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
												released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                                board = board.delitem(0);
                                                last = false;
                                            }
											released_cards=released_cards.additem(pc_deck.cardindeck(card).getSuit(),pc_deck.cardindeck(card).getValue());
                                            pc_cards = pc_cards.additem(pc_deck.cardindeck(card).getSuit(), pc_deck.cardindeck(card).getValue());
                                        }
                                    } else if (pc_deck.cardindeck(card).getValue().equals("J")) {
                                        System.out.println("\nComputer got the cards on the board.");
                                        for (int i = 0; i < boardl; i++) {
                                            pc_cards = pc_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
											released_cards=released_cards.additem(board.cardindeck(0).getSuit(),board.cardindeck(0).getValue());
                                            board = board.delitem(0);
                                            last = false;
                                        }
										released_cards=released_cards.additem(pc_deck.cardindeck(card).getSuit(),pc_deck.cardindeck(card).getValue());
                                        pc_cards = pc_cards.additem(pc_deck.cardindeck(card).getSuit(), pc_deck.cardindeck(card).getValue());

                                    } else {
                                        board = board.additem(pc_deck.cardindeck(card).getSuit(), pc_deck.cardindeck(card).getValue());
                                    }
									
                                } else {
                                    board = board.additem(pc_deck.cardindeck(card).getSuit(), pc_deck.cardindeck(card).getValue());
                                }
                                pc_deck = pc_deck.delitem(card);
                                System.out.println("\nBoard:");
                                board.showboard();

                                flag = true;
                            }

                        }


                    }
                    System.out.println("\nGame finished");

                    if (last==true) {
                        while (board.decklength() != 0) {
                            user_cards = user_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
                            board=board.delitem(0);

                        }
                    } else if (last==false) {
                        while (board.decklength() != 0) {
                            pc_cards = pc_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
                            board=board.delitem(0);

                        }
                    }


                    if (user_cards.decklength() > pc_cards.decklength()) {
                        user_score = user_score + 3;
                    } else if (pc_cards.decklength() > user_cards.decklength()) {
                        pc_score = pc_score + 3;
                    }
					
                    for (int i = 0; i < user_cards.decklength(); i++) {
                        if (user_cards.cardindeck(i).getValue().equals("10") && user_cards.cardindeck(i).getSuit().equals("♦")) {
                            user_score = user_score + 3;
                        } else if (user_cards.cardindeck(i).getValue().equals("2") && user_cards.cardindeck(i).getSuit().equals("♣")) {
                            user_score = user_score + 2;
                        } else {
                            user_score = user_score + 1;
                        }
                    }

                    for (int i = 0; i < pc_cards.decklength(); i++) {
                        if (pc_cards.cardindeck(i).getValue().equals("10") && pc_cards.cardindeck(i).getSuit().equals("♦")) {
                            pc_score = pc_score + 3;
                        } else if (pc_cards.cardindeck(i).getValue().equals("2") && pc_cards.cardindeck(i).getSuit().equals("♣")) {
                            pc_score = pc_score + 2;
                        } else {
                            pc_score = pc_score + 1;
                        }
                    }

                    if (user_score > pc_score) {
                        System.out.println("you win");                       
                    } else if (user_score < pc_score) {
                        System.out.println("pc win");                        
                    } else {
                        System.out.println("draw");                        
                    }
					System.out.println("your score is" + user_score);
                    System.out.println("pc's score is" + pc_score);
					
					scoretable= new ScoreTable();
                    Score user = new Score(name,user_score);
                    scoretable.updatetable(user).write();
                    scoretable.readtable();

                    break;

            }
        }

    }


}