package io.github.giih06.libraryapi.repository;

import io.github.giih06.libraryapi.model.Autor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Italiana");
        autor.setDataNascimento(LocalDate.of(1950, 1, 31));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);

    }
}
