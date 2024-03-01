package safrilar.packges.services;

import org.springframework.stereotype.Service;
import safrilar.packges.models.PagamentoModel;
import safrilar.packges.repositorys.PagamentoRepository;
import safrilar.packges.util.Util;

import java.util.List;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(final PagamentoRepository pagamentoRepository){

        this.pagamentoRepository = pagamentoRepository;
    }

    public List<PagamentoModel> listarTodosPagamentos (){
        return pagamentoRepository.findAll();
    }

    public PagamentoModel salvar (PagamentoModel pagamentoModel){

        return pagamentoRepository.save(pagamentoModel);
    }

    public PagamentoModel editar (PagamentoModel pagamentoModel) throws IllegalAccessException {

        PagamentoModel pagamento = pagamentoRepository.findById(pagamentoModel.getId()).get();

        Util.copiarCamposNaoNulos(pagamentoModel, pagamento);


        pagamento = pagamentoRepository.save(pagamento);

        return pagamento;
    }

    public PagamentoModel buscarPorId (Long id){
        return pagamentoRepository.findById(id).get();
    }

    public String deletar (Long id){

        if(pagamentoRepository.existsById(id)){

            pagamentoRepository.deleteById(id);

            return "deletado com sucesso";
        }

        return "não foi possivel deletar";
    }
}
