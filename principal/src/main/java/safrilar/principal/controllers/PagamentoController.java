package safrilar.principal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safrilar.packges.models.PagamentoModel;
import safrilar.packges.repositorys.PagamentoRepository;
import safrilar.packges.services.PagamentoService;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {
    private final PagamentoService pagamentoService;

    public PagamentoController (final PagamentoService pagamentoService){

        this.pagamentoService = pagamentoService;
    }

    @PostMapping()
    public ResponseEntity<?> salvarAgricultor (@RequestBody PagamentoModel pagamentoModel){

        return ResponseEntity.ok(pagamentoService.salvar(pagamentoModel));

    }

    @PutMapping()
    public ResponseEntity<?> EditarAgricultor (@RequestBody PagamentoModel pagamentoModel) throws IllegalAccessException {

        return ResponseEntity.ok(pagamentoService.editar(pagamentoModel));

    }

    @GetMapping({"/id"})
    public ResponseEntity<?> buscarPorId (@PathVariable Long id){

        return ResponseEntity.ok(pagamentoService.buscarPorId(id));

    }
    @GetMapping()
    public ResponseEntity<?> listarTodos (){

        return ResponseEntity.ok(pagamentoService.listarTodosPagamentos());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (Long id){

        return ResponseEntity.ok(pagamentoService.deletar(id)) ;
    }
}
