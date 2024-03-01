package safrilar.packges.services;

import org.springframework.stereotype.Service;
import safrilar.packges.models.EnderecoModel;
import safrilar.packges.repositorys.EnderecoRepository;
import safrilar.packges.util.Util;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService (final EnderecoRepository enderecoRepository){

        this.enderecoRepository = enderecoRepository;
    }

    public Long salvar(EnderecoModel parametros){

        enderecoRepository.save(parametros);

        return parametros.getId();
    }

    public Long editar(EnderecoModel parametros) throws IllegalAccessException {

        EnderecoModel endereco = enderecoRepository.findById(parametros.getId()).get();

        Util.copiarCamposNaoNulos(parametros,endereco);

        endereco = enderecoRepository.save(endereco);

        return endereco.getId();
    }

    public List<EnderecoModel> listarTodos (){

        return enderecoRepository.findAll();
    }

    public EnderecoModel enderecoPorCep(String cep){

        return enderecoRepository.findEnderecoModelByCep(cep);

    }

    public EnderecoModel enderecoPorId(Long id){

        return enderecoRepository.findById(id).get();
    }

    public String deletar (Long id){

        if(enderecoRepository.existsById(id)){

            enderecoRepository.deleteById(id);

            return "deletado com sucesso";
        }

        return "não foi possivel deletar";
    }
}
