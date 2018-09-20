create database sigmaBD;
use sigmaBD;

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

create table produto(
	idProduto int not null auto_increment,
	nome varchar(45) not null,
	tipo varchar(45) not null,
	preco double not null,
	login varchar(45) not null,
	qtde double not null,
	primary key(idProduto));

create table terreno(
	idTerreno int not null auto_increment,
	area double not null,
	nome varchar(45) not null,
	login varchar(45) not null,
	estado varchar(45) not null,
	gastos double not null,
	cultura varchar(45) not null,
	primary key(idTerreno));

create table colheita(
	idColheita int not null auto_increment,
	idTerreno int not null,
	data date not null,
	qtde double not null,
	nomeTerreno varchar(45) not null,
	cultura varchar(45) not null,
	primary key(idColheita));

create table plantio(
	idPlantio int not null auto_increment,
	idTerreno int not null,
	data date not null,
	sementes varchar(45) not null,
	qtde_sementes double not null,
	cultura varchar(45) not null,
	primary key(idPlantio));

create table manut_terreno(
	idManut_terreno int not null auto_increment,
	nome varchar(45) not null,
	defensivo varchar(45) not null,
	qtde_defensivo double not null,
	data date not null,
	idTerreno int not null,
	primary key(idManut_terreno));

create table vendas(
	idVendas int not null auto_increment,
	data date not null,
	grao varchar(45) not null,
	qtde double not null,
	preco double not null,
	receita double not null,
	login varchar(45) not null,
	primary key(idVendas));

create table movimento(
	idMov int not null auto_increment,
	nf varchar(45) default '-',
	nome varchar(45) not null,
	tipo varchar(45) not null,
	qtde double not null,
	descricao varchar(45) default '-',
	preco_un double default 0,
	login varchar(45) not null,
	data date not null,
	idTerreno int default 0,
	primary key(idMov));

    
alter table maquina
	add foreign key(login) references cliente(login);
    
alter table item
	add foreign key (idMaquina) references maquina(idMaquina);

alter table manutencao
	add foreign key (idItem) references item(idItem),
    add foreign key (idMaquina) references maquina(idMaquina);

alter table produto
	add foreign key (login) references cliente(login);

alter table vendas
	add foreign key (login) references cliente(login);

alter table terreno
	add foreign key (login) references cliente(login);

alter table movimento
	add foreign key (login) references cliente(login),
	add foreign key (idTerreno) references terreno(idTerreno);

alter table colheita
	add foreign key (idTerreno) references terreno(idTerreno);

alter table plantio
	add foreign key (idTerreno) references terreno(idTerreno);

alter table manut_terreno
	add foreign key (idTerreno) references terreno(idTerreno);	

#teste