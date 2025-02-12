package main;

import entidades.*;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
 
public class principal {
    public static void main(String[] args) {
        List<Veiculo> frota = new ArrayList<>();
        Scanner ler = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Cadastrar Moto");
            System.out.println("3. Cadastrar Caminhão");
            System.out.println("4. Consultar Frota");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = ler.nextInt();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Marca do carro: ");
                    String marca = ler.nextLine();
                    System.out.println("Modelo do carro: ");
                    String modelo = ler.nextLine();
                    System.out.println("Ano do carro: ");
                    int ano = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Quilometragem do carro: ");
                    double quilometragem = ler.nextDouble();
                    ler.nextLine();
                    System.out.println("Tem ar-condicionado? (true/false): ");
                    boolean temArCondicionado = ler.nextBoolean();
                    System.out.println("Qual a capacidade do tanque em Litros?");
                    double capacidadeTanque = ler.nextDouble();
                    ler.nextLine();
                    Carro carro = new Carro(marca, modelo, ano, quilometragem, temArCondicionado, capacidadeTanque);
                    frota.add(carro);
                    System.out.println("Carro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Marca da moto: ");
                    marca = ler.nextLine();
                    System.out.println("Modelo da moto: ");
                    modelo = ler.nextLine();
                    System.out.println("Ano da moto: ");
                    ano = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Quilometragem da moto: ");
                    quilometragem = ler.nextDouble();
                    ler.nextLine();
                    System.out.println("Cilindradas da moto: ");
                    int cilindradas = ler.nextInt();
                    ler.nextLine();
                    Moto moto = new Moto(marca, modelo, ano, quilometragem, cilindradas);
                    frota.add(moto);
                    System.out.println("Moto cadastrada com sucesso!");
                    break;

                case 3:
                    System.out.println("Marca do caminhão: ");
                    marca = ler.nextLine();
                    System.out.println("Modelo do caminhão: ");
                    modelo = ler.nextLine();
                    System.out.println("Ano do caminhão: ");
                    ano = ler.nextInt();
                    ler.nextLine();
                    System.out.println("Quilometragem do caminhão: ");
                    quilometragem = ler.nextDouble();
                    ler.nextLine();
                    System.out.println("Capacidade de carga (toneladas): ");
                    double capacidadeCarga = ler.nextDouble();
                    ler.nextLine();

                    Caminhao caminhao = new Caminhao(marca, modelo, ano, quilometragem, capacidadeCarga);
                    frota.add(caminhao);
                    System.out.println("Caminhão cadastrado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--- Frota de Veículos ---");
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        for (Veiculo veiculo : frota) {
                            System.out.println("\nMarca: " + veiculo.getMarca());
                            System.out.println("Modelo: " + veiculo.getModelo());
                            System.out.println("Ano: " + veiculo.getAno());
                            System.out.println("Quilometragem: " + veiculo.getQuilometragem());
                            veiculo.exibirDetalhes();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        ler.close();
    }
}
