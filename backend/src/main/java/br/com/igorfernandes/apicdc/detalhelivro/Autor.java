package br.com.igorfernandes.apicdc.detalhelivro;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String nome;
    private @NotBlank @URL String linkGithub;
    @PastOrPresent
    private final LocalDate createdAt = LocalDate.now();

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank String nome, @NotBlank @URL String linkGithub) {
        this.nome = nome;
        this.linkGithub = linkGithub;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", linkGithub='" + linkGithub + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
