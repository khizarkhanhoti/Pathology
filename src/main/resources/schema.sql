create table if not exists User
(
    id            bigint(8)   not null auto_increment,
    name          varchar(45) not null,
    password      varchar(45) not null,
    authorization varchar(45) not null,
    active        tinyint(1)  not null
);

create table if not exists Patient
(
    reg        bigint(8)   not null auto_increment,
    name      varchar(45) not null,
    gender    varchar(45) not null,
    specimen  varchar(45) not null,
    contact   varchar(45) not null,
    cnic      varchar(45) not null,
    isPending tinyint(1)  not null,
    amount    int         not null
);

create table if not exists Doctor
(
    id   bigint(8)   not null auto_increment,
    name varchar(45) not null
);

create table if not exists Tests (
     id          bigint(8)   not null auto_increment,
     name        varchar(60) not null,
     amount      int         not null
);

create table if not exists Test
(
    id     bigint(8)   not null auto_increment,
    name   varchar(45) not null,
    nrange  varchar(60) not null,
    result varchar(45),
    amount int         not null
);

