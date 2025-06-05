package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController diz que é uma rota para a API
@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }


    @PostMapping("/criar")
    public MissaoModel criarMissao(@RequestBody MissaoModel missaoModel) {
        return missoesService.criarMissao(missaoModel);
    }

    @PutMapping("/alterarID")
    public String alterarMissao() {
        return "Alterado com sucesso!";
    }

    @GetMapping("/listar")
    public List<MissaoModel> mostrarTodasMissoes() {
        return missoesService.listarMissoes();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel buscarMissaoPorId(@PathVariable Long id) {
        return missoesService.buscarMissaoPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deleteMissao(id);
    }


}
