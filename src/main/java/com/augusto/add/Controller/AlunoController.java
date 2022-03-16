package com.augusto.add.Controller;

import com.augusto.add.Entity.Aluno;
import com.augusto.add.Repository.AlunoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Aluno> alunos = this.alunoRepository.findAll();
        if (alunos != null && !alunos.isEmpty()){
            model.addAttribute("alunos", alunos);
        }
        return "listarAlunos";
    }

    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable int id){
        Aluno aluno = this.alunoRepository.getById(id);
        if (aluno != null){
            model.addAttribute("aluno", aluno);
        }
        return "detalharAluno";
    }

    @GetMapping("/create")
    public String carregarForm(){
        return "cadastraAluno";
    }

    @PostMapping("/create")
    public String createAluno(Model model, @RequestBody Aluno aluno){
        Aluno novoAluno = this.alunoRepository.save(aluno);
        if (novoAluno != null){
            model.addAttribute("novoAluno", novoAluno);
        }
        return "cadastraAluno";
    }

    @DeleteMapping("/{id}")
    public String deleteAluno(Model model, @PathVariable int id){
        Aluno aluno = this.alunoRepository.getById(id);

        if (aluno != null) {
            alunoRepository.delete(aluno);
            model.addAttribute("wasDeleted", true);
        }

        return "listarAlunos";
    }

    @PatchMapping("/update")
    public String updateAluno(Model model, @RequestBody Aluno aluno){
        this.alunoRepository.updateAluno(aluno.getId(), aluno.getNome(), aluno.getDataDeNascimento());

        return "listarAlunos";
    }
}
