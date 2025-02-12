package entidades;

import java.util.Scanner;

public abstract class Veiculo {
    protected Scanner input = new Scanner(System.in);
    private String marca;
    private String modelo;
    private int ano;
    protected double quilometragem;
    
    public Veiculo(String marca, String modelo, int ano, double quilometragem) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
    }
    
    public abstract double calcularConsumo();
    public abstract void cadastraViagem(double km);
    public void mostrar(){
        System.out.println("Veículo cadastrado: " + marca + " " + modelo);
    }
    public abstract void exibirDetalhes();
    
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

    
}
