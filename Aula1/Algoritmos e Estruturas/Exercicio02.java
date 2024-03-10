import java.util.Scanner;

public class Exercicio02 {
    Scanner input = new Scanner(System.in);
    String[] nomes = new String[10];
    int posicao = 0;

    public Exercicio02() {

    }

    public boolean cadastrar(String nomeCadastrar) {
        if (posicao < nomes.length) {
            nomes[posicao++] = nomeCadastrar;
            return true;
        }
        return false;
    }

    public void imprimir() {
        for (int i = 0; i < posicao; i++) {
            System.out.println(nomes[i]);
        }
    }

    // metodo so para busca para nao precisar repetir duas vezes a mesma estrutura
    public int buscar(String nomeBusca) {
        for (int i = 0; i < nomes.length; i++) {
            if (nomeBusca.equals(nomes[i])) {
                return i;
            }
        }
        return -1;
    }
    //

    public boolean alterar(String nomeAntigo, String nomeNovo) {
        int posicao = buscar(nomeAntigo);
        if (posicao >= 0) {
            nomes[posicao] = nomeNovo;
            return true;
        }
        return false;
    }

    public boolean excluir(String nomeExcluir) {
        int posicao = buscar(nomeExcluir);
        if (posicao >= 0) { // realocando
            for (int i = posicao; i < nomes.length - 1; i++) {
                nomes[i] = nomes[i + 1];
            }
            // deixando o espaco final, apos realocacao, como null
            // nomes[posicao] = null;
            // posicao--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Exercicio02 ex02 = new Exercicio02();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar todos os nomes");
        System.out.println("3 - Alterar");
        System.out.println("4 - Remover");
        System.out.println("5 - finalizar");

        int opcao = ex02.input.nextInt();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome a ser cadastrado:");
                    String nome = ex02.input.next();
                    if (ex02.cadastrar(nome)) {
                        System.out.println("Nome cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o nome!");
                    }
                    break;

                case 2:
                    ex02.imprimir();
                    break;

                case 3:
                    System.out.println("Digite o nome a ser alterado:");
                    String nomeAntigo = ex02.input.next();
                    System.out.println("Digite o novo nome:");
                    String nomeNovo = ex02.input.next();
                    if (ex02.alterar(nomeAntigo, nomeNovo)) {
                        System.out.println("Nome alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o nome!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome a ser removido:");
                    String nomeExcluir = ex02.input.next();
                    if (ex02.excluir(nomeExcluir)) {
                        System.out.println("Nome excluído com sucesso!");
                    } else {
                        System.out.println("Nome não excluído!");
                    }
                    break;
            }
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos os nomes");
            System.out.println("3 - Alterar");
            System.out.println("4 - Remover");
            System.out.println("5 - Finalizar");

            opcao = ex02.input.nextInt();
        }
        System.out.println("Programa finalizado.");
        ex02.input.close();
    }
}

/*
 * Utilizando um array estático de dez posições, desenvolva um algoritmo com as
 * seguintes funcionalidades:
 * 
 * Cadastrar;
 * Listar todos os nomes;
 * Alterar;
 * Remover;
 * Finalizar.
 * 
 * Essa estrutura ficará em um laço de repetição.
 * 
 */