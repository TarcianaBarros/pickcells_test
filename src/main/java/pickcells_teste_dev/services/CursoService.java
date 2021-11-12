package pickcells_teste_dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pickcells_teste_dev.dao.CursoDao;
import pickcells_teste_dev.ententies.Curso;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoDao cursoDao;

    public Curso find(Curso curso) {
        return cursoDao.findById(curso.getId()).get();
    }

    public List<Curso> findAll(){
        return cursoDao.findAll();
    }

    public void save(Curso curso) {
        cursoDao.save(curso);
    }

    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }


}
