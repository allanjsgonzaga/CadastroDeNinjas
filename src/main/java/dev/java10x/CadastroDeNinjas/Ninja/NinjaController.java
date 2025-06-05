package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //declarar que é um controller
@RequestMapping("/ninjas")
public class NinjaController {

    //Injeção de dependência
    private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/BemVindo") //Ação de Get
    public String boasVindas() {
        return "Boas Vindas";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso:" + novoNinja.getNome() + "ID: " + novoNinja.getId());
    }

    //Procurara Ninja por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> buscarNinjaId(@PathVariable Long id) {

        NinjaDTO ninjaDTO = ninjaService.buscarNinjaId(id);

        if (ninjaDTO != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(ninjaDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: "+ id + "não encontrado");
    }

    //Mostrar todos os Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinja(@RequestBody NinjaDTO ninjaDTO, @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.atualizarNinja(ninjaDTO, id);
        if(ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: "+ id + "não encontrado");
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaId(@PathVariable Long id) {
        if (ninjaService.buscarNinjaId(id) != null) {
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja com ID: " + id + "deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID: " + id + "não encontrado");
    }
}
