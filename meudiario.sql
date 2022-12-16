create database meudiario;
use meudiario;

create table aluno(RA int not null primary key, nome varchar(100) not null, CPF varchar(100) not null);
create table professor(id int not null primary key, nome varchar(100) not null, CPF varchar(100) not null);
create table classe(turma varchar(20) not null primary key, idProfessor int not null, RAAluno int not null, media double default(0), foreign key 
(idProfessor) references professor(id), foreign key (RAAluno) references aluno(RA));



