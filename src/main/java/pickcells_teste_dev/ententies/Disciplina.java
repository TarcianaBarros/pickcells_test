package pickcells_teste_dev.ententies;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "DISCIPLINAS")
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "disciplina")
    private List<CursoDisciplina> cursoDisciplinas;

    public Disciplina(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
