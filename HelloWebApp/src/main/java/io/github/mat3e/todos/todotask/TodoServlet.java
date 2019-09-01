package io.github.mat3e.todos.todotask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);
    private TodoRepository todoRepository;

    TodoServlet(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    ResponseEntity<List<TodoTask>> findAll(){
        logger.info("Request got");
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<TodoTask> toggleImportant(@PathVariable Integer id){
        var todo = todoRepository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            todoRepository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    void deleteImportants(){
        List<TodoTask> result = todoRepository.findAll();
        for (TodoTask task : result)
            if (task.isDone())
                todoRepository.delete(task);
    }

    @PostMapping
    ResponseEntity<TodoTask> saveTodo(@RequestBody TodoTask todo){
        return ResponseEntity.ok(todoRepository.save(todo));
    }
}
