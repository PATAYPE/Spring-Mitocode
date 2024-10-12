create table usuario(
id integer not null,
nombre character,
clave character,
tipo character,
estado char,
constraint usuarios_pkey primary key(id)
);


insert into usuario(id,nombre, clave, tipo, estado)
values(1,'JMEDINA', '123','ROLE_ADMIN','1');

insert into usuario(id,nombre, clave, tipo, estado)
values(2,'MITO', '123','ROLE_USER','1');

insert into usuario(id,nombre, clave, tipo, estado)
values(3,'JMEDINA', '123','ROLE_USER','1');

insert into usuario(id,nombre, clave, tipo, estado)
values(4,'CODE', '123','ROLE_XYZ','1');