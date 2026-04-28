INSERT INTO `puesto_de_trabajo` (`id`, `nombre`) VALUES (1, 'Panadero');
INSERT INTO `puesto_de_trabajo` (`id`, `nombre`) VALUES (2, 'Analista de Laboratorio');
INSERT INTO `puesto_de_trabajo` (`id`, `nombre`) VALUES (3, 'Cajero');
INSERT INTO `puesto_de_trabajo` (`id`, `nombre`) VALUES (4, 'Repartidor');

INSERT INTO `genero` (`id`, `nombre`) VALUES (1, 'Masculino');
INSERT INTO `genero` (`id`, `nombre`) VALUES (2, 'Femenino');
INSERT INTO `genero` (`id`, `nombre`) VALUES (3, 'Otro');

INSERT INTO `usuario` (`id`, `contrasena`, `fecha_hora_creacion`, `fecha_nacimiento`, `hora_desayuno`, `nick_usuario`, `nombre`, `primer_apellido`, `segundo_apellido`, `genero_id`, `puesto_de_trabajo_id`) VALUES (1, 'password123', '2024-01-01', '1990-01-01', '10:00:00', 'diablito69', 'Juan', 'Azabache', 'Perez', 1, 2);
INSERT INTO `usuario` (`id`, `contrasena`, `fecha_hora_creacion`, `fecha_nacimiento`, `hora_desayuno`, `nick_usuario`, `nombre`, `primer_apellido`, `segundo_apellido`, `genero_id`, `puesto_de_trabajo_id`) VALUES (2, 'password456', '2024-01-02', '1992-02-02', '08:30:00', 'Marixxx', 'Maria', 'Lopez', NULL, 3, 3);
INSERT INTO `usuario` (`id`, `contrasena`, `fecha_hora_creacion`, `fecha_nacimiento`, `hora_desayuno`, `nick_usuario`, `nombre`, `primer_apellido`, `segundo_apellido`, `genero_id`, `puesto_de_trabajo_id`) VALUES (3, 'password789', '2024-01-03', '1985-03-03', '09:15:00', 'Carlos_San', 'Carlos', 'Martinez', 'Noriega', 2, 1);
INSERT INTO `usuario` (`id`, `contrasena`, `fecha_hora_creacion`, `fecha_nacimiento`, `hora_desayuno`, `nick_usuario`, `nombre`, `primer_apellido`, `segundo_apellido`, `genero_id`, `puesto_de_trabajo_id`) VALUES (4, 'password012', '2024-01-04', '1995-04-04', '07:45:00', 'AnaWin', 'Anita', 'Gonzalez', 'Wintour', 2, 4);

INSERT INTO `direccion` (`id`, `direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES (1, b'1', 'Calle Alondra', 123, 1);
INSERT INTO `direccion` (`id`, `direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES (5, b'0', 'Calle Secundaria', 321, 1);
INSERT INTO `direccion` (`id`, `direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES (2, b'1', 'Calle Real', 456, 2);
INSERT INTO `direccion` (`id`, `direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES (3, b'1', 'Avenida Principal', 789, 3);
INSERT INTO `direccion` (`id`, `direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES (4, b'1', 'Boulevard de la Paz', 101, 4);