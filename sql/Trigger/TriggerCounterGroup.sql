create or replace trigger group_id_trg
before insert on grp
for each row
begin
  if :new.id is null then
    select CounterGroup.nextval into :new.id from dual;
  end if;
end;