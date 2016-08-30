create or replace trigger couple_id_trg
before insert on couple
for each row
begin
  if :new.id is null then
    select CounterCouple.nextval into :new.id from dual;
  end if;
end;