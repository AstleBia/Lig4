package interfaceGrafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
public class Menu implements ActionListener{
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton normalGame = new JButton();
    JButton turboGame = new JButton();
    public Menu(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,800);
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Lig 4");

        textfield.setBackground(Color.RED);
        textfield.setForeground(Color.BLACK);
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("ESCOLHA O MODO DE JOGO");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,900,100);

        button_panel.setLayout(new BoxLayout(button_panel,BoxLayout.PAGE_AXIS));
        button_panel.setBackground(Color.GRAY);

        button_panel.add(normalGame);
        normalGame.setFont(new Font("MV Boli",Font.BOLD,50));
        normalGame.setFocusable(false);
        normalGame.addActionListener(this);
        normalGame.setText("Lig 4 Normal");

        button_panel.add(turboGame);
        turboGame.setFont(new Font("MV Boli",Font.BOLD,50));
        turboGame.setFocusable(false);
        turboGame.addActionListener(this);
        turboGame.setText("Lig 4 Turbo");

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == normalGame){
            GuiTabuleiro iniciarNormal = new GuiTabuleiro();
            frame.setVisible(false);
        }
        else{
            GuiTabuleiroTurbo iniciarTurbo = new GuiTabuleiroTurbo();
            frame.setVisible(false);
        }
    }

}
