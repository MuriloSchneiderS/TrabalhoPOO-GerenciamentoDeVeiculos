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
    public void cadastraViagem(double km) {
        double carga;
        do{
            System.out.print("Quanta carga o caminhão levará? Kg");
            carga = input.nextDouble();
            if(carga>capacidadeCarga){
                System.out.println("A capacidade do caminhão é apenas "+capacidadeCarga+". Insira uma carga menor.");
            }else{
                capacidadeCarga -= carga;
                if (km > 0) {
                    this.quilometragem += km;
                    System.out.println("Descarregando carga...");
                    capacidadeCarga += carga;
                } else {
                    System.out.println("Distância inválida.");
                }
            }
        }while(carga>capacidadeCarga);
    }
    
    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Caminhão"+
        "\n Marca: " + this.getMarca()+"\n Modelo: " + this.getModelo()+"\n Ano: " + this.getAno()+"\n Quilometragem: " + this.getQuilometragem()+"km");
        System.out.println(" Capacidade de carga: " + this.capacidadeCarga + "T");
    }

    
}
