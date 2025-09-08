package practicas.proyecciones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

    /// Aca estan los endpoints para retornar las proyecciones de cliente

    @GetMapping
    public List<Cliente> listarClientes() throws Exception {
        return clienteService.listarClientes();
    }

    @GetMapping("/busquedaSimple")
    public ClienteProyeccionSimple buscarCliente(@RequestParam String nombre) throws Exception {
        return clienteService.listarProyeccionSimple(nombre);
    }

    @GetMapping("/listaSimple")
    public List<ClienteProyeccionSimple> listasClientesProyeccionSimple() {
        return clienteService.listarClientesPorProyeccionSimple("listaSimple");
    }

    @GetMapping("/query")
    public List<Pedido> buscarPedidos(@RequestParam String nombre) throws Exception {
        return clienteService.listarPedidos(nombre);
    }
}
