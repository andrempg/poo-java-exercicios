import java.util.ArrayList;

class Aluno {

    private String nome;
    private String matricula;
    private ArrayList<Double> notas;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public double calcularMedia() {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        return notas.isEmpty() ? 0 : soma / notas.size();
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}

public class Exercicio2 {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("André", "1231");

        // Passando notas pelo método
        aluno.adicionarNota(8);
        aluno.adicionarNota(9);
        aluno.adicionarNota(6);

        System.out.println("Aluno: " + aluno.getNome());
        System.out.println("Média: " + aluno.calcularMedia());
    }
}

