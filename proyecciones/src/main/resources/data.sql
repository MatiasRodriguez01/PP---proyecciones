-- Clientes
INSERT INTO cliente(nombre, email) VALUES ('Juan Perez', 'juan@example.com');
INSERT INTO cliente(nombre, email) VALUES ('Maria Garcia', 'maria@example.com');

-- Productos
INSERT INTO producto(nombre, precio) VALUES ('Laptop', 1500.00);
INSERT INTO producto(nombre, precio) VALUES ('Telefono', 800.00);
INSERT INTO producto(nombre, precio) VALUES ('Mouse', 100.0);
INSERT INTO producto(nombre, precio) VALUES ('Teclado', 200.00);

-- Pedidos
INSERT INTO pedido(fecha, cliente_id) VALUES ('2023-10-21', 1);
INSERT INTO pedido(fecha, cliente_id) VALUES ('2023-10-22', 1);

-- Relación pedido-producto (si usas @ManyToMany en Pedido con Producto)
INSERT INTO pedido_productos(pedido_id, producto_id) VALUES (1, 1);
INSERT INTO pedido_productos(pedido_id, producto_id) VALUES (1, 2);
INSERT INTO pedido_productos(pedido_id, producto_id) VALUES (2, 3);
INSERT INTO pedido_productos(pedido_id, producto_id) VALUES (2, 4);
