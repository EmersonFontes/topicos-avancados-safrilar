package safrilar.packges.DTOs;

import lombok.Getter;
import lombok.Setter;
import safrilar.packges.models.EnderecoModel;

@Getter
@Setter
public class EnderecoDTO {

    private Long id;
    private String cep;

    private String logradouro;
    private String numeroRua;

    private String complementoEndereco;

    //private List<CargaModel> cargas;

    public EnderecoDTO(){}

    public EnderecoDTO(EnderecoModel model){

        this.id = model.getId();
        this.cep = model.getCep();
        this.complementoEndereco = model.getComplementoEndereco();
        this.logradouro = model.getLogradouro();
        this.numeroRua = model.getNumeroRua();
    }
}
