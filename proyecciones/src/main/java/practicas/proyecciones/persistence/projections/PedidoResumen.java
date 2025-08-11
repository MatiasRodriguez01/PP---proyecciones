package practicas.proyecciones.persistence.projections;

import java.time.LocalDate;

public interface PedidoResumen {
    Long getId();
    LocalDate getFecha();

    default String getDatos() {
        return "Pedido: "+ getId() + ",Fecha: " + getFecha() ;
    };
}
