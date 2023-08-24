package interfaceGrafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import exceptions.ValorInvalido;
import jogador.Jogador;
import tabuleiros.Tabuleiro;

public class GuiTabuleiro implements ActionListener{
    Tabuleiro tab = new Tabuleiro();
    Jogador jogador1 = new Jogador("jogador 1");
    Jogador jogador2 = new Jogador("jogador 2");
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel bottom_panel = new JPanel();
    JButton reset_button = new JButton();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] buttons = new JButton[6][7];
    private boolean vezJogadorUm = true;
    public void criarJogador(){
        jogador1.setId('1');
        jogador2.setId('2');
    }
    public GuiTabuleiro(){
        tab.zerarTabuleiro();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,800);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Lig 4 Normal");

        textfield.setBackground(Color.RED);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("LIG 4");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(6,7));
        button_panel.setBackground(Color.BLUE);

        bottom_panel.setLayout(new BorderLayout());
        bottom_panel.setBounds(0,740,800,60);
        bottom_panel.setBackground(Color.GREEN);

        reset_button.setText("reset");
        reset_button.setFont(new Font("MV Boli",Font.BOLD,20));
        reset_button.setFocusable(false);
        reset_button.addActionListener(this);
        reset_button.setForeground(Color.BLACK);
        reset_button.setPreferredSize(new Dimension(40,40));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j] = new JButton();
                button_panel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,120));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
            }
        }

        bottom_panel.add(reset_button);
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.add(bottom_panel,BorderLayout.SOUTH);

        criarJogador();
    }
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if(e.getSource()==buttons[i][j]){
                    if(vezJogadorUm){
                        try{
                            tab.jogada(j+1,jogador1);
                            atualizarTabuleiro();
                            if(tab.vitoria(jogador1)){
                                textfield.setText("Vitoria Jogador 1!");
                                pararJogo();
                            }
                            else if(tab.checarTabCheio()){
                                textfield.setText("Empate!");
                                pararJogo();
                            }
                            else{
                                trocarJogador();
                                textfield.setText("Jogador 2");
                            }
                        }
                        catch(ValorInvalido er){
                            JOptionPane.showMessageDialog(null,"Jogada Invalida");
                        }
                    }
                    else{
                        try{
                            tab.jogada(j+1,jogador2);
                            atualizarTabuleiro();
                            if(tab.vitoria(jogador2)){
                                textfield.setText("Vitoria Jogador 2!");
                                pararJogo();
                            }
                            else if(tab.checarTabCheio()){
                                textfield.setText("Empate!");
                                pararJogo();
                            }
                            else{
                                trocarJogador();
                                textfield.setText("Jogador 1");
                            }
                        }
                        catch(ValorInvalido er){
                            JOptionPane.showMessageDialog(null,"Jogada Invalida");
                        }
                    }
                }
                else if(e.getSource() == reset_button){
                    tab.zerarTabuleiro();
                    atualizarTabuleiro();
                    vezJogadorUm = true;
                    textfield.setText("Jogador 1");
                    //libera os botões
                    for (int k = 0; k < 6; k++) {
                        for (int l = 0; l < 7; l++) {
                            buttons[i][j].setEnabled(true);
                        }
                    }
                }
            }
        }

    }

    public void trocarJogador(){
        vezJogadorUm = !vezJogadorUm;
    }

    public void pararJogo(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }
    public void atualizarTabuleiro(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j].setText(Character.toString(tab.getPosicao(i,j)));
                if(Objects.equals(buttons[i][j].getText(), "1")) {
                    buttons[i][j].setForeground(Color.RED);
                }
                else if(Objects.equals(buttons[i][j].getText(), "2")){
                    buttons[i][j].setForeground(Color.BLUE);
                }
                else if(Objects.equals(buttons[i][j].getText(), "0")){
                    buttons[i][j].setText("");
                }
            }
        }
    }


}
