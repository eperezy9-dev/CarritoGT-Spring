package gt.com.carritogt.service;

import gt.com.carritogt.model.ShoppingCartItem;
import gt.com.carritogt.repository.ShoppingCartRepository;
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
class ShoppingCartServiceTest {

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @InjectMocks
    private ShoppingCartService shoppingCartService;

    private ShoppingCartItem item;

    @BeforeEach
    void configurar() {
        item = new ShoppingCartItem();
        item.setIdShoppingCart(1);
        item.setIdProducto(2);
        item.setCodUsuario("usuario-prueba");
        item.setCantidad(3);
    }

    @Test
    void obtenerTodosDebeRetornarLista() {
        when(shoppingCartRepository.findAll())
                .thenReturn(List.of(item));

        List<ShoppingCartItem> resultado =
                shoppingCartService.obtenerTodos();

        assertEquals(1, resultado.size());
        assertEquals(2, resultado.get(0).getIdProducto());
        verify(shoppingCartRepository).findAll();
    }

    @Test
    void obtenerPorIdDebeRetornarElementoExistente() {
        when(shoppingCartRepository.findById(1))
                .thenReturn(Optional.of(item));

        ShoppingCartItem resultado =
                shoppingCartService.obtenerPorId(1);

        assertEquals(1, resultado.getIdShoppingCart());
        verify(shoppingCartRepository).findById(1);
    }

    @Test
    void obtenerPorIdDebeLanzarErrorSiNoExiste() {
        when(shoppingCartRepository.findById(99))
                .thenReturn(Optional.empty());

        RuntimeException error = assertThrows(
                RuntimeException.class,
                () -> shoppingCartService.obtenerPorId(99)
        );

        assertEquals(
                "Elemento del carrito no encontrado",
                error.getMessage()
        );
    }

    @Test
    void agregarDebeGuardarElementoValido() {
        when(shoppingCartRepository.save(item)).thenReturn(item);

        ShoppingCartItem resultado =
                shoppingCartService.agregar(item);

        assertSame(item, resultado);
        verify(shoppingCartRepository).save(item);
    }

    @Test
    void agregarDebeRechazarProductoNulo() {
        item.setIdProducto(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> shoppingCartService.agregar(item)
        );

        verify(shoppingCartRepository, never()).save(any());
    }

    @Test
    void agregarDebeRechazarCantidadNula() {
        item.setCantidad(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> shoppingCartService.agregar(item)
        );

        verify(shoppingCartRepository, never()).save(any());
    }

    @Test
    void agregarDebeRechazarCantidadCero() {
        item.setCantidad(0);

        assertThrows(
                IllegalArgumentException.class,
                () -> shoppingCartService.agregar(item)
        );

        verify(shoppingCartRepository, never()).save(any());
    }

    @Test
    void eliminarDebeBorrarElementoExistente() {
        when(shoppingCartRepository.existsById(1))
                .thenReturn(true);

        assertDoesNotThrow(
                () -> shoppingCartService.eliminar(1)
        );

        verify(shoppingCartRepository).deleteById(1);
    }

    @Test
    void eliminarDebeLanzarErrorSiNoExiste() {
        when(shoppingCartRepository.existsById(99))
                .thenReturn(false);

        assertThrows(
                RuntimeException.class,
                () -> shoppingCartService.eliminar(99)
        );

        verify(shoppingCartRepository, never()).deleteById(any());
    }

    @Test
    void vaciarDebeEliminarTodosLosElementos() {
        shoppingCartService.vaciar();

        verify(shoppingCartRepository).deleteAll();
    }

    @Test
    void actualizarDebeGuardarCambios() {
        ShoppingCartItem cambios = new ShoppingCartItem();
        cambios.setIdProducto(5);
        cambios.setCodUsuario("usuario-actualizado");
        cambios.setCantidad(4);

        when(shoppingCartRepository.findById(1))
                .thenReturn(Optional.of(item));
        when(shoppingCartRepository.save(item)).thenReturn(item);

        ShoppingCartItem resultado =
                shoppingCartService.actualizar(1, cambios);

        assertEquals(5, resultado.getIdProducto());
        assertEquals("usuario-actualizado", resultado.getCodUsuario());
        assertEquals(4, resultado.getCantidad());

        verify(shoppingCartRepository).save(item);
    }

    @Test
    void actualizarDebeLanzarErrorSiNoExiste() {
        when(shoppingCartRepository.findById(99))
                .thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> shoppingCartService.actualizar(99, item)
        );

        verify(shoppingCartRepository, never()).save(any());
    }
}
