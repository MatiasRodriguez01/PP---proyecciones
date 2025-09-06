package practicas.proyecciones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practicas.proyecciones.persistence.entities.Cliente;
import practicas.proyecciones.persistence.entities.Pedido;
import practicas.proyecciones.persistence.projections.simples.ClienteProyeccionSimple;
import practicas.proyecciones.services.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listarClientes() throws Exception {
        return clienteService.listar();
    }

    @GetMapping("/simple")
    public ClienteProyeccionSimple buscarCliente(@RequestParam String nombre) throws Exception {
        return clienteService.listarProyeccionSimple(nombre);
    }

    @GetMapping("/query")
    public List<Pedido> buscarPedidos(@RequestParam String nombre) throws Exception {
        return clienteService.listarPedidos(nombre);
    }
}
