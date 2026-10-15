package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    LivroResponseDto atualizarLivro(String isbn, LivroPostPutDto livroPostPutDto);

    void removerLivro(String isbn);

    LivroResponseDto buscarPorIsbn(String isbn);

    List<LivroResponseDto> buscarPorTitulo(String titulo);
}
