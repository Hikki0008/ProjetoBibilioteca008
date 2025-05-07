package Biblioteca008.BancoDeDados;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Conexao {

        private static final String URL = "jdbc:mysql://localhost:3306/seu_banco";
        private static final String USUARIO = "root";
        private static final String SENHA = null;

        public static Connection conectar() throws SQLException {
            try {
                // Opcional a partir do JDBC 4.0, mas pode ser útil em versões antigas
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver MySQL não encontrado.");
                e.printStackTrace();
            }

            return DriverManager.getConnection(URL, USUARIO, SENHA);
        }

        public static void desconectar(Connection conn) {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Conexão fechada.");
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão.");
                    e.printStackTrace();
                }
            }
        }
    }
