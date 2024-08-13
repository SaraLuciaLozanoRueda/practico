INSERT INTO paises (nombre) VALUES ("Colombia");

INSERT INTO regiones (nombre,pais_id) VALUES ("Central",1);

INSERT INTO ciudades (nombre,region_id) VALUES ("Bogota",1);

INSERT INTO laboratorios (nombre,ciudad_id) VALUES ("sas.lab" , 1);

INSERT INTO activos (nombre) VALUES ("activo1");
 
INSERT INTO administraciones (descripcion) VALUES ("descripcion1");

INSERT INTO unidad (nombre) VALUES ("unidad1");

INSERT INTO clientes (nombre,apellido,ciudad_id,email,cumpleaños,lon,latitud) VALUES ("sara","lozano",1,"sara@gmail.com","2007/04/02",12,16);

INSERT INTO farmacias (nombre,direccion,lon,latfarmacia,ciudad_id,logo) VALUES ("PYG.far","cll 17 - 24 -74",12,34,1,"nosotros te atendemos");

INSERT INTO medicinas (procedimientos,nombre,registro,descripcion,admin_id,activo_id,unidad_id,rol,laboratorio_id) VALUES ("ciruguia","anestesia","op.1234","provee adormecimiento y reduccion de dolor",1,1,1,"enfermo",1);

INSERT INTO farmedi (farmacia_id,medicina_id,precio) VALUES (1,1,123);