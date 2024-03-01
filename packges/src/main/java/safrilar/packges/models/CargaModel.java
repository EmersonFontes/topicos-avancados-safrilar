package safrilar.packges.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import safrilar.packges.DTOs.CargaDTO;
import safrilar.packges.enums.CargaStatusEnum;
import safrilar.packges.enums.TipoCargaEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_carga")
@Getter
@Setter
public class CargaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_descricao")
    private String descricao;

    @Column(name = "car_valor")
    private Double valor;

    @Column(name = "car_data_saida")
    private Date dataSaida;

    @Column(name = "car_data_entrega")
    private Date dataEntrega;

    @Column(name = "car_peso")
    private Double peso;

    @Column(name = "car_tipo_carga")
    private TipoCargaEnum tipoCarga;

    @Column(name = "car_status_carga")
    private CargaStatusEnum statusCarga;

    @OneToMany
    @JsonIdentityReference
    private List<AgricultorModel> agricultores;

    @ManyToOne(optional = true)
    @JsonIdentityReference
    private CaminhoneiroModel caminhoneiro;

    @OneToOne
    @JsonIdentityReference
    @JoinColumn(name = "pag_id")
    private PagamentoModel pagamento;

    @ManyToOne
    @JsonIdentityReference
    private EnderecoModel endereco;

    public CargaModel(){}

    public CargaModel(CargaDTO carga){

        this.id = carga.getId();
        this.dataEntrega = carga.getDataEntrega();
        this.dataSaida = carga.getDataSaida();
        this.statusCarga = carga.getStatusCarga();
        if(carga.getPagamento() != null){
            this.pagamento = new PagamentoModel(carga.getPagamento()) ;
        }
        this.tipoCarga = carga.getTipoCarga();
        this.peso = carga.getPeso();
        this.valor = carga.getValor();
        this.descricao = carga.getDescricao();

        if(carga.getEndereco() != null){
            this.endereco = new EnderecoModel(carga.getEndereco()) ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargaModel that = (CargaModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
