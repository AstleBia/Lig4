package jogo;
import exceptions.ValorInvalido;
import interfaceGrafica.GuiTabuleiro;
import jogador.Jogador;
import tabuleiros.InterfaceTabuleiro;
import tabuleiros.Tabuleiro;
import java.util.Scanner;
public class JogoNormal extends Jogo{
    public void iniciar(){
       InterfaceTabuleiro tab = new Tabuleiro();
       tab.zerarTabuleiro();
       tab.printarTabuleiro();
       while(getManterJogo()){
           boolean sucesso = true;
           int coluna;
           if(getVezJogadorUm()){
               System.out.println("Vez do jogador 1");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               //coluna = guitab.esperarJogada();
               //System.out.println(coluna);
               try{
                   tab.jogada(coluna, jogador1);
                   sucesso = true;
               }
               catch(ValorInvalido e){
                   System.err.println("Jogada nao pode ser feita: " + e.getMessage());
                   System.out.println("Tente novamente");
                   sucesso = false;
               }
               if(tab.vitoria(jogador1)){
                   setManterJogo(false);
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   setManterJogo(false);
               }
               if(sucesso){
                   trocarJogador();
               }
           }
           else{
               System.out.println("Vez do jogador 2");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               try {
                   tab.jogada(coluna, jogador2);
                   sucesso = true;
               }
               catch(ValorInvalido e){
                   System.err.println("Jogada nao pode ser feita: " + e.getMessage());
                   System.out.println("Tente novamente");
                   sucesso = false;
               }
               if(tab.vitoria(jogador2)){
                   setManterJogo(false);
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   setManterJogo(false);
               }
               if(sucesso){
                   trocarJogador();
               }
           }
           tab.printarTabuleiro();
       }
    }
}
