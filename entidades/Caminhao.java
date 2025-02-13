package entidades;
 
public class Caminhao extends Veiculo {
    private double capacidadeCarga;
    private double carga=0;

    public Caminhao(String marca, String modelo, int ano, double quilometragem, double totalCombustivel, double capacidadeCarga) {
        super(marca, modelo, ano, quilometragem, totalCombustivel);
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public double calcularConsumo() {
        return quilometragem / totalCombustivel * (1 + (carga / 10000));
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
        "\n Marca: " + this.getMarca()+"\n Modelo: " + this.getModelo()+"\n Ano: " + this.getAno()+"\n Quilometragem: " + this.getQuilometragem()+"km"+"\n Total de combustive abastecido: "+this.getTotalCombustivel()+"L");
        System.out.println(" Capacidade de carga: " + this.getCapacidade() + "T");
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
    public double getCapacidade(){
        return capacidadeCarga;
    }
}
