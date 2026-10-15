package gt.com.carritogt.controller;

import gt.com.carritogt.model.Producto;
import gt.com.carritogt.repository.ProductoRepository;
import gt.com.carritogt.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;
    private final ProductoService productoService;

    public ProductoController(ProductoRepository productoRepository,
                              ProductoService productoService) {
        this.productoRepository = productoRepository;
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(
            @PathVariable Integer id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(
            @RequestBody Producto producto) {
        producto.setIdProducto(null);
        Producto nuevoProducto =
                productoService.guardarProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }
}
