

public class Game {

    Deck deck;
    Player[] players;
    int rounds;

    Game(String[] names, int rounds) {

        deck = new Deck();
        deck.shuffle();

        players = new Player[names.length];

        for (int i = 0; i < names.length; i++) {
            players[i] = new Player(names[i]);
        }

        this.rounds = rounds;
    }

    public void playGame() {

        for (int r = 1; r <= rounds; r++) {

            System.out.println("Round " + r);

            int highest = -1;

            for (Player p : players) {

                p.drawCard(deck);

                System.out.println(p.name + " drew " + p.getCard());

                if (p.getCard().getValue() > highest) {
                    highest = p.getCard().getValue();
                }
            }

            for (Player p : players) {

                if (p.getCard().getValue() == highest) {
                    p.addPoint();
                }
            }

            System.out.println();
        }

        showWinner();
    }

    public void showWinner() {

        Player winner = players[0];

        for (Player p : players) {

            if (p.getScore() > winner.getScore()) {
                winner = p;
            }
        }

        System.out.println("Final Scores:");

        for (Player p : players) {
            System.out.println(p);
        }

        System.out.println("Winner is: " + winner.name);
    }
}
