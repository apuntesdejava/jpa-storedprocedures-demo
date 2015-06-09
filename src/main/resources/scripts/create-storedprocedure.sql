-- --------------------------------------------------------------------------------
-- Routine DDL
-- Note: comments before and after the routine body will not be stored by the server
-- --------------------------------------------------------------------------------
DELIMITER $$

CREATE PROCEDURE `p`(out p1 varchar(25),inout inc int)
BEGIN
	select version() into p1;
	set inc = inc +1;
END
