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
	public Deck delitem(int a) {
        Deck new_deck = new Deck(deck.length - 1);
        int delete = a;
        int index = 0;
        for (int i = 0; i < deck.length; i++) {
            if (i == delete) {
                continue;
            }
            new_deck.cardindeck(index).setValue(deck[i].getValue());
            new_deck.cardindeck(index).setSuit(deck[i].getSuit());
            index++;
        }
        return new_deck;
    }
	public Deck additem(String suit, String value) {
        Deck new_deck = new Deck(deck.length + 1);
        for (int i = 0; i < deck.length; i++) {
            new_deck.cardindeck(i).setValue(deck[i].getValue());
            new_deck.cardindeck(i).setSuit(deck[i].getSuit());
        }
        new_deck.cardindeck(deck.length).setValue(value);
        new_deck.cardindeck(deck.length).setSuit(suit);
        return new_deck;
    }
	
	public Deck shuffle() {
        Random r = new Random();
        Deck new_deck = new Deck(0);
        int num = 52;
        Deck ndeck = new Deck(52);
        for (int i = 0; i < 52; i++) {
            int a = r.nextInt(num);
            new_deck = new_deck.additem(ndeck.cardindeck(a).getSuit(), ndeck.cardindeck(a).getValue());
            ndeck = ndeck.delitem(a);
            num = num - 1;
        }
        return new_deck;
    }
	public Deck cutdeck(int a){
        Deck new_deck = new Deck(0);
        for (int i = a ; i <deck.length ; i++) {
            new_deck=new_deck.additem(deck[i].getSuit(), deck[i].getValue());
        }
        for (int i = 0 ; i<a ; i++) {
            new_deck=new_deck.additem(deck[i].getSuit(), deck[i].getValue());
        }
        return new_deck;

    }