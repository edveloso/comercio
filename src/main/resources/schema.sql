--create database comercio;

--show databases;

--use comercio;
create table usuario (
     id int not null primary key auto_increment,
     login varchar(80),
     senha varchar(80)
);

insert into usuario(login,senha)
    values ('admin', 'admin');

select * from usuario;

create table produto (
  id int not null primary key auto_increment,
  foto varchar(80),
  nome varchar(80),
  descricao varchar(255),
  preco double(10,2)
);
select * from  produto;

insert into produto (foto, nome, descricao, preco)
    values(
		'iphone.jpeg',
        'Iphone',
        'Design inovador, totalmente em vidro. A câmera que o mundo inteiro adora, ainda melhor. O chip mais poderoso e inteligente em qualquer smartphone. Recarga sem fio simples de verdade.',
        3099.00
        );
        
insert into produto (foto, nome, descricao, preco)
    values(
		'cart.png',
        'Carrinho de Bebê Agile Cinza',
        'O Carrinho Multikids tem estrutura de alumínio, por isso é mais leve, resistente e versátil. Possui cinto de segurança de 5 pontos, capota retrátil com visor e tela, 3 rodas com travas e freios.',
        355.70
        );      
        
select * from produto;        

ALTER TABLE produto MODIFY foto blob(100000) ;

select * from hibernate_sequence ;

update hibernate_sequence set next_val = 7;

