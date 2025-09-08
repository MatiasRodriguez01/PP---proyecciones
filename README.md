# Sistema de Proyecciones Spring Boot

Este proyecto demuestra diferentes tipos de proyecciones de datos usando Spring Data JPA en una aplicación de gestión de pedidos, clientes y productos. [1](#0-0) 

## Arquitectura del Proyecto

El sistema implementa una arquitectura de 3 capas: [2](#0-1) 

- **Controllers**: Endpoints REST que exponen las APIs
- **Services**: Lógica de negocio y manejo de excepciones  
- **Repositories**: Acceso a datos con proyecciones JPA

## Tipos de Proyecciones Implementadas

### 1. Proyecciones Simples (Interface-based)
Extraen campos específicos de una entidad usando interfaces. [3](#0-2) 

### 2. Proyecciones Compuestas
Incluyen relaciones entre entidades manteniendo la estructura de proyección. [4](#0-3) 

### 3. Proyecciones Abiertas (SpEL)
Usan expresiones SpEL para computar valores dinámicamente. [5](#0-4) 

### 4. Proyecciones DTO (Class-based)
Usan clases concretas con consultas JPQL personalizadas. [6](#0-5) 

## APIs Disponibles

### Gestión de Pedidos (`/api/pedidos`)

#### Buscar pedido simple por cliente
```
GET /api/pedidos/buscarSimple?nombre={nombreCliente}
```
Retorna: `PedidoProyeccionSimple` [7](#0-6) 

#### Buscar pedidos compuestos por cliente  
```
GET /api/pedidos/buscar?nombre={nombreCliente}
```
Retorna: `List<PedidoProyeccionCompuesta>` [8](#0-7) 

#### Listar todos los pedidos (proyección simple)
```
GET /api/pedidos/listarSimple
```
Retorna: `List<PedidoProyeccionSimple>` [9](#0-8) 

### Gestión de Clientes (`/api/clientes`)

#### Listar todos los clientes (entidad completa)
```
GET /api/clientes
```
Retorna: `List<Cliente>` [10](#0-9) 

#### Buscar cliente por proyección simple
```
GET /api/clientes/simple?nombre={nombreCliente}
```
Retorna: `ClienteProyeccionSimple` [11](#0-10) 

#### Buscar pedidos de un cliente (consulta nativa)
```
GET /api/clientes/query?nombre={nombreCliente}
```
Retorna: `List<Pedido>` [12](#0-11) 

### Gestión de Productos (`/api/productos`)

#### Proyección simple
```
GET /api/productos/listaSimple
```
Retorna: `List<ProductoProyeccionSimple>` [13](#0-12) 

#### Proyección abierta (SpEL)
```
GET /api/productos/listaAbierta  
```
Retorna: `List<ProductosProyeccionAbierta>` [14](#0-13) 

#### Proyección DTO
```
GET /api/productos/listaDTO
```
Retorna: `List<ProductoDTO>` [15](#0-14) 

## Configuración y Ejecución

### Prerrequisitos
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Configuración de Base de Datos
El proyecto usa JPA con MySQL. [16](#0-15)  Las entidades están mapeadas con anotaciones JPA estándar.

### Ejecutar el Proyecto
```bash
mvn spring-boot:run
```

### Probar las APIs
Una vez ejecutado, las APIs estarán disponibles en `http://localhost:8080`

Ejemplo de prueba:
```bash
curl http://localhost:8080/api/productos/listaSimple
curl http://localhost:8080/api/pedidos/buscar?nombre=Juan
```

## Estructura de Proyecciones por Repositorio

### ProductRepository
- **Simple**: `findAllProjectedBy()` [17](#0-16) 
- **Abierta**: `findAllOpenProjectedBy()` [18](#0-17) 
- **DTO**: `findProductoByDTO()` [19](#0-18) 

### PedidoRepository  
- **Simple**: `findByClienteNombre()`, `findAllPedidosBy()` [20](#0-19) 
- **Compuesta**: `findAllByClienteNombre()` [21](#0-20) 

### ClienteRepository
- **Simple**: `findAllByNombre()` [22](#0-21) 
- **Consulta Nativa**: `findByListPedidosForCliente()` [23](#0-22) 

## Notas

El proyecto incluye tests de integración que demuestran el uso de las proyecciones. [24](#0-23)  Los servicios implementan manejo de excepciones consistente para todas las operaciones. [25](#0-24) 

Wiki pages you might want to explore:
- [Layered Architecture (MatiasRodriguez01/PP---proyecciones)](/wiki/MatiasRodriguez01/PP---proyecciones#2.1)
- [REST API Controllers (MatiasRodriguez01/PP---proyecciones)](/wiki/MatiasRodriguez01/PP---proyecciones#3)
- [Data Access Layer (MatiasRodriguez01/PP---proyecciones)](/wiki/MatiasRodriguez01/PP---proyecciones#4)

### Citations

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/PedidoController.java (L15-17)
```java
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/PedidoController.java (L19-23)
```java
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/PedidoController.java (L25-28)
```java
    @GetMapping("/buscarSimple")
    public Optional<PedidoProyeccionSimple> buscarPedidoPorNombre(@RequestParam String nombre) throws Exception {
        return pedidoService.buscarPedidoPorNombre(nombre);
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/PedidoController.java (L30-33)
```java
    @GetMapping("/buscar")
    public List<PedidoProyeccionCompuesta> buscarPedidosPorCliente(@RequestParam String nombre) throws Exception {
        return pedidoService.buscarPedidosPorNombre(nombre);
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/PedidoController.java (L35-38)
```java
    @GetMapping("/listarSimple")
    public List<PedidoProyeccionSimple> listarPedidosSimple() throws Exception {
        return pedidoService.listarPedidosProyeccionSimple();
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/projections/simples/ProductoProyeccionSimple.java (L3-6)
```java
public interface ProductoProyeccionSimple {
    String getNombre();
    Double getPrecio();
}
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/projections/compuestas/PedidoProyeccionCompuesta.java (L9-15)
```java
public interface PedidoProyeccionCompuesta {

    Long getId();
    LocalDate getFecha();
    List<ProductoProyeccionSimple> getProductos();

}
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/projections/abiertas/ProductosProyeccionAbierta.java (L7-8)
```java
    @Value("#{target.precio + ' ' + target.nombre}")
    String getFullData();
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/ProductRepository.java (L17-17)
```java
    List<ProductoProyeccionSimple> findAllProjectedBy();
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/ProductRepository.java (L19-19)
```java
    List<ProductosProyeccionAbierta> findAllOpenProjectedBy();
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/ProductRepository.java (L21-22)
```java
    @Query("SELECT new practicas.proyecciones.persistence.projections.clasesDTO.ProductoDTO(p.nombre, p.precio) From Producto p")
    List<ProductoDTO> findProductoByDTO();
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ClienteController.java (L23-26)
```java
    @GetMapping
    public List<Cliente> listarClientes() throws Exception {
        return clienteService.listar();
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ClienteController.java (L28-31)
```java
    @GetMapping("/simple")
    public ClienteProyeccionSimple buscarCliente(@RequestParam String nombre) throws Exception {
        return clienteService.listarProyeccionSimple(nombre);
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ClienteController.java (L33-36)
```java
    @GetMapping("/query")
    public List<Pedido> buscarPedidos(@RequestParam String nombre) throws Exception {
        return clienteService.listarPedidos(nombre);
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ProductoController.java (L21-24)
```java
    @GetMapping("/listaSimple")
    public List<ProductoProyeccionSimple> listarProductoProyeccionSimple() throws Exception {
        return productoService.listarProductosProyeccionSimple();
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ProductoController.java (L26-29)
```java
    @GetMapping("/listaAbierta")
    public List<ProductosProyeccionAbierta>  listarProductoProyeccionAbierta() throws Exception {
        return productoService.listarProductosProyeccionAbierta();
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/Controllers/ProductoController.java (L31-34)
```java
    @GetMapping("/listaDTO")
    public List<ProductoDTO> listarProductoProyeccionBasadaEnClase() throws Exception {
        return productoService.listarProductosProyeccionBasadaEnClases();
    }
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/entities/Pedido.java (L11-12)
```java
@Entity
@Table(name = "pedido")
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/PedidoRepository.java (L18-20)
```java
    Optional <PedidoProyeccionSimple> findByClienteNombre(String nombre);

    List<PedidoProyeccionSimple> findAllPedidosBy();
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/PedidoRepository.java (L22-22)
```java
    List<PedidoProyeccionCompuesta> findAllByClienteNombre(String nombre);
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/ClienteRepository.java (L18-18)
```java
    ClienteProyeccionSimple findAllByNombre(String nombre);
```

**File:** proyecciones/src/main/java/practicas/proyecciones/persistence/repositories/ClienteRepository.java (L20-26)
```java
    @Query(value = """
        SELECT p.* FROM pedido p
                INNER JOIN pedidos_cliente pc ON pc.pedido_id = p.id
                INNER JOIN cliente c ON c.id = p.cliente_id
            WHERE c.nombre = :nombre;  
    """, nativeQuery = true)
    List<Pedido> findByListPedidosForCliente(@Param("nombre") String nombre);
```

**File:** proyecciones/src/test/java/practicas/proyecciones/PedidoProyeccionTest.java (L35-36)
```java
    public void testBuscarPedidosConCliente() throws Exception {
        List<PedidoProyeccionCompuesta> pedidos = pedidoRepository.findByClienteNombre("Juan Perez");
```

**File:** proyecciones/src/main/java/practicas/proyecciones/services/ProductoService.java (L21-25)
```java
        try {
            return productRepository.findAllProjectedBy();
        } catch (Exception e) {
            throw new Exception("No se filtro la lista de productos por proyeccion simple!!");
        }
```
