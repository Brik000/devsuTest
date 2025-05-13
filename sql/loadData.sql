USE accountdb;

INSERT INTO cuenta (numero_cuenta, tipo_cuenta, saldo_inicial, estado, cliente_id)
VALUES
('478758', 'Ahorros', 2000, 'True', 1),
('225487', 'Corriente', 100, 'True', 2),
('495878', 'Ahorros', 0, 'True', 3),
('496825', 'Ahorros', 540, 'True', 2),
('585545', 'Corriente', 1000, 'True', 1);

USE customerdb;

INSERT INTO cliente (nombre, genero, edad, identificacion, direccion, telefono, contrasena, estado)
VALUES
('Jose Lema', 'Masculino', 30, '1725347865', 'Otavalo sn y principal', '098254785', '1234', 'True'),
('Marianela Montalvo', 'Femenino', 28, '1725489632', 'Amazonas y NNUU', '097548965', '5678', 'True'),
('Juan Osorio', 'Masculino', 33, '1725326987', '13 junio y Equinoccial', '098874587', '1245', 'True');


-- docker exec -i mysql-customer mysql -uroot -proot customerdb < loaddata.sql
-- docker exec -i mysql-account mysql -uroot -proot accountdb < loaddata.sql

