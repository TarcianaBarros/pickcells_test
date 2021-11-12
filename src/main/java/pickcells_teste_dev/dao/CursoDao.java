package pickcells_teste_dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pickcells_teste_dev.ententies.Curso;

@Repository
public interface CursoDao extends JpaRepository<Curso, Long> {

}
