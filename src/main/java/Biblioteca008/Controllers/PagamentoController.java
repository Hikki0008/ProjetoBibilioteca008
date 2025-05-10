package Biblioteca008.Controllers;

import Biblioteca008.Modelos.Emprestimos;
import Biblioteca008.Services.PagamentoService;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.time.LocalDate;

public class PagamentoController {

    @FXML
    private TextField campoIdEmprestimo;

    @FXML
    private Label mensagemLabel;

    private final PagamentoService pagamentoService = new PagamentoService();

    @FXML
    private void onRegistrarPagamento() {
        try {
            int idEmprestimo = Integer.parseInt(campoIdEmprestimo.getText());

            // Mock do empréstimo (em app real, busque do banco)
            Emprestimos emprestimo = new Emprestimos();
            emprestimo.setIdEmprestimos(idEmprestimo);
            emprestimo.setDevolvido(true);
            emprestimo.setDataDevolucao(LocalDate.now());
            emprestimo.setDataPrevistaDevolucao(LocalDate.now().minusDays(3)); // Simula atraso

            pagamentoService.registrarPagamento(emprestimo);
            mensagemLabel.setText("Pagamento registrado com sucesso!");

        } catch (NumberFormatException e) {
            mensagemLabel.setText("ID do empréstimo inválido.");
        } catch (Exception e) {
            mensagemLabel.setText("Erro ao registrar pagamento.");
            e.printStackTrace();
        }
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

            // Fecha janela atual
            ((Stage) campoIdEmprestimo.getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
