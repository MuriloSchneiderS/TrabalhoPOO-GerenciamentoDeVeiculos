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
                    
                    System.out.println("Quantos litros de combustivel ja forma abastecidos no tanque do veiculo?");
                    double totalCombustivel = ler.nextDouble();
                    ler.nextLine();
                    
                    System.out.println("Tem ar-condicionado? (true/false): ");
                    boolean temArCondicionado = ler.nextBoolean();
                    
                    System.out.println("Qual a capacidade do tanque em Litros?");
                    double capacidadeTanque = ler.nextDouble();
                    ler.nextLine();
                    
                    Carro carro = new Carro(marca, modelo, ano, quilometragem, totalCombustivel, temArCondicionado, capacidadeTanque);
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
                    
                    System.out.println("Este tanque ja foi abastecido de quantos litros de combustivel?");
                    totalCombustivel=ler.nextDouble();
                    ler.nextLine();
                    
                    System.out.println("Cilindradas da moto: ");
                    int cilindradas = ler.nextInt();
                    ler.nextLine();
                    
                    Moto moto = new Moto(marca, modelo, ano, quilometragem, totalCombustivel, cilindradas);
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

                    System.out.println("Este tanque ja foi abastecido de quantos litros de combustivel?");
                    totalCombustivel=ler.nextDouble();
                    ler.nextLine();

                    System.out.println("Capacidade de carga (toneladas): ");
                    double capacidadeCarga = ler.nextDouble();
                    ler.nextLine();
                    
                    Caminhao caminhao = new Caminhao(marca, modelo, ano, quilometragem, totalCombustivel, capacidadeCarga);
                    frota.add(caminhao);
                    System.out.println("Caminhão cadastrado com sucesso!");
                    break;
                case 4:
                    System.out.println("\n--- Frota de Veículos ---");
                    if (frota.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {
                        System.out.println(frota.size()+" Veículos cadastrados, sendo eles "+porcentagensFrota(frota));
                        int c=1;
                        Veiculo maiorQuilometragem=frota.get(0);
                        Veiculo maisNovo=frota.get(0);
                        Veiculo maisAntigo=frota.get(0);
                        Veiculo maiorConsumo=frota.get(0);
                        Veiculo menorConsumo=frota.get(0);

                        for (Veiculo veiculo : frota) {
                            System.out.print(c+"º: ");
                            veiculo.exibirDetalhes();
                            c++;
                            if(veiculo.getQuilometragem()>maiorQuilometragem.getQuilometragem())
                                maiorQuilometragem = veiculo;
                            if(veiculo.getAno()>maisNovo.getAno())
                                maisNovo = veiculo;
                            if(veiculo.getAno()<maisAntigo.getAno())
                                maisAntigo = veiculo;
                            if(veiculo.calcularConsumo()>maiorConsumo.calcularConsumo())
                                maiorConsumo = veiculo;
                            if(veiculo.calcularConsumo()<maiorConsumo.calcularConsumo())
                                menorConsumo = veiculo;
                            
                        }
                        System.out.println("--- dados adicionais da frota ---");
                        System.out.print("Veículo com maior quilometragem: ");
                        maiorQuilometragem.mostrar();
                        System.out.print("Veículo mais novo: ");
                        maisNovo.mostrar();
                        System.out.print("Veículo mais antigo: ");
                        maisAntigo.mostrar();
                        System.out.print("Veículo com maior consumo de combustível: ");
                        maiorConsumo.mostrar();;
                        System.out.print("Veículo com menor consumo de combustível: ");
                        menorConsumo.mostrar();
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
    public static String porcentagensFrota(List<Veiculo> frota){
        double caminhoes = frota.stream().filter(quant-> quant instanceof Caminhao).count();
        double carros = frota.stream().filter(quant-> quant instanceof Carro).count();
        double motos = frota.stream().filter(quant-> quant instanceof Moto).count();
        /*double caminhoes=0, carros=0, motos=0;
        for(Object v: frota){
            if(v instanceof Caminhao){
                caminhoes++;
            }else if(v instanceof Carro){
                carros++;
            }else if(v instanceof Moto){
                motos++;
            }
        }*/
        return "Caminhões: "+(int)caminhoes+" ("+String.format("%.2f", caminhoes/frota.size()*100 )+"%), "+
        "Carros: "+(int)carros+" ("+String.format("%.2f", carros/frota.size()*100 )+"%), "+
        "Motos: "+(int)motos+" ("+String.format("%.2f", motos/frota.size()*100 )+"%)\n";
    }
}
