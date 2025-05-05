package Biblioteca008.Services;

import Biblioteca008.Modelos.Emprestimos;
import Biblioteca008.Repositorios.EmprestimoRepository;
import Biblioteca008.Repositorios.LivrosRepository;
import Biblioteca008.Modelos.Livros;

import java.time.LocalDate;
import java.util.List;

public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    private final LivrosRepository livrosRepository = new LivrosRepository();

    /**
     * Registra um novo empréstimo apenas se o livro estiver disponível.
     */
    public boolean registrarEmprestimo(Emprestimos emprestimo) {
        Livros livro = livrosRepository.buscarPorId(emprestimo.getIdLivro());

        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return false;
        }

        if (!livro.getDisponibilidade().equalsIgnoreCase("DISPONIVEL")) {
            System.out.println("Livro indisponível para empréstimo.");
            return false;
        }

        // Marca o livro como emprestado
        livro.setDisponibilidade("EMPRESTADO");
        livrosRepository.atualizar(livro);

        // Registra o empréstimo
        emprestimoRepository.salvar(emprestimo);
        System.out.println("Empréstimo registrado com sucesso.");
        return true;
    }

    public void registrarDevolucao(int idEmprestimo, LocalDate dataDevolvido) {
        List<Emprestimos> emprestimos = emprestimoRepository.listarTodos();

        for (Emprestimos emp : emprestimos) {
            if (emp.getIdEmprestimos() == idEmprestimo && !emp.isDevolvido()) {
                emp.setDevolvido(true);
                emp.setDataDevolucao(dataDevolvido);
                emprestimoRepository.atualizar(emp);

                // Atualiza a disponibilidade do livro
                Livros livro = livrosRepository.buscarPorId(emp.getIdLivro());
                if (livro != null) {
                    livro.setDisponibilidade("DISPONIVEL");
                    livrosRepository.atualizar(livro);
                }

                System.out.println("Devolução registrada.");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado ou já devolvido.");
    }

    public List<Emprestimos> listarTodos() {
        return emprestimoRepository.listarTodos();
    }
}
