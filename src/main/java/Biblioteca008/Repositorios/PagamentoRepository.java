package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Pagamento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository {
    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String usuario = "root";
    private final String senha = "sua_senha";

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public void salvar(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos (id_emprestimos, data_pagamento, valor_pago) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getIdEmprestimos());
            stmt.setDate(2, Date.valueOf(pagamento.getDataPagamento()));
            stmt.setDouble(3, pagamento.getValorPago());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pagamento> listarTodos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        String sql = "SELECT * FROM pagamentos";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("id_emprestimos"),
                        rs.getDate("data_pagamento").toLocalDate(),
                        rs.getDouble("valor_pago")
                );
                pagamentos.add(pagamento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar os pagamentos no banco de dados.");
            System.err.println("Detalhes do erro: " + e.getMessage());
        }

        return pagamentos;
    }
}
