package Biblioteca008.Services;

import Biblioteca008.Repositorios.ClienteRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Collection;

public class ClienteService {

    private ClienteRepository repository = new ClienteRepository();

    //Conexão com o banco........................
    //...........................................
    //...........................................

    String sql = "INSERT INTO Clientes (id, nome, email, cpf) VALUES (???)";
    try (Connection conn = DriverManager.getConnection(url,usuario, senha));

    PreparedStatement stmt = conn.prepareStatement(sql)) ;

}

