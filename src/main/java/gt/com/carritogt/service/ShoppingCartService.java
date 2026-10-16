package gt.com.carritogt.service;

import gt.com.carritogt.model.ShoppingCartItem;
import gt.com.carritogt.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(
            ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public List<ShoppingCartItem> obtenerTodos() {
        return shoppingCartRepository.findAll();
    }

    public ShoppingCartItem obtenerPorId(Integer id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Elemento del carrito no encontrado"));
    }

    public ShoppingCartItem agregar(ShoppingCartItem item) {
        if (item.getIdProducto() == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        }

        if (item.getCantidad() == null || item.getCantidad() < 1) {
            throw new IllegalArgumentException(
                    "La cantidad debe ser mayor que cero");
        }

        return shoppingCartRepository.save(item);
    }

    public void eliminar(Integer id) {
        if (!shoppingCartRepository.existsById(id)) {
            throw new RuntimeException(
                    "Elemento del carrito no encontrado");
        }

        shoppingCartRepository.deleteById(id);
    }

    public void vaciar() {
        shoppingCartRepository.deleteAll();
    }
}
