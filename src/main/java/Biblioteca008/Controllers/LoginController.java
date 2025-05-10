package Biblioteca008.Controllers;

import Biblioteca008.Services.UsuarioService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private Label labelMensagem;

    private UsuarioService loginService = new UsuarioService();

    @FXML
    private void onLoginClick() {
        String usuario = campoUsuario.getText();
        String senha = campoSenha.getText();

        if (usuario.isEmpty() || senha.isEmpty()) {
            labelMensagem.setText("Por favor, preencha ambos os campos.");
            return;
        }

        boolean autenticado = false;
        try {
            autenticado = loginService.autenticar(usuario, senha);
        } catch (Exception e) {
            labelMensagem.setText("Erro ao autenticar.");
            e.printStackTrace();
            return;
        }

        if (autenticado) {
            labelMensagem.setText("Login realizado com sucesso!");
                abrirTelaInicio();
            } else {
            labelMensagem.setText("Usuário ou senha inválidos.");
        }
    }

    @FXML
    private void onCancelClick() {
        System.exit(0);
    }
    private void abrirTelaInicio() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("/Biblioteca008/Views/inicio.fxml"));
            javafx.scene.Parent root = loader.load();
            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Tela de Início");
            stage.setScene(scene);
            stage.show();

            // Fecha a tela de login
            ((javafx.stage.Stage) campoUsuario.getScene().getWindow()).close();

        } catch (Exception e) {
            e.printStackTrace();
            labelMensagem.setText("Erro ao abrir tela de início.");
        }
    }

}


