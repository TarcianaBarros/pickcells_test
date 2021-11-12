package pickcells_teste_dev;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pickcells_teste_dev.dao.CursoDisciplinaDao;
import pickcells_teste_dev.ententies.Curso;
import pickcells_teste_dev.ententies.CursoDisciplina;
import pickcells_teste_dev.ententies.Disciplina;
import pickcells_teste_dev.enums.Categoria;
import pickcells_teste_dev.services.CursoDisciplinaService;
import pickcells_teste_dev.services.CursoService;
import pickcells_teste_dev.services.DisciplinaService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GerenciadorDeCursosTeste implements CommandLineRunner {

    @Autowired
    private CursoService cursoService;
    @Autowired
    private DisciplinaService disciplinaService;
    @Autowired
    private CursoDisciplinaService cursoDisciplinaService;

    @Autowired
    private CursoDisciplinaDao cursoDisciplinaDao;

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorDeCursosTeste.class, args);

    }

    public List<Curso> cadastroCursos() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(null, "Ciência da Computação", Categoria.GRADUACAO));
        cursos.add(new Curso(null, "Sistemas de Informação", Categoria.GRADUACAO));
        cursos.add(new Curso(null, "Engenharia de Software", Categoria.MESTRADO));
        cursos.add(new Curso(null, "Inteligência Computacional", Categoria.MESTRADO));
        cursos.add(new Curso(null, "Ciência da Computação", Categoria.DOUTORADO));
        cursos.add(new Curso(null, "Inteligência Artificial", Categoria.DOUTORADO));

        for (Curso curso : cursos) {
            cursoService.save(curso);
        }

        return cursos;
    }

    public List<Disciplina> cadastroDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(null, "Algoritmos e Programação"));
        disciplinas.add(new Disciplina(null, "Matemática Computacional"));
        disciplinas.add(new Disciplina(null, "Estatística"));
        disciplinas.add(new Disciplina(null, "Empreendedorismo e Inovação"));
        disciplinas.add(new Disciplina(null, "Tópicos Avançados em Banco de Dados"));
        disciplinas.add(new Disciplina(null, "Metodologia Científica"));
        disciplinas.add(new Disciplina(null, "Tópicos Avançados em Linguagens de Programação"));

        for (Disciplina disciplina : disciplinas) {
            disciplinaService.save(disciplina);

        }

        return disciplinas;
    }

    public Curso recuperarCurso(List<Curso> cursos, String nome, Categoria categoria) {
        for (Curso curso : cursos) {
            if (curso.getNome().equals(nome) && curso.getCategoria().equals(categoria)) {
                return curso;
            }
        }
        return null;

    }

    public Disciplina recuperarDisciplina(List<Disciplina> disciplinas, String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equals(nome)) {
                return disciplina;
            }

        }
        return null;

    }

    public CursoDisciplina salvarCursoDisciplina(List<Disciplina> disciplinas, String nome_disc, List<Curso> cursos, String nome_curso, int credito, boolean obrigatoria, Categoria categoria) {
        // Recuperando curso
        Curso curso = recuperarCurso(cursos, nome_curso, categoria);

        // Recuperando disciplina
        Disciplina disciplina = recuperarDisciplina(disciplinas, nome_disc);
        CursoDisciplina cursoDisciplina = new CursoDisciplina(null, disciplina, curso, credito, obrigatoria);
        cursoDisciplinaService.save(cursoDisciplina);
        return cursoDisciplina;
    }

    @Override
    public void run(String... args) throws Exception {

        // Cadastro dos cursos
        List<Curso> cursos = cadastroCursos();

        // Cadastro das disciplinas
        List<Disciplina> disciplinas = cadastroDisciplinas();

        List<CursoDisciplina> cursoDisciplinas = new ArrayList<>();

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Ciência da Computação", 6, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Matemática Computacional", cursos, "Ciência da Computação", 4, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Ciência da Computação", 2, false, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Banco de Dados", cursos, "Ciência da Computação", 6, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Ciência da Computação", 4, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Linguagens de Programação", cursos, "Ciência da Computação", 6, false, Categoria.GRADUACAO));

        // Mudou de curso
        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Sistemas de Informação", 4, false, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Sistemas de Informação", 4, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Empreendedorismo e Inovação", cursos, "Sistemas de Informação", 4, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Banco de Dados", cursos, "Sistemas de Informação", 6, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Sistemas de Informação", 4, true, Categoria.GRADUACAO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Linguagens de Programação", cursos, "Sistemas de Informação", 4, true, Categoria.GRADUACAO));

        // Mudou de curso
        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Engenharia de Software", 4, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Matemática Computacional", cursos, "Engenharia de Software", 6, false, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Engenharia de Software", 6, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Banco de Dados", cursos, "Engenharia de Software", 4, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Engenharia de Software", 6, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Linguagens de Programação", cursos, "Engenharia de Software", 6, true, Categoria.MESTRADO));

        // Mudou de curso
        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Inteligência Computacional", 4, false, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Matemática Computacional", cursos, "Inteligência Computacional", 4, false, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Inteligência Computacional", 6, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Empreendedorismo e Inovação", cursos, "Inteligência Computacional", 6, false, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Inteligência Computacional", 6, true, Categoria.MESTRADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Linguagens de Programação", cursos, "Inteligência Computacional", 6, true, Categoria.MESTRADO));

        // Mudou de curso
        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Ciência da Computação", 6, true, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Matemática Computacional", cursos, "Ciência da Computação", 6, true, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Ciência da Computação", 4, false, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Banco de Dados", cursos, "Ciência da Computação", 4, false, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Ciência da Computação", 6, true, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Linguagens de Programação", cursos, "Ciência da Computação", 4, true, Categoria.DOUTORADO));

        // Mudou de curso
        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Algoritmos e Programação", cursos, "Inteligência Artificial", 6, true, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Matemática Computacional", cursos, "Inteligência Artificial", 4, false, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Estatística", cursos, "Inteligência Artificial", 6, false, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Empreendedorismo e Inovação", cursos, "Inteligência Artificial", 2, true, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Tópicos Avançados em Banco de Dados", cursos, "Inteligência Artificial", 2, false, Categoria.DOUTORADO));

        // Salvar relação curso vs. disciplina
        cursoDisciplinas.add(salvarCursoDisciplina(disciplinas, "Metodologia Científica", cursos, "Inteligência Artificial", 6, true, Categoria.DOUTORADO));


        System.out.println("\n#########################################################################################\n");


        //VERIFICAR MAIOR NUMERO DE CREDITOS
//        List<CursoDisciplina> x = cursoDisciplinaDao.findAllAgrupado();
//        for (CursoDisciplina y: x){
//            System.out.println(y);
//        }
        System.out.println("\n#########################################################################################\n");
        for (CursoDisciplina cursoDisciplina : cursoDisciplinas) {
            System.out.println("\nCurso: " + cursoDisciplina.getCurso().getNome() + "\nDisciplinas: " + cursoDisciplina.getDisciplina().getNome() + "\nCrédito: " + cursoDisciplina.getCredito());


        }


    }


}


