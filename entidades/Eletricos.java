package entidades;

public interface Eletricos {
    int carga=0;//0%-100%
    public void carregamento();
    public void pilotoAutomatico();
    public void carregar(int carga);
}
