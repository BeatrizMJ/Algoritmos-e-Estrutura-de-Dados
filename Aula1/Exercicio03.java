import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio03 {
    Scanner input = new Scanner(System.in);
    List<Produto> produtos;

    public Exercicio03() {
        produtos = new ArrayList<>();
    }

    public boolean cadastrar(String nomeCadastrar, double valorCadastrar) {
        Produto novoProduto = new Produto(nomeCadastrar, valorCadastrar);
        produtos.add(novoProduto);
        return true;
    }

    public void imprimir() {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println(produto);
        }
    }

    public boolean buscar(String termo) {
        boolean encontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(produto);
                encontrado = true;
            }
        }
        return encontrado;
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

    public static void main(String[] args) {
        Exercicio03 ex03 = new Exercicio03();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Pesquisar");
        System.out.println("4 - Alterar");
        System.out.println("5 - Remover");
        System.out.println("6 - Finalizar");

        int opcao = ex03.input.nextInt();

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto a ser cadastrado:");
                    String nomeCadastrar = ex03.input.next();
                    System.out.println("Digite o valor do produto a ser cadastrado:");
                    double valorCadastrar = ex03.input.nextDouble();

                    if (ex03.cadastrar(nomeCadastrar, valorCadastrar)) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o produto!");
                    }
                    break;

                case 2:
                    ex03.imprimir();
                    break;

                case 3:
                    System.out.println("Digite o termo ao qual deseja pesquisar um produto:");
                    String termo = ex03.input.next();
                    if (!ex03.buscar(termo)) {
                        System.out.println("Não foi possível encontrar produtos com esse termo!");
                    }
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
            System.out.println("2 - Listar");
            System.out.println("3 - Pesquisar");
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

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
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

    @Override
    public String toString() {
        return "Nome: " + nome + ", Valor: R$" + valor;
    }
}
/*
 * Utilizando um array dinâmico, desenvolva um algoritmo para gerenciar
 * produtos, contendo as seguintes funcionalidades:
 * 
 * Cadastro: Informar nome do produto e valor.
 * Listagem: Listar todos os produtos (nome e valor).
 * Pesquisa: Será pedido um termo, localize os produtos que contenham aquele
 * termo no seu nome.
 * Alterar: Será pedido o nome do produto que será alterado. Informe um novo
 * nome e o valor.
 * Remover: Através do nome do produto, realize a exclusão.
 * Finalizar: Encerra o sistema.
 * 
 */