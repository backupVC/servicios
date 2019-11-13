DROP FUNCTION IF EXISTS conIVA;
DELIMITER //

CREATE FUNCTION conIVA (idLibro int) RETURNS DOUBLE
BEGIN
  DECLARE PVP DOUBLE;
  SELECT precio INTO PVP FROM libros WHERE id = idLibro;
  RETURN PVP * 1.21;
END; //
DELIMITER ;