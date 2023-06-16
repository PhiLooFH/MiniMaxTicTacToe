import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;

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
    private JButton buttons[][] = new JButton[3][3];
    private int field[][] = new int[3][3];
    private player playerList[] = new player[2];
    private player currentPlayer;
    private int turnCounter = 0;

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

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        // Calculate the position to center the frame
        int frameWidth = this.frame.getSize().width;
        int frameHeight = this.frame.getSize().height;
        int posX = (screenWidth - frameWidth) / 2;
        int posY = (screenHeight - frameHeight) / 2;

        // Set the frame position
        this.frame.setLocation(posX, posY);
        this.layout = new GridLayout(3,3);
        this.frame.setLayout(layout);
        this.playerList[0] = playerOne;
        this.playerList[1] = playerTwo;
    }

    public void initControls() {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        this.currentPlayer = this.playerList[0];
        playerList[0].setMarker('1');
        playerList[1].setMarker('2');

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

        this.buttons[0][0] = this.one;
        this.buttons[0][1] = this.two;
        this.buttons[0][2] = this.three;
        this.buttons[1][0] = this.four;
        this.buttons[1][1] = this.five;
        this.buttons[1][2] = this.six;
        this.buttons[2][0] = this.seven;
        this.buttons[2][1] = this.eight;
        this.buttons[2][2] = this.nine;

        opponentMove();
    }

    private boolean proofWinCondition(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (field[0][j] == symbol && field[1][j] == symbol && field[2][j] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol) {
            return true;
        }

        if (field[2][0] == symbol && field[1][1] == symbol && field[0][2] == symbol) {
            return true;
        }

        return false;

    }

    private boolean isMovesLeft()
    {
        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if (field[i][j]== 0)
                    return true;
        return false;
    }
    
    private player getOtherPlayer(player comparePlayer) {
        return Arrays.stream(playerList).filter(player -> !player.equals(comparePlayer)).findFirst().get();
    }



    public void actionPerformed(ActionEvent e) {
        int row = -1;
        int col = -1;
        Object source = e.getSource();

        if (source == this.one) {
            this.one.setText(this.currentPlayer.getCharacter());
            this.one.setEnabled(false);
            row = 0;
            col =0;
        } else if (source == this.two) {
            this.two.setText(this.currentPlayer.getCharacter());
            this.two.setEnabled(false);
            row = 0;
            col = 1;
        } else if (source == this.three) {
            this.three.setText(this.currentPlayer.getCharacter());
            this.three.setEnabled(false);
            row = 0;
            col = 2;
        } else if (source == this.four) {
            this.four.setText(this.currentPlayer.getCharacter());
            this.four.setEnabled(false);
            row = 1;
            col = 0;
        } else if (source == this.five) {
            this.five.setText(this.currentPlayer.getCharacter());
            this.five.setEnabled(false);
            row = 1;
            col = 1;
        } else if (source == this.six) {
            this.six.setText(this.currentPlayer.getCharacter());
            this.six.setEnabled(false);
            row = 1;
            col = 2;
        } else if (source == this.seven) {
            this.seven.setText(this.currentPlayer.getCharacter());
            this.seven.setEnabled(false);
            row = 2;
            col = 0;
        } else if (source == this.eight) {
            this.eight.setText(this.currentPlayer.getCharacter());
            this.eight.setEnabled(false);
            row = 2;
            col = 1;
        } else if (source == this.nine) {
            this.nine.setText(this.currentPlayer.getCharacter());
            this.nine.setEnabled(false);
            row = 2;
            col = 2;
        }

        //Write PlayerSymbol into choosen field
        this.field[row][col] = currentPlayer.getMarker();

        changePlayer();

        turnCounter++;

        //From round 5 on a Win is possible so check if someone won
        if(this.turnCounter >= 5) {
            if(this.proofWinCondition(getOtherPlayer(this.currentPlayer).getMarker())) {
                JOptionPane.showMessageDialog(this.frame, "'"+
                       this.getOtherPlayer(this.currentPlayer).getCharacter()+"'"+" wins!");
                this.resetBoard();
            }
            if(this.turnCounter == 9 && !this.proofWinCondition(getOtherPlayer(this.currentPlayer).getMarker())) {
                JOptionPane.showMessageDialog(this.frame, "Draw!");
                this.resetBoard();
            }
        }

        //change currentPlayer to the player in playerList that is currently not currentPlayer

        opponentMove();
    }

    private void opponentMove() {
        if(this.currentPlayer.isAi()) {
            //currentPlayer.getBestPossibleMove(this.field);
            move bestMove = new move();
            if(this.turnCounter > 0) {
                bestMove = this.findBestMove();
            } else {
                bestMove = this.getRandomMove();
            }

            ActionEvent event = new ActionEvent(this.buttons[bestMove.getRow()][bestMove.getCol()], ActionEvent.ACTION_PERFORMED, "Click");
            for (ActionListener listener : this.buttons[bestMove.getRow()][bestMove.getCol()].getActionListeners()) {
                listener.actionPerformed(event);
            }
        }
    }

    private move getRandomMove() {
        move randomMove = new move();
        Random random = new Random();
        randomMove.setRow(random.nextInt(3));
        randomMove.setCol(random.nextInt(3));
        System.out.println(randomMove.getRow());
        System.out.println(randomMove.getCol());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[randomMove.getRow()][randomMove.getCol()] == 0) {
                    return randomMove;
                } else {
                    randomMove.setRow(random.nextInt(3));
                    randomMove.setCol(random.nextInt(3));
                }
            }
        }
        return randomMove;
    }

    private void changePlayer() {
        this.currentPlayer = this.getOtherPlayer(this.currentPlayer);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText(" ");
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = 0;
            }
        }
        this.turnCounter = 0;
        this.currentPlayer = this.playerList[0];
    }

    private move findBestMove() {
        int bestVal = -1000;
        move bestMove = new move();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(this.field[i][j] == 0) {
                    this.field[i][j] = currentPlayer.getMarker();
                    int moveVal = miniMax(0, false);
                    this.field[i][j] = 0;

                    if(moveVal > bestVal) {
                        bestMove.setRow(i);
                        bestMove.setCol(j);
                        bestVal = moveVal;
                    }
                }
            }

        }
        return bestMove;
    }

    private int miniMax(int depth, boolean isMax) {
        
        int score = this.evaluatePosition(currentPlayer);

        //subtract growing depth to get shorter path when moves have the same rating
        if(score == 10) return score-depth;

        if(score == -10) return score-depth;

        if(score == 0) return score-depth;
        int best;
        if(isMax) {
            best = -1000;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(this.field[i][j] == 0) {
                        this.field[i][j] = currentPlayer.getMarker();
                        best = Math.max(best, miniMax(depth+1, false));
                        this.field[i][j] = 0;
                    }
                }

            }
        } else {
            best = 1000;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(this.field[i][j] == 0) {
                        this.field[i][j] = this.getOtherPlayer(currentPlayer).getMarker();
                        best = Math.min(best, miniMax(depth+1, true));
                        this.field[i][j] = 0;
                    }
                }

            }
        }
        return best;
    }

    private int evaluatePosition(player maximizingPlayer){

        if(proofWinCondition(maximizingPlayer.getMarker())) {
            return 10;
        } else if(proofWinCondition(getOtherPlayer(maximizingPlayer).getMarker())) {
            return -10;
        } else if (!isMovesLeft()) {
            return 0;
        }
        return 5;
    }
}
