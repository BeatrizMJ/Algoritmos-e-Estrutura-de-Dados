package Aula2;
//@autor Beatriz Moresco Joaquim
import java.util.HashMap;
import java.util.Scanner;

public class Exercicio05 {
    private HashMap<String, Aluno> alunos;
    private int aprovados;
    private int reprovados;
    Scanner input;

    public Exercicio05() {
        this.alunos = new HashMap<>();
        this.input = new Scanner(System.in);
        this.aprovados = 0; 
        this.reprovados = 0;
    }

    public void cadastrarAluno(String matricula, String nome, double nota) {
        Aluno aluno = new Aluno(nome, nota);
        alunos.put(matricula, aluno);
    }

    public Aluno selecionarAluno(String matricula) {
        return alunos.get(matricula);
    }

    public void alterarDadosAluno(String matricula, String novoNome, double novaNota) {
        Aluno aluno = alunos.get(matricula);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setNota(novaNota);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void excluirAluno(String matricula) {
        alunos.remove(matricula);
    }

    public void calcularEstatisticas() {
        aprovados = 0; 
        reprovados = 0;
        for (Aluno aluno : alunos.values()) {
            if (aluno.getNota() >= 6.0) {
                aprovados++;
            } else {
                reprovados++;
            }
        }
    }

    public static void main(String[] args) {
        Exercicio05 exercicio = new Exercicio05();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Cadastrar");
        System.out.println("2 - Selecionar aluno");
        System.out.println("3 - Alterar dados do aluno");
        System.out.println("4 - Excluir aluno");
        System.out.println("5 - Calcular estatísticas");
        System.out.println("6 - Finalizar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    System.out.println("Digite a matrícula do aluno:");
                    String matricula = scanner.nextLine();
                    System.out.println("Digite o nome do aluno:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a nota do aluno:");
                    double nota = scanner.nextDouble();
                    exercicio.cadastrarAluno(matricula, nome, nota);
                    break;

                case 2:
                    System.out.println("Digite a matrícula do aluno:");
                    matricula = scanner.nextLine();
                    Aluno alunoSelecionado = exercicio.selecionarAluno(matricula);
                    if (alunoSelecionado != null) {
                        System.out.println("Aluno encontrado:");
                        System.out.println("Nome: " + alunoSelecionado.getNome());
                        System.out.println("Nota: " + alunoSelecionado.getNota());
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("Digite a matrícula do aluno:");
                    matricula = scanner.nextLine();
                    System.out.println("Digite o novo nome do aluno:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a nova nota do aluno:");
                    nota = scanner.nextDouble();
                    exercicio.alterarDadosAluno(matricula, nome, nota);
                    break;

                case 4:
                    System.out.println("Digite a matrícula do aluno:");
                    matricula = scanner.nextLine();
                    exercicio.excluirAluno(matricula);
                    System.out.println("Aluno excluído com sucesso.");
                    break;

                case 5:
                    exercicio.calcularEstatisticas();
                    int totalAlunos = exercicio.alunos.size(); 
                    System.out.println("Total de alunos registrados: " + totalAlunos);
                    System.out.println("Total de alunos aprovados: " + exercicio.aprovados);
                    System.out.println("Total de alunos reprovados: " + exercicio.reprovados);
                    break;
            }

            System.out.println("\n1 - Cadastrar");
            System.out.println("2 - Selecionar aluno");
            System.out.println("3 - Alterar dados do aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("5 - Calcular estatísticas");
            System.out.println("6 - Finalizar");

            opcao = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}

class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
/*
 * Tema livre, utilizando HashMap. Além das funcionalidades padrões de um CRUD:
 * 
 * Cadastro.
 * Seleção.
 * Alteração.
 * Exclusão.
 * 
 * Implemente uma opção de estatísticas, retornando alguns contadores, exemplo:
 * 30 alunos registros
 * 20 aprovados
 * 10 reprovados
 */