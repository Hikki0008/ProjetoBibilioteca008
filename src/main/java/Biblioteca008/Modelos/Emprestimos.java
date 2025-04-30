package Biblioteca008.Modelos;

public class Emprestimos {
    private int id_emprestimo;
    private int id_cliente;
    private int id_livro;
    private String dataemprestimo;
    private String datadevolucao;

    public Emprestimos (){
        this.id_emprestimo = id_emprestimo;
        this.id_cliente = id_cliente;
        this.id_livro = id_livro;
        this.dataemprestimo = dataemprestimo;
        this.datadevolucao = datadevolucao;

    }
    //Getters e Setters.....
    public int getId_emprestimo() {
        return id_emprestimo;
    }
    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public int getId_livro() {
        return id_livro;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    public String getDataemprestimo() {
        return dataemprestimo;
    }
    public void setDataemprestimo(String dataemprestimo) {
        this.dataemprestimo = dataemprestimo;
    }
    public String getDatadevolucao() {
        return datadevolucao;
    }
    public void setDatadevolucao(String datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

}
