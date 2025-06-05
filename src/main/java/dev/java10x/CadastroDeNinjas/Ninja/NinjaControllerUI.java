package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUI {

    private final NinjaService ninjaService;

    public NinjaControllerUI(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public String listarNinjas(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
        //tem que retornar o nome da página que renderiza
    }

    @GetMapping("/listar/{id}")
    public String buscarNinjaId(@PathVariable Long id, Model model) {

        NinjaDTO ninja = ninjaService.buscarNinjaId(id);

        if (ninja != null) {
            model.addAttribute("ninja", ninja);
            return "detalhesNinjas";
        }
        model.addAttribute("mensagem", "Ninjas não encontrado");
        return "listarNinjas";
    }

    @PostMapping("/criar")
    public String criarNinja(@ModelAttribute NinjaDTO ninjaDTO, Model model) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        model.addAttribute("ninja", novoNinja);  // Adiciona o ninja ao modelo
        return "redirect:/ninjas/ui/listar";  // Redireciona para a página de listagem de ninjas
    }

    @GetMapping("/deletar/{id}")
    public String deletarNinjaId(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
        return "redirect:/ninjas/ui/listar";
    }


    @GetMapping("/exibirformulario")
    public String exibirFormulario() {
        return "salvarNinjas";
    }



}
