package tabuleiros;
import jogador.Jogador;

public interface InterfaceTabuleiro {
    public abstract int getLinhas();
    public abstract int getColunas();
    public abstract char[][] getTabuleiro();
    public abstract void setTabuleiro(int linha, int coluna, char valor);
    public abstract void zerarTabuleiro();
    public abstract void printarTabuleiro();
    public abstract void jogada(int coluna, Jogador jogador);
    public abstract boolean vitoria(Jogador jogador);
    public abstract boolean checarTabCheio();

}
