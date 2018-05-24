create schema bv_interview;

create table bv_interview.inserts_monitored (
  id serial not null,
  description varchar(60),
  last_mod timestamp default current_timestamp,
  constraint propertiesTable_pk primary key(id)
);

insert into bv_interview.inserts_monitored (description) values ('first entry by Zoli');

