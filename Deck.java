


import java.util.Random;

public class Deck {

    Card[] cards;
    int top = 0;

    Deck() {

        cards = new Card[52];
        int counter = 0;

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards[counter++] = new Card(suit, rank);
            }
        }
    }

    public void shuffle() {

        Random random = new Random();

        for (int i = 0; i < cards.length; i++) {

            int j = random.nextInt(cards.length);

            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public Card drawCard() {

        if (top < cards.length) {
            return cards[top++];
        }

        return null;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Card c : cards) {
            sb.append(c).append("\n");
        }

        return sb.toString();
    }
}
enum Suit {
    Spades, Hearts, Diamonds, Clubs
}
enum Rank {

    Ace(1), Two(2), Three(3), Four(4), Five(5),
    Six(6), Seven(7), Eight(8), Nine(9), Ten(10),
    Jack(11), Queen(12), King(13);

    int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
