create or replace trigger faculty_id_trg
before insert on faculty
for each row
begin
  if :new.id is null then
    select CounterFaculty.nextval into :new.id from dual;
  end if;
end;