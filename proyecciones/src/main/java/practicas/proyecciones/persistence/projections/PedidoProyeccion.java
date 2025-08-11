package practicas.proyecciones.persistence.projections;

import java.time.LocalDate;

public interface PedidoProyeccion {

    Long getId();
    LocalDate getFecha();
    ClienteProyeccion getCliente();

    default String getDatos() {
      return "Fecha: " + getFecha() + ", Del cliente: " + getCliente().getNombre();
    };
}
