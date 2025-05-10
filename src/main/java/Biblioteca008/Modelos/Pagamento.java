package Biblioteca008.Modelos;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Pagamento {
    private final IntegerProperty idPagamento = new SimpleIntegerProperty();
    private final IntegerProperty idEmprestimos = new SimpleIntegerProperty();
    private final ObjectProperty<LocalDate> dataPagamento = new SimpleObjectProperty<>();
    private final DoubleProperty valorPago = new SimpleDoubleProperty();

    public Pagamento(int idEmprestimos, LocalDate dataPagamento, double valorPago) {
        this.idEmprestimos.set(idEmprestimos);
        this.dataPagamento.set(dataPagamento);
        this.valorPago.set(valorPago);
    }

    public int getIdPagamento() {
        return idPagamento.get();
    }

    public void setIdPagamento(int id) {
        this.idPagamento.set(id);
    }

    public IntegerProperty idPagamentoProperty() {
        return idPagamento;
    }

    public int getIdEmprestimos() {
        return idEmprestimos.get();
    }

    public void setIdEmprestimos(int id) {
        this.idEmprestimos.set(id);
    }

    public IntegerProperty idEmprestimosProperty() {
        return idEmprestimos;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento.get();
    }

    public void setDataPagamento(LocalDate data) {
        this.dataPagamento.set(data);
    }

    public ObjectProperty<LocalDate> dataPagamentoProperty() {
        return dataPagamento;
    }

    public double getValorPago() {
        return valorPago.get();
    }

    public void setValorPago(double valor) {
        this.valorPago.set(valor);
    }

    public DoubleProperty valorPagoProperty() {
        return valorPago;
    }
}
