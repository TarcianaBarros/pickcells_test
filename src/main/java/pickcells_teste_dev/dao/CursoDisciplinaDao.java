package pickcells_teste_dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pickcells_teste_dev.ententies.CursoDisciplina;

import java.util.List;

@Repository
public interface CursoDisciplinaDao extends JpaRepository<CursoDisciplina, Long> {

    @Query("SELECT sum(cd.credito) , c FROM CursoDisciplina cd JOIN cd.curso c where cd.obrigatoria = 1 group by c")
    public List<CursoDisciplina> findAllAgrupado();


}

