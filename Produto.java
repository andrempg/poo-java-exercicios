public class Produto {

    String nome;
    double preco;
    int quantidade;

    void adicionarEstoque(int qtd) {
        quantidade += qtd;
    }

    void removerEstoque(int qtd) {
        if (qtd <= quantidade) {
            quantidade -= qtd;
        } else {
            System.out.println("Estoque insuficiente");
        }
    }

    void mostrarProduto() {
        System.out.println("Produto: " + nome);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade: " + quantidade);
    }

    public static void main(String[] args) {

        Produto p1 = new Produto();

        p1.nome = "Notebook";
        p1.preco = 3500;
        p1.quantidade = 10;

        p1.removerEstoque(2);
        p1.adicionarEstoque(5);

        p1.mostrarProduto();
    }
}