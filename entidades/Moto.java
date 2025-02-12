package entidades;
 
public class Moto extends Veiculo {
    private int cilindradas;
    private int capacidadeTanque;
    private int combustivel=0;

    public Moto(String marca, String modelo, int ano, double quilometragem, int cilindradas) {
        super(marca, modelo, ano, quilometragem);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularConsumo() {
        return 30.0;
    }
    @Override
    public void cadastraViagem(double km) {
        if (km > 0) {
            this.quilometragem += km;
        } else {
            System.out.println("Distância inválida.");
        }
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Moto");
        System.out.println("Cilindradas: " + cilindradas);
    }

    public void abastecer(double litros){
        double espacoNoTanque;
        do{
            espacoNoTanque = capacidadeTanque-combustivel;
            if(litros<espacoNoTanque){
                this.combustivel += litros;
            }else{
                System.out.println("Quantidade de combustivel invalida, o tanque possui apenas "+espacoNoTanque+"L de espaço livre, de um total de "+capacidadeTanque+"L.");
            }
        }while(litros<espacoNoTanque);
    }
}
