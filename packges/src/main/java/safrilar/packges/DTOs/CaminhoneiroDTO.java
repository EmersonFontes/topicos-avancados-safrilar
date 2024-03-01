package safrilar.packges.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import safrilar.packges.models.CaminhoneiroModel;
import safrilar.packges.models.CargaModel;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CaminhoneiroDTO extends UsuarioDTO {


    private String numeroHabilitacao;

    private String placaCaminhao;

    private Double pesoCaminhao;

    private List<CargaDTO> cargas;

    public CaminhoneiroDTO(CaminhoneiroModel model){

        super(model);

        this.setId(model.getId());
        this.setNome(model.getNome());
        this.setSenha(model.getSenha());
        this.setTelefone(model.getTelefone());
        this.numeroHabilitacao = model.getNumeroHabilitacao();
        this.pesoCaminhao = model.getPesoCaminhao();
        this.placaCaminhao = model.getPlacaCaminhao();
        if(model.getCargas() != null){
            this.cargas = model.getCargas().stream().map(CargaDTO::new).collect(Collectors.toList());

        }
    }

}
