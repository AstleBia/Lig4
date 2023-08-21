package jogo;
import jogador.Jogador;
import tabuleiros.Tabuleiro;
import java.util.Scanner;
abstract class Jogo {
    private boolean manterJogo = true;
    private boolean vezJogadorUm = true;
    private char char1,char2;
    Scanner input = new Scanner(System.in);
    Jogador jogador1 = new Jogador("jogador 1");
    Jogador jogador2 = new Jogador("jogador 2");
    public boolean getManterJogo(){
        return manterJogo;
    }
    public void setManterJogo(boolean manterJogo){
        this.manterJogo = manterJogo;
    }
    public boolean getVezJogadorUm(){
        return vezJogadorUm;
    }
    public void criarJogadores(){
        System.out.println("digite o simbolo do jogador 1: ");
        char1 = input.next().charAt(0);
        System.out.println("digite o simbolo do jogador 2: ");
        char2 = input.next().charAt(0);
        jogador1.setId(char1);
        jogador2.setId(char2);
    }
    public void trocarJogador(){
        vezJogadorUm = !vezJogadorUm;
    }
    public abstract void iniciar();
}
