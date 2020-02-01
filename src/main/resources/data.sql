create table produto (
    id int not null primary key auto_increment,
    nome varchar(100),
    descricao varchar(255),
    preco double(10,2)
);

insert into produto (nome, descricao, preco) 
	values ('iphone.jpeg',
		'Um exemplo de texto rápido para construir o título do card e fazer preencher o conteúdo do card.',
		4500.00
	);
	
select * from produto;	