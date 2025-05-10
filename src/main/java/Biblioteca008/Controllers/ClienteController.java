package Biblioteca008.Controllers;

import Biblioteca008.Modelos.Cliente;
import Biblioteca008.Repositorios.ClienteRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ClienteController {

    @FXML private TextField campoNome;
    @FXML private TextField campoSexo;
    @FXML private TextField campoDatanascimento;
    @FXML private TextField campoEndereco;
    @FXML private TextField campoCpf;

    @FXML private TableView<Cliente> tabelaCliente;
    @FXML private TableColumn<Cliente, String> colNome;
    @FXML private TableColumn<Cliente, String> colSexo;
    @FXML private TableColumn<Cliente, String> colDatanascimento;
    @FXML private TableColumn<Cliente, String> colEndereco;
    @FXML private TableColumn<Cliente, String> colCpf;

    private final ClienteRepository clienteRepository = new ClienteRepository();
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    private Cliente clienteSelecionado;

    @FXML
    public void initialize() {
        configurarColunas();
        listarClientes();
        tabelaCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> preencherCamposComSelecao());
    }

    private void configurarColunas() {
        colNome.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNome()));
        colSexo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getSexo()));
        colDatanascimento.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDatanascimento()));
        colEndereco.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEndereco()));
        colCpf.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCpf()));
    }

    private void listarClientes() {
        try {
            clientes = FXCollections.observableArrayList(clienteRepository.listarTodos());
            tabelaCliente.setItems(clientes);
        } catch (Exception e) {
            exibirErro("Erro ao listar clientes", e.getMessage());
        }
    }

    @FXML
    public void salvarCliente() {
        try {
            Cliente cliente = new Cliente(
                    campoNome.getText(),
                    campoSexo.getText(),
                    campoDatanascimento.getText(),
                    campoEndereco.getText(),
                    campoCpf.getText()
            );

            clienteRepository.salvarCliente(cliente);
            listarClientes();
            limparCampos();
        } catch (Exception e) {
            exibirErro("Erro ao salvar cliente", e.getMessage());
        }
    }

    @FXML
    public void atualizarCliente() {
        if (clienteSelecionado != null) {
            try {
                clienteSelecionado.setNome(campoNome.getText());
                clienteSelecionado.setSexo(campoSexo.getText());
                clienteSelecionado.setDatanascimento(campoDatanascimento.getText());
                clienteSelecionado.setEndereco(campoEndereco.getText());
                clienteSelecionado.setCpf(campoCpf.getText());

                clienteRepository.atualizarCliente(clienteSelecionado);
                listarClientes();
                limparCampos();
            } catch (Exception e) {
                exibirErro("Erro ao atualizar cliente", e.getMessage());
            }
        }
    }

    @FXML
    public void deletarCliente() {
        if (clienteSelecionado != null) {
            try {
                clienteRepository.deletarCliente(clienteSelecionado.getCpf());
                listarClientes();
                limparCampos();
            } catch (Exception e) {
                exibirErro("Erro ao deletar cliente", e.getMessage());
            }
        }
    }

    @FXML
    public void limparCampos() {
        campoNome.clear();
        campoSexo.clear();
        campoDatanascimento.clear();
        campoEndereco.clear();
        campoCpf.clear();
        clienteSelecionado = null;
        tabelaCliente.getSelectionModel().clearSelection();
    }

    public void preencherCamposComSelecao() {
        clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        if (clienteSelecionado != null) {
            campoNome.setText(clienteSelecionado.getNome());
            campoSexo.setText(clienteSelecionado.getSexo());
            campoDatanascimento.setText(clienteSelecionado.getDatanascimento());
            campoEndereco.setText(clienteSelecionado.getEndereco());
            campoCpf.setText(clienteSelecionado.getCpf());
        }
    }

    private void exibirErro(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    @FXML
    private void onVoltarInicio() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Biblioteca008/Views/inicio.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Tela de Início");
            stage.setScene(new Scene(root));
            stage.show();

            // Fecha a janela atual usando um nó da interface (ex: campoNome)
            Stage janelaAtual = (Stage) campoNome.getScene().getWindow();
            janelaAtual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

