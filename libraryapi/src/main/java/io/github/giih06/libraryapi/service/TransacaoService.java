package io.github.giih06.libraryapi.service;

import io.github.giih06.libraryapi.model.Autor;
import io.github.giih06.libraryapi.model.GeneroLivro;
import io.github.giih06.libraryapi.model.Livro;
import io.github.giih06.libraryapi.repository.AutorRepository;
import io.github.giih06.libraryapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    // livro (titulo,..., nome_arquivo) -> id.png
    @Transactional
    public void salvarLivroComFoto() {
        // salvar o livro
        // repository.save(livro);

        // pega o id do livro = livro.getId();
        // var id = livro.getId();

        // salvar foto do livro -> bucker na nuvem
        // bucketService.salvar(livro.getFoto(), id + ".png");

        // atualizar o nome do arquivo que foi salvo
        // livro.setNomeArquivoFoto(id + ".png");
    }

    @Transactional
    public void atualizacaoSemAtualizar() {
        var livro = livroRepository
                .findById(UUID.fromString("967e2466-2bdc-427b-b959-4a561e4ab7da"))
                .orElse(null);

        livro.setDataPublicacao(LocalDate.of(2024, 9, 1));
    }

    @Transactional
    public void executaTransacao() {
        // salvam o autor
        Autor autor = new Autor();
        autor.setNome("Teste Nandinha");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1991, 12, 27));
        autorRepository.save(autor);

        // salva o livro
        Livro livro = new Livro();
        livro.setTitulo("Coding Test da NANDA");
        livro.setIsbn("32234-12144");
        livro.setPreco(BigDecimal.valueOf(69));
        livro.setGenero(GeneroLivro.CIENCIA);
        livro.setDataPublicacao(LocalDate.of(2010, 6, 21));
        livro.setAutor(autor);
        livroRepository.save(livro);

        if (autor.getNome().equals("Teste Nandinha")) {
            throw new RuntimeException("Rollback!");
        }
    }
}
