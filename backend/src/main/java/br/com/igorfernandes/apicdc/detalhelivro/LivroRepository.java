package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends CrudRepository<Livro,Long> {
    Optional<Livro> findByIsbn(String isbn);

    Optional<Livro> findByTitulo(String titulo);
}
