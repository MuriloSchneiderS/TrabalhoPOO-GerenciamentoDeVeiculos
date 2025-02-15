package entidades;
 
public class Carro extends Veiculo {
    protected boolean temArCondicionado;
    private double capacidadeTanque;
    protected int passageiros=1;

    public Carro(String marca, String modelo, int ano, double quilometragem, double totalCombustivel, boolean temArCondicionado, double capacidadeTanque) {
        super(marca, modelo, ano, quilometragem, totalCombustivel);
        this.temArCondicionado = temArCondicionado;
        this.capacidadeTanque = capacidadeTanque;
    }
    
    @Override
    public double calcularConsumo() {
        return quilometragem/totalCombustivel*(passageiros * 0.1);//Aumenta levemente o consumo com mais passageiros
    }
    @Override
    public void cadastraViagem(double km) {
        receberPassageiros(1);//Motorista precisa entrar antes de qualquer coisa
        System.out.print("Quantos passageiros irão junto?(sem contar o motorista) ");
        receberPassageiros(input.nextInt());
        System.out.println("Serão necessários "+calcularConsumo()+"L de gasolina.");
        if (km > 0) {
            this.quilometragem += km;
            this.totalCombustivel += km*calcularConsumo();
            System.out.println("Viagem realizada.");
            desembarcarPassageiros(passageiros);
        } else {
            System.out.println("Distância inválida.");
        }
    }
    @Override
    public void exibirDetalhes() {
        System.out.println("Carro"+
        "\n Marca: " + this.getMarca()+"\n Modelo: " + this.getModelo()+"\n Ano: " + this.getAno()+"\n Quilometragem: " + this.getQuilometragem()+"km"+"\n Total de combustivel abastecido: "+this.getTotalCombustivel()+"L");
        System.out.println(" Capacidade do Tanque: "+this.capacidadeTanque+"L.\n Tem ar-condicionado: " + (this.temArCondicionado ? "Sim. " : "Não. "));
    }

    public void receberPassageiros(int quant){
        passageiros+=quant;
    }
    public void desembarcarPassageiros(int quant){
        passageiros-=quant;
    }
}
