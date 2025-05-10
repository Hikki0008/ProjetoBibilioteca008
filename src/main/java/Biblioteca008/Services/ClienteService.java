package Biblioteca008.Services;

import Biblioteca008.Modelos.Cliente;
import Biblioteca008.Repositorios.ClienteRepository;

import java.util.List;

public class ClienteService {

    private ClienteRepository repository = new ClienteRepository();

    public void adicionarCliente(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        }
        Cliente existente = repository.buscarPorCpf(cliente.getCpf());
        if (existente == null) {
            repository.salvarCliente(cliente);
        } else {
            throw new IllegalArgumentException("Cliente já existe com o CPF fornecido.");
        }
    }

    public Cliente buscarCliente(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser nulo ou vazio.");
        }
        return repository.buscarPorCpf(cpf);
    }

    public List<Cliente> listarClientes() {
        return repository.listarTodos();
    }

    public void deletarCliente(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser nulo ou vazio.");
        }
        repository.deletarCliente(cpf);
    }
}

