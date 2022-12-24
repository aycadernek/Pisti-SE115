public class Card {
    private String suit ;
    private String  value ;
    public Card(String s, String v){
        suit=s;
        value=v;
    }
    public void setSuit(String s){  suit=s;}
    public void setValue(String v){ value=v;}
    public String getSuit(){ return suit;}
    public String getValue(){ return value;}
    public void seecard(){System.out.print( getSuit()+getValue());}
}
