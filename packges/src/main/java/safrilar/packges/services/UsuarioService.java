package safrilar.packges.services;

import org.springframework.stereotype.Service;
import safrilar.packges.models.AgricultorModel;
import safrilar.packges.models.CaminhoneiroModel;
import safrilar.packges.repositorys.AgricultorRepository;
import safrilar.packges.repositorys.CaminhoneiroRepository;
import safrilar.packges.util.Util;

import java.util.List;

@Service
public class UsuarioService {

    private final AgricultorRepository agricultorRepository;

    private final CaminhoneiroRepository caminhoneiroRepository;

    public UsuarioService(final AgricultorRepository agricultorRepository,
                          final CaminhoneiroRepository caminhoneiroRepository){

        this.agricultorRepository = agricultorRepository;
        this.caminhoneiroRepository = caminhoneiroRepository;

    }
    public AgricultorModel salvarAgricultor (AgricultorModel agricultorModel) {

        agricultorRepository.save(agricultorModel);

        return agricultorModel;
    }

    public AgricultorModel editarAgricultor (AgricultorModel agricultorModel) throws IllegalAccessException {

        AgricultorModel agricultor = agricultorRepository.findById(agricultorModel.getId()).get();


        agricultor.setCafAgricultor(agricultorModel.getCafAgricultor());
        agricultor.setEnderecoUsuario(agricultorModel.getEnderecoUsuario());
        agricultor.setNome(agricultorModel.getNome());
        agricultor.setSenha(agricultorModel.getSenha());
        agricultor.setTelefone(agricultorModel.getTelefone());

        return agricultor;
    }

    public CaminhoneiroModel editarCaminhoneiro (CaminhoneiroModel caminhoneiroModel) throws IllegalAccessException {

        CaminhoneiroModel caminhoneiro = caminhoneiroRepository.findById(caminhoneiroModel.getId()).get();

        caminhoneiro.setEnderecoUsuario(caminhoneiroModel.getEnderecoUsuario());
        caminhoneiro.setNome(caminhoneiroModel.getNome());
        caminhoneiro.setSenha(caminhoneiroModel.getSenha());
        caminhoneiro.setTelefone(caminhoneiroModel.getTelefone());
        caminhoneiro.setCargas(caminhoneiroModel.getCargas());
        caminhoneiro.setNumeroHabilitacao(caminhoneiroModel.getNumeroHabilitacao());
        caminhoneiro.setPesoCaminhao(caminhoneiroModel.getPesoCaminhao());
        caminhoneiro.setPlacaCaminhao(caminhoneiroModel.getPlacaCaminhao());

        caminhoneiro = caminhoneiroRepository.save(caminhoneiro);

        return caminhoneiro;
    }

    public CaminhoneiroModel salvarCaminhoneiro (CaminhoneiroModel caminhoneiroModel){

        caminhoneiroRepository.save(caminhoneiroModel);

        return caminhoneiroModel;
    }

    public List<CaminhoneiroModel> listarTodosCaminhoneiros (){

        List<CaminhoneiroModel> lista = caminhoneiroRepository.findAll();

        return lista;
    }

    public List<AgricultorModel> listarTodosAgricultores (){

        List<AgricultorModel> lista = agricultorRepository.findAll();

        return lista;
    }

    public String deletarCaminhoneiro (Long id){

        if(caminhoneiroRepository.existsById(id)){

            caminhoneiroRepository.deleteById(id);

            return "deletado com sucesso";
        }

        return "não foi possivel deletar";
    }

    public String deletarAgricultor (Long id){

        if(agricultorRepository.existsById(id)){

            agricultorRepository.deleteById(id);

            return "deletado com sucesso";
        }

        return "não foi possivel deletar";
    }

}
