package safrilar.packges.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import safrilar.packges.DTOs.PagamentoDTO;
import safrilar.packges.enums.StatusPagamentoEnum;
import safrilar.packges.enums.TipoPagamentoEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "tb_pagamento")
@Getter
@Setter
public class PagamentoModel{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pag_id")
    private Long id;

    @Column(name = "pag_descricao")
    private String descricao;

    @Column(name = "pag_data_pag")
    private Date dataPagamento;

    @Column(name = "pag_valor")
    private Double valor;

    @Column(name = "pag_tipo_pag")
    private TipoPagamentoEnum tipoPagamento;

    @Column(name = "pag_status_pag")
    private StatusPagamentoEnum statusPagamento;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "car_id")
    private CargaModel carga;

    public PagamentoModel(){}

    public PagamentoModel(PagamentoDTO pagamento){

        this.id = pagamento.getId();
        this.dataPagamento = pagamento.getDataPagamento();
        this.descricao = pagamento.getDescricao();
        this.valor = pagamento.getValor();
        this.statusPagamento = pagamento.getStatusPagamento();
        this.tipoPagamento = pagamento.getTipoPagamento();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoModel pagamento = (PagamentoModel) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
