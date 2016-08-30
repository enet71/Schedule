create or replace trigger subject_id_trg
before insert on Subject
for each row
begin
  if :new.id is null then
    select CounterSubject.nextval into :new.id from dual;
  end if;
end;