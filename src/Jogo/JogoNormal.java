package jogo;
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
           int coluna;
           if(getVezJogadorUm()){
               System.out.println("Vez do jogador 1");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               tab.jogada(coluna, jogador1);
               if(tab.vitoria(jogador1)){
                   setManterJogo(false);
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   setManterJogo(false);
               }
           }
           else{
               System.out.println("Vez do jogador 2");
               System.out.println("digite a coluna da sua jogada: ");
               coluna = input.nextInt();
               tab.jogada(coluna,jogador2);
               if(tab.vitoria(jogador2)){
                   setManterJogo(false);
               }
               if(tab.checarTabCheio()){
                   System.out.println("empate");
                   setManterJogo(false);
               }
           }
           tab.printarTabuleiro();
           trocarJogador();
       }
    }
}
