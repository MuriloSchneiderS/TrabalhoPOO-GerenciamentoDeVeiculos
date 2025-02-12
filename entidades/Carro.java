package entidades;
 
public class Carro extends Veiculo {
    private boolean temArCondicionado;
    private double capacidadeTanque;

    public Carro(String marca, String modelo, int ano, double quilometragem, boolean temArCondicionado, double capacidadeTanque) {
        super(marca, modelo, ano, quilometragem);
        this.temArCondicionado = temArCondicionado;
        this.capacidadeTanque = capacidadeTanque;
    }

    @Override
    public double calcularConsumo() {
        return 10.0;
    }
    @Override
    public void cadastraViagem(double km) {
        System.out.println("Serão necessários "+(12.5*km)+"L de gasolina.");//12.5km/l = média de consumo de um carro
        if (km > 0) {
            this.quilometragem += km;
            System.out.println("Viagem realizada.");
        } else {
            System.out.println("Distância inválida.");
        }
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Tipo: Carro"+
        "\n Marca: " + this.getMarca()+"\n Modelo: " + this.getModelo()+"\n Ano: " + this.getAno()+"\n Quilometragem: " + this.getQuilometragem()+"km");
        System.out.println(" Capacidade do Tanque: "+this.capacidadeTanque+"L.\n Tem ar-condicionado: " + (this.temArCondicionado ? "Sim. " : "Não. "));
    }

}
