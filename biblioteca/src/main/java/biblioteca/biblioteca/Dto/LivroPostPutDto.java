package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    
    @JsonProperty("isbn")
    @NotBlank(message = "O ISBN do livro não pode ser vazio")
    private String isbn;

    @JsonProperty("titulo")
    @NotBlank(message = "O título do livro não pode ser vazio")
    private String titulo;

    @JsonProperty("ano")
    @NotNull(message = "O ano do livro não pode ser nulo")
    private Integer ano;

    @JsonProperty("edicao")
    @NotNull(message = "A edição do livro não pode ser nula")
    private Integer edicao;

    @JsonProperty("autorId")
    @NotNull(message = "O ID do autor não pode ser nulo")
    private Long autorId;
}