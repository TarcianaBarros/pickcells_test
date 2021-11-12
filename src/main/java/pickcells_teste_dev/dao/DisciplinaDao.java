package pickcells_teste_dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pickcells_teste_dev.ententies.Disciplina;

@Repository
public interface DisciplinaDao extends JpaRepository<Disciplina, Long> {

}
