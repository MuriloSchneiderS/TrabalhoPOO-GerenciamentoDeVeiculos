package entidades;
 
public class Carro extends Veiculo {
    protected double capacidadeTanque;
    protected boolean temArCondicionado;
    protected int passageiros=1;

    public Carro(String marca, String modelo, int ano, double quilometragem, double totalCombustivel, double capacidadeTanque, boolean temArCondicionado) {
        super(marca, modelo, ano, quilometragem, totalCombustivel);
        this.capacidadeTanque = capacidadeTanque;
        this.temArCondicionado = temArCondicionado;
    }
    public Carro getCopy(){//copia de carro para transformar em um carro elétrico, para não precisar desprivar os atributos de Carro.
        return new Carro(marca, modelo, passageiros, quilometragem, totalCombustivel, capacidadeTanque, temArCondicionado);
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
        "\n Marca: " +marca+"\n Modelo: " +modelo+"\n Ano: " +ano+"\n Quilometragem: " +quilometragem+"km"+"\n Total de combustivel abastecido: "+totalCombustivel+"L");
        System.out.println(" Capacidade do Tanque: "+capacidadeTanque+"L.\n Tem ar-condicionado: " + (temArCondicionado? "Sim. " : "Não. "));
    }

    public void receberPassageiros(int quant){
        passageiros+=quant;
    }
    public void desembarcarPassageiros(int quant){
        passageiros-=quant;
    }
}
