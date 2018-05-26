CREATE TABLE categoria (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NULL,
  genero VARCHAR (50),
  altura DOUBLE,
  nascimento DATE,
  PRIMARY KEY (id)
) engine=InnoDB DEFAULT CHARSET=utf8;