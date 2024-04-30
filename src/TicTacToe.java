import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe implements ActionListener{


    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_Panel = new JPanel();
    JPanel button_Panel = new JPanel();
    JLabel text_Field = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        text_Field.setBackground(new Color(25,25,25));
        text_Field.setForeground(new Color(25,255,0));
        text_Field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_Field.setHorizontalAlignment(JLabel.CENTER);
        text_Field.setText("TicTacToe");
        text_Field.setOpaque(true);


        title_Panel.setLayout(new BorderLayout());
        title_Panel.setBounds(0,0,800,100);

        button_Panel.setLayout(new GridLayout(3,3));
        button_Panel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i]=new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }



        title_Panel.add(text_Field);
        frame.add(title_Panel,BorderLayout.NORTH);
        frame.add(button_Panel);


        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(250,0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        text_Field.setText("O Turn");
                        check();
                    }
                }else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        text_Field.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(random.nextInt(2)==0){
            player1_turn = true;
            text_Field.setText("X Turn ");
        }else{
            player1_turn = false;
            text_Field.setText("O Turn");
        }
    }

    public void check(){
        // check X wins conditions
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }


        // check O wins conditions
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    public void xWins(int a,int b, int c){
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i =0; i<9; i++){
            buttons[i].setEnabled(false);
            text_Field.setText("X Wins");
        }
    }
    public void oWins(int a,int b, int c) {
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
            text_Field.setText("Y Wins");
        }
    }
}
