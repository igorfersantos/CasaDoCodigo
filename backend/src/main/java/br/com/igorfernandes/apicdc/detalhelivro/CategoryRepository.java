package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
