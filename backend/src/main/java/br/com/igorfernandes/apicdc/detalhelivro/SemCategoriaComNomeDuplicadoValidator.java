package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class SemCategoriaComNomeDuplicadoValidator implements Validator {
    private CategoryRepository categoryRepository;

    public SemCategoriaComNomeDuplicadoValidator(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovaCategoriaForm form = (NovaCategoriaForm) target;
        Optional<Categoria> possivelCategoria = categoryRepository.findByNome(form.getNome());

        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null, "Já existe uma categoria com esse nome");
        }
    }
}
