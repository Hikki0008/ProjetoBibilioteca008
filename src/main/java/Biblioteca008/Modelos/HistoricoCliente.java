package Biblioteca008.Modelos;

import java.time.LocalDateTime;

public class HistoricoCliente {



        private LocalDateTime data;
        private String tipo;
        private String descricao;

        public HistoricoCliente(LocalDateTime data, String tipo, String descricao) {
            this.data = data;
            this.tipo = tipo;
            this.descricao = descricao;
        }

        public LocalDateTime getData() { return data; }
        public String getTipo() { return tipo; }
        public String getDescricao() { return descricao; }
}


