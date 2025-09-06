package practicas.proyecciones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practicas.proyecciones.persistence.projections.compuestas.PedidoProyeccionCompuesta;
import practicas.proyecciones.persistence.projections.simples.PedidoProyeccionSimple;
import practicas.proyecciones.services.PedidoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/buscarSimple")
    public Optional<PedidoProyeccionSimple> buscarPedidoPorNombre(@RequestParam String nombre) throws Exception {
        return pedidoService.buscarPedidoPorNombre(nombre);
    }

    @GetMapping("/buscar")
    public List<PedidoProyeccionCompuesta> buscarPedidosPorCliente(@RequestParam String nombre) throws Exception {
        return pedidoService.buscarPedidosPorNombre(nombre);
    }

    @GetMapping("/listarSimple")
    public List<PedidoProyeccionSimple> listarPedidosSimple() throws Exception {
        return pedidoService.listarPedidosProyeccionSimple();
    }
}
