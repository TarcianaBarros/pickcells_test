package pickcells_teste_dev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pickcells_teste_dev.ententies.CursoDisciplina;
import pickcells_teste_dev.services.CursoDisciplinaService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/cursoDisciplina")
public class CursoDisciplinaController {

    @Autowired
    private CursoDisciplinaService cursoDisciplinaService;

    @GetMapping("/buscar/{cursoDisciplina}")
    public ResponseEntity<CursoDisciplina> find(@PathVariable("cursoDisciplina") CursoDisciplina cursoDisciplina) {
        if (cursoDisciplina != null) {
            return ResponseEntity.ok().body(cursoDisciplinaService.find(cursoDisciplina));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar/todas")
    public ResponseEntity<List<CursoDisciplina>> buscarTodas() {
        return ResponseEntity.ok().body(cursoDisciplinaService.findAll());
    }

    @PostMapping("/save")
    public void save(@RequestBody CursoDisciplina cursoDisciplina){
        cursoDisciplinaService.save(cursoDisciplina);
    }

    @PutMapping("/change")
    public ResponseEntity<Void> change(@RequestBody CursoDisciplina cursoDisciplina) throws URISyntaxException {
        cursoDisciplinaService.save(cursoDisciplina);
        return ResponseEntity.created(new URI("http://localhost:8080/cursodisciplina/" + cursoDisciplina.getId())).build();
    }

    @DeleteMapping("/delete/{cursoDisciplina}")
    public ResponseEntity<Void> delete(@PathVariable("cursoDisciplina") CursoDisciplina cursoDisciplina) {
        if (cursoDisciplina != null) {
            cursoDisciplinaService.delete(cursoDisciplina);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
