Create database Sessions;

Use Sessions;

Create table Usuarios
(
    Codigo int identity(1,1),
    Nombre varchar (100),
    Apellido varchar(100),
    Correo varchar(100),
    DNI varchar(8),
    Celular varchar(9),
    Usuario varchar(15),
    Pass varchar(50),
    Nivel varchar(1),
    Estado varchar(1)
    Constraint Codigo_PK primary key (Codigo)
);

--Drop table Usuarios;

Insert into Usuarios (Usuario,Pass,Nombre,Apellido,Correo,DNI,Celular,Nivel,Estado) values ('daniel','fe01ce2a7fbac8fafaed7c982a04e229','DANIEL','ACEVEDO JHONG','dacevedo@gmail.com','11111111','123456789','1','A');
Insert into Usuarios (Usuario,Pass,Nombre,Apellido,Correo,DNI,Celular,Nivel,Estado) values ('miguel','fe01ce2a7fbac8fafaed7c982a04e229','MIGUELVICENTE','AGURTO RONDOY','magurto@gmail.com','11111111','123456789','2','A');
Insert into Usuarios (Usuario,Pass,Nombre,Apellido,Correo,DNI,Celular,Nivel,Estado) values ('alcala','fe01ce2a7fbac8fafaed7c982a04e229','CHRISTIAN NELSON','ALCALÁ NEGRÓN','calcala@gmail.com','11111111','123456789','1','A');
Insert into Usuarios (Usuario,Pass,Nombre,Apellido,Correo,DNI,Celular,Nivel,Estado) values ('almora','fe01ce2a7fbac8fafaed7c982a04e229','RAUL EDUARDO','ALMORA HERNANDEZ','ralmora@gmail.com','11111111','123456789','1','A');
Insert into Usuarios (Usuario,Pass,Nombre,Apellido,Correo,DNI,Celular,Nivel,Estado) values ('jorge','fe01ce2a7fbac8fafaed7c982a04e229','JORGE ','ALOSILLA VELAZCO VERA','jalosilla@gmail.com','11111111','123456789','2','A');


