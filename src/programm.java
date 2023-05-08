
public class programm {

    public static void main(String args[]) {
        player playerOne = new player("F", true);
        player playerTwo = new player("U");
        game g = new game(playerOne, playerTwo);
        g.initControls();
        g.getFrame().setVisible(true);
    }



}
