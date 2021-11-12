package pickcells_teste_dev.ententies;


import lombok.AllArgsConstructor;
import lombok.Data;
import pickcells_teste_dev.enums.Categoria;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "CATEGORIA", nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @OneToMany(mappedBy = "curso")
    private List<CursoDisciplina> cursoDisciplinas;

    public Curso() {

    }

    public Curso(Long id, String nome, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return getId().equals(curso.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}



