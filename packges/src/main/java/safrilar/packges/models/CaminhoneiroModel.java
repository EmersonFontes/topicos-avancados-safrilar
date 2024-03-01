package safrilar.packges.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("caminhoneiro")
@Getter
@Setter
public class CaminhoneiroModel extends UsuarioModel {

    @Column(name = "usua_cam_numero_hab")
    private String numeroHabilitacao;

    @Column(name = "usua_cam_placa_cam")
    private String placaCaminhao;

    @Column(name = "usua_cam_peso_cam")
    private Double pesoCaminhao;

    @OneToMany(mappedBy = "caminhoneiro")
    @JsonBackReference
    private List<CargaModel> cargas;


}
