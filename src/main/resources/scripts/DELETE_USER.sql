-- stored procedure will be here
DELIMITER //

CREATE PROCEDURE DELETE_USER(IN ID VARCHAR(255))

  BEGIN

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
      ROLLBACK;
    END;

    DECLARE EXIT HANDLER FOR SQLWARNING
    BEGIN
      ROLLBACK;
    END;

    START TRANSACTION;
    
		  delete from credentials where credentials.USER_ID = ID;
      delete from contacts where contacts.USER_ID = ID;
      delete from users where users.ID = ID;

    COMMIT;
  END