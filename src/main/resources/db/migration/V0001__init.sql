DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cidade` varchar(100) NOT NULL,
  `data_nascimento` datetime NOT NULL,
  `nome` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `ean` varchar(20) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `pedido`;
CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `valor_total` decimal(10,2) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `produto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

ALTER TABLE pedido ADD FOREIGN KEY (cliente_id) REFERENCES cliente(id);
ALTER TABLE pedido ADD FOREIGN KEY (produto_id) REFERENCES produto(id);

/*
  KEY `fk_pedido_cliente` (`cliente_id`),
  KEY `fk_pedido_produto` (`produto_id`)
*/

INSERT INTO cliente(cidade, data_nascimento, nome, uf) VALUES('Uberlandia', now(), 'Joao da silva', 'MG');
INSERT INTO cliente(cidade, data_nascimento, nome, uf) VALUES('São Paulo', now(), 'Carlos', 'SP');
INSERT INTO cliente(cidade, data_nascimento, nome, uf) VALUES('Rio de Janeiro', now(), 'João', 'RJ');

INSERT INTO produto(descricao, ean, valor) VALUES('Produto 001', '001', 150.00);
INSERT INTO produto(descricao, ean, valor) VALUES('Produto 002', '002', 180.00);
INSERT INTO produto(descricao, ean, valor) VALUES('Produto 003', '003', 260.00);

