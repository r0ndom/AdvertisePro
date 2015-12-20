-- stored procedure will be here
DELIMITER //

CREATE PROCEDURE CREATE_USER(IN ID VARCHAR(255),
                             IN FIRST_NAME VARCHAR(255),
                             IN LAST_NAME VARCHAR(255),
                             IN MIDDLE_NAME VARCHAR(255),
                             IN ROLE VARCHAR(255),
                             IN CONTACT_ID VARCHAR(255),
                             IN CITY VARCHAR(255),
                             IN POST_CODE INT,
                             IN STREET VARCHAR(255),
                             IN HOUSE VARCHAR(255),
                             IN FLAT VARCHAR(255),
                             IN PHONE VARCHAR(255),
                             IN EMAIL VARCHAR(255),
                             IN LOGIN VARCHAR(255),
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

    insert into USERS(ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME, ROLE) values (ID, FIRST_NAME, LAST_NAME, MIDDLE_NAME, ROLE);
    insert into CONTACTS(ID, USER_ID, CITY, POST_CODE, STREET, HOUSE, FLAT, PHONE, EMAIL) values (CONTACT_ID, ID, CITY, POST_CODE, STREET, HOUSE, FLAT, PHONE, EMAIL);
    insert into CREDENTIALS(LOGIN, PASS, USER_ID) values (LOGIN, PASS, ID);

    COMMIT;
  END