package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Frota {
    public Frota() {
    }
    Scanner ler = new Scanner(System.in);
    private List<Veiculo> frota = new ArrayList<>();

    // 1. Cadastrar Carro
    public void cadastrarCarro() {
        try {
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

            System.out.println("Qual a capacidade do tanque em Litros?");
            double capacidadeTanque = ler.nextDouble();
            ler.nextLine();

            System.out.println("Tem ar-condicionado? (true/false): ");
            boolean temArCondicionado = ler.nextBoolean();
            ler.nextLine();

            Carro carro = new Carro(marca, modelo, ano, quilometragem, totalCombustivel, temArCondicionado,
                    capacidadeTanque);
            frota.add(carro);
            System.out.println("Carro cadastrado com sucesso!");
        } catch (Exception numberFormatException) {
            ler.nextLine();
        }
    }

    // 2. Cadastrar Moto
    public void cadastrarMoto() {
        try {
            System.out.println("Marca da moto: ");
            String marca = ler.nextLine();

            System.out.println("Modelo da moto: ");
            String modelo = ler.nextLine();

            System.out.println("Ano da moto: ");
            int ano = ler.nextInt();
            ler.nextLine();

            System.out.println("Quilometragem da moto: ");
            double quilometragem = ler.nextDouble();
            ler.nextLine();

            System.out.println("Este tanque ja foi abastecido de quantos litros de combustivel?");
            double totalCombustivel = ler.nextDouble();
            ler.nextLine();

            System.out.println("Cilindradas da moto: ");
            int cilindradas = ler.nextInt();
            ler.nextLine();

            Moto moto = new Moto(marca, modelo, ano, quilometragem, totalCombustivel, cilindradas);
            frota.add(moto);
            System.out.println("Moto cadastrada com sucesso!");
        } catch (Exception numberFormatException) {
            ler.nextLine();
        }
    }

    // 3. Cadastrar Caminhão
    public void cadastrarCaminhao() {
        try {
            System.out.println("Marca do caminhão: ");
            String marca = ler.nextLine();

            System.out.println("Modelo do caminhão: ");
            String modelo = ler.nextLine();

            System.out.println("Ano do caminhão: ");
            int ano = ler.nextInt();
            ler.nextLine();

            System.out.println("Quilometragem do caminhão: ");
            double quilometragem = ler.nextDouble();
            ler.nextLine();

            System.out.println("Este tanque ja foi abastecido de quantos litros de combustivel?");
            double totalCombustivel = ler.nextDouble();
            ler.nextLine();

            System.out.println("Capacidade de carga (toneladas): ");
            double capacidadeCarga = ler.nextDouble();
            ler.nextLine();

            Caminhao caminhao = new Caminhao(marca, modelo, ano, quilometragem, totalCombustivel, capacidadeCarga);
            frota.add(caminhao);
            System.out.println("Caminhão cadastrado com sucesso!");
        } catch (Exception numberFormatException) {
            ler.nextLine();
        }
    }

    // 4. Consultar a frota
    public void consultarFrota() {
        System.out.println("\n--- Frota de Veículos ---");
        if (frota.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
        } else {
            System.out.println(frota.size() + " Veículos cadastrados, sendo eles " + porcentagensFrota(frota));

            System.out.println("--- Ordenar por: ---");
            System.out.println("1: Data" +
                    "\n2: Tipo" +
                    "\n3: Mais novo");
            int ordem = ler.nextInt();
            ler.nextLine();
            switch (ordem) {
                case 1:
                    listarPorData(frota);
                    break;
                case 2:
                    listarPorTipo(frota);
                    break;
                case 3:
                    listarPorAno(frota);
                    break;
                default:
                    System.out.println("Opção inválida");
            }

            Veiculo maiorQuilometragem = frota.get(0);
            Veiculo maisNovo = frota.get(0), maisAntigo = frota.get(0);
            Veiculo maiorConsumo = frota.get(0), menorConsumo = frota.get(0);
            for (Veiculo veiculo : frota) {
                if (veiculo.getQuilometragem() > maiorQuilometragem.getQuilometragem())
                    maiorQuilometragem = veiculo;
                if (veiculo.getAno() > maisNovo.getAno())
                    maisNovo = veiculo;
                if (veiculo.getAno() < maisAntigo.getAno())
                    maisAntigo = veiculo;
                if (veiculo.calcularConsumo() > maiorConsumo.calcularConsumo())
                    maiorConsumo = veiculo;
                if (veiculo.calcularConsumo() < maiorConsumo.calcularConsumo())
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
            maiorConsumo.mostrar();
            ;
            System.out.print("Veículo com menor consumo de combustível: ");
            menorConsumo.mostrar();
        }
    }

    // 5. Pesquisar
    public void pesquisar() {
        try {
            System.out.println("--- Pesquisar ---");
            System.out.println("1. Por Marca" +
                    "\n2. Por Modelo" +
                    "\n3. Por ano");
            switch (ler.nextInt()) {
                case 1:
                    System.out.print("Digite a Marca: ");
                    pesquisarPorMarca(frota, ler.next()).forEach(v -> v.exibirDetalhes());
                    break;
                case 2:
                    System.out.print("Digite o Modelo: ");
                    pesquisarPorModelo(frota, ler.next()).forEach(v -> v.exibirDetalhes());
                    break;
                case 3:
                    System.out.print("Digite o Ano: ");
                    pesquisarPorAno(frota, ler.nextInt()).forEach(v -> v.exibirDetalhes());
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (Exception numberFormatException) {
            System.out.println("Opção inválida! ");
            ler.nextLine();
        }
    }

    // 4. Formas de consultar Frota
    public static void listarPorData(List<Veiculo> frota) {
        int c = 1;
        for (Veiculo veiculo : frota) {
            System.out.println("--- Ordem: Data de cadastramento ---");
            System.out.print(c + "º: ");
            veiculo.exibirDetalhes();
            c++;
        }
    }

    public static void listarPorTipo(List<Veiculo> frota) {
        System.out.println("--- Ordem: Tipo de veículo ---");
        for (Veiculo veiculo : frota) {
            if (veiculo.getClass().getSimpleName().startsWith("Caminhao"))
                veiculo.exibirDetalhes();
        }
        for (Veiculo veiculo : frota) {
            if (veiculo.getClass().getSimpleName().startsWith("Carro"))
                veiculo.exibirDetalhes();
        }
        for (Veiculo veiculo : frota) {
            if (veiculo.getClass().getSimpleName().startsWith("Moto"))
                veiculo.exibirDetalhes();
        }
    }

    public static void listarPorAno(List<Veiculo> frota) {
        System.out.println("--- Ordem: Ano do veículo ---");
        // Compara cada um dos itens da lista e os ordena por ano, por fim exibe os
        // detalhes de cada veiculo na ordem
        frota.stream().sorted((v1, v2) -> Integer.compare(v1.getAno(), v2.getAno())).forEach(v -> v.exibirDetalhes());
    }

    // 5. Tipos de pesquisa
    public static List<Veiculo> pesquisarPorMarca(List<Veiculo> frota, String marca) {
        // filtra os veículos que contêm os caracteres pesquisados no campo marca e
        // retorna como uma lista
        System.out.println("## Marca "+marca+" ##");
        return frota.stream().filter(v -> v.getMarca().contains(marca)).collect(Collectors.toList());
    }

    public static List<Veiculo> pesquisarPorModelo(List<Veiculo> frota, String modelo) {
        // filtra os veículos que contêm os caracteres pesquisados no campo modelo e
        // retorna como uma lista
        System.out.println("## Modelo "+modelo+" ##");
        return frota.stream().filter(v -> v.getModelo().contains(modelo)).collect(Collectors.toList());
    }

    public static List<Veiculo> pesquisarPorAno(List<Veiculo> frota, int ano) {
        // filtra os veículos que contêm os números pesquisados no campo ano e retorna
        // como uma lista
        System.out.println("## Ano "+ano+" ##");
        return frota.stream().filter(v -> v.getAno() == ano).collect(Collectors.toList());
    }

    // Dados gerais
    public String resumo() {
        return frota.size() + " veículos cadastrados, sendo eles " + porcentagensFrota(frota);
    }

    public static String porcentagensFrota(List<Veiculo> frota) {
        // Contagem dos veículos por tipo filtrado
        double caminhoes = frota.stream().filter(quant -> quant instanceof Caminhao).count();
        double carros = frota.stream().filter(quant -> quant instanceof Carro).count();
        double motos = frota.stream().filter(quant -> quant instanceof Moto).count();
        /*
         * double caminhoes=0, carros=0, motos=0;
         * for(Object v: frota){
         * if(v instanceof Caminhao){
         * caminhoes++;
         * }else if(v instanceof Carro){
         * carros++;
         * }else if(v instanceof Moto){
         * motos++;
         * }
         * }
         */
        // Texto formatado é retornado
        return "Caminhões: " + (int) caminhoes + " (" + String.format("%.2f", caminhoes / frota.size() * 100) + "%), " +
                "Carros: " + (int) carros + " (" + String.format("%.2f", carros / frota.size() * 100) + "%), " +
                "Motos: " + (int) motos + " (" + String.format("%.2f", motos / frota.size() * 100) + "%)\n";
    }
}
