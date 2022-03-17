package com.augusto.add.Controller;

import com.augusto.add.Entity.Aluno;
import com.augusto.add.Entity.Turma;
import com.augusto.add.Repository.AlunoRepository;
import com.augusto.add.Repository.TurmaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoRepository alunoRepository;
    private TurmaRepository turmaRepository;

    public AlunoController(AlunoRepository alunoRepository, TurmaRepository turmaRepository){
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
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
    public String carregarForm(Model model){

        List<Turma> turmas = this.turmaRepository.findAll();
        if (turmas != null && !turmas.isEmpty()){
            model.addAttribute("turmas", turmas);
        }

        return "cadastraAluno";
    }

    @PostMapping("/create")
    public String createAluno(Model model, Aluno aluno, String data_de_nascimento) throws ParseException {
        aluno.setDataDeNascimento(new SimpleDateFormat("yyyy-MM-dd").parse(data_de_nascimento));
        Aluno novoAluno = this.alunoRepository.save(aluno);
        if (novoAluno != null){
            model.addAttribute("novoAluno", novoAluno);
        }
        return "redirect:/aluno";
    }

    @DeleteMapping("/{id}")
    public String deleteAluno(Model model, @PathVariable int id){
        Aluno aluno = this.alunoRepository.getById(id);

        if (aluno != null) {
            alunoRepository.delete(aluno);
            model.addAttribute("wasDeleted", true);
        }

        return "cadastraAluno";
    }

    @PatchMapping("/update")
    public String updateAluno(Model model, @RequestBody Aluno aluno) {
        this.alunoRepository.updateAluno(aluno.getId(), aluno.getNome(), aluno.getDataDeNascimento());

        return "cadastraAluno";
    }
}
