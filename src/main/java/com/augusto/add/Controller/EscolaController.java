package com.augusto.add.Controller;

import com.augusto.add.Entity.Escola;
import com.augusto.add.Repository.EscolaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/escola")
public class EscolaController {
    private EscolaRepository escolaRepository;

    public EscolaController(EscolaRepository escolaRepository){
        this.escolaRepository = escolaRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Escola> escolas = this.escolaRepository.findAll();
        if (escolas != null && !escolas.isEmpty()){
            model.addAttribute("escolas", escolas);
        }
        return "listarEscolas";
    }

    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable int id){
        Escola escola = this.escolaRepository.getById(id);
        if (escola != null){
            model.addAttribute("escola", escola);
        }
        return "detalharEscola";
    }

    @GetMapping("/create")
    public String carregarForm(){
        return "cadastraEscola";
    }

    @PostMapping("/create")
    public String createEscola(Model model, @RequestBody Escola escola){
        Escola novaEscola = this.escolaRepository.save(escola);
        if (novaEscola != null){
            model.addAttribute("novaEscola", novaEscola);
        }
        return "cadastraEscola";
    }

    @DeleteMapping("/{id}")
    public String deleteEscola(Model model, @PathVariable int id){
        Escola escola = this.escolaRepository.getById(id);

        if (escola != null) {
            escolaRepository.delete(escola);
            model.addAttribute("wasDeleted", true);
        }

        return "listarEscola";
    }

    @PatchMapping("/update")
    public String updateEscola(Model model, @RequestBody Escola escola){
        this.escolaRepository.updateEscola(escola.getId(), escola.getNome(), escola.getEndereco());

        return "listarEscola";
    }
}
