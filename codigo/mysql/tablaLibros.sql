DROP TABLE IF EXISTS libros;

CREATE TABLE libros (
  id int not null auto_increment,
  titulo varchar(50) not null unique,
  autor varchar(50) default null,
  precio double default 0,
  primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

