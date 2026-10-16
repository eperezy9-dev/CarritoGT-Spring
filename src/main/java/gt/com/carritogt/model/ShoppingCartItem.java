package gt.com.carritogt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idShoppingCart")
    private Integer idShoppingCart;

    @Column(name = "idProducto")
    private Integer idProducto;

    @Column(name = "codUsuario")
    private String codUsuario;

    @Column(name = "cantidad")
    private Integer cantidad;

    public ShoppingCartItem() {
    }

    public Integer getIdShoppingCart() {
        return idShoppingCart;
    }

    public void setIdShoppingCart(Integer idShoppingCart) {
        this.idShoppingCart = idShoppingCart;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
