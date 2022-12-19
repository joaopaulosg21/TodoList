package aprendendo.spring.ToDoList.repositories;

import org.springframework.data.repository.CrudRepository;

import aprendendo.spring.ToDoList.entities.Task;

public interface ToDoRepository extends CrudRepository<Task,Integer>{
    
}
