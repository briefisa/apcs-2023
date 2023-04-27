import javax.swing.plaf.nimbus.NimbusLookAndFeel;

class Deck {

    private Card[] cards;
    private Card[] deck;

    public Deck() {
        cards = new Card[52];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[((i - 1)*13) + j - 1] = new Card(j, i);
                //System.out.println(cards[((i - 1)*13) + j - 1]);
            }
        }
        deck = new Card[52];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[((i - 1)*13) + j - 1] = new Card(j, i);
            }
        }
    }
    
    public void deal() {
        Card[] hand = new Card[6];
        for (int i = 0; i < 6; i++) {
            hand[i] = this.flipCard();
        }
        for (Card a : hand) {
            System.out.println(a);
        }
        //return hand;
    }

    public Card flipCard() {
        Card card = null;
        while (card == null) {
            int rand = (int)Math.random()*52;
            card = this.deck[rand];
            this.deck[rand] = null;
        }
        return card;
    } 

    public void reset() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[((i - 1)*13) + j - 1].setCard(j, i);
            }
        }
    }
}

class Card {

    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }
    
    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public String getNumName() {
        String cardName = "";
        if (num == 1) {
            cardName = "ace";
        } else if(num <= 10) {
            cardName = "" + num;
        } else if(num == 11) {
            cardName = "jack";
        } else if(num == 12) {
            cardName = "queen";
        } else if(num == 13) {
            cardName = "king";
        } else {
            cardName = "invalid";
        }
        return cardName;
    }

    public String getSuitName() {
        String suitName = "";
        if (suit == 1) {
            suitName = "spades";
        } else if(suit == 2) {
            suitName = "hearts";
        } else if(suit == 3) {
            suitName = "diamonds";
        } else if (suit == 4) {
            suitName = "clubs";
        } else {
            suitName = "invalid";
        }
        return suitName;
    }

    public void setCard(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public String toString() {
        return this.getNumName() + " of " + this.getSuitName();
    }
}

public class Cribbage {

    public static void main(String[] args) {
        Deck a = new Deck();
        a.deal();
    }
}