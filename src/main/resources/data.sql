delete from User;
delete from Doctor;
delete from Tests;
insert into User (id, name, password, authorization, active) values (1, 'khizar', 'khan', 'user', 0);

insert into Doctor (id, name) values ( 1, 'Dr. Jahaanzeb' );
insert into Doctor (id, name) values ( 2, 'Dr. Abid Jameel' );

insert into Tests (id, name, amount) values (null, 'SBR', 430);
insert into Tests (id, name, amount) values (null, 'RBS', 1300);