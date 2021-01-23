package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public abstract class CampoUnicoLivroValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    public abstract Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm);

    @Override
    public void validate(Object target, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) target;

        Optional<Livro> possivelLivro = buscaLivroPorCampo(form);

        if(possivelLivro.isPresent()){
            String nomeCampoInvalido = getNomeCampoInvalido();
            errors.rejectValue(nomeCampoInvalido, null,nomeCampoInvalido + ": Já existe um livro igual cadastrado");
        }
    }

    protected abstract String getNomeCampoInvalido();
}
