package safrilar.packges.models;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Usua_tipo_usuario")
@Getter
@Setter
public class UsuarioModel  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usua_id")
    private Long id;

    @Column(name = "usua_nome")
    private String nome;

    @Column(name = "usua_senha")
    private String senha;

    @Column(name = "usua_telefone")
    private String telefone;

    @ManyToOne(targetEntity = EnderecoModel.class)
    @JoinColumn(name = "end_id")
    private EnderecoModel enderecoUsuario;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
