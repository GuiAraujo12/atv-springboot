package biblioteca.biblioteca.Service;


import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LivroCrudPadraoService implements LivroCrudService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository livroRepository;
    
    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = modelMapper.map(livroPostPutDto, Livro.class);
        return modelMapper.map(livroRepository.save(livro), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto atualizarLivro(String isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro_ini = livroRepository.findById(isbn).orElseThrow(() -> new RuntimeException("Livro não existe"));
        modelMapper.map(livroPostPutDto, livro_ini);

        Livro livro_fim = livroRepository.save(livro_ini);
        return modelMapper.map(livro_fim, LivroResponseDto.class);
    }

    @Override
    public void removerLivro(String isbn) {
        if (!livroRepository.existsById(isbn)){
            throw new RuntimeException("Livro não existe!");
        }
        livroRepository.deleteById(isbn);
    }

    @Override
    public LivroResponseDto buscarPorIsbn(String isbn) {
        Livro livro = livroRepository.findById(isbn).orElse(null);
        
        if (livro != null) {
            return modelMapper.map(livro, LivroResponseDto.class);
        }

        return null;
    }

    @Override
    public List<LivroResponseDto> buscarPorTitulo(String titulo) {
        List<Livro> todos = livroRepository.findAll();
        List<LivroResponseDto> result = new ArrayList<>();

        for (Livro l : todos) {
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                LivroResponseDto dto = modelMapper.map(l, LivroResponseDto.class);
                result.add(dto);
            }
        }

        return result;
    }
    
}
