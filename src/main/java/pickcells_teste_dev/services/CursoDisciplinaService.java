package pickcells_teste_dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pickcells_teste_dev.dao.CursoDisciplinaDao;
import pickcells_teste_dev.ententies.CursoDisciplina;

import java.util.List;

@Service
public class CursoDisciplinaService {

    @Autowired
    private CursoDisciplinaDao cursoDisciplinaDao;

    public CursoDisciplina find(CursoDisciplina cursoDisciplina) {
        return cursoDisciplinaDao.findById(cursoDisciplina.getId()).get();
    }

    public List<CursoDisciplina> findAll() {
        return cursoDisciplinaDao.findAll();
    }

    public void save(CursoDisciplina cursoDisciplina) {
        cursoDisciplinaDao.save(cursoDisciplina);
    }

    public void delete(CursoDisciplina cursoDisciplina) {
        cursoDisciplinaDao.delete(cursoDisciplina);
    }




}
