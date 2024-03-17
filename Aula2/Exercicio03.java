package Aula2;

//@autor Beatriz Moresco Joaquim
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio03 {
    Scanner input = new Scanner(System.in);
    List<Produto> produtos;

    public Exercicio03() {
        produtos = new ArrayList<>();
    }

    public boolean cadastrar(String nomeCadastrar, double valorCadastrar, String segmento) {
        Produto novoProduto = new Produto(nomeCadastrar, valorCadastrar, segmento);
        produtos.add(novoProduto);
        return true;
    }

    public boolean alterar(String nomeAntigo, String nomeNovo, double valorNovo) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equalsIgnoreCase(nomeAntigo)) {
                produto.setNome(nomeNovo);
                produto.setValor(valorNovo);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String nomeExcluir) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equalsIgnoreCase(nomeExcluir)) {
                produtos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void exibirQuantidadePorSegmento() {
        List<String> segmentos = new ArrayList<>();
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (!segmentos.contains(produto.getSegmento())) {
                segmentos.add(produto.getSegmento());
            }
        }

        for (int i = 0; i < segmentos.size(); i++) {
            String segmento = segmentos.get(i);
            int quantidade = 0;
            for (int j = 0; j < produtos.size(); j++) {
                Produto produto = produtos.get(j);
                if (produto.getSegmento().equals(segmento)) {
                    quantidade++;
                }
            }
            System.out.println("Segmento: " + segmento + ", Quantidade: " + quantidade);
        }
    }

    public static void main(String[] args) {
        Exercicio03 ex03 = new Exercicio03();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Selecionar todos os registros");
        System.out.println("3 - Quantidade por Segmento");
        System.out.println("4 - Alterar");
        System.out.println("5 - Remover");
        System.out.println("6 - Finalizar");

        int opcao = ex03.input.nextInt();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto a ser cadastrado:");
                    String nomeCadastrar = ex03.input.next();
                    System.out.println("Digite o valor do produto a ser cadastrado:");
                    double valorCadastrar = ex03.input.nextDouble();
                    System.out.println("Digite o segmento do produto:");
                    String segmento = ex03.input.next();

                    if (ex03.cadastrar(nomeCadastrar, valorCadastrar, segmento)) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o produto!");
                    }
                    break;

                case 2:
                    if (ex03.produtos.isEmpty()) {
                        System.out.println("Não há registros para selecionar.");
                    } else {
                        System.out.println("Registros selecionados:");
                        for (int i = 0; i < ex03.produtos.size(); i++) {
                            System.out.println(ex03.produtos.get(i));
                        }
                    }
                    break;

                case 3:
                    ex03.exibirQuantidadePorSegmento();
                    break;

                case 4:
                    System.out.println("Digite o nome do produto a ser alterado:");
                    String nomeAntigo = ex03.input.next();
                    System.out.println("Digite o novo nome:");
                    String nomeNovo = ex03.input.next();
                    System.out.println("Digite o novo valor:");
                    double valorNovo = ex03.input.nextDouble();

                    if (ex03.alterar(nomeAntigo, nomeNovo, valorNovo)) {
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o produto!");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome do produto a ser removido:");
                    String nomeExcluir = ex03.input.next();
                    if (ex03.remover(nomeExcluir)) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover o produto!");
                    }
                    break;
            }
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Selecionar todos os registros");
            System.out.println("3 - Quantidade por Segmento");
            System.out.println("4 - Alterar");
            System.out.println("5 - Remover");
            System.out.println("6 - Finalizar");

            opcao = ex03.input.nextInt();
        }
        System.out.println("Programa finalizado.");
        ex03.input.close();
    }
}

class Produto {
    private String nome;
    private double valor;
    private String segmento;

    public Produto(String nome, double valor, String segmento) {
        this.nome = nome;
        this.valor = valor;
        this.segmento = segmento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Valor: R$" + valor + ", Segmento: " + segmento;
    }
}
/*
 * Utilizando um ArrayList, crie um algoritmo com as seguintes funcionalidades:
 * 
 * Cadastrar (Deverá cadastrar o nome de um produto e o segmento, pode adicionar
 * mais características, caso queira).
 * Selecionar todos os registros.
 * Quantidade de segmentos: Exiba o nome e a quantidade de produtos em cada
 * segmento.
 * Alterar dados (Realize uma validação para garantir que será alterado).
 * Remoção (Realize uma validação para garantir que será removido).
 * 
 * Essa estrutura ficará em uma estrutura de repetição e poderão ser registradas
 * inúmeras informações.
 */