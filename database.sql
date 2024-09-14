CREATE DATABASE agendamentoemaildb;

USE agendamentoemaildb;

CREATE TABLE agendamentoemail (
    id int NOT NULL AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    assunto varchar(50) NOT NULL,
    mensagem varchar(255) NOT NULL,
    agendado tinytext NOT NULL,
    PRIMARY KEY (id)
);