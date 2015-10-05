create database appetite;

use appetite;

-- First Level
create table sucursal(
	id_sucursal int primary key auto_increment,
	nombre varchar(50)
);

create table menu(
	id_categoria int primary key auto_increment,
    nombre_categoria varchar(50),
    color varchar(30)
);

create table cuenta(
    id_cuenta int primary key auto_increment,
    total decimal(8,2),
    propina decimal(8,2)
);

create table tarjeta_credito(
	numero_tarjeta varchar(16) primary key,
    codigo_seguridad varchar(3),
    fecha_vencimiento date,
    tipo_tarjeta varchar(80)
);

create table codigo_promocion(
	id_promocion int primary key auto_increment,
    codigo varchar(12),
    vigencia date
);

-- Second level
create table asiento(
	id_asiento int primary key auto_increment,
    id_sucursal int not null,
    area varchar(50),
    foreign key (id_sucursal) references sucursal(id_sucursal)
);

create table platillo(
	id_platillo int primary key auto_increment,
    id_categoria int not null,
    nombre_platillo varchar(100),
    descripcion varchar(300),
    precio decimal(6,4),
    foreign key (id_categoria) references menu(id_categoria)
);


create table datos_pago(
	id_pago int primary key auto_increment,
    numero_tarjeta varchar(16) not null,
    nombre_propietario varchar(50),
    apellido_paterno varchar(50),
    apellido_materno varchar(50),
    correo varchar(80),
    foreign key(numero_tarjeta) references tarjeta_credito(numero_tarjeta)
);

-- Third level
create table carrito_compra(
	id_carrito int primary key auto_increment,
	id_categoria int not null,
    id_platillo int not null,
    id_promocion int,
    foreign key (id_categoria) references cuenta(id_cuenta),
    foreign key (id_promocion) references codigo_promocion(id_promocion),
    foreign key (id_platillo) references platillo(id_platillo)
);

create table reservacion(
	id_reservacion int primary key auto_increment,
    id_sucursal int not null,
    id_pago int,
    id_cuenta int not null,
    hora_entrada datetime,
    hora_salida datetime,
    numero_personas int,
    foreign key(id_sucursal) references sucursal(id_sucursal),
    foreign key(id_pago) references datos_pago(id_pago),
    foreign key(id_cuenta) references cuenta(id_cuenta)
);


