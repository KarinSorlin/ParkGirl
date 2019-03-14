public class Card {

    public int Balance;
    public Boolean Blocked;

    public String CardNr;
    public Card(String cardNr, int balance, Boolean blocked){
        CardNr = cardNr;
        Balance = balance;
        Blocked = blocked;
    }
    public Card(String cardNr, int balance){
        this(cardNr, balance, false);
    }

}
