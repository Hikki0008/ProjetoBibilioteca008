package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Usuario;

public class UsuarioRepository {

    //Conexão com o banco de dados...
    //...............................
    //...............................

    public Usuario buscarPorcpf(String cpf) {
        String SQL = "SELECT * FROM Usuario WHERE cpf = ?" + cpf + "'";

        //try (Connection conn = DriverManager.getConnection(url, user, password);
        //     PreparedStatement stmt = conn.prepareStatement(SQL)) {
        //     stmt.setString(1, cpf);
        //     ResultSet rs = stmt.executeQuery();
        //     if (rs.next()) {
        //         String cpf = rs.getString("CPF");
        //         String senha = rs.getString("senha");
        //         return new Usuario(cpf, senha);
        //     }
        // }catch (SQLException e) {
        //      System.out.println("Erro ao buscar usuário: " + e.getMessage());
        // }
        return null; // Exemplo: sempre retorna null (substitua pela lógica real)
    }
}
