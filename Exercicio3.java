import java.math.BigDecimal;

class Funcionario {
    private String nome;
    private BigDecimal salarioBase;

    public Funcionario(String nome, BigDecimal salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public BigDecimal calcularSalario() {
        return salarioBase;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }
}

class Gerente extends Funcionario {
    private double bonus;

    public Gerente(String nome, BigDecimal salarioBase, Double bonus) {
        super(nome, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public BigDecimal calcularSalario() {
        BigDecimal bonusValor = getSalarioBase().multiply(BigDecimal.valueOf(bonus));
        return getSalarioBase().add(bonusValor);
    }
}

class Desenvolvedor extends Funcionario {
    private double horaExtra;

    public Desenvolvedor(String nome, BigDecimal salarioBase, Double horaExtra) {
        super(nome, salarioBase);
        this.horaExtra = horaExtra;
    }

        @Override
        public BigDecimal calcularSalario() {
            return getSalarioBase().add(BigDecimal.valueOf(horaExtra));
    }
}


public class Exercicio3 {
    public static void main(String[] args) {

        Gerente gerente = new Gerente(
                "Carlos",
                new BigDecimal("5000"),
                0.10
        );

        Desenvolvedor dev = new Desenvolvedor(
                "Ana",
                new BigDecimal("4000"),
                800.0
        );

        System.out.println("Salário gerente: " + gerente.calcularSalario());
        System.out.println("Salário desenvolvedor: " + dev.calcularSalario());
    }
}
