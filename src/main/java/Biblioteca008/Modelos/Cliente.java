package Biblioteca008.Modelos;

import javafx.beans.property.*;

public class Cliente {
    private final StringProperty nome = new SimpleStringProperty();
    private final StringProperty sexo = new SimpleStringProperty();
    private final StringProperty cpf = new SimpleStringProperty();
    private final StringProperty datanascimento = new SimpleStringProperty();
    private final StringProperty endereco = new SimpleStringProperty();

    public Cliente() {}

    public Cliente(String nome, String sexo, String cpf, String datanascimento, String endereco) {
        this.nome.set(nome);
        this.sexo.set(sexo);
        this.cpf.set(cpf);
        this.datanascimento.set(datanascimento);
        this.endereco.set(endereco);
    }

    // Propriedades (necessárias para TableView)
    public StringProperty nomeProperty() { return nome; }
    public StringProperty sexoProperty() { return sexo; }
    public StringProperty cpfProperty() { return cpf; }
    public StringProperty datanascimentoProperty() { return datanascimento; }
    public StringProperty enderecoProperty() { return endereco; }

    // Getters e setters padrão
    public String getNome() { return nome.get(); }
    public void setNome(String nome) { this.nome.set(nome); }

    public String getSexo() { return sexo.get(); }
    public void setSexo(String sexo) { this.sexo.set(sexo); }

    public String getCpf() { return cpf.get(); }
    public void setCpf(String cpf) { this.cpf.set(cpf); }

    public String getDatanascimento() { return datanascimento.get(); }
    public void setDatanascimento(String datanascimento) { this.datanascimento.set(datanascimento); }

    public String getEndereco() { return endereco.get(); }
    public void setEndereco(String endereco) { this.endereco.set(endereco); }

    @Override
    public String toString() {
        return nome.get() + " (" + cpf.get() + ")";
    }
}
