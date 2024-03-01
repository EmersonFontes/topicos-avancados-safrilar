package safrilar.principal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import safrilar.packges.models.AgricultorModel;
import safrilar.packges.models.CaminhoneiroModel;
import safrilar.packges.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController  (final UsuarioService usuarioService){
        this.usuarioService = usuarioService;

    }

    @PostMapping("/agricultor")
    public ResponseEntity<?> salvarAgricultor (@RequestBody AgricultorModel usuarioModel){

        return ResponseEntity.ok(usuarioService.salvarAgricultor(usuarioModel));

    }

    @PostMapping("/caminhoneiro")
    public ResponseEntity<?> salvarCaminhoneiro (@RequestBody CaminhoneiroModel caminhoneiro){

        return ResponseEntity.ok(usuarioService.salvarCaminhoneiro(caminhoneiro));

    }

    @PutMapping("/caminhoneiro")
    public ResponseEntity<?> alterarCaminhoneiro (@RequestBody CaminhoneiroModel caminhoneiro) throws IllegalAccessException {

        return ResponseEntity.ok(usuarioService.editarCaminhoneiro(caminhoneiro));

    }

    @PutMapping("/agricultor")
    public ResponseEntity<?> alterarAgricultor (@RequestBody AgricultorModel agricultor) throws IllegalAccessException {

        return ResponseEntity.ok(usuarioService.editarAgricultor(agricultor));

    }

    @GetMapping("/caminhoneiro")
    public ResponseEntity<?> listarTodosCaminhoneiro (){

        return ResponseEntity.ok(usuarioService.listarTodosCaminhoneiros());

    }

    @GetMapping("/agricultor")
    public ResponseEntity<?> listarTodosAgricultores (){

        return ResponseEntity.ok(usuarioService.listarTodosAgricultores());

    }

    @DeleteMapping("/caminhoneiro/{id}")
    public ResponseEntity<?> deletarCaminhoneiro (Long id){

        return ResponseEntity.ok(usuarioService.deletarCaminhoneiro(id)) ;
    }

    @DeleteMapping("/agricultor/{id}")
    public ResponseEntity<?> deletarAgricultor (Long id){

        return ResponseEntity.ok(usuarioService.deletarAgricultor(id)) ;
    }
}
