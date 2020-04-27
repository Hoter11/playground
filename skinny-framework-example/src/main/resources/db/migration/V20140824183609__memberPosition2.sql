
insert into positions(id, name, created_at, updated_at)
values(1, 'Big Boss', '2008-01-01 00:00:01', '2008-01-01 00:00:02'),
      (2, 'Manager', '2008-01-02 00:00:01', '2008-01-02 00:00:02'),
      (3, 'Skaa', '2008-01-03 00:00:01', '2008-01-03 00:00:02');


alter table members add column position_id bigint;
alter table members add constraint members_position_id_fk foreign key (position_id) references positions(id);

