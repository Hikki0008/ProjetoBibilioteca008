package Biblioteca008.Services;

import Biblioteca008.Modelos.Cliente;
import Biblioteca008.Repositorios.ClienteRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.List;

public class ClienteService {

    private ClienteRepository repository = new ClienteRepository();

    public void AdicionarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        Cliente existente = repository.buscarPorcpf(cliente.getCpf());
        if (existente == null) {
            repository.salvarcliente(cliente);
        } else {
            throw new IllegalArgumentException("Cliente já existe com o CPF fornecido.");
        }
    }


    public Cliente buscarCliente(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("O CPF não pode ser nulo.");
        }else {
            return repository.buscarPorcpf(cpf);
        }
    }
    public List<Cliente> listarClientes() {
        return repository.ListarTodos();

    }

    public void deletarCliente(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("O CPF não pode ser nulo.");
        }
        repository.deletarCliente(cpf);
    }
}
