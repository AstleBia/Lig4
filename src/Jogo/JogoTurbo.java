package jogo;
import tabuleiros.Lig4Turbo;


public class JogoTurbo extends Jogo {
    public void iniciar(){
        Lig4Turbo tab = new Lig4Turbo();
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
