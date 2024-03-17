package Aula2;
//@autor Beatriz Moresco Joaquim
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Exercicio04 {
    Scanner input = new Scanner(System.in);
    List<ProdutoLinked> produtosLinked;

    public Exercicio04() {
        produtosLinked = new LinkedList<>();
    }

    public boolean cadastrarProduto(String nomeCadastrar) {
        ProdutoLinked novoProduto = new ProdutoLinked(nomeCadastrar);
        if (!produtosLinked.isEmpty()) {
            produtosLinked.get(produtosLinked.size() - 1).proximo = novoProduto;
            novoProduto.anterior = produtosLinked.get(produtosLinked.size() - 1);
        }
        return produtosLinked.add(novoProduto);
    }

    public boolean alterarProduto(String nomeAntigo, String nomeNovo) {
        for (int i = 0; i < produtosLinked.size(); i++) {
            ProdutoLinked produto = produtosLinked.get(i);
            if (produto.getNome().equalsIgnoreCase(nomeAntigo)) {
                produto.setNome(nomeNovo);
                return true;
            }
        }
        return false;
    }

    public boolean removerProduto(String nomeExcluir) {
        for (int i = 0; i < produtosLinked.size(); i++) {
            ProdutoLinked produto = produtosLinked.get(i);
            if (produto.getNome().equalsIgnoreCase(nomeExcluir)) {
                if (produto.anterior != null) {
                    produto.anterior.proximo = produto.proximo;
                }
                if (produto.proximo != null) {
                    produto.proximo.anterior = produto.anterior;
                }
                return produtosLinked.remove(produto);
            }
        }
        return false;
    }

    public void listarProdutos() {
        for (int i = 0; i < produtosLinked.size(); i++) {
            System.out.println(produtosLinked.get(i).getNome());
        }
    }

    public static void main(String[] args) {
        Exercicio04 ex04 = new Exercicio04();
        Scanner input = new Scanner(System.in);

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Selecionar");
        System.out.println("3 - Alterar");
        System.out.println("4 - Remover");
        System.out.println("5 - Finalizar");

        int opcao = input.nextInt();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto a ser cadastrado:");
                    String nomeCadastrar = input.next();

                    if (ex04.cadastrarProduto(nomeCadastrar)) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o produto!");
                    }
                    break;

                case 2:
                    ex04.listarProdutos();
                    break;

                case 3:
                    System.out.println("Digite o nome do produto a ser alterado:");
                    String nomeAntigo = input.next();
                    System.out.println("Digite o novo nome do produto:");
                    String nomeNovo = input.next();

                    if (ex04.alterarProduto(nomeAntigo, nomeNovo)) {
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o produto!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome do produto a ser removido:");
                    String nomeExcluir = input.next();
                    if (ex04.removerProduto(nomeExcluir)) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Não foi possível remover o produto!");
                    }
                    break;
            }

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Selecionar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Remover");
            System.out.println("5 - Finalizar");

            opcao = input.nextInt();
        }
        System.out.println("Programa finalizado.");
        input.close();
    }
}

class ProdutoLinked {
    private String nome;
    ProdutoLinked anterior;
    ProdutoLinked proximo;

    public ProdutoLinked(String nome) {
        this.nome = nome;
        this.anterior = null;
        this.proximo = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoLinked getAnterior() {
        return anterior;
    }

    public void setAnterior(ProdutoLinked anterior) {
        this.anterior = anterior;
    }

    public ProdutoLinked getProximo() {
        return proximo;
    }

    public void setProximo(ProdutoLinked proximo) {
        this.proximo = proximo;
    }
}
/*
 * Tema livre! Utilizando LinkedList, implemente uma estrutura de nós, lembrando
 * que cada objeto precisa especificar o registro anterior e o próximo.
 * 
 * Deverá ter as funcionalidades de: cadastro, seleção, alteração e exclusão,
 * dentro de uma estrutura de repetição.
 */