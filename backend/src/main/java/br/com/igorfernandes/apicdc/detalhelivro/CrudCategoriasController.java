package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudCategoriasController {

    @Autowired
    private CategoryRepository categoryRepository;

    @InitBinder("novaCategoriaForm")
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoryRepository));
    }

    @PostMapping("/api/categoria")
    @Transactional
    public void nova(@RequestBody @Valid NovaCategoriaForm form) {
        Categoria novaCategoria = new Categoria(form.getNome());
        categoryRepository.save(novaCategoria);
    }
}
