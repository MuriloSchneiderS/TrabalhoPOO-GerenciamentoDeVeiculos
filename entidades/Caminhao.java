package entidades;
 
public class Caminhao extends Veiculo {
    protected double capacidadeCarga;//Espaço na carroceria
    protected double carga=0;//Carga que está na carroceria

    public Caminhao(String marca, String modelo, int ano, double quilometragem, double totalCombustivel, double capacidadeCarga) {
        super(marca, modelo, ano, quilometragem, totalCombustivel);
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public double calcularConsumo() {
        return quilometragem / totalCombustivel * (1 + (carga / 10000));//Consumo aumenta com mais carga
    }
    @Override
    public void cadastraViagem(double km) {
        do{
            System.out.print("Quanta carga o caminhão levará? Kg");
            double pacote = input.nextDouble();
            if(pacote>capacidadeCarga){
                System.out.println("A capacidade do caminhão é apenas "+capacidadeCarga+". Insira uma carga menor.");
            }else{
                if (km > 0) {
                    abastecerCarroceria(pacote);
                    this.quilometragem += km;
                    this.totalCombustivel += km*calcularConsumo();
                    System.out.println("Descarregando...");
                    descarregar(pacote);
                } else {
                    System.out.println("Distância inválida.");
                }
            }
        }while(carga>capacidadeCarga);
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Caminhão"+
        "\n Marca: " +marca+"\n Modelo: " +modelo+"\n Ano: " +ano+"\n Quilometragem: " +quilometragem+"km"+"\n Total de combustive abastecido: "+totalCombustivel+"L");
        System.out.println(" Capacidade de carga: " +capacidadeCarga+ "T");
    }

    public void abastecerCarroceria(double kg){
        capacidadeCarga-= kg;
        carga+=kg;
    }
    public void descarregar(double kg){
        capacidadeCarga += kg;
        carga-=kg;
    }
    public void esvaziarCarroceria(){
        carga=0;
    }
}
