import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class game implements ActionListener {

    private JFrame frame;
    private GridLayout layout;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton buttons[] = new JButton[9];
    private int turnCounter = 0;
    private int field[] = new int[9];
    private player playerList[] = new player[2];
    private player currentPlayer;

    public JFrame getFrame() {
        return this.frame;
    }

    public game(player playerOne, player playerTwo) {
        if(playerOne.getCharacter().equals(playerTwo.getCharacter())){
            throw new InvalidParameterException("The players cannot have the same character");
        }
        this.frame = new JFrame("Tic Tac Toe");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(600, 600);
        this.layout = new GridLayout(3,3);
        this.frame.setLayout(layout);
        this.playerList[0] = playerOne;
        this.playerList[1] = playerTwo;
    }

    public void initControls() {

        this.currentPlayer = this.playerList[0];
        playerList[0].setMarker(1);
        playerList[1].setMarker(2);

        this.one = new JButton(" ");
        this.one.addActionListener(this);
        this.one.setFocusPainted(false);
        this.frame.getContentPane().add(this.one);

        this.two = new JButton(" ");
        this.two.addActionListener(this);
        this.two.setFocusPainted(false);
        this.frame.getContentPane().add(this.two);

        this.three = new JButton(" ");
        this.three.addActionListener(this);
        this.three.setFocusPainted(false);
        this.frame.getContentPane().add(this.three);

        this.four = new JButton(" ");
        this.four.addActionListener(this);
        this.four.setFocusPainted(false);
        this.frame.getContentPane().add(this.four);

        this.five = new JButton(" ");
        this.five.addActionListener(this);
        this.five.setFocusPainted(false);
        this.frame.getContentPane().add(this.five);

        this.six = new JButton(" ");
        this.six.addActionListener(this);
        this.six.setFocusPainted(false);
        this.frame.getContentPane().add(this.six);

        this.seven = new JButton(" ");
        this.seven.addActionListener(this);
        this.seven.setFocusPainted(false);
        this.frame.getContentPane().add(this.seven);

        this.eight = new JButton(" ");
        this.eight.addActionListener(this);
        this.eight.setFocusPainted(false);
        this.frame.getContentPane().add(this.eight);

        this.nine = new JButton(" ");
        this.nine.addActionListener(this);
        this.nine.setFocusPainted(false);
        this.frame.getContentPane().add(this.nine);

        this.buttons[0] = this.one;
        this.buttons[1] = this.two;
        this.buttons[2] = this.three;
        this.buttons[3] = this.four;
        this.buttons[4] = this.five;
        this.buttons[5] = this.six;
        this.buttons[6] = this.seven;
        this.buttons[7] = this.eight;
        this.buttons[8] = this.nine;

        if(this.currentPlayer.isAi()) {
            //currentPlayer.getBestPossibleMove(this.field);
            System.out.println(this.findBestMove());
            ActionEvent event = new ActionEvent(this.buttons[this.findBestMove()], ActionEvent.ACTION_PERFORMED, "Click");
            for (ActionListener listener : this.buttons[this.findBestMove()].getActionListeners()) {
                listener.actionPerformed(event);
            }
        }
    }

    private boolean proofWinCondition() {
        boolean result =
                (this.field[0] > 0 && this.field[0] == this.field[1] && this.field[1] == this.field[2]) ||
                (this.field[0] > 0 && this.field[0] == this.field[3] && this.field[3] == this.field[6]) ||
                (this.field[4] > 0 && this.field[4] == this.field[1] && this.field[4] == this.field[7]) ||
                (this.field[4] > 0 && this.field[4] == this.field[3] && this.field[4] == this.field[5]) ||
                (this.field[4] > 0 && this.field[4] == this.field[0] && this.field[4] == this.field[8]) ||
                (this.field[4] > 0 && this.field[4] == this.field[6] && this.field[4] == this.field[2]) ||
                (this.field[8] > 0 && this.field[8] == this.field[5] && this.field[5] == this.field[2]) ||
                (this.field[8] > 0 && this.field[8] == this.field[7] && this.field[7] == this.field[6]);
        //oben links - mitte - unten rechts
        return result;
    }
    
    private player getOtherPlayer(player comparePlayer) {
        return Arrays.stream(playerList).filter(player -> !player.equals(comparePlayer)).findFirst().get();
    }

    private player checkWinningPlayerOrNull() {
        player returnPlayer = new player("_");
        if(proofWinCondition()) {
            returnPlayer = this.getOtherPlayer(this.currentPlayer);
        }

        return returnPlayer;
    }

    public void actionPerformed(ActionEvent e) {
        int i = 0;
        if(e.getSource() == this.one){
            this.one.setText(this.currentPlayer.getCharacter());
            this.one.setEnabled(false);
        } else if(e.getSource() == this.two){
            this.two.setText(this.currentPlayer.getCharacter());
            this.two.setEnabled(false);
            i = 1;
        } else if(e.getSource() == this.three) {
            this.three.setText(this.currentPlayer.getCharacter());
            this.three.setEnabled(false);
            i = 2;
        } else if(e.getSource() == this.four) {
            this.four.setText(this.currentPlayer.getCharacter());
            this.four.setEnabled(false);
            i = 3;
        } else if(e.getSource() == this.five) {
            this.five.setText(this.currentPlayer.getCharacter());
            this.five.setEnabled(false);
            i = 4;
        } else if(e.getSource() == this.six) {
            this.six.setText(this.currentPlayer.getCharacter());
            this.six.setEnabled(false);
            i = 5;
        } else if(e.getSource() == this.seven) {
            this.seven.setText(this.currentPlayer.getCharacter());
            this.seven.setEnabled(false);
            i = 6;
        } else if(e.getSource() == this.eight) {
            this.eight.setText(this.currentPlayer.getCharacter());
            this.eight.setEnabled(false);
            i = 7;
        } else if(e.getSource() == this.nine) {
            this.nine.setText(this.currentPlayer.getCharacter());
            this.nine.setEnabled(false);
            i = 8;
        }

        //Write PlayerSymbol into choosen field
        this.field[i] = currentPlayer.getMarker();

        //change currentPlayer to the player in playerList that is currently not currentPlayer
        this.currentPlayer = this.getOtherPlayer(this.currentPlayer);

        turnCounter++;

        //From round 5 on a Win is possible so check if someone won
        if(this.turnCounter >= 5) {
            if(this.proofWinCondition()) {
                JOptionPane.showMessageDialog(this.frame, "'"+
                       this.getOtherPlayer(this.currentPlayer).getCharacter()+"'"+" wins!");
                this.resetBoard();
            }
            if(this.turnCounter == 9 && !this.proofWinCondition()) {
                JOptionPane.showMessageDialog(this.frame, "Draw!");
                this.resetBoard();
            }
        }
        if(this.currentPlayer.isAi()) {
            //currentPlayer.getBestPossibleMove(this.field);
            System.out.println(this.findBestMove());
            ActionEvent event = new ActionEvent(this.buttons[this.findBestMove()], ActionEvent.ACTION_PERFORMED, "Click");
            for (ActionListener listener : this.buttons[this.findBestMove()].getActionListeners()) {
                listener.actionPerformed(event);
            }
        }
    }
    private void resetBoard() {
        for(int j = 0; j < this.buttons.length; j++) {
            this.buttons[j].setEnabled(true);
            this.buttons[j].setText(" ");
            this.field[j] = 0;
        }
        this.turnCounter = 0;
        this.currentPlayer = this.playerList[0];
    }

    private int evaluatePosition(player maximizingPlayer){
        player minimzingPlayer = this.getOtherPlayer(maximizingPlayer);

        if(this.checkWinningPlayerOrNull().equals(maximizingPlayer)) {
            return 10;
        } else if(this.checkWinningPlayerOrNull().equals(minimzingPlayer)) {
            return -10;
        } else if (this.turnCounter == 9 && !this.proofWinCondition()) {
            return 0;
        }
        return 5;
    }

    private int miniMax(int depth, boolean isMax, player maximizingPlayer) {
        
        int score = this.evaluatePosition(maximizingPlayer);

        if(score == 10) return score;

        if(score == -10) return score;

        if(score == 0) return score;

        if(isMax) {
            int best = -1000;
            for(int i = 0; i < 9; i++) {
                if(this.field[i] == 0) {
                    this.field[i] = maximizingPlayer.getMarker();
                    best = Math.max(best, miniMax(depth+1, !isMax, maximizingPlayer));
                    this.field[i] = 0;
                }
            }
            return best;
        } else {
            int best = 1000;
            for(int i = 0; i < 9; i++) {
                if(this.field[i] == 0) {
                    this.field[i] = this.getOtherPlayer(maximizingPlayer).getMarker();
                    best = Math.min(best, miniMax(depth+1, !isMax, maximizingPlayer));
                    this.field[i] = 0;
                }
            }
            return best;
        }
    }

    private int findBestMove() {
        int bestVal = -1000;
        int bestMove = 0;

        for(int i = 0; i < 9; i++) {
            if(this.field[i] == 0) {
                this.field[i] = this.currentPlayer.getMarker();
                int moveVal = miniMax(0, false, currentPlayer);
                this.field[i] = 0;

                if(moveVal > bestVal) {
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }
}
