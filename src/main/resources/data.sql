INSERT INTO INTEGRA.USUARIO
(id, nome, email, usuario, senha, status, data_criacao, cliente_id)
VALUES(1, 'Rodrigo', 'rodrigo@gmail.com', 'rodrigo.nunes', '$2a$10$7piXDrZUpm7ErxVk7BVEPu5waHYxBl8cL7ht.fEjf5cV0uOY1hAlG', 1, '2021-08-20', 1);

INSERT INTO INTEGRA.CLIENTE
(id, nome, ativo)
VALUES(1, 'Exito', 1);

INSERT INTO INTEGRA.GRUPO
(id, nome)
VALUES(1, 'Normal');
