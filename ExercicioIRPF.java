import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contribuinte {
    private String nome;
    private String cpf;
    private double rendimentos;
    private double gastosDedutiveis;
    private byte dependentes;

    public Contribuinte(String nome, String cpf, double rendimentos, double gastosDedutiveis, byte dependentes){
        this.nome = nome;
        this.cpf = cpf;
        this.rendimentos = rendimentos;
        this.gastosDedutiveis = gastosDedutiveis;
        this.dependentes = dependentes;
    }

    public byte getDependentes() {
        return dependentes;
    }

    public double getRendimentos() {
        return rendimentos;
    }

    public double getGastosDedutiveis() {
        return gastosDedutiveis;
    }
}

class FaixaImposto {
    private double limiteSuperior;
    private double aliquota;
    private double parcelaDeduzir;

    public FaixaImposto(double limiteSuperior, double aliquota, double parcelaDeduzir) {
        this.limiteSuperior = limiteSuperior;
        this.aliquota = aliquota;
        this.parcelaDeduzir = parcelaDeduzir;
    }

    public double getLimiteSuperior() {
        return limiteSuperior;
    }
    public double getAliquota() {
        return aliquota;
    }
    public double getParcelaDeduzir() {
        return parcelaDeduzir;
    }
}

class TabelaProgressiva {
    private List<FaixaImposto> faixas;

    public TabelaProgressiva() {
        faixas = new ArrayList<>();
        faixas.add(new FaixaImposto(2259.20, 0.0, 0.0));           // Isento
        faixas.add(new FaixaImposto(2826.65, 0.075, 169.44));     // 7.5%
        faixas.add(new FaixaImposto(3751.05, 0.15, 381.44));      // 15%
        faixas.add(new FaixaImposto(4664.68, 0.225, 662.77));     // 22.5%
        faixas.add(new FaixaImposto(Double.MAX_VALUE, 0.275, 790.58)); // 27.5%
    }

    public FaixaImposto buscarFaixa(double baseCalculo) {
        for (FaixaImposto faixa : faixas) {
            if (baseCalculo <= faixa.getLimiteSuperior()) {
                return faixa;
            }
        }
        return faixas.getLast();
    }
}

class CalculadoraIRPF {
    public double calcularBaseCalculo(Contribuinte c){
        double valorDependentes = c.getDependentes() * 189.59;
        return c.getRendimentos() - c.getGastosDedutiveis() - valorDependentes;
    }

    public double identificarAliquota (double baseCalculo){
        if (baseCalculo <= 2259.20) {
            return 0.0;
        } else if (baseCalculo <= 2826.65) {
            return 0.075;
        } else if (baseCalculo <= 3751.05) {
            return 0.15;
        } else if (baseCalculo <= 4664.68) {
            return 0.225;
        } else {
            return 0.275;
        }
    }

    public double calcularImposto(double baseCalculo){
        TabelaProgressiva tabela = new TabelaProgressiva();
        FaixaImposto faixa = tabela.buscarFaixa(baseCalculo);
        return (baseCalculo * faixa.getAliquota()) - faixa.getParcelaDeduzir();
    }
}








public class ExercicioIRPF {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CalculadoraIRPF calc = new CalculadoraIRPF();

        System.out.println("=== Teste de Cálculo IRPF ===");
        System.out.print("Digite seu rendimento bruto mensal: ");
        double rendimentos = teclado.nextDouble();

        System.out.print("Digite seus gastos dedutíveis (Saúde/Educação/INSS): ");
        double gastos = teclado.nextDouble();

        System.out.print("Quantidade de dependentes: ");
        byte deps = teclado.nextByte();

        Contribuinte c = new Contribuinte("Teste", "123.456.789-00", rendimentos, gastos, deps);

        double base = calc.calcularBaseCalculo(c);
        double imposto = calc.calcularImposto(base);

        System.out.println("\n--- Relatório Final ---");
        System.out.printf("Base de Cálculo: R$ %.2f\n", base);

        if (imposto <= 0) {
            System.out.println("Resultado: ISENTO");
        } else {
            System.out.printf("Imposto Devido Mensal: R$ %.2f\n", imposto);
        }

        teclado.close();
    }
}

