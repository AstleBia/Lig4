package jogador;

public class Jogador {
    private char idJogador;
    private String nome;
    public Jogador(String nome){
        this.nome = nome;
    }
    public char getId(){
        return idJogador;
    }
    public void setId(char idJogador){
        this.idJogador = idJogador;
    }
    public String getNome(){
        return nome;
    }
}
