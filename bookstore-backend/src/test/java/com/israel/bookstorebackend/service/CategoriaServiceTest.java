package com.israel.bookstorebackend.service;

import com.israel.bookstorebackend.domain.Categoria;
import com.israel.bookstorebackend.dtos.CategoriaDTO;
import com.israel.bookstorebackend.exceptions.ObjectNotFoundException;
import com.israel.bookstorebackend.repository.CategoriaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoriaServiceTest {

    public static final String NOME = "teste";
    public static final String DESCRICAO = "descricao";
    public static final long ID = 1L;
    @InjectMocks
    private CategoriaService service;

    @Mock
    private CategoriaRepository repository;

    private Categoria categoria;

    private CategoriaDTO categoriaDTO;

    private Optional<Categoria> optionalCategoria;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCategoria();
    }

    @Test
    void whenFindByIdThenReturnAndCategoriaInstance() {
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalCategoria);

        Categoria response = service.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Categoria.class, response.getClass());
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NOME, response.getNome());
        Assertions.assertEquals(DESCRICAO, response.getDescricao());
    }

    @Test
    void whenFindByIdThenReturnAndObjectNotFoundException(){
        Mockito.when(repository.findById(Mockito.anyLong())).thenThrow(new ObjectNotFoundException("Objeto não encontrado! Id: " + ID + ", Tipo: " + Categoria.class.getName()));

        try{
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Objeto não encontrado! Id: " + ID + ", Tipo: " + Categoria.class.getName(), ex.getMessage());
        }

    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    private void startCategoria() {
        categoria = new Categoria(ID, NOME, DESCRICAO);
        categoriaDTO = new CategoriaDTO(ID, NOME, DESCRICAO);
        optionalCategoria = Optional.of(new Categoria(ID, NOME, DESCRICAO));
    }
}