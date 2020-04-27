-- For H2 Database
drop table if exists positions;
create table positions (
  id bigserial not null primary key,
  name varchar(512) not null,
  created_at timestamp not null,
  updated_at timestamp not null
);
