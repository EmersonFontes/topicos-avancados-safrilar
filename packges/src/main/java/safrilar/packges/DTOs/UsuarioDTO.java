package safrilar.packges.DTOs;


import lombok.Getter;
import lombok.Setter;
import safrilar.packges.models.UsuarioModel;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String senha;

    private String telefone;

    public UsuarioDTO (UsuarioModel model){

        this.id = model.getId();
        this.nome = model.getNome();
        this.senha = model.getSenha();
        this.telefone = model.getTelefone();


    }

}
