package entidades;
 
public class Carro extends Veiculo {
    private boolean temArCondicionado;

    public Carro(String marca, String modelo, int ano, double quilometragem, boolean temArCondicionado) {
        super(marca, modelo, ano, quilometragem);
        this.temArCondicionado = temArCondicionado;
    }

    @Override
    public double calcularConsumo() {
        return 10.0;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Carro");
        System.out.println("Tem ar-condicionado: " + (temArCondicionado ? "Sim" : "Não"));
    }

}
