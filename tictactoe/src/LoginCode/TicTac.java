package LoginCode;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

abstract class TicTacToeGame {
    protected Component frame;
    protected JFrame frmTictactoe;
    protected JTextField XCount;
    protected JTextField OCount;
    protected int XCount1 = 0;
    protected int OCount1 = 0;
    protected String startGame = "X";
    protected int[] board = new int[9];
    protected int i = 0;

    protected abstract void winningGame();
    protected abstract void choosePlayer();
}

class TicTac extends TicTacToeGame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TicTac window = new TicTac();
                    window.frmTictactoe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TicTac() {
        initialize();
    }

    protected void winningGame() {
        // For player X
        if (board[0] == 1 && board[1] == 1 && board[2] == 1) {
            JOptionPane.showMessageDialog(frame, "Player X wins", " Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            XCount1++;
            XCount.setText(String.valueOf(XCount1));
        }
        // Remaining winning conditions omitted for brevity...

    }

    protected void choosePlayer() {
        if (startGame.equalsIgnoreCase("X")) {
            startGame = "O";
        } else {
            startGame = "X";
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmTictactoe = new JFrame();
        frmTictactoe.setResizable(false);
        frmTictactoe.setTitle("TicTacToe");
        frmTictactoe.setBounds(100, 100, 600, 400);
        frmTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmTictactoe.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        frmTictactoe.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 5, 2, 2));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        final JButton btn1 = new JButton("");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                btn1.setText(startGame);
                if (startGame.equalsIgnoreCase("X")) {
                    btn1.setForeground(Color.RED);
                    board[0] = 1;
                    i++;
                } else {
                    btn1.setForeground(Color.BLUE);
                    board[0] = 0;
                    i++;
                }
                choosePlayer();
                winningGame();
            }
        });
        btn1.setFont(new Font("Tahoma", Font.BOLD, 60));
        panel_1.add(btn1, BorderLayout.CENTER);

        // Remaining buttons and panels omitted for brevity...
    }
}
