package Biblioteca008.Modelos;

import java.time.LocalDate;

public class Emprestimos {
    private int idEmprestimos;
    private int idCliente;
    private int idLivro;
    private LocalDate dataEmprestimos;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimos() {
    }

    public Emprestimos(int idEmprestimos, int idCliente, int idLivro,
                       LocalDate dataEmprestimos, LocalDate dataDevolucao, boolean devolvido) {
        this.idEmprestimos = idEmprestimos;
        this.idCliente = idCliente;
        this.idLivro = idLivro;
        this.dataEmprestimos = dataEmprestimos;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

    // Getters e Setters
    public int getIdEmprestimos() {
        return idEmprestimos;
    }

    public void setIdEmprestimos(int idEmprestimos) {
        this.idEmprestimos = idEmprestimos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public LocalDate getDataEmprestimos() {
        return dataEmprestimos;
    }

    public void setDataEmprestimos(LocalDate dataEmprestimos) {
        this.dataEmprestimos = dataEmprestimos;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
