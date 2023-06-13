public class programm {

    public static void main(String args[]) {
        player playerOne = new player("Player");
        player playerTwo = new player("AI", true);
        game g = new game(playerOne, playerTwo);
        g.initControls();
        g.getFrame().setVisible(true);
    }
}
