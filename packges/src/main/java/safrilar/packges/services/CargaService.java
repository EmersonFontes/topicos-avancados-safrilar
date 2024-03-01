package safrilar.packges.services;

import org.springframework.stereotype.Service;
import safrilar.packges.DTOs.CargaDTO;
import safrilar.packges.models.CargaModel;
import safrilar.packges.repositorys.CargaRepository;
import safrilar.packges.util.Util;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargaService {

    private final CargaRepository cargaRepository;

    public CargaService(final CargaRepository cargaRepository){

        this.cargaRepository = cargaRepository;
    }

    public List<CargaModel> listarCargas(){

        List<CargaModel> cargas = cargaRepository.findAll();
        return cargas;
    }

    public CargaDTO cargaPorId (Long id){

         Optional<CargaModel> carga = cargaRepository.findById(id);

         if(carga.isPresent()){
             return new CargaDTO(carga.get()) ;
         }

         return null;
    }

    public Long salvar (CargaModel parametros){

        parametros = cargaRepository.save(parametros);

        return parametros.getId();

    }

    public Long alterar (CargaModel parametros) throws IllegalAccessException {

        CargaModel carga = cargaRepository.findById(parametros.getId()).get();

        Util.copiarCamposNaoNulos(parametros,carga);

        carga = cargaRepository.save(carga);

        return carga.getId();

    }

    public String deletar (Long id){

        if(cargaRepository.existsById(id)){

            cargaRepository.deleteById(id);

            return "deletado com sucesso";
        }

        return "não foi possivel deletar";
    }
}
