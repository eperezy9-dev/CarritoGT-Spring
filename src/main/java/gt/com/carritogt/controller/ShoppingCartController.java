package gt.com.carritogt.controller;

import gt.com.carritogt.model.ShoppingCartItem;
import gt.com.carritogt.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(
            ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public List<ShoppingCartItem> obtenerTodos() {
        return shoppingCartService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ShoppingCartItem obtenerPorId(@PathVariable Integer id) {
        return shoppingCartService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShoppingCartItem agregar(
            @RequestBody ShoppingCartItem item) {
        return shoppingCartService.agregar(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        shoppingCartService.eliminar(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vaciar() {
        shoppingCartService.vaciar();
    }
}
