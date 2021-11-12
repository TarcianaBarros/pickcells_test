package pickcells_teste_dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pickcells_teste_dev.ententies.Curso;
import pickcells_teste_dev.services.CursoService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/buscar/{curso}")
    public ResponseEntity<Curso> find(@PathVariable("curso") Curso curso) {
        if (curso != null) {
            return ResponseEntity.ok().body(cursoService.find(curso));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Curso>> buscarTodos() {
        return ResponseEntity.ok().body(cursoService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Curso curso) throws URISyntaxException {
        cursoService.save(curso);
        return ResponseEntity.created(new URI("http://localhost:8080/curso/" + curso.getNome())).build();
    }

    @PutMapping("/change")
    public ResponseEntity<Void> change(@RequestBody Curso curso) throws URISyntaxException {
        cursoService.save(curso);
        return ResponseEntity.created(new URI("http://localhost:8080/curso/" + curso.getNome())).build();
    }

    @DeleteMapping("/delete/{curso}")
    public ResponseEntity<Void> delete(@PathVariable("curso") Curso curso) {
        if (curso != null) {
            cursoService.delete(curso);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
