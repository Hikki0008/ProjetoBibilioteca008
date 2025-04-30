package Biblioteca008.Modelos;

public class Usuario {


    private String cpf;
    private String nome;
    private String senha;

    public Usuario(String cpf, String senha) {

        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
    }

    public String getCodUsuario() {
        return cpf;
    }
    public void setCodUsuario(String codUsuario) {
        cpf = cpf;
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
