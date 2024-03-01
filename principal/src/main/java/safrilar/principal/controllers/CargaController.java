package safrilar.principal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safrilar.packges.DTOs.CargaDTO;
import safrilar.packges.models.CargaModel;
import safrilar.packges.services.CargaService;


import java.util.List;

@RestController
@RequestMapping(value = "/cargas")

public class CargaController {

    private final CargaService cargaService;

    public CargaController (final CargaService cargaService){

        this.cargaService = cargaService;
    }

    @PostMapping()
    public ResponseEntity<?> salvarAgricultor (@RequestBody CargaModel carga){

        return ResponseEntity.ok(cargaService.salvar(carga));

    }

    @PutMapping
    public ResponseEntity<?> alterarAgricultor(@RequestBody CargaModel carga) throws IllegalAccessException {

        return ResponseEntity.ok(cargaService.alterar(carga));
    }


    @GetMapping("/all")
    public ResponseEntity<List<CargaModel>> listaCargas (){

        return ResponseEntity.ok(cargaService.listarCargas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> cargaPorId (@PathVariable Long id){

        return ResponseEntity.ok(cargaService.cargaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar (Long id){

        return ResponseEntity.ok(cargaService.deletar(id)) ;
    }


}
