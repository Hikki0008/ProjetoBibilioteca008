package Biblioteca008.Controllers;

import Biblioteca008.Modelos.HistoricoCliente;
import Biblioteca008.Repositorios.EmprestimoRepository;
import Biblioteca008.Repositorios.LivrosRepository;
import Biblioteca008.Repositorios.PagamentoRepository;
import Biblioteca008.Services.HistoricoClienteService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class HistoricoController {

    @FXML private TableView<HistoricoCliente> tableViewHistorico;
    @FXML private TableColumn<HistoricoCliente, String> colData;
    @FXML private TableColumn<HistoricoCliente, String> colTipo;
    @FXML private TableColumn<HistoricoCliente, String> colDescricao;

    private final HistoricoClienteService historicoClienteService = new HistoricoClienteService(
            new EmprestimoRepository(),
            new PagamentoRepository(),
            new LivrosRepository()
    );

    @FXML
    public void initialize() {
        configurarColunas();
        carregarHistorico(1); // Exemplo: Carregar histórico do cliente com ID 1
    }

    private void configurarColunas() {
        colData.setCellValueFactory(cellData -> {
            String dataFormatada = cellData.getValue().getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            return new javafx.beans.property.SimpleStringProperty(dataFormatada);
        });

        colTipo.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTipo()));
        colDescricao.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDescricao()));
    }

    private void carregarHistorico(int idCliente) {
        List<HistoricoCliente> historico = historicoClienteService.gerarHistoricoDoCliente(idCliente);
        ObservableList<HistoricoCliente> dados = FXCollections.observableArrayList(historico);
        tableViewHistorico.setItems(dados);
    }
    @FXML
    private void onVoltarInicio() {
        try {
            // Carrega a tela de início
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Biblioteca008/Views/inicio.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Tela de Início");
            stage.setScene(new Scene(root));
            stage.show();

            // Fecha a janela atual
            Stage janelaAtual = (Stage) tableViewHistorico.getScene().getWindow();
            janelaAtual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
