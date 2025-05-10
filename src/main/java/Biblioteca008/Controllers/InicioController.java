package Biblioteca008.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


    public class InicioController {

        @FXML
        private Button buttonLivros;
        @FXML
        private Button buttonUsuarios;
        @FXML
        private Button buttonEmprestimos;
        @FXML
        private Button buttonPagamento;
        @FXML
        private Button buttonCliente;

        @FXML
        public void initialize() {
            // Adicionando ações aos botões
            buttonLivros.setOnAction(event -> abrirTelaLivros());
            buttonUsuarios.setOnAction(event -> abrirTelaUsuarios());
            buttonEmprestimos.setOnAction(event -> abrirTelaEmprestimos());
            buttonPagamento.setOnAction(event -> abrirTelaPagamento());
            buttonCliente.setOnAction(event -> abrirTelaCliente());
        }

        private void abrirTelaLivros() {
            carregarTela("Livros");
        }

        private void abrirTelaUsuarios() {
            carregarTela("Usuarios");
        }

        private void abrirTelaEmprestimos() {
            carregarTela("Emprestimos");
        }

        private void abrirTelaPagamento() {
            carregarTela("Pagamento");
        }

        private void abrirTelaCliente() {
            carregarTela("Cliente");
        }

        private void carregarTela(String nomeTela) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/views/" + nomeTela + ".fxml"));
                Parent root = loader.load();

                // Cria uma nova cena e exibe
                Stage stage = (Stage) buttonLivros.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                // Exibir mensagem de erro ou alerta caso haja problema no carregamento da tela
            }
        }
    }
