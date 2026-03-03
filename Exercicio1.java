class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0 ) {
            saldo += valor;
            System.out.println("Depósito Realizado!");
        } else {
            System.out.println("Valor inválido para depósito");
        }
    }

    public void sacar(double valor) {
        if (saldo >= valor && valor > 0) {
            saldo -= valor;
            System.out.println("Saque realizado");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido!");
        }
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("12345-6", "André", 1000.0);

        conta.depositar(500);
        conta.sacar(300);
        conta.sacar(2000);

        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Saldo atual: " + conta.getSaldo());
    }
}










