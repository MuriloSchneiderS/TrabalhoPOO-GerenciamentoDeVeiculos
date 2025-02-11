package entidades;
 
public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int ano, double quilometragem, int cilindradas) {
        super(marca, modelo, ano, quilometragem);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularConsumo() {
        return 30.0;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Moto");
        System.out.println("Cilindradas: " + cilindradas);
    }
    
}
