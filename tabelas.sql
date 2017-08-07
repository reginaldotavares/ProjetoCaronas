CREATE TABLE usuario
(
  idUsuario integer NOT NULL DEFAULT nextval('usuario_seq'::regclass),
  nome varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  dataDeNascimento Date NOT NULL,
  sexo varchar (100) NOT NULL,
  senha varchar (100) NOT NULL,
  telefone varchar (100) NOT NULL,
  PRIMARY KEY (idUsuario)
);

CREATE TABLE carona
(
  idCarona integer NOT NULL DEFAULT nextval('carona_seq'::regclass),
  idUsuario integer NOT NULL,
  origem varchar(100) NOT NULL,
  destino  varchar(100) NOT NULL,
  distancia real,
  horasaida time NOT NULL,
  data Date NOT NULL,
  ajudadecusto real NOT NULL,
  PRIMARY KEY (idCarona),
  FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario)
);

CREATE TABLE pontos_adicinais
(
  idPontos integer NOT NULL DEFAULT nextval('pontos_seq'::regclass),
  idCarona integer NOT NULL,
  ponto varchar(100) NOT NULL,
  PRIMARY KEY (idPontos),
  FOREIGN KEY (idCarona) REFERENCES carona (idCarona)
);
