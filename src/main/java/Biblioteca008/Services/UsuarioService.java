package Biblioteca008.Services;

import Biblioteca008.Modelos.Usuario;
import Biblioteca008.Repositorios.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository repository = new UsuarioRepository();

    public boolean autenticar(String cpf, String senha) {
        Usuario usuario = repository.buscarPorcpf(cpf);
        return usuario != null && usuario.getSenha().equals(senha);
    }
}
