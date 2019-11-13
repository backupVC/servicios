DROP PROCEDURE IF EXISTS insertar_update;

DELIMITER //
CREATE PROCEDURE insertar_update(nuevoTitulo VARCHAR(50), nuevoAutor VARCHAR(50), nuevoPrecio DOUBLE)
COMMENT '’Procedimiento que inserta actualiza un libro de la base de datos'
BEGIN
  IF NOT EXISTS (SELECT l.titulo
    FROM libros AS l
    WHERE l.titulo = nuevoTitulo) THEN
      INSERT INTO libros(titulo, autor, precio)
      VALUES (nuevoTitulo, nuevoAutor, nuevoPrecio);
  ELSE
    UPDATE libros AS l SET titulo = nuevoTitulo, autor = nuevoAutor,
      precio = nuevoPrecio WHERE l.titulo= nuevoTitulo;
  END IF;
END//
DELIMITER ;
