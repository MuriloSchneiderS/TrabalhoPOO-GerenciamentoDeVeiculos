package entidades;
 
public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, double quilometragem, double capacidadeCarga) {
        super(marca, modelo, ano, quilometragem);
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public double calcularConsumo() {
        return 5.0;
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Caminhão");
        System.out.println("Capacidade de carga: " + capacidadeCarga + " toneladas");
    }
    
}
