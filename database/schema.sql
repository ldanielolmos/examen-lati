-- Make sure we're using our `blog` database
\c laticash;

CREATE TABLE IF NOT EXISTS clientes (
  id SERIAL PRIMARY KEY,
  nombre varchar(255),
  paterno varchar(255),
  materno varchar(255)
);

CREATE TABLE IF NOT EXISTS cat_cuentas (
  tipo_cuenta varchar(10) PRIMARY KEY,
  descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS cat_operaciones(
  tipo_operacion varchar(10) PRIMARY KEY,
  descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS operaciones (
  id SERIAL PRIMARY KEY,
  tipo_operacion varchar(10),
  fecha_operacion timestamp
);

CREATE TABLE IF NOT EXISTS cuentas (
  id SERIAL PRIMARY KEY,
  tipo_cuenta varchar(10),
  cliente int,
  monto_apertura decimal,
  fecha_apertura timestamp,
  id_operacion int,
  comision_apertura decimal,
  saldo_final decimal
);

CREATE TABLE IF NOT EXISTS cat_creditos(
  tipo_credito varchar(10) PRIMARY KEY,
  descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS solicitudes (
  id SERIAL PRIMARY KEY,
  fecha_solicitud timestamp,
  cliente int,
  tipo_credito varchar(10),
  monto_solicitado decimal,
  aprobado boolean,
  comentarios varchar(100),
  id_operacion int
);

CREATE TABLE IF NOT EXISTS creditos ( 
  id SERIAL PRIMARY KEY,
  fecha_credito timestamp,
  monto_aprobado decimal,
  plazo_aprobado int,
  interes_mensual decimal,
  solicitud int,
  id_operacion int
);

CREATE TABLE IF NOT EXISTS depositos(
  id SERIAL PRIMARY KEY,
  fecha_deposito timestamp,
  cuenta int, 
  monto_deposito decimal,
  id_operacion int
);

ALTER TABLE operaciones ADD FOREIGN KEY (tipo_operacion) REFERENCES cat_operaciones (tipo_operacion);

ALTER TABLE cuentas ADD FOREIGN KEY (cliente) REFERENCES clientes (id);

ALTER TABLE cuentas ADD FOREIGN KEY (tipo_cuenta) REFERENCES cat_cuentas (tipo_cuenta);

ALTER TABLE cuentas ADD FOREIGN KEY (id_operacion) REFERENCES operaciones (id);

ALTER TABLE solicitudes ADD FOREIGN KEY (tipo_credito) REFERENCES cat_creditos (tipo_credito);

ALTER TABLE solicitudes ADD FOREIGN KEY (id_operacion) REFERENCES operaciones (id);

ALTER TABLE creditos ADD FOREIGN KEY (solicitud) REFERENCES solicitudes (id);

ALTER TABLE creditos ADD FOREIGN KEY (id_operacion) REFERENCES operaciones (id);

ALTER TABLE depositos ADD FOREIGN KEY (cuenta) REFERENCES cuentas (id);

ALTER TABLE depositos ADD FOREIGN KEY (id_operacion) REFERENCES operaciones (id);

INSERT INTO public.clientes (nombre, paterno, materno)
VALUES ('MARIO ANTONIO', 'TORRES', 'CASTRO');

INSERT INTO public.clientes (nombre, paterno, materno)
VALUES ('MARCO', 'PEREZ', 'BECERRA');

INSERT INTO public.clientes (nombre, paterno, materno)
VALUES ('PAULINA', 'RUBIO', 'TORRES');

INSERT INTO public.cat_cuentas (tipo_cuenta, descripcion)
VALUES ('AHORRO', 'CUENTAS DE AHORRO');

INSERT INTO public.cat_cuentas (tipo_cuenta, descripcion)
VALUES ('CHEQUES', 'CUENTAS DE CHEQUES');

INSERT INTO public.cat_cuentas (tipo_cuenta, descripcion)
VALUES ('CREDITO', 'CUENTAS DE CREDITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CNTA-ALTA', 'ALTA DE CUENTAS');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CNTA-BAJA', 'BAJA DE CUENTAS');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CNTA-MOD', 'MOD DE CUENTAS');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('SOL-ALTA', 'ALTA DE SOLICITUD');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('SOL-BAJA', 'BAJA DE SOLICITUD');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('SOL-MOD', 'MOD DE SOLICITUD');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CRED-ALTA', 'ALTA DE CREDITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CRED-BAJA', 'BAJA DE CREDITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('CRED-MOD', 'MOD DE CREDITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('DEP-ALTA', 'ALTA DE DEPOSITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('DEP-BAJA', 'BAJA DE DEPOSITO');

INSERT INTO public.cat_operaciones (tipo_operacion, descripcion)
VALUES ('DEP-MOD', 'MOD DE DEPOSITO');

INSERT INTO public.cat_creditos (tipo_credito, descripcion)
VALUES ('PERSONAL', 'CREDITO PERSONAL');

INSERT INTO public.cat_creditos (tipo_credito, descripcion)
VALUES ('NOMINA', 'CREDITO PERSONAL');
