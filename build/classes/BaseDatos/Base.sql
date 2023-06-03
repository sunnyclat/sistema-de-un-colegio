/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sunnyclat
 * Created: May 30, 2019



host:remotemysql.com
port:3306
user:ZnQXQsvfXA
pass: 6oUEIrhlzd

database name: ZnQXQsvfXA




   LIKNKS NETBEANS DRIVER OLD
    https://stackoverflow.com/questions/46131295/classcastexception-java-math-biginteger-cannot-be-cast-to-java-lang-long-on-con


 */


/*
Nota:
Al ejecutar en el remoto los primeros comandos tiran error por la falta de derecho en crear la base, pero al final me crea las tablas

Siempre crear la conexion para la base de dato sql. No tiene nada que ver con el testconnection, ya que el driver en libraries funciona con la clase connector.

*/


drop database if exists colegio;
create database colegio;
use colegio;

drop table if exists alumnos;
drop table if exists cursos;

create table cursos(
	codigo int auto_increment primary key,
    materia varchar(25) not null,
    profesor varchar(25) not null,
    dia enum('lunes','martes','miercoles','jueves','viernes'),
    turno enum('mañana','tarde','noche')
);
create table alumnos(
	codigo int auto_increment primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int,
    codigoCurso int
);
alter table alumnos 
	add constraint fk_alumnos_codigoCurso
    foreign key(codigoCurso)
    references cursos(codigo);

show tables;
select *from cursos;



