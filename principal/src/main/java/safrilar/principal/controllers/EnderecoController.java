package safrilar.principal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safrilar.packges.models.EnderecoModel;
import safrilar.packges.services.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {


    private final EnderecoService enderecoService;

    public EnderecoController(final EnderecoService enderecoService){

        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<?> salvar (@RequestBody EnderecoModel parametros){

        return ResponseEntity.ok(enderecoService.salvar(parametros));
    }

    @PutMapping
    public ResponseEntity<?> editar (@RequestBody EnderecoModel parametros) throws IllegalAccessException {

        return ResponseEntity.ok(enderecoService.editar(parametros));
    }

    @GetMapping
    public ResponseEntity<?> listarTodos(){

        return ResponseEntity.ok(enderecoService.listarTodos());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<?> enderecoPorId (@PathVariable Long id){

        return  ResponseEntity.ok(enderecoService.enderecoPorId(id)) ;
    }

    @GetMapping({"/cep"})
    public ResponseEntity<?> listarTodos(@RequestParam String cep){

        return ResponseEntity.ok(enderecoService.enderecoPorCep(cep));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (Long id){

        return ResponseEntity.ok(enderecoService.deletar(id)) ;
    }
}
