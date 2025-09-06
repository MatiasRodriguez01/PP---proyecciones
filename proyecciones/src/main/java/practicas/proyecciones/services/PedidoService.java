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

    public Optional<PedidoProyeccionSimple> buscarPedidoPorNombre(String nombre) throws Exception {
        try {
            return pedidoRepository.findByClienteNombre(nombre);
        } catch (Exception e) {
            throw new Exception("No se encontro el pedido de " + nombre);
        }
    }

    public List<PedidoProyeccionCompuesta> buscarPedidosPorNombre(String nombre) throws Exception {
        try {
            return pedidoRepository.findAllByClienteNombre(nombre);
        } catch (Exception e) {
            throw new Exception("No se encontro los pedidos de " + nombre);
        }
    }

    public List<PedidoProyeccionSimple> listarPedidosProyeccionSimple() throws Exception {
        try {
            return pedidoRepository.findAllPedidosBy();
        } catch (Exception e) {
            throw new Exception("No se pudo filtrar los pedidos por la proyeccion simple");
        }
    }

}
