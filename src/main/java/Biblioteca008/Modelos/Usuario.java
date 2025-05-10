package Biblioteca008.Modelos;

public class Usuario {

    private String cpf;
    private String nome;
    private String senha;

    // Construtor completo
    public Usuario(String cpf, String nome, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
    }

    // Construtor alternativo (caso venha só com CPF e senha)
    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
