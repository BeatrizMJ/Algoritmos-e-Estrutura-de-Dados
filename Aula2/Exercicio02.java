package Aula2;
//@autor Beatriz Moresco Joaquim
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Exercicio02 {
    Scanner input = new Scanner(System.in);
    List<String> nomes;
    int posicao = 0;

    public Exercicio02() {
        nomes = new Vector<>();
    }

    public boolean cadastrar(String nomeCadastrar) {
        if (!nomes.contains(nomeCadastrar)) {
            nomes.add(nomeCadastrar);
            return true;
        }
        return false;
    }

    public boolean buscar(String termo) {
        boolean encontrado = false;
        for (int i = 0; i < nomes.size(); i++) {
            String nome = nomes.get(i);
            if (nome.toLowerCase().replaceAll("\\s", "").contains(termo.toLowerCase().replaceAll("\\s", ""))) {
                System.out.println(nome);
                encontrado = true;
            }
        }
        return encontrado;
    }    

    public boolean alterar(String nomeAntigo, String nomeNovo) {
        for (int i = 0; i < nomes.size(); i++) {
            String nome = nomes.get(i);
            if (nome.equalsIgnoreCase(nomeAntigo)) {
                nomes.set(i, nomeNovo);
                return true;
            }
        }
        return false;
    }

    public boolean remover(String nomeExcluir) {
        for (int i = 0; i < nomes.size(); i++) {
            String nome = nomes.get(i);
            if (nome.equalsIgnoreCase(nomeExcluir)) {
                nomes.remove(i);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Exercicio02 ex02 = new Exercicio02();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Selecionar tudo");
        System.out.println("3 - Pesquisa");
        System.out.println("4 - Alterar");
        System.out.println("5 - Remover");
        System.out.println("6 - Finalizar");

        int opcao = ex02.input.nextInt();
        ex02.input.nextLine(); 

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome a ser cadastrado:");
                    String nomeCadastrar = ex02.input.nextLine();
                    if (ex02.cadastrar(nomeCadastrar)) {
                        System.out.println("Nome cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o nome (Não pode haver registros iguais)!");
                    }
                    break;

                case 2:
                    if (ex02.nomes.isEmpty()) {
                        System.out.println("Não há registros para selecionar.");
                    } else {
                        System.out.println("Registros selecionados:");
                        for (int i = 0; i < ex02.nomes.size(); i++) {
                            System.out.println(ex02.nomes.get(i));
                        }
                        /*for (String n : ex02.nomes) {
                            System.out.println(n);
                        }*/
                    }
                    break;

                case 3:
                    System.out.println("Digite o termo ao qual deseja pesquisar um nome:");
                    String termo = ex02.input.nextLine();
                    if (!ex02.buscar(termo)) {
                        System.out.println("Não foi possível encontrar nomes com esse termo!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o nome a ser alterado:");
                    String nomeAntigo = ex02.input.nextLine();
                    System.out.println("Digite o novo nome:");
                    String nomeNovo = ex02.input.nextLine();
                    if (ex02.alterar(nomeAntigo, nomeNovo)) {
                        System.out.println("Nome alterado com sucesso!");
                    } else {
                        System.out.println("Não foi possível alterar o nome!");
                    }
                    break;

                case 5:
                    System.out.println("Digite o nome a ser removido:");
                    String nomeExcluir = ex02.input.nextLine();
                    if (ex02.remover(nomeExcluir)) {
                        System.out.println("Nome removido com sucesso!");
                    } else {
                        System.out.println("Nome não removido!");
                    }
                    break;
            }

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Selecionar tudo");
            System.out.println("3 - Pesquisa");
            System.out.println("4 - Alterar");
            System.out.println("5 - Remover");
            System.out.println("6 - Finalizar");

            opcao = ex02.input.nextInt();
            ex02.input.nextLine(); // Consumes newline character
        }
        System.out.println("Programa finalizado.");
        ex02.input.close();
    }
}

/*
 * Utilizando um Vector, crie um algoritmo com as seguintes funcionalidades:
 * 
 * Cadastrar (Não poderá haver registros iguais).
 * Selecionar todos os registros.
 * Realizar uma pesquisa através de um termo (Se o nome possui A, por exemplo).
 * Alterar dados (Realize uma validação para garantir que será alterado).
 * Remoção (Realize uma validação para garantir que será removido).
 * 
 * Essa estrutura ficará em uma estrutura de repetição e poderão ser registradas
 * inúmeras informações.
 */