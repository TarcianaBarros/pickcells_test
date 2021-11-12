package pickcells_teste_dev.ententies;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class CursoDisciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @Column(name = "CREDITO", nullable = false)
    private int credito;

    @Column(name = "OBRIGATORIA", nullable = false)
    private boolean obrigatoria;

    public CursoDisciplina() {

    }

    public CursoDisciplina(Long id, Disciplina disciplina, Curso curso, int credito, boolean obrigatoria) {
        this.id = id;
        this.disciplina = disciplina;
        this.curso = curso;
        this.credito = credito;
        this.obrigatoria = obrigatoria;
    }

    public CursoDisciplina(int credito, Disciplina disciplina) {
        this.credito = credito;
        this.disciplina = disciplina;

    }


}
