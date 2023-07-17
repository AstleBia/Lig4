import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Selecione o modo de jogo");
        System.out.println("Para normal digite '1'");
        System.out.println("Para turbo digite '2'");
        int modoDeJogo = input.nextInt();
        if(modoDeJogo == 1){
            Jogo jogo = new Jogo();
            jogo.criarJogadores();
            jogo.iniciar();
        }
        else if(modoDeJogo == 2){
            JogoTurbo jogo = new JogoTurbo();
            jogo.criarJogadores();
            jogo.iniciar();
        }
    }
}
