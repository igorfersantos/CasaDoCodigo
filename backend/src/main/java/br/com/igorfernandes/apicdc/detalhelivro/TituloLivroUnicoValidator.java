package br.com.igorfernandes.apicdc.detalhelivro;

import java.util.Optional;

public class TituloLivroUnicoValidator extends CampoUnicoLivroValidator {
    private LivroRepository livroRepository;

    public TituloLivroUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm) {
        return livroRepository.findByTitulo(novoLivroForm.getTitulo());
    }

    @Override
    protected String getNomeCampoInvalido() {
        return "titulo";
    }
}
