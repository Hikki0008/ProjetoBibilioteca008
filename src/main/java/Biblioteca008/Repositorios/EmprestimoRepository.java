package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Emprestimos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {
    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String usuario = "root";
    private final String senha = "sua_senha";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public void salvar(Emprestimos emp) {
        String sql = "INSERT INTO emprestimos (livro_id, cliente_id, data_emprestimo, data_devolucao, devolvido) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, emp.getIdLivro());
            stmt.setInt(2, emp.getIdCliente());
            stmt.setDate(3, Date.valueOf(emp.getDataEmprestimos()));
            stmt.setDate(4, Date.valueOf(emp.getDataDevolucao()));
            stmt.setBoolean(5, emp.isDevolvido());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Emprestimos emp) {
        String sql = "UPDATE emprestimos SET data_devolucao = ?, devolvido = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(emp.getDataDevolucao())); // Atualiza a data de devolução
            stmt.setBoolean(2, emp.isDevolvido()); // Marca como devolvido ou não
            stmt.setInt(3, emp.getIdEmprestimos()); // Identificador do empréstimo para atualização

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Emprestimos> listarTodos() {
        List<Emprestimos> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Emprestimos emp = new Emprestimos();
                emp.setIdEmprestimos(rs.getInt("id"));
                emp.setIdLivro(rs.getInt("livro_id"));
                emp.setIdCliente(rs.getInt("cliente_id"));
                emp.setDataEmprestimos(rs.getDate("data_emprestimo").toLocalDate());
                emp.setDataDevolucao(rs.getDate("data_devolucao").toLocalDate());
                emp.setDevolvido(rs.getBoolean("devolvido"));

                emprestimos.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emprestimos;
    }
}
