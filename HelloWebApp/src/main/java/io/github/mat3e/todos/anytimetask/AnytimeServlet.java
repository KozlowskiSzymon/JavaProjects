package io.github.mat3e.todos.anytimetask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api/anytimes")
class AnytimeServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(AnytimeServlet.class);
    private AnytimeRepository anytimeRepository;

    AnytimeServlet(AnytimeRepository repository) {
        this.anytimeRepository = repository;
    }

    @GetMapping
    ResponseEntity<List<AnytimeTask>> findAll(){
        logger.info("Request got");
        return ResponseEntity.ok(anytimeRepository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<AnytimeTask> toggleImportant(@PathVariable Integer id){
        var todo = anytimeRepository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            anytimeRepository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    void deleteImportants(){
        List<AnytimeTask> result = anytimeRepository.findAll();
        for (AnytimeTask task : result)
            if (task.isDone())
                anytimeRepository.delete(task);
    }

    @PostMapping
    ResponseEntity<AnytimeTask> saveTodo(@RequestBody AnytimeTask todo){
        return ResponseEntity.ok(anytimeRepository.save(todo));
    }
}
