CREATE OR REPLACE PROCEDURE CREATEGROUP(NAME IN NVARCHAR2,COURSE IN NUMBER,FACULTY NVARCHAR2)
IS
BEGIN
INSERT INTO GRP VALUES (null,NAME,COURSE,FACULTY);
END CREATEGROUP;
/