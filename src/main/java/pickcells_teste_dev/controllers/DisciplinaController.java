package pickcells_teste_dev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pickcells_teste_dev.ententies.Disciplina;
import pickcells_teste_dev.services.DisciplinaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("/buscar/{disciplina}")
    public ResponseEntity<Disciplina> find(@PathVariable("disciplina") Disciplina disciplina) {
        if (disciplina != null) {
            return ResponseEntity.ok().body(disciplinaService.find(disciplina));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/todas")
    public ResponseEntity<List<Disciplina>> buscarTodas() {
        return ResponseEntity.ok().body(disciplinaService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody Disciplina disciplina) throws URISyntaxException {
        disciplinaService.save(disciplina);
        return ResponseEntity.created(new URI("http://localhost:8080/disciplina/" + disciplina.getNome())).build();
    }

    @PutMapping("/change")
    public ResponseEntity<Void> change(@RequestBody Disciplina disciplina) throws URISyntaxException {
        disciplinaService.save(disciplina);
        return ResponseEntity.created(new URI("http://localhost:8080/disciplina/" + disciplina.getNome())).build();
    }

    @DeleteMapping("/delete/{disciplina}")
    public ResponseEntity<Void> delete(@PathVariable("disciplina") Disciplina disciplina) {
        if (disciplina != null) {
            disciplinaService.delete(disciplina);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
