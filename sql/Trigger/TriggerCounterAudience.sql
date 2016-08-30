create or replace trigger audience_id_trg
before insert on audience
for each row
begin
  if :new.id is null then
    select CounterAudience.nextval into :new.id from dual;
  end if;
end;