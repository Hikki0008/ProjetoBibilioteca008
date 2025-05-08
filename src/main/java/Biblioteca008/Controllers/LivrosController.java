package Biblioteca008.Controllers;

import Biblioteca008.Modelos.Livros;
import Biblioteca008.Services.LivrosService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LivrosController {

    @FXML private TextField campoExemplar;
    @FXML private TextField campoAutor;
    @FXML private TextField campoEdicao;
    @FXML private TextField campoAno;
    @FXML private TextField campoDisponibilidade;

    @FXML private TableView<Livros> tabelaLivros;
    @FXML private TableColumn<Livros, Integer> colId;
    @FXML private TableColumn<Livros, String> colExemplar;
    @FXML private TableColumn<Livros, String> colAutor;
    @FXML private TableColumn<Livros, Byte> colEdicao;
    @FXML private TableColumn<Livros, Short> colAno;
    @FXML private TableColumn<Livros, String> colDisponibilidade;

    private LivrosService service = new LivrosService();
    private ObservableList<Livros> livrosList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        colExemplar.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getExemplar()));
        colAutor.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getAutor()));
        colEdicao.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getEdicao()));
        colAno.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getAno()));
        colDisponibilidade.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getDisponibilidade()));

        carregarTabela();
    }

    private void carregarTabela() {
        livrosList.setAll(service.listarLivros());
        tabelaLivros.setItems(livrosList);
    }

    @FXML
    private void salvarLivro() {
        try {
            Livros livro = construirLivroDosCampos();

            service.adicionarLivro(livro);
            mostrarInfo("Livro salvo com sucesso.");
            carregarTabela();
            limparCampos();

        } catch (Exception e) {
            mostrarErro("Erro ao salvar: " + e.getMessage());
        }
    }

    @FXML
    private void atualizarLivro() {
        Livros selecionado = tabelaLivros.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarErro("Selecione um livro para atualizar.");
            return;
        }

        try {
            Livros livroAtualizado = new Livros(
                    selecionado.getId(),
                    campoExemplar.getText(),
                    campoAutor.getText(),
                    Byte.parseByte(campoEdicao.getText()),
                    Short.parseShort(campoAno.getText()),
                    campoDisponibilidade.getText()
            );

            service.atualizarLivro(livroAtualizado);
            mostrarInfo("Livro atualizado com sucesso.");
            carregarTabela();
            limparCampos();
        } catch (Exception e) {
            mostrarErro("Erro ao atualizar: " + e.getMessage());
        }
    }

    @FXML
    private void removerLivro() {
        Livros selecionado = tabelaLivros.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarErro("Selecione um livro para remover.");
            return;
        }

        try {
            service.removerLivro(selecionado.getId());
            mostrarInfo("Livro removido com sucesso.");
            carregarTabela();
            limparCampos();
        } catch (Exception e) {
            mostrarErro("Erro ao remover: " + e.getMessage());
        }
    }

    @FXML
    private void limparCampos() {
        campoExemplar.clear();
        campoAutor.clear();
        campoEdicao.clear();
        campoAno.clear();
        campoDisponibilidade.clear();
        tabelaLivros.getSelectionModel().clearSelection();
    }

    @FXML
    private void preencherCamposComSelecao() {
        Livros livro = tabelaLivros.getSelectionModel().getSelectedItem();
        if (livro != null) {
            campoExemplar.setText(livro.getExemplar());
            campoAutor.setText(livro.getAutor());
            campoEdicao.setText(String.valueOf(livro.getEdicao()));
            campoAno.setText(String.valueOf(livro.getAno()));
            campoDisponibilidade.setText(livro.getDisponibilidade());
        }
    }

    private Livros construirLivroDosCampos() {
        return new Livros(
                0, // ID será gerado automaticamente
                campoExemplar.getText(),
                campoAutor.getText(),
                Byte.parseByte(campoEdicao.getText()),
                Short.parseShort(campoAno.getText()),
                campoDisponibilidade.getText()
        );
    }

    private void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    private void mostrarInfo(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

