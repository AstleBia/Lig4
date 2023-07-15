public class Tabuleiro {
    private int linhas = 6;
    private int colunas = 7;
    private char[][] tabuleiro = new char[linhas][colunas];
    public Tabuleiro(){
        for(int x = 0; x<linhas; x++){
            for(int y = 0; y<colunas;y++){
                tabuleiro[x][y] = '0';
            }
        }
    }

    public void printarTabuleiro(){
        for(int x = 0; x<linhas;x++){
            for(int y = 0; y<colunas;y++){
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    public void jogada(int coluna, Jogador jogador){
        boolean movimentoValido = true;
        //checar se movimento é valido
        if((coluna <= 0) || (coluna > colunas)){
            movimentoValido = false;
            System.out.println("essa coluna nao existe");
        }
        //procurar espaco livre na coluna
        if(movimentoValido) {
            for (int x = linhas - 1; x >= 0; x--) {
                if (tabuleiro[x][coluna-1] == '0') {
                    tabuleiro[x][coluna-1] = jogador.getId();
                    break;
                }
            }
        }
    }

    public boolean vitoria(Jogador jogador){
        //checar horizontal
        for(int x = 0; x<linhas;x++){
            for(int y = 0; y<colunas-3;y++){
                if((tabuleiro[x][y] == jogador.getId()) && (tabuleiro[x][y+1] == jogador.getId()) && (tabuleiro[x][y+2] == jogador.getId()) && (tabuleiro[x][y+3] == jogador.getId())){
                    System.out.println("vitoria do " + jogador.getNome());
                    return true;

                }
            }
        }
        //checar vertical
        for(int x = 0;x<linhas-3;x++){
            for(int y=0;y<colunas;y++){
                if((tabuleiro[x][y] == jogador.getId()) && (tabuleiro[x+1][y] == jogador.getId()) && (tabuleiro[x+2][y] == jogador.getId()) && (tabuleiro[x+3][y] == jogador.getId())){
                    System.out.println("vitoria do " + jogador.getNome());
                    return true;

                }
            }
        }
        //checar diagonal 1
        for(int x = 0;x<linhas-3;x++){
            for(int y = 0;y<colunas-3;y++){
                if((tabuleiro[x][y] == jogador.getId()) && (tabuleiro[x+1][y+1] == jogador.getId()) && (tabuleiro[x+2][y+2] == jogador.getId()) && (tabuleiro[x+3][y+3] == jogador.getId())){
                    System.out.println("vitoria do " + jogador.getNome());
                    return true;
                }
            }
        }
        //checar diagonal 2
        for(int x = 0;x<linhas-3;x++){
            for(int y = colunas-1;y>=3;y--){
                if((tabuleiro[x][y] == jogador.getId()) && (tabuleiro[x+1][y-1] == jogador.getId()) && (tabuleiro[x+2][y-2] == jogador.getId()) && (tabuleiro[x+3][y-3] == jogador.getId())){
                    System.out.println("vitoria do " + jogador.getNome());
                    return true;
                }
            }
        }
        return false;
    }

    //checar se o tabuleiro ja foi preenchido
    public boolean checarTabCheio(){
        for(int x = 0;x<linhas;x++){
            for(int y = 0;y<colunas;y++){
                if(tabuleiro[x][y] == '0'){
                    return false;
                }
            }
        }
        return true;
    }
}
