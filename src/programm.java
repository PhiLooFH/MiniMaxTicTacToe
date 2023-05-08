
public class programm {

    public static void main(String args[]) {
        player playerOne = new player("X", true);
        player playerTwo = new player("O");
        game g = new game(playerOne, playerTwo);
        g.initControls();
        g.getFrame().setVisible(true);
    }



}
