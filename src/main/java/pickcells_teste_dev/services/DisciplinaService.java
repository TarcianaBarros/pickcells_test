package pickcells_teste_dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pickcells_teste_dev.dao.DisciplinaDao;
import pickcells_teste_dev.ententies.Disciplina;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaDao disciplinaDao;

    public Disciplina find(Disciplina disciplina) {
        return disciplinaDao.findById(disciplina.getId()).get();
    }

    public List<Disciplina> findAll() {
        return disciplinaDao.findAll();
    }

    public void save(Disciplina disciplina) {
        disciplinaDao.save(disciplina);
    }

    public void delete(Disciplina disciplina) {
        disciplinaDao.delete(disciplina);
    }


}
