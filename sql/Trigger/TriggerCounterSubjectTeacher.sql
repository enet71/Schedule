create or replace trigger SubjectTeacher_id_trg
before insert on SubjectTeacher
for each row
begin
  if :new.id is null then
    select CounterSubjectTeacher.nextval into :new.id from dual;
  end if;
end;