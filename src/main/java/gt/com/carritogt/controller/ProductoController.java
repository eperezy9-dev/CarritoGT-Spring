package gt.com.carritogt.controller;

import gt.com.carritogt.model.Producto;
import gt.com.carritogt.repository.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.List;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    @GetMapping
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }
}
