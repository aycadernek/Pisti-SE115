public class Deck {
    private Card[] deck;

    public Deck(int length) { 
        if (length != 52) {
            deck = new Card[length];
            for (int i = 0; i < deck.length; i++) {
                deck[i] = new Card("", "");
            }
        } else {
            deck = new Card[52];
            String[] values = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
            String[] suits = {"♠", "♣", "♥", "♦"};
            int num = 0;
            for (int i = 0; i < 4; i++) {
                for (int a = 0; a < 13; a++) {
                    deck[num] = new Card(suits[i], values[a]);
                    num++;

                }
            }
        }
    }
	public void seeDeck() {  
        for (int i = 0; i < deck.length; i++) {
            deck[i].seecard();
        }
    }

    public int decklength() {
        return deck.length;
    }

    public Card cardindeck(int i) {
        return deck[i];
    }