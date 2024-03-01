package safrilar.packges.DTOs;

import lombok.Getter;
import lombok.Setter;
import safrilar.packges.enums.CargaStatusEnum;
import safrilar.packges.enums.TipoCargaEnum;
import safrilar.packges.models.CargaModel;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class CargaDTO {

    private Long id;
    private String descricao;
    private Double valor;
    private Date dataSaida;
    private Date dataEntrega;
    private Double peso;
    private TipoCargaEnum tipoCarga;
    private CargaStatusEnum statusCarga;
    private PagamentoDTO pagamento;
    private EnderecoDTO endereco;
    private List<AgricultorDTO> agricultores;
    private CaminhoneiroDTO caminhoneiro;
    public CargaDTO(){}
    public CargaDTO (CargaModel model){

        super();
        this.id = model.getId();
        this.dataEntrega = model.getDataEntrega();
        this.dataSaida = model.getDataSaida();
        this.statusCarga = model.getStatusCarga();
        if(model.getPagamento() != null){
            this.pagamento = new PagamentoDTO(model.getPagamento());
        }
        if(model.getCaminhoneiro()!= null){
            this.caminhoneiro = new CaminhoneiroDTO(model.getCaminhoneiro());
        }
        this.tipoCarga = model.getTipoCarga();
        this.peso = model.getPeso();
        this.valor = model.getValor();
        this.descricao = model.getDescricao();

        if(model.getEndereco() != null){
            this.endereco = new EnderecoDTO(model.getEndereco());
        }
    }

}
