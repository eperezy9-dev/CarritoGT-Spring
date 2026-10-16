package gt.com.carritogt.repository;

import gt.com.carritogt.model.ShoppingCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository
        extends JpaRepository<ShoppingCartItem, Integer> {
}