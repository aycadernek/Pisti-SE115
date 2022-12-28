import java.util.Random;
public class PC {
   public int throwcard(Deck board,Deck pc_deck, Deck released_cards) {
      int index=-1;
      int[] repeat = new int[pc_deck.decklength()];
      if (board.decklength()==0) {
          if (pc_deck.decklength() == 1) {
              return 0;
          } else {
              for (int i = 0; i < pc_deck.decklength(); i++) {
                  if (pc_deck.cardindeck(i).getValue().equals("J")) {
                      repeat[i] = 0;
                  } else {
                      for (int a = 0; a < released_cards.decklength(); a++) {
                          if (released_cards.cardindeck(a).getValue().equals(pc_deck.cardindeck(i).getValue())) {
                              repeat[i] = repeat[i] + 1;
                          }
                      }
                  }
              }
          }
          int repeated = -1;
          for (int i = 0; i < repeat.length; i++) {
              if (repeat[i] > repeated) {
                  repeated=repeat[i];
                  index = i;
              }
          }
          return index;
      }else{
          if (pc_deck.decklength()==1){
              return 0;
          }
          Card topcard= new Card(board.cardindeck((board.decklength()-1)).getSuit(),board.cardindeck((board.decklength()-1)).getValue());
          board=board.delitem((board.decklength()-1));
          int boardlength= board.decklength();
          for (int i=0;i<boardlength;i++) {
              released_cards = released_cards.additem(board.cardindeck(0).getSuit(), board.cardindeck(0).getValue());
              board = board.delitem(0);
          }
          for (int i = 0; i < pc_deck.decklength(); i++) {
              if (pc_deck.cardindeck(i).getValue().equals(topcard.getValue())){
                  index=i;
                  return i;
              }
              else if (pc_deck.cardindeck(i).getValue().equals("J")) {
                  repeat[i] = 0;
              } else {
                  for (int a = 0; a < released_cards.decklength(); a++) {
                      if (released_cards.cardindeck(a).getValue().equals(pc_deck.cardindeck(i).getValue())) {
                          repeat[i] = repeat[i] + 1;
                      }
                  }
              }
          }
          int repeated = -1;
          for (int i = 0; i < repeat.length; i++) {
              if (repeat[i] > repeated) {
                  repeated=repeat[i];
                  index = i;
              }
          }
          return index;
      }
  }
}


