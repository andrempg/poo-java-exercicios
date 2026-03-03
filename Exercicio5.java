/* Sistema de Pagamentos com Múltiplos Métodos */

interface MetodoPagamento {
    void processar(double valor);
}

class CartaoCredito implements MetodoPagamento{
    private String numeroCartao;

    public CartaoCredito (String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void processar(double valor) {
        double total = valor * 1.05;
        System.out.println("Pagamento de R$" + total + " aprovada no cartão de num " + numeroCartao);
    }
}

class Pix implements MetodoPagamento {
    private String cpf;

    public Pix (String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void processar(double valor) {
        double total = valor * 0.95;
        System.out.println("Pagamento feito no pix " + cpf + " de R$ " + total);
    }
}

class Boleto implements MetodoPagamento {
    private String codigoBarras;

    public Boleto (String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void processar(double valor) {
        System.out.println("Pagamento feito no boleto de R$ " + valor);
    }
}

class Carrinho {
    private double valorTotal;

    public Carrinho(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public void finalizarCompra(MetodoPagamento metodo){
        metodo.processar(this.valorTotal);
    }
}


public class Exercicio5 {
    public static void main(String[] args) {
        Carrinho meuCarrinho = new Carrinho(100.00);

        System.out.println("\n Teste Cartão");
        meuCarrinho.finalizarCompra(new CartaoCredito("1234-5678"));

        System.out.println("\n Teste Pix");
        meuCarrinho.finalizarCompra(new Pix("andremurilo@email.com"));


        System.out.println("\n Boleto");
        meuCarrinho.finalizarCompra(new Boleto("1231231231"));
    }
}
