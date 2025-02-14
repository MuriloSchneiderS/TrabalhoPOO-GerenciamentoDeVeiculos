package main;

import entidades.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
 
public class principal {
    public static void main(String[] args){        
        Scanner ler = new Scanner(System.in);
        List<Frota> frotas = new ArrayList<>();/*lista com diversos objetos Frota, 
                                                que contêm a frota em si(na forma de uma ArrayList encapsulada) 
                                                e os métodos de interação com a frota.*/
        int opcao=0;
        do{
            try{
                System.out.println("--- Menu de frotas ---");
                System.out.println("1. Cadastrar nova frota"+
                "\n2. consultar frotas"+
                "\n0. Encerrar programa");
                opcao=ler.nextInt();
                ler.nextLine();
                switch (opcao) {
                    case 1:
                        frotas.add(new Frota());
                        menuDeCadastro(frotas.getLast());
                        break;
                    case 2:
                        int c=1;
                        if (frotas.isEmpty()) {
                            System.out.println("## Nenhuma frota cadastrada. ##\n");
                        }else{
                            for (Frota frota : frotas) {
                                System.out.println("## "+frotas.size()+" frotas cadastradas ##");
                                System.out.println(c + "º frota: ");
                                c++;
                                System.out.println(frota.resumo());
                            }
                        }
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }catch(Exception numberFormatException){
                System.out.println("Tipo de dado inválido inserido."+"\nReiniciando...\n");
                opcao=-10;
                ler.next();
            }
        }while(opcao!=0);
        ler.close();
    }

    public static void menuDeCadastro(Frota frota){
        Scanner ler = new Scanner(System.in);//Se "ler.close()" o sistema encerra o System.in e quando vai usar outro scanner causa um erro.
        int opcao=0;
        do {
            try{/*Tratamento contra tipo de dado errado inserido, 
                veiculos ja cadastrados não são perdidos ao reiniciar*/
                System.out.println("\n--- Menu de cadastro ---");
                System.out.println("1. Cadastrar Carro");
                System.out.println("2. Cadastrar Moto");
                System.out.println("3. Cadastrar Caminhão");
                System.out.println("4. Consultar Frota");
                System.out.println("5. Pesquisar");
                System.out.println("0. Sair");
                System.out.println("Escolha uma opção: ");
                opcao = ler.nextInt();
                ler.nextLine();
                switch (opcao) {
                    case 1://Cadastrar Carro
                        frota.cadastrarCarro();
                        break;
                    case 2://Cadastrar Moto
                        frota.cadastrarMoto();
                        break;
                    case 3://Cadastrar Caminhão
                        frota.cadastrarCaminhao();
                        break;
                    case 4://Consultar Frota com uma lista ordenada por data de cadastramento, tipo ou ano do veículo
                        frota.consultarFrota();
                        break;
                    case 5://Pesquisar por marca, modelo ou ano
                        frota.pesquisar();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }catch(Exception numberFormatException){
                System.out.println("Tipo de dado inválido inserido. "+"Reiniciando menu...\n");
                opcao=-10;
                ler.next();
            }
        } while (opcao != 0);
    }   
}