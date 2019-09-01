package io.github.mat3e.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LangsServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(LangsServlet.class);
    private LangService service;

    LangsServlet(LangService service) {
        this.service = service;
    }

    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs(){
        logger.info("Request got");
        return ResponseEntity.ok(service.findAll());
    }
}
