package practicas.proyecciones.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practicas.proyecciones.persistence.projections.compuestas.PedidoProyeccionCompuesta;
import practicas.proyecciones.persistence.projections.simples.PedidoProyeccionSimple;
import practicas.proyecciones.persistence.repositories.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // usando la proyeccion dinamica retornamos una lista de pedidos por proyeccion compuesta usando su nombre
    public List<PedidoProyeccionCompuesta> buscarPedidosProyeccionCompuestaPorNombre(String nombre) throws Exception {
        try {
            return pedidoRepository.findAllByClienteNombre(nombre, PedidoProyeccionCompuesta.class);
        } catch (Exception e) {
            throw new Exception("No se encontro los pedidos de " + nombre);
        }
    }

    // usando la proyeccion dinamica retornamos una lista de pedidos por proyeccion simple usando su nombre
    public List<PedidoProyeccionSimple> listarPedidosProyeccionSimplePorNombre(String nombre) throws Exception {
        try {
            return pedidoRepository.findAllByClienteNombre(nombre, PedidoProyeccionSimple.class);
        } catch (Exception e) {
            throw new Exception("No se pudo filtrar los pedidos por la proyeccion simple");
        }
    }

}
