create database ativ3;
use ativ3;

create table Cliente (
    id int primary key auto_increment,
    cpf bigint not null,
    nome varchar(45) not null
);

CREATE TABLE Contrato (
    id int primary key auto_increment,
    redacao text,
    ultimaAtualizacao date,
    cliente_id int,
    foreign key (cliente_id) references Cliente(id)
);

describe Cliente;
describe Contrato;

SELECT * FROM cliente;
SELECT * FROM contrato;