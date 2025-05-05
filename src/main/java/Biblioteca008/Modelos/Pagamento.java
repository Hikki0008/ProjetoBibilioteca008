package Biblioteca008.Modelos;

import java.time.LocalDate;

public class Pagamento {
    private int idPagamento;
    private int idEmprestimos;
    private LocalDate dataPagamento;
    private double valorPago;

    public Pagamento(int idEmprestimos, LocalDate dataPagamento, double valorPago) {
        this.idEmprestimos = idEmprestimos;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }

    // Getters and setters
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdEmprestimos() {
        return idEmprestimos;
    }

    public void setIdEmprestimos(int idEmprestimos) {
        this.idEmprestimos = idEmprestimos;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
