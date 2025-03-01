-- Creación de base de datos
CREATE database examen_practico;

-- Elimnar tablas si ya existen
DROP TABLE IF EXISTS examen_practico.payments;
DROP TABLE IF EXISTS examen_practico.payments_seq;
DROP TABLE IF EXISTS examen_practico.status_payment;
DROP TABLE IF EXISTS examen_practico.status_payment_seq;


-- Creación de tabla para almacenar los estatus de los pagos
CREATE TABLE examen_practico.status_payment(
    status_id INT PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100) NOT NULL
);

-- Creación de tabla para alcenar los pagos
CREATE TABLE examen_practico.payments (
    pay_id INT PRIMARY KEY AUTO_INCREMENT,
    concept varchar(255) NOT NULL,
    quantity_products int NOT NULL,
    shipping_person varchar(255) NOT NULL,
    deposit_person varchar(255) NOT NULL,
    amount decimal(10.2) NOT NULL,
    status int not null,
    constraint fk_payments_status_payment foreign key(status) references status_payment(status_id) on delete cascade on update cascade
);
