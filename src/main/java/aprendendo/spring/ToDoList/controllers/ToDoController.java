package aprendendo.spring.ToDoList.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aprendendo.spring.ToDoList.entities.Task;
import aprendendo.spring.ToDoList.repositories.ToDoRepository;
import aprendendo.spring.ToDoList.utils.Response;

@RestController
public class ToDoController {
    @Autowired
    private ToDoRepository repository;

    @GetMapping("/")
    public @ResponseBody Iterable<Task> findAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<Response> addNewTask(@RequestBody Task task) {
        repository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Task Created"));
    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity<Response> deleteTask(@RequestParam int id) {
        Optional<Task> task = repository.findById(id);
        if(task.isEmpty() == false) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(String.format("Task com o id %s deletada",id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(String.format("Task com o id %s não encontrada",id)));
    }

    @PutMapping("/conclude")
    public @ResponseBody ResponseEntity<Response> concludeTask(@RequestParam int id) {
        Optional<Task> task = repository.findById(id);
        if(task.isEmpty() == false) {
            Task t = task.get();
            if(t.getConcluded() == true) {
                return ResponseEntity.status(HttpStatus.OK).body(new Response(String.format("Task com o id %s ja está concluida",id)));
            }
            t.setConcluded();
            repository.save(t);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(String.format("Task com o id %s concluida",id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response(String.format("Task com o id %s não encontrada",id)));
    } 
    
}
