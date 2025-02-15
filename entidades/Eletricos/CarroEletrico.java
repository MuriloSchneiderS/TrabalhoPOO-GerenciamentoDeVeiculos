package entidades.Eletricos;
import entidades.Carro;

public class CarroEletrico extends Carro implements Eletricos {
    private int bateria;//0%-100%
    private double consumo;
    private boolean auto=false;

    public CarroEletrico(String marca, String modelo, int ano, double quilometragem, double totalCombustivel,
                        boolean temArCondicionado, double capacidadeTanque, double consumo) {
        super(marca, modelo, ano, quilometragem, totalCombustivel, temArCondicionado, capacidadeTanque);
        this.consumo = consumo;
    }
    
    @Override
    public void pilotoAutomatico() {
        auto= auto/*==true*/?false:true;
        if (auto) {
            auto=false;
            System.out.println("Piloto automático desativado.");
        }else{
            auto=true;
            System.out.println("Piloto automático ativado.");
        }
    }
    @Override
    public void carregar(int carga) {
        bateria= bateria+carga>100? 100:bateria+carga;//Bateria vai até 100%
    }
    
    @Override
    public double calcularConsumo(){
        //Custo por 100 km = consumo de energia do veículo (kWh/100km) x tarifa de energia (R$/kWh)
        return consumo*0.75;//Estimativa de tarifa média em R$. 
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Carro elétrico "+
        "\n Marca: " + this.getMarca()+"\n Modelo: " + this.getModelo()+"\n Ano: " + this.getAno()+"\n Quilometragem: " + this.getQuilometragem()+"km"+"\n Ciclos de carregamento: "+this.getTotalCombustivel()+"L");
        System.out.println("\n Tem ar-condicionado: " + (this.temArCondicionado ? "Sim. " : "Não. ")+
        "\nBateria: "+bateria+"\nConsumo: "+consumo+"\nCusto por 100km: "+calcularConsumo());
    }
}
