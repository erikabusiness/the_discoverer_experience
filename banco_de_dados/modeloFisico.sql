CREATE SCHEMA `the_discoverer_xp` ;
USE `the_discoverer_xp` ;

CREATE TABLE Pacotes (
idPacote INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
descPacote DOUBLE,
valorPacote DOUBLE
);

CREATE TABLE Destino (
idDestino INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
nomeDestino VARCHAR(50),
avaliacao INT
);

CREATE TABLE Usuario (
idUsuario INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
senha VARCHAR(10),
email VARCHAR(30),
CPF VARCHAR(15),
nome VARCHAR(50),
localização VARCHAR(100)
);

CREATE TABLE Reserva (

idReserva INT PRIMARY KEY NOT NULL AUTO_INCREMENT,

idPacote INT,
idDestino INT,
idUsuario INT,
dtCheckout VARCHAR(10),
statusReserva BOOLEAN,
dtCheckIn VARCHAR(10),
FOREIGN KEY(idPacote) REFERENCES Pacotes (idPacote),
FOREIGN KEY(idDestino) REFERENCES Destino (idDestino),
FOREIGN KEY(idUsuario) REFERENCES Usuario (idUsuario)
);

ALTER TABLE `the_discoverer_xp`.`reserva` 
DROP FOREIGN KEY `reserva_ibfk_1`,
DROP FOREIGN KEY `reserva_ibfk_2`,
DROP FOREIGN KEY `reserva_ibfk_3`;
ALTER TABLE `the_discoverer_xp`.`reserva` 
ADD CONSTRAINT `reserva_ibfk_1`
  FOREIGN KEY (`idPacote`)
  REFERENCES `the_discoverer_xp`.`pacotes` (`idPacote`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_2`
  FOREIGN KEY (`idDestino`)
  REFERENCES `the_discoverer_xp`.`destino` (`idDestino`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `reserva_ibfk_3`
  FOREIGN KEY (`idUsuario`)
  REFERENCES `the_discoverer_xp`.`usuario` (`idUsuario`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
CREATE VIEW reserva_destino as
select r.idReserva, r.dtCheckout, r.statusReserva, r.dtCheckIn, d.*, p.*, u.* 
from reserva r, destino d, pacotes p, usuario u
where d.idDestino =  d.idDestino and p.idPacote = p.idPacote and u.idUsuario = u.idUsuario;

select r.idReserva, r.dtCheckout, r.statusReserva, r.dtCheckIn, d.*, p.*, u.* 
from reserva r, destino d, pacotes p, usuario u
where d.idDestino =  d.idDestino and p.idPacote = p.idPacote and u.idUsuario = u.idUsuario;