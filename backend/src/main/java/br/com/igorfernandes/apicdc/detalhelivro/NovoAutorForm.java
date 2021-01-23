package br.com.igorfernandes.apicdc.detalhelivro;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class NovoAutorForm {

    @NotBlank
    private String nome;
    @NotBlank
    @URL
    private String linkGithub;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLinkGithub() {
        return linkGithub;
    }

    public void setLinkGithub(String linkGithub) {
        this.linkGithub = linkGithub;
    }

    public Autor NovoAutor() {
        return new Autor(nome, linkGithub);
    }
}
