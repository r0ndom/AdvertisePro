-- stored procedure will be here
DELIMITER //

CREATE PROCEDURE UPDATE_USER(IN ID VARCHAR(255),
                             IN FIRST_NAME VARCHAR(255),
                             IN LAST_NAME VARCHAR(255),
                             IN MIDDLE_NAME VARCHAR(255),
                             IN CITY VARCHAR(255),
                             IN POST_CODE INT,
                             IN STREET VARCHAR(255),
                             IN HOUSE VARCHAR(255),
                             IN FLAT VARCHAR(255),
                             IN PHONE VARCHAR(255),
                             IN EMAIL VARCHAR(255),
                             IN PASS VARCHAR(255))

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
    
      update credentials AS c set c.PASS = PASS
      where c.USER_ID = ID;
      
      update contacts AS c set c.CITY = CITY, c.POST_CODE = POST_CODE, 
      c.STREET = STREET, c.HOUSE = HOUSE, c.FLAT = FLAT, c.PHONE = PHONE,
      c.EMAIL = EMAIL where c.USER_ID = ID;
      
      update users AS u set u.FIRST_NAME = FIRST_NAME, u.LAST_NAME = LAST_NAME,
      u.MIDDLE_NAME = MIDDLE_NAME where u.ID = ID;

    COMMIT;
  END