package Biblioteca008.Modelos;

import javafx.beans.property.*;
import java.time.LocalDateTime;

public class HistoricoCliente {

    private final ObjectProperty<LocalDateTime> data = new SimpleObjectProperty<>();
    private final StringProperty tipo = new SimpleStringProperty();
    private final StringProperty descricao = new SimpleStringProperty();

    public HistoricoCliente(LocalDateTime data, String tipo, String descricao) {
        this.data.set(data);
        this.tipo.set(tipo);
        this.descricao.set(descricao);
    }

    // Getters padrão
    public LocalDateTime getData() {
        return data.get();
    }

    public String getTipo() {
        return tipo.get();
    }

    public String getDescricao() {
        return descricao.get();
    }

    // Setters padrão
    public void setData(LocalDateTime data) {
        this.data.set(data);
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    // Propriedades para uso com JavaFX
    public ObjectProperty<LocalDateTime> dataProperty() {
        return data;
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }
}
