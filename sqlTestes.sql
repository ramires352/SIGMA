select * from terreno;

select * from produto;

select * from plantio;

select if((select cultura from terreno where idTerreno = 1) in (select tipo from produto where login = 'teste'),'TRUE','FALSE');

select qtde from produto where tipo = 'Soja';
update produto set qtde = qtde + 10 where tipo = 'Soja' and login = 'teste';

select * from movimento;

select * from colheita;

select * from colheita where data > '2018-09-13';

select * from colheita where idTerreno in (select idTerreno from terreno where login = 'teste') and data >= '2018-09-13' and data <= '2018-09-14';

insert into movimento (nome, tipo, qtde, preco_un, login, data) values ("testando","Semente",10,45.67,"teste",'2018-09-19');

select * from produto where login = 'teste' and tipo in ('Soja','Milho','Aveia','Trigo');