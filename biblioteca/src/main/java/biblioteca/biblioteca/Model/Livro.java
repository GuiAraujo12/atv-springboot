package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_livros")
public class Livro {

    @Id
    @Column(name = "isbn", nullable = false)
    @JsonProperty("isbn")
    private String isbn;

    @Column(name = "titulo", nullable = false)
    @JsonProperty("titulo")
    private String titulo;

    @Column(name = "ano", nullable = false)
    @JsonProperty("ano")
    private Integer ano;

    @Column(name = "edicao", nullable = false)
    @JsonProperty("edicao")
    private Integer edicao;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonProperty("autor")
    private Autor autor;
}