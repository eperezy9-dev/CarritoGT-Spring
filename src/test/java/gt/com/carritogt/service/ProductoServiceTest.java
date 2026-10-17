package gt.com.carritogt.service;

import gt.com.carritogt.model.Producto;
import gt.com.carritogt.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoService productoService;

    @Test
    void listarProductosDebeRetornarLaLista() {
        List<Producto> productos = List.of(
                new Producto(),
                new Producto()
        );

        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = productoService.listarProductos();

        assertEquals(2, resultado.size());
        verify(productoRepository).findAll();
    }

    @Test
    void obtenerProductoPorIdDebeRetornarProductoExistente() {
        Producto producto = new Producto();

        when(productoRepository.findById(1))
                .thenReturn(Optional.of(producto));

        Optional<Producto> resultado =
                productoService.obtenerProductoPorId(1);

        assertTrue(resultado.isPresent());
        assertSame(producto, resultado.get());
    }

    @Test
    void obtenerProductoPorIdDebeRetornarVacioSiNoExiste() {
        when(productoRepository.findById(99))
                .thenReturn(Optional.empty());

        Optional<Producto> resultado =
                productoService.obtenerProductoPorId(99);

        assertTrue(resultado.isEmpty());
    }
}
