SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM pedidos_cliente;
DELETE FROM pedido_productos;
DELETE FROM pedido;
DELETE FROM producto;
DELETE FROM cliente;

SET FOREIGN_KEY_CHECKS = 1;
