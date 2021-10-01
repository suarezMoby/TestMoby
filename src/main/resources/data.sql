DROP TABLE IF EXISTS candidato;

CREATE TABLE candidato (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  tipo VARCHAR(10) NOT NULL,
  dni int DEFAULT NULL,
  fecha_nacimiento date DEFAULT NULL
);

INSERT INTO candidato (nombre, apellido, tipo, dni, fecha_nacimiento) VALUES
  ('Danilo', 'Suarez', 'DNI', '33102857', '1987-07-16'),
  ('Cristian', 'Fabro', 'DNI', '34133357', '1987-07-18');


  DROP TABLE IF EXISTS tecnologia;

  CREATE TABLE tecnologia (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    nombre VARCHAR(250) NOT NULL,
    version VARCHAR(250) NOT NULL
  );

  INSERT INTO tecnologia (nombre, version) VALUES
    ('Java', '1.1'),
    ('Phyton', '2');

  DROP TABLE IF EXISTS candidato_x_tecnologia;

      CREATE TABLE candidato_x_tecnologia (
        id_candidato_x_tecnologia INT AUTO_INCREMENT  PRIMARY KEY,
        id_candidato INT NOT NULL,
        id_tecnologia INT NOT NULL,
        anios_experiencia INT NOT NULL,
        CONSTRAINT `FK_candidato` FOREIGN KEY (`id_candidato`) REFERENCES `candidatos` (`id`),
        CONSTRAINT `FK_tecnologia` FOREIGN KEY (`id_tecnologia`) REFERENCES `tecnologia` (`id`);
      );

      INSERT INTO tecnologia (id_candidato, id_tecnologia, anios_experiencia) VALUES
        ('1', '2', '4'),
        ('2', '1', '2');