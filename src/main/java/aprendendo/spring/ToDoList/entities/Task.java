package aprendendo.spring.ToDoList.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private boolean concluded;

    public Task() {
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.concluded = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getId() {
        return id;
    }

    public boolean getConcluded() {
        return concluded;
    }

    public void setConcluded() {
        if(this.concluded == false) this.concluded = true;
    }
}
