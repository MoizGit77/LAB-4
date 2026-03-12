
public class Player {

    String name;
    int score;
    Card currentCard;

    Player(String name) {
        this.name = name;
        score = 0;
    }

    public void drawCard(Deck deck) {
        currentCard = deck.drawCard();
    }

    public Card getCard() {
        return currentCard;
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Player: ").append(name)
          .append(" | Score: ").append(score);

        return sb.toString();
    }
}
