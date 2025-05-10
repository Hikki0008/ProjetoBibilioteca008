package Biblioteca008.Repositorios;

import Biblioteca008.Modelos.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {

    private final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private final String usuario = "root";
    private final String senha = null; // ou null, dependendo da configuração

    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    public void salvarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, sexo, datanascimento, endereco, cpf) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSexo());
            stmt.setString(3, cliente.getDatanascimento());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarTodos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("nome"),
                        rs.getString("sexo"),
                        rs.getString("datanascimento"),
                        rs.getString("endereco"),
                        rs.getString("cpf")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                        rs.getString("nome"),
                        rs.getString("sexo"),
                        rs.getString("datanascimento"),
                        rs.getString("endereco"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, sexo = ?, datanascimento = ?, endereco = ? WHERE cpf = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getSexo());
            stmt.setString(3, cliente.getDatanascimento());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCpf());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarCliente(String cpf) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
