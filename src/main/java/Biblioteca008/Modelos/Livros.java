package Biblioteca008.Modelos;

import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;

public class Livros {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty exemplar = new SimpleStringProperty();
    private StringProperty autor = new SimpleStringProperty();
    private IntegerProperty edicao = new SimpleIntegerProperty();
    private IntegerProperty ano = new SimpleIntegerProperty();
    private StringProperty disponibilidade = new SimpleStringProperty();

    public Livros() {}

    public Livros(int id, String exemplar, String autor, byte edicao, short ano, String disponibilidade) {
        this.id.set(id);
        this.exemplar.set(exemplar);
        this.autor.set(autor);
        this.edicao.set(edicao);
        this.ano.set(ano);
        this.disponibilidade.set(disponibilidade);
    }

    public IntegerProperty idProperty() { return id; }
    public StringProperty exemplarProperty() { return exemplar; }
    public StringProperty autorProperty() { return autor; }
    public ObservableValue<String> edicaoProperty() { return edicao; }
    public IntegerProperty anoProperty() { return ano; }
    public StringProperty disponibilidadeProperty() { return disponibilidade; }

    // Getters e setters padrões
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }

    public String getExemplar() { return exemplar.get(); }
    public void setExemplar(String exemplar) { this.exemplar.set(exemplar); }

    public String getAutor() { return autor.get(); }
    public void setAutor(String autor) { this.autor.set(autor); }

    public String getEdicao() { return edicao.get(); }
    public void setEdicao(int edicao) { this.edicao.set(edicao); }

    public int getAno() { return ano.get(); }
    public void setAno(int ano) { this.ano.set(ano); }

    public String getDisponibilidade() { return disponibilidade.get(); }
    public void setDisponibilidade(String disponibilidade) { this.disponibilidade.set(disponibilidade); }
}
