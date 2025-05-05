package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Livros;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável apenas pelas operações de banco de dados (DAO).
 * Cada método executa uma query específica.
 */
public class LivrosRepository {

    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String usuario = "root";
    private final String senha = "sua_senha";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public void salvar(Livros livro) {
        String sql = "INSERT INTO livros (id, exemplar, autor, edicao, ano, disponibilidade) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, livro.getId());
            stmt.setString(2, livro.getExemplar());
            stmt.setString(3, livro.getAutor());
            stmt.setByte(4, livro.getEdicao());
            stmt.setShort(5, livro.getAno());
            stmt.setString(6, livro.getDisponibilidade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar livro: " + e.getMessage(), e);
        }
    }

    public Livros buscarPorId(int id) {
        String sql = "SELECT * FROM livros WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Livros(
                        rs.getInt("id"),
                        rs.getString("exemplar"),
                        rs.getString("autor"),
                        rs.getByte("edicao"),
                        rs.getShort("ano"),
                        rs.getString("disponibilidade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Livros> listarTodos() {
        List<Livros> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                livros.add(new Livros(
                        rs.getInt("id"),
                        rs.getString("exemplar"),
                        rs.getString("autor"),
                        rs.getByte("edicao"),
                        rs.getShort("ano"),
                        rs.getString("disponibilidade")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public void atualizar(Livros livro) {
        String sql = "UPDATE livros SET exemplar = ?, autor = ?, edicao = ?, ano = ?, disponibilidade = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getExemplar());
            stmt.setString(2, livro.getAutor());
            stmt.setByte(3, livro.getEdicao());
            stmt.setShort(4, livro.getAno());
            stmt.setString(5, livro.getDisponibilidade());
            stmt.setInt(6, livro.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM livros WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
