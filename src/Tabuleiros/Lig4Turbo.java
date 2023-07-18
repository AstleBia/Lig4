package tabuleiros;
import jogador.Jogador;

public class Lig4Turbo extends Tabuleiro {
    public void jogada(int coluna, Jogador jogador){
        char[][] tab = getTabuleiro();
        boolean movimentoValido = true;
        //checar se movimento é valido
        if((coluna <= 0) || (coluna > getColunas())){
            movimentoValido = false;
            System.out.println("essa coluna nao existe");
        }
        //procurar espaco livre na coluna
        if(movimentoValido) {
            for (int x = getLinhas() - 1; x >= 0; x--) {
                if (tab[x][coluna-1] == '0') {
                    setTabuleiro(x,coluna-1, jogador.getId());
                    if(coluna-1 == 0){
                        if(tab[x][coluna]!= '0' && tab[x][coluna]!= jogador.getId()){
                            setTabuleiro(x,coluna, jogador.getId());
                        }
                    }
                    else if((coluna-1)==getColunas()-1){
                        if(tab[x][coluna-2] != '0' && tab[x][coluna-2]!= jogador.getId()){
                            setTabuleiro(x,coluna-2, jogador.getId());
                        }
                    }
                    else{
                        if((tab[x][coluna-2] != '0' ) && (tab[x][coluna-2] != jogador.getId())){
                            setTabuleiro(x,coluna-2,jogador.getId());
                        }
                        if((tab[x][coluna] != '0') && (tab[x][coluna] != jogador.getId())){
                            setTabuleiro(x,coluna, jogador.getId());
                        }
                    }
                    break;
                }
            }
        }
    }
}
