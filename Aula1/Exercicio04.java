
/*
 * Motivo da utilização da fila como estrutura de dados para esse exercício:
 * Escolhi a fila pois o padrão fila, ou queue, é uma estrutura de dados que segue o princípio "primeiro a entrar, primeiro a sair" (FIFO - First-In-First-Out).
 * Isso significa que o primeiro elemento inserido na fila será o primeiro a ser removido.
 * No caso do exercício em questão, será feito um atendimento que deverá respeitar a ordem de chegada para quem será o primeiro a ser atendido. Resumindo, o primeiro a chegar será o primeiro a ser atendido/sair. A estrutura de dados fila representa exatamente essa ordem que precisamos, por isso é a melhor escolha e por isso a escolhi.
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio04 {
    Scanner input = new Scanner(System.in);
    Queue<String> fila;

    public Exercicio04() {
        fila = new LinkedList<>();
    }

    public boolean cadastrar(String nomeCadastrar) {
        return fila.add(nomeCadastrar);
    }

    public String remover() {
        if (!fila.isEmpty()) {
            return fila.remove();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Exercicio04 ex04 = new Exercicio04();

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Remover");
        System.out.println("3 - Finalizar");

        int opcao = ex04.input.nextInt();

        while (opcao != 3) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome a ser cadastrado:");
                    String nome = ex04.input.next();
                    if (ex04.cadastrar(nome)) {
                        System.out.println("Nome cadastrado com sucesso!");
                    } else {
                        System.out.println("Não foi possível cadastrar o nome!");
                    }
                    break;

                case 2:
                    String nomeRemovido = ex04.remover();
                    if (nomeRemovido != null) {
                        System.out.println("Nome " + nomeRemovido + " removido com sucesso!");
                    } else {
                        System.out.println("A fila está vazia, não há nomes para remover.");
                    }
                    break;
            }
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Remover");
            System.out.println("3 - Finalizar");

            opcao = ex04.input.nextInt();
        }
        System.out.println("Programa finalizado.");
        ex04.input.close();
    }
}
/*
 * Escolha uma das opções de estrutura de dados: Array, Fila, Lista ou Pilha.
 * 
 * Desenvolva um sistema para atendimento (ficará em uma estrutura de
 * repetição), este projeto terá as seguintes funcionalidades:
 * 
 * Cadastrar atendimento (informe o nome da pessoa).
 * Remover (deverá remover em ordem de chegada).
 * Finalizar (encerrar o sistema).
 * 
 * No cabeçalho do projeto, utilizando comentários, explique o motivo de ter
 * utilizado determinada estrutura de dado.
 */