package br.com.igorfernandes.apicdc.detalhelivro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class TituloLivroUnicoValodator implements Validator {
    private LivroRepository livroRepository;

    public TituloLivroUnicoValodator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoLivroForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NovoLivroForm form = (NovoLivroForm) o;
        String titulo = form.getTitulo();

        Optional<Livro> possivelLivro = livroRepository.findByTitulo(titulo);
        if(possivelLivro.isPresent()){
            errors.rejectValue("titulo", null,"Já existe um livro com esse titulo");
        }
    }
}
