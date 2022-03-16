package com.augusto.add.Controller;

import com.augusto.add.Entity.Aluno;
import com.augusto.add.Entity.Endereco;
import com.augusto.add.Repository.AlunoRepository;
import com.augusto.add.Repository.EnderecoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
    private EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    @GetMapping
    public String getAll(Model model){
        List<Endereco> enderecos = this.enderecoRepository.findAll();
        if (enderecos != null && !enderecos.isEmpty()){
            model.addAttribute("enderecos", enderecos);
        }
        return "listarEnderecos";
    }

    @GetMapping("/{id}")
    public String getOne(Model model, @PathVariable int id){
        Endereco endereco = this.enderecoRepository.getById(id);
        if (endereco != null){
            model.addAttribute("endereco", endereco);
        }
        return "detalharEndereco";
    }

    @GetMapping("/create")
    public String carregarForm(){
        return "cadastraAluno";
    }

    @PostMapping("/create")
    public String createEndereco(Model model, @RequestBody Endereco endereco){
        Endereco novoEndereco = this.enderecoRepository.save(endereco);
        if (novoEndereco != null){
            model.addAttribute("novoEndereco", novoEndereco);
        }
        return "cadastraEndereco";
    }

    @DeleteMapping("/{id}")
    public String deleteEndereco(Model model, @PathVariable int id){
        Endereco endereco = this.enderecoRepository.getById(id);

        if (endereco != null) {
            enderecoRepository.delete(endereco);
            model.addAttribute("wasDeleted", true);
        }

        return "listarEnderecos";
    }

    @PatchMapping("/update")
    public String updateAluno(Model model, @RequestBody Endereco endereco){
        this.enderecoRepository.updateEndereco(endereco.getId(), endereco.getLogradouro(), endereco.getBairro(), endereco.getCidade(), endereco.getComplemento(), endereco.getEstado());

        return "listarAlunos";
    }
}
