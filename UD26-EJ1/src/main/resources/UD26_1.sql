DROP DATABASE IF EXISTS UD26_1;
CREATE DATABASE UD26_1;
USE UD26_1;

CREATE TABLE piezas(
codigo INT AUTO_INCREMENT PRIMARY KEY,
nombre varchar(100)
);

CREATE TABLE proveedores(
id char(4) PRIMARY KEY,
nombre varchar(100)
);

CREATE TABLE suministra(
id INT AUTO_INCREMENT PRIMARY KEY,
codigoPieza INT,
idProveedor char(4),
precio int,
FOREIGN KEY (codigoPieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE SET NULL,
FOREIGN KEY (idProveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE SET NULL
);

INSERT INTO piezas(nombre) VALUES ('Tornillo'), ('Bisagra'), ('Muesca');
INSERT INTO proveedores(id, nombre) VALUES ('A','Mann'), ('B','Fierro'), ('C','Zanusi');
INSERT INTO suministra(codigoPieza, idProveedor, precio) VALUES (1,'A',150), (2,'B',180), (2,'C',300);
