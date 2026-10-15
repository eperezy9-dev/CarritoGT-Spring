package gt.com.carritogt.repository;

import gt.com.carritogt.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository
        extends JpaRepository<Producto, Integer> {
}
