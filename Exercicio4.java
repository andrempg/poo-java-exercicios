class Autor {
    private String nome;
    private String nacionalidade;

    public Autor(String nome, String nacionalidade){
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }
}


class Livro {
    private String titulo;
    private Autor autor;
    private boolean status;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = true;
    }

    public void emprestar(){
        if (status) {
            status = false;
            System.out.println("Livro disponível!");
        } else {
            System.out.println("Livro indisponível!");
        }
    }
}


public class Exercicio4 {
    public static void main(String[] args){

        Autor autor = new Autor("André", "Brasileiro");
        Livro livro = new Livro("Lua", autor);
        livro.emprestar();
        livro.emprestar();
    }
}
