-- Inserts de los estatus
insert into examen_practico.status_payment (status_id, description) values (1, 'Iniciado');
insert into examen_practico.status_payment (status_id, description) values (2, 'En proceso');
insert into examen_practico.status_payment (status_id, description) values (3, 'Finalizado');

-- Confirmación de los antes ejecutado
commit;