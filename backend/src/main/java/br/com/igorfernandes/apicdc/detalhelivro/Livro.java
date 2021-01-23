package br.com.igorfernandes.apicdc.detalhelivro;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank @Size(max = 100) String titulo;
    private @NotBlank @Size(max = 50) String subtitulo;
    private @Min(20) BigDecimal preco;
    private @NotBlank String conteudo;
    private @NotBlank String sumario;
    private @Min(100) int numeroPaginas;
    private @NotBlank String isbn;
    private @NotBlank @URL String linkCapaLivro;
    @ManyToOne
    private @NotNull Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank @Size(max = 100) String titulo,
                 @NotBlank @Size(max = 50) String subtitulo,
                 @Min(20) BigDecimal preco,
                 @NotBlank String conteudo,
                 @NotBlank String sumario,
                 @Min(100) int numeroPaginas,
                 @NotBlank String isbn,
                 @NotBlank @URL String linkCapaLivro, @NotNull Autor autor) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.preco = preco;
        this.conteudo = conteudo;
        this.sumario = sumario;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.linkCapaLivro = linkCapaLivro;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", preco=" + preco +
                ", conteudo='" + conteudo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", linkCapaLivro='" + linkCapaLivro + '\'' +
                ", autor=" + autor +
                '}';
    }
}
