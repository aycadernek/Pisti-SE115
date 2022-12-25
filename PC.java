import java.util.Random;
public class PC {
    public int throwcard(Deck cardlist, Card topcard){
        Random r= new Random();
        for (int i=0;i<cardlist.decklength();i++){
            if(cardlist.cardindeck(i).getValue().equals(topcard.getValue())){
                return i;
            }
        }
        for (int i=0;i<cardlist.decklength();i++){
            if( cardlist.cardindeck(i).getValue().equals("J")){
                return i;
            }
        }
        int index=r.nextInt(cardlist.decklength());
        return index;

    }
}
