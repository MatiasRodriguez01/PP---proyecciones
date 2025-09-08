package practicas.proyecciones.persistence.projections.compuestas;

import practicas.proyecciones.persistence.projections.simples.ClienteProyeccionSimple;
import practicas.proyecciones.persistence.projections.simples.ProductoProyeccionSimple;

import java.time.LocalDate;
import java.util.List;

public interface PedidoProyeccionCompuesta {

    Long getId();
    LocalDate getFecha();
    ClienteProyeccionSimple getCliente();
    List<ProductoProyeccionSimple> getProductos();

}
