package entidades;

public class CaminhaoEletrico extends Caminhao implements Eletricos {
    private int bateria;//0%-100%
    private double consumo;
    private boolean auto=false;
    public CaminhaoEletrico(String marca, String modelo, int ano, double quilometragem, double totalCombustivel,
                            double capacidadeCarga, double consumo) {
        super(marca, modelo, ano, quilometragem, totalCombustivel, capacidadeCarga);
        this.consumo = consumo;
    }
    
    @Override
    public void pilotoAutomatico() {
        auto=auto/*==true*/? false : true;
        if (auto) {
            System.out.println("Piloto automático ativado.");
        }else{
            System.out.println("Piloto automático desativado.");
        }
    }
    @Override
    public void carregar(int carga) {
        bateria= bateria+carga>100? 100 : bateria+carga;//Bateria vai até 100%
    }
    @Override
    public double calcularConsumo(){
        //Custo por 100 km = consumo de energia do veículo (kWh/100km) x tarifa de energia (R$/kWh)
        return consumo*0.80;//Estimativa de tarifa média em R$. 
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Caminhão elétrico"+
        "\n Marca: " +marca+"\n Modelo: " +modelo+"\n Ano: " +ano+"\n Quilometragem: " +quilometragem+"km"+"\n Total de combustive abastecido: "+totalCombustivel+"L");
        System.out.println(" Capacidade de carga: " +capacidadeCarga+ "T");
        System.out.println(" Consumo elétrico em R$/100km: "+calcularConsumo());
    }
}
