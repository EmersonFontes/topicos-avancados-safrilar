package safrilar.packges.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("agricultor")
@Getter
@Setter
public class AgricultorModel extends UsuarioModel {

    @Column(name = "usua_agri_caf")
    private String cafAgricultor;

}
