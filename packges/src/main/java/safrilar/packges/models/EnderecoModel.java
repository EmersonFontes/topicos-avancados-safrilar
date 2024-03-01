package safrilar.packges.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import safrilar.packges.DTOs.EnderecoDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class EnderecoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "end_id")
    private Long id;

    @Column(name = "end_cep")
    private String cep;

    @Column(name = "end_logradouro")
    private String logradouro;

    @Column(name = "end_numero_rua")
    private String numeroRua;

    @Column(name = "end_complemento_end")
    private String complementoEndereco;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "endereco")
    @JsonBackReference
    private List<CargaModel> cargas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "enderecoUsuario")
    @JsonIgnore

    private List<UsuarioModel> usuarios;



    public EnderecoModel(){}

    public EnderecoModel(EnderecoDTO model){

        this.id = model.getId();
        this.cep = model.getCep();
        this.complementoEndereco = model.getComplementoEndereco();
        this.logradouro = model.getLogradouro();
        this.numeroRua = model.getNumeroRua();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoModel that = (EnderecoModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
