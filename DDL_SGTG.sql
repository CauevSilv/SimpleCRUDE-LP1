CREATE SCHEMA listaGames;

USE listaGames;


CREATE TABLE game (
id_game int  auto_increment PRIMARY KEY,
nome varchar(255),
genero varchar(255),
critica varchar(255),
ano varchar(255),
tamanho varchar(255),
pirata boolean

);
