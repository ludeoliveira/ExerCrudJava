###comandos pg admin

####criar tabela:

create table cachorro(
 id serial primary key,
 raca varchar(50),
 grupo varchar(50),
 altura varchar(20),
 personalidade varchar(50),
)

####consultar dados:

select * from cachorro

####inserir dados:

insert into cachorro(raca, grupo, altura, personalidade)values('Dalmata', 'Grupo dos Não Esportistas', '56 a 61 cm', 'Amigável, ativo, brincalhão, extrovertido');


####editar dados:

update cachorro set
raca = 'beagle',
grupo = 'grupo dos hounds',
altura = '36 a 41 cm',
personalidade = 'Amável, Determinado, Gentil, Inteligente'
where id = x

