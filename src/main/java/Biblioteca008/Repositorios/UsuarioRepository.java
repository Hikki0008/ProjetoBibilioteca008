package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Usuario;
import java.sql.*;

public class UsuarioRepository {

    private String url = "jdbc:mysql://localhost:3306/biblioteca"; // Ajuste o nome do banco
    private String user = "root"; // Ajuste conforme seu ambiente
    private String password = null; // Coloque a senha do seu MySQL

    public Usuario buscarPorcpf(String cpf) {
        String SQL = "SELECT * FROM Usuario WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String cpfEncontrado = rs.getString("cpf");
                String senha = rs.getString("senha");
                return new Usuario(cpfEncontrado, senha);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}


