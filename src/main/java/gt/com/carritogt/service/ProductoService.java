package gt.com.carritogt.service;

import gt.com.carritogt.model.Producto;
import gt.com.carritogt.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto actualizarProducto(Integer id, Producto productoActualizado) {
        return productoRepository.findById(id)
                .map(productoExistente -> {
                    productoExistente.setNombre(productoActualizado.getNombre());
                    productoExistente.setCodigo(productoActualizado.getCodigo());
                    productoExistente.setImagen(productoActualizado.getImagen());
                    productoExistente.setPrecio(productoActualizado.getPrecio());
                    return productoRepository.save(productoExistente);
                })
                .orElse(null);
    }
    public boolean eliminarProducto(Integer id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }
}
