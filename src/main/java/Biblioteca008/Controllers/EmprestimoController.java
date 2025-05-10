package Biblioteca008.Controllers;


import Biblioteca008.Modelos.Emprestimos;
import Biblioteca008.Services.EmprestimoService;
import Biblioteca008.Modelos.Livros;
import Biblioteca008.Repositorios.LivrosRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoController {

    @FXML private TextField campoIdLivro;
    @FXML private TextField campoIdCliente;
    @FXML private DatePicker campoDataEmprestimo;
    @FXML private DatePicker campoDataDevolucao;
    @FXML private Button btnRegistrarEmprestimo;
    @FXML private Button btnRegistrarDevolucao;
    @FXML private ListView<String> listaEmprestimos;

    private final EmprestimoService emprestimoService = new EmprestimoService();
    private final LivrosRepository livrosRepository = new LivrosRepository();

    @FXML
    public void initialize() {
        listarEmprestimos();

        btnRegistrarEmprestimo.setOnAction(event -> registrarEmprestimo());
        btnRegistrarDevolucao.setOnAction(event -> registrarDevolucao());
    }

    private void registrarEmprestimo() {
        int idLivro = Integer.parseInt(campoIdLivro.getText());
        int idCliente = Integer.parseInt(campoIdCliente.getText());
        LocalDate dataEmprestimo = campoDataEmprestimo.getValue();
        LocalDate dataDevolucao = campoDataDevolucao.getValue();

        Emprestimos emprestimo = new Emprestimos(idLivro, idCliente, dataEmprestimo, dataDevolucao, false);
        boolean sucesso = emprestimoService.registrarEmprestimo(emprestimo);

        if (sucesso) {
            listarEmprestimos();
        } else {
            exibirAlerta("Erro ao registrar empréstimo", "Livro indisponível para empréstimo.");
        }
    }

    private void registrarDevolucao() {
        try {
            int idEmprestimo = Integer.parseInt(campoIdLivro.getText());  // Supondo que você use o id do livro como ID do empréstimo
            LocalDate dataDevolucao = campoDataDevolucao.getValue();
            emprestimoService.registrarDevolucao(idEmprestimo, dataDevolucao);
            listarEmprestimos();
        } catch (Exception e) {
            exibirAlerta("Erro ao registrar devolução", "Empréstimo não encontrado.");
        }
    }

    private void listarEmprestimos() {
        List<Emprestimos> emprestimos = emprestimoService.listarTodos();
        ObservableList<String> emprestimosList = FXCollections.observableArrayList();

        for (Emprestimos emprestimo : emprestimos) {
            String texto = "ID: " + emprestimo.getIdEmprestimos() +
                    ", Livro ID: " + emprestimo.getIdLivro() +
                    ", Cliente ID: " + emprestimo.getIdCliente() +
                    ", Devolvido: " + (emprestimo.isDevolvido() ? "Sim" : "Não");
            emprestimosList.add(texto);
        }

        listaEmprestimos.setItems(emprestimosList);
    }

    private void exibirAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
