select * from maquina;
select * from cliente;
select * from item;
select * from manutencao;

create database sigmabd;
use sigmabd;

create table cliente(
	login varchar(50) not null,
    senha varchar(50) not null,
    primary key(login));
    
create table item(
	idItem int not null auto_increment,
    nome varchar(45) not null,
    idMaquina int not null,
    horas_duracao int not null,
    horas_trab int not null,
    preco double not null,
    marca varchar(45) not null,
    primary key(idItem));
    
create table manutencao(
	idManutencao int not null auto_increment,
    dia date not null,
    idItem int not null,
    preco double not null,
    horas_dur int not null,
    marca varchar(45) not null,
    idMaquina int not null,
    primary key(idManutencao));

create table maquina(
	idMaquina int not null auto_increment,
    nome varchar(45) not null,
    login varchar(45) not null,
    primary key(idMaquina));
    
alter table maquina
	add foreign key(login) references cliente(login);
    
alter table item
	add foreign key (idMaquina) references maquina(idMaquina);

alter table manutencao
	add foreign key (idItem) references item(idItem),
    add foreign key (idMaquina) references maquina(idMaquina);

