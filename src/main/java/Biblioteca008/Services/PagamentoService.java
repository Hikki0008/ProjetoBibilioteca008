package Biblioteca008.Services;

import Biblioteca008.Modelos.Emprestimos;
import Biblioteca008.Modelos.Pagamento;
import Biblioteca008.Repositorios.PagamentoRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PagamentoService {

    private final PagamentoRepository pagamentoRepository = new PagamentoRepository();

    // Cálculo de multa por atraso
    public double calcularMulta(Emprestimos emprestimo) {
        if (emprestimo.getDataDevolucao() == null || !emprestimo.isDevolvido()) {
            return 0.0;
        }

        // Se a devolução foi após o prazo
        long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), emprestimo.getDataDevolucao());
        if (diasAtraso > 0) {
            return diasAtraso * 5.0;
        }
        return 0.0;
    }

    // Registra o pagamento
    public void registrarPagamento(Emprestimos emprestimo) {
        // Verifica se o livro foi devolvido
        if (emprestimo.getDataDevolucao() == null || !emprestimo.isDevolvido()) {
            System.out.println("O livro ainda não foi devolvido. Não é possível registrar o pagamento.");
            return;
        }

        // Calcular a multa (caso haja atraso)
        double multa = calcularMulta(emprestimo);
        double valorTotal = multa; // Aqui podemos adicionar outros custos, caso necessário

        // Criação do pagamento
        Pagamento pagamento = new Pagamento(emprestimo.getIdEmprestimos(), LocalDate.now(), valorTotal);

        // Registrar o pagamento no banco de dados
        pagamentoRepository.salvar(pagamento);
        System.out.println("Pagamento registrado: R$ " + valorTotal);
    }
}


