-- ======================
--  SCHEMA FOR customerdb
-- ======================

CREATE DATABASE IF NOT EXISTS customerdb;
USE customerdb;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    genero VARCHAR(50),
    edad INT,
    identificacion VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(100),
    contrasena VARCHAR(255),
    estado VARCHAR(50)
);

CREATE TABLE reporte (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_id BIGINT UNIQUE,
    contenido LONGBLOB,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- ======================
--  SCHEMA FOR accountdb
-- ======================

CREATE DATABASE IF NOT EXISTS accountdb;
USE accountdb;

CREATE TABLE cuenta (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_cuenta VARCHAR(100),
    tipo_cuenta VARCHAR(100),
    saldo_inicial DECIMAL(15,2),
    estado VARCHAR(50),
    cliente_id BIGINT
);

CREATE TABLE movimiento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    tipo_movimiento VARCHAR(100),
    valor DECIMAL(15,2),
    saldo DECIMAL(15,2),
    cuenta_id BIGINT
);
