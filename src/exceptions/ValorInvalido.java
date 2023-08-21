package exceptions;

public class ValorInvalido extends Exception{
    public ValorInvalido(int valor){
        super("O valor " + valor + " nao eh valido");
    }
}
