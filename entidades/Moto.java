package entidades;
 
public class Moto extends Veiculo {
    protected double capacidadeTanque;
    protected double cilindradas;
    protected double combustivel=0;

    public Moto(String marca, String modelo, int ano, double quilometragem, double totalCombustivel, double capacidadeTanque, double cilindradas) {
        super(marca, modelo, ano, quilometragem, totalCombustivel);
        this.capacidadeTanque = capacidadeTanque;
        this.cilindradas = cilindradas;
    }

    public double calcularConsumo() {
        return quilometragem*totalCombustivel*0.9;//Assumindo que motos têm um fator de consumo menor
    }
    @Override
    public void cadastraViagem(double km) {
        double combustivelNecessario = km*calcularConsumo();
        if (km > 0 && combustivelNecessario<combustivel) {
            this.combustivel -= combustivelNecessario;
            this.quilometragem += km;
            this.totalCombustivel += combustivelNecessario;
        } else if(km>0 && combustivelNecessario>combustivel){
            System.out.println("Esta viagem ira gastar "+combustivelNecessario+"L de combustivel, você tem apenas "+combustivel+"L no tanque, abasteça!");
        } else {
            System.out.println("Distância inválida.");
        }
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Moto"+
        "\n Marca: " +marca+"\n Modelo: " +modelo+"\n Ano: " +ano+"\n Quilometragem: " +quilometragem+"km"+"\n Total de combustivel abastecido: "+totalCombustivel+"L");
        System.out.println(" Cilindradas: " + cilindradas);
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
        }while(litros>espacoNoTanque);
    }
}
