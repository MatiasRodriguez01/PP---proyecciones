package practicas.proyecciones.persistence.projections.compuestas;


import java.util.List;


public interface ClienteProyeccionCompuesta {
    Long getId();
    String getNombre();
    String getEmail();
    List<PedidoProyeccionCompuesta> getPedidos();


}
