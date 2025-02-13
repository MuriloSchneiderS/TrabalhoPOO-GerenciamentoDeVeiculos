package entidades;

import java.util.Scanner;

public abstract class Veiculo {
    protected Scanner input = new Scanner(System.in);
    private String marca;
    private String modelo;
    private int ano;
    protected double quilometragem;
    protected double totalCombustivel;
    
    public Veiculo(String marca, String modelo, int ano, double quilometragem,double totalCombustivel) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.totalCombustivel = totalCombustivel;
    }
    
    public abstract double calcularConsumo();
    public abstract void cadastraViagem(double km);
    public void mostrar(){
        System.out.println(this.getClass().getSimpleName()+" " + marca + " " + modelo);
    }
    public abstract void exibirDetalhes();
    public void trocarTanque(){
        totalCombustivel=0;
    }
    
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAno() {
        return ano;
    }
    public double getQuilometragem() {
        return quilometragem;
    }
    public double getTotalCombustivel(){
        return totalCombustivel;
    }
    
}
