package br.com.uniesp.tarefas.controller;

import br.com.uniesp.tarefas.entity.Tarefa;
import br.com.uniesp.tarefas.enuns.Status;
import br.com.uniesp.tarefas.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    private final TarefaRepository repository;

    @PostMapping
    public Tarefa salvar(@RequestBody Tarefa Tarefa) {
        return repository.save(Tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Integer id, @RequestParam Status status){
        Tarefa tarefa = repository.findById(id).orElseThrow();
        tarefa.setStatus(status);
        return repository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
