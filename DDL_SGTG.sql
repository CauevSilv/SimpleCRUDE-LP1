CREATE SCHEMA listaGames;

USE listaGames;

drop table game

CREATE TABLE game (
id_game int  auto_increment PRIMARY KEY,
nome varchar(255),
genero varchar(255),
critica varchar(255),
ano varchar(255),
tamanho varchar(255),
pirata boolean

);

CREATE TABLE links (
id_link int auto_increment PRIMARY KEY,
id_jogo int,
link text,

CONSTRAINT fk_gameid FOREIGN KEY (id_jogo)
	REFERENCES game(id_game)
    ON DELETE CASCADE ON UPDATE CASCADE

);