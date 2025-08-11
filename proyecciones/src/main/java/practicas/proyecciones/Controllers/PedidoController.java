package practicas.proyecciones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practicas.proyecciones.persistence.projections.PedidoProyeccion;
import practicas.proyecciones.persistence.repositories.PedidoRepository;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/Buscar")
    public List<PedidoProyeccion> buscarPedidosPorCliente(@RequestParam String nombre){
        return pedidoRepository.findByClienteNombre(nombre);
    }
}
