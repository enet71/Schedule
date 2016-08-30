create or replace trigger teacher_id_trg
before insert on teacher
for each row
begin
  if :new.id is null then
    select CounterTeacher.nextval into :new.id from dual;
  end if;
end;