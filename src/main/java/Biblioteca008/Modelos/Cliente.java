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

}
