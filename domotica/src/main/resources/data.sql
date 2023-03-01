CREATE TABLE IF NOT EXISTS control_hogar.usuario{
    id INT PRIMARY KEY NOT NULL SERIAL,
    usuario VARCHAR(45) NOT  NULL,
    password VARCHAR(45) NOT NULL
};
CREATE TABLE IF NOT EXISTS control_hogar.hogar{
    id INT PRIMARY KEY NOT NULL SERIAL,
    tipo VARCHAR(45) NULL,
    nombre VARCHAR(45) NULL,
    pin INT NULL,
    estado INT NULL
};

INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (1, 'Luz', 'Dormitorio', 1, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (2, 'Luz', 'Sala', 2, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (3, 'Luz', 'Cocina', 3, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (4, 'Luz', 'Baño', 4, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (5, 'Luz', 'Garaje', 5, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (6, 'Puerta', 'Garaje', 6, 0);
INSERT INTO IF NOT EXISTS control_hogar.hogar (`id`, `tipo`, `nombre`, `pin`, `estado`) VALUES (7, 'Puerta', 'Principal', 7, 0);