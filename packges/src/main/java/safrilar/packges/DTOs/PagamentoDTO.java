package safrilar.packges.DTOs;

import lombok.Getter;
import lombok.Setter;
import safrilar.packges.enums.StatusPagamentoEnum;
import safrilar.packges.enums.TipoPagamentoEnum;
import safrilar.packges.models.PagamentoModel;

import java.util.Date;
@Getter
@Setter
public class PagamentoDTO {

    private Long id;
    private String descricao;
    private Date dataPagamento;
    private Double valor;
    private TipoPagamentoEnum tipoPagamento;
    private StatusPagamentoEnum statusPagamento;

    public PagamentoDTO (PagamentoModel model){

        this.id = model.getId();
        this.dataPagamento = model.getDataPagamento();
        this.descricao = model.getDescricao();
        this.valor = model.getValor();
        this.statusPagamento = model.getStatusPagamento();
        this.tipoPagamento = model.getTipoPagamento();
    }

}
