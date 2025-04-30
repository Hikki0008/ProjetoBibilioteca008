package Biblioteca008.Modelos;

public class Cliente {

    private int id;
    private String nome;
    private String sexo;
    private String cpf;
    private String datanascimento;
    private String endereco;


    public Cliente (String nome, String sexo, String cpf,String datanascimento, String endereco){

        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.endereco = endereco;


    }
        //Getters e Setters........
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDatanascimento() {
        return datanascimento;
    }
    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
