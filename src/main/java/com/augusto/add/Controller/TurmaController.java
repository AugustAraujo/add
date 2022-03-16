package com.augusto.add.Controller;

import com.augusto.add.Entity.Turma;
import com.augusto.add.Repository.TurmaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/turma")
public class TurmaController {
    private TurmaRepository turmaRepository;

    public TurmaController(TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Turma> alunos = this.turmaRepository.findAll();
        if (alunos != null && !alunos.isEmpty()){
            model.addAttribute("alunos", alunos);
        }
        return "listarTurmas";
    }


    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable int id){
        Turma turma = this.turmaRepository.getById(id);
        if (turma != null){
            model.addAttribute("aluno", turma);
        }
        return "detalharTurmas";
    }

    @GetMapping("/create")
    public String carregarForm(){
        return "cadastraTurma";
    }

    @PostMapping("/create")
    public String createTurma(Model model, @RequestBody Turma turma){
        Turma novaTurma = this.turmaRepository.save(turma);
        if (novaTurma != null){
            model.addAttribute("novoAluno", novaTurma);
        }
        return "cadastraAluno";
    }

    @DeleteMapping("/{id}")
    public String deleteTurma(Model model, @PathVariable int id){
        Turma turma = this.turmaRepository.getById(id);

        if (turma != null) {
            turmaRepository.delete(turma);
            model.addAttribute("wasDeleted", true);
        }

        return "listarTurmas";
    }

    @PatchMapping("/update")
    public String updateAluno(Model model, @RequestBody Turma turma){
        this.turmaRepository.updateTurma(turma.getId(), turma.getNome(), turma.getCapacidade());

        return "listarTurmas";
    }
}
