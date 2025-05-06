package Biblioteca008.Services;

import Biblioteca008.Modelos.Emprestimos;
import Biblioteca008.Modelos.HistoricoCliente;
import Biblioteca008.Modelos.Pagamento;
import Biblioteca008.Repositorios.EmprestimoRepository;
import Biblioteca008.Repositorios.LivrosRepository;
import Biblioteca008.Repositorios.PagamentoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HistoricoClienteService {

    private final EmprestimoRepository emprestimoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final LivrosRepository livrosRepository;

    public HistoricoClienteService(EmprestimoRepository emprestimoRepository,
                                   PagamentoRepository pagamentoRepository,
                                   LivrosRepository livrosRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.livrosRepository = livrosRepository;
    }

    // Método para gerar o histórico de um cliente
    public List<HistoricoCliente> gerarHistoricoDoCliente(int idCliente) {
        List<HistoricoCliente> historico = new ArrayList<>();

        // Adiciona os registros de empréstimos e devoluções
        for (Emprestimos emp : emprestimoRepository.listarTodos()) {
            if (emp.getIdCliente() == idCliente) {
                String tituloLivro = String.valueOf(livrosRepository.buscarPorId(emp.getIdLivro()));

                historico.add(new HistoricoCliente(
                        emp.getDataEmprestimos().atStartOfDay(),
                        "EMPRÉSTIMO",
                        "Livro: " + tituloLivro
                ));

                // Se o livro foi devolvido, adiciona a devolução
                if (emp.isDevolvido()) {
                    historico.add(new HistoricoCliente(
                            emp.getDataDevolucao().atStartOfDay(),
                            "DEVOLUÇÃO",
                            "Livro: " + tituloLivro
                    ));
                }
            }
        }

        // Adiciona os registros de pagamentos
        for (Pagamento pag : pagamentoRepository.listarTodos()) {
            Emprestimos emprestimo = emprestimoRepository.listarTodos().stream()
                    .filter(e -> e.getIdEmprestimos() == pag.getIdEmprestimos() && e.getIdCliente() == idCliente)
                    .findFirst()
                    .orElse(null);

            if (emprestimo != null) {
                String tituloLivro = String.valueOf(livrosRepository.buscarPorId(emprestimo.getIdLivro()));

                historico.add(new HistoricoCliente(
                        pag.getDataPagamento().atStartOfDay(),
                        "PAGAMENTO",
                        "Livro: " + tituloLivro + " - R$" + pag.getValorPago()
                ));
            }
        }

        // Ordena o histórico por data
        historico.sort(Comparator.comparing(HistoricoCliente::getData));
        return historico;
    }

    // Método para exibir o histórico do cliente
    public void mostrarHistoricoCliente(int idCliente) {
        // Chama o método gerarHistoricoDoCliente para obter o histórico
        List<HistoricoCliente> historico = gerarHistoricoDoCliente(idCliente);

        // Exibe o histórico no console
        System.out.println("Histórico do Cliente (ID: " + idCliente + "):");
        for (HistoricoCliente registro : historico) {
            System.out.println(registro.getData() + " | " + registro.getTipo() + " | " + registro.getDescricao());
        }
    }
}

