package io.github.mat3e.todos.importanttask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api/importants")
class ImportantServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(ImportantServlet.class);
    private ImportantRepository importantRepository;

    ImportantServlet(ImportantRepository importantRepository) {
        this.importantRepository = importantRepository;
    }

    @GetMapping
    ResponseEntity<List<ImportantTask>> findAll(){
        logger.info("Request got");
        return ResponseEntity.ok(importantRepository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<ImportantTask> toggleImportant(@PathVariable Integer id){
        var todo = importantRepository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            importantRepository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    void deleteImportants(){
        List<ImportantTask> result = importantRepository.findAll();
        for (ImportantTask task : result)
            if (task.isDone())
                importantRepository.delete(task);
    }

    @PostMapping
    ResponseEntity<ImportantTask> saveTodo(@RequestBody ImportantTask todo){
        return ResponseEntity.ok(importantRepository.save(todo));
    }
}
