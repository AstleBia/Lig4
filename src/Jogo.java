import java.util.Scanner;
public class Jogo {
    private boolean manterJogo = true;
    private boolean vezJogadorUm = true;
    private char char1,char2;
    Scanner input = new Scanner(System.in);
    Jogador jogador1 = new Jogador("jogador 1");
    Jogador jogador2 = new Jogador("jogador 2");
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
    public void iniciar(){
       Tabuleiro tab = new Tabuleiro();
       tab.printarTabuleiro();
       while(manterJogo){
           int coluna;
           if(vezJogadorUm){
               System.out.println("Vez do jogador 1");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               tab.jogada(coluna, jogador1);
               if(tab.vitoria(jogador1)){
                   manterJogo=false;
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   manterJogo = false;
               }
           }
           else{
               System.out.println("Vez do jogador 2");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               tab.jogada(coluna,jogador2);
               if(tab.vitoria(jogador2)){
                   manterJogo = false;
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   manterJogo = false;
               }
           }
           tab.printarTabuleiro();
           trocarJogador();
       }
    }
}
