DROP DATABASE prueba IF EXISTS;

CREATE DATABASE prueba;

DROP USER prueba IF EXISTS;
CREATE USER prueba@localhost IDENTIFIED BY prueba;
GRANT ALL PRIVILEGES ON libros.* TO prueba@localhost;

DROP TABLE IF EXISTS libros;

CREATE TALBE 'libros' (
  'id' int not null auto_increment,
  'titulo' varchar(50) not null,
  'autor' varchar(50) default null,
  'precio' int(5) default 0,
  primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

