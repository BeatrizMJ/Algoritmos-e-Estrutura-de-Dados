package AtividadeAvaliativa;
//@autor Beatriz Moresco Joaquim
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Unidade1 {
    private Queue<Tarefas> fila;
    static Scanner input = new Scanner(System.in);

    public Unidade1() {
        this.fila = new LinkedList<>();
    }

    public boolean addTarefas(Tarefas descricaoTarefa) {
        if (!fila.contains(descricaoTarefa)) {
            fila.add(descricaoTarefa);
            return true;
        }
        return false;
    }

    public boolean remover() {
        if (!fila.isEmpty()) {
            fila.poll(); 
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Unidade1 uni1 = new Unidade1(); 

        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Concluir tarefa");
        System.out.println("3 - Visualizar próxima tarefa");
        System.out.println("4 - Finalizar");
        int opcao = input.nextInt();

        while (opcao != 4) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite a tarefa a ser adicionada:");
                    String descricaoTarefaString = input.next();
                    Tarefas descricaoTarefa = new Tarefas(descricaoTarefaString); 

                    if (uni1.addTarefas(descricaoTarefa)) {
                        System.out.println("Tarefa adicionada com sucesso!");
                    } else {
                        System.out.println("Não foi possível adicionar a tarefa!");
                    }
                    break;

                case 2:
                    if (uni1.remover()) {
                        System.out.println("Tarefa concluída.");
                    } else {
                        System.out.println("Não há tarefas a serem concluídas.");
                    }
                    break;

                case 3:
                    if (!uni1.fila.isEmpty()) {
                        System.out.println("Próxima tarefa a ser realizada: " + uni1.fila.peek().getDescricaoTarefa());
                    } else {
                        System.out.println("Não há tarefas a serem realizadas.");
                    }
                    break;
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - -");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Concluir tarefa");
            System.out.println("3 - Visualizar próxima tarefa");
            System.out.println("4 - Finalizar");
            opcao = input.nextInt();
        }
        System.out.println("Programa finalizado.");
        input.close();
    }
}
/*
 * Você foi contratado para desenvolver um sistema de gerenciamento de tarefas
 * para uma equipe de desenvolvimento de software na linguagem Java.
 * O sistema deve permitir que os membros da equipe adicionem tarefas, removam
 * tarefas concluídas e visualizem as próximas tarefas a serem realizadas.
 * O sistema deve ser capaz de lidar com as seguintes operações:
 * Adicionar uma nova tarefa à lista.
 * Concluir uma tarefa, removendo-a da lista.
 * Visualizar a próxima tarefa a ser realizada.
 * 
 * Requisitos adicionais:
 * As tarefas devem ser armazenadas em uma estrutura de dados que permita a
 * fácil adição e remoção de elementos.
 * A visualização da próxima tarefa deve ser feita de forma eficiente, sem a
 * necessidade de percorrer toda a lista de tarefas.
 * O sistema deve ser escalável e capaz de lidar com um grande número de
 * tarefas.
 * 
 * Instruções:
 * Projete e implemente o sistema de gerenciamento de tarefas usando uma das
 * seguintes estruturas de dados: lista, fila ou pilha.
 * Ao implementar a estrutura de dados escolhida, forneça uma explicação
 * detalhada do motivo pelo qual você escolheu essa estrutura em particular
 * (crie um README para isso).
 * Teste o sistema com diferentes cenários para garantir que ele funcione
 * conforme o esperado.
 */
