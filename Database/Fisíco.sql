CREATE DATABASE nasairline;

CREATE TABLE Destinos (
    id_destino INT PRIMARY KEY auto_increment NOT NULL,
    pais VARCHAR(40),
    preco DOUBLE,
    avaliacao INT
);

CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY auto_increment NOT NULL,
    nome VARCHAR(40),
    email VARCHAR(40),
    senha VARCHAR(20),
    telefone VARCHAR(11)
);

CREATE TABLE Promocoes (
    id_promocao INT PRIMARY KEY auto_increment NOT NULL,
    preco_promo DOUBLE,
    validade DATE
);

CREATE TABLE Reserva (
    id_reserva INT PRIMARY KEY auto_increment NOT NULL,
    cliente_id INT,
    promocao_id INT,
    destino_id int,
    valor DOUBLE,
    data_ida DATE,
    data_return DATE,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id_cliente) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (destino_id) REFERENCES destinos(id_destino) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (promocao_id) REFERENCES promocoes(id_promocao) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Inserção de dados na tabela Destinos
INSERT INTO Destinos (pais, preco, avaliacao) VALUES
('França', 1500.00, 4),
('Itália', 1200.00, 4),
('Japão', 1800.00, 5),
('Austrália', 1600.00, 4),
('Espanha', 1400.00, 4),
('Canadá', 1700.00, 4);

-- Inserção de dados na tabela Clientes
INSERT INTO Clientes (id_cliente, nome, email, senha, telefone) VALUES
('Maria Silva', 'maria@example.com', 'senha123', '1234567890'),
('João Santos', 'joao@example.com', 'senha456', '9876543210'),
('Ana Pereira', 'ana@example.com', 'senha789', '5551234567'),
('Pedro Gomes', 'pedro@example.com', 'senhaabc', '1112223333'),
('Marta Lima', 'marta@example.com', 'senhaxyz', '9998887777'),
('Carlos Mendes', 'carlos@example.com', 'senha456', '7778889999');

-- Inserção de dados na tabela Promocoes
INSERT INTO Promocoes (id_promocao, preco_promo, validade) VALUES
(1200.00, '2023-05-10'),
(1400.00, '2023-06-05'),
(1500.00, '2023-07-15'),
(1300.00, '2023-08-01'),
(1100.00, '2023-09-10'),
(1250.00, '2023-10-20');

-- Inserção de dados na tabela Reserva
INSERT INTO Reserva (id_reserva, cliente_id, promocao_id, destino_id, valor, data_ida, data_return) VALUES
(1, 1, 1, 2, 1200.00, '2023-05-15', '2023-05-20'),
(2, 2, 3, 4, 1600.00, '2023-06-10', '2023-06-17'),
(3, 3, 2, 3, 1800.00, '2023-07-20', '2023-07-30'),
(4, 4, 4, 5, 1400.00, '2023-08-05', '2023-08-12'),
(5, 5, 1, 1, 1500.00, '2023-09-12', '2023-09-20'),
(6, 6, 5, 6, 1700.00, '2023-10-01', '2023-10-10');


/* Seleção Tabelas */
SELECT * FROM Destinos;
SELECT * FROM Clientes;
SELECT * FROM Promocoes;
SELECT * FROM Reserva;

/* Seleção Personalizada */
-- Compra - Cliente
SELECT r.id_reserva, c.nome AS nome_cliente, d.pais AS destino, p.preco_promo AS preco_promocao, r.data_ida, r.data_return
FROM Reserva AS r
JOIN Clientes AS c ON r.cliente_id = c.id_cliente
JOIN Destinos AS d ON r.destino_id = d.id_destino
JOIN Promocoes AS p ON r.promocao_id = p.id_promocao
ORDER BY nome_cliente;

-- Destino - Promoção
SELECT d.pais AS destino, d.preco, p.preco_promo AS preco_promocao, p.validade AS validade_promocao
FROM Destinos AS d
JOIN Promocoes AS p ON d.promocao_id = p.id_promocao
ORDER BY destino;

/* Atualização de Dados */
-- Clientes
UPDATE Clientes SET nome = 'Bruna da Silva', email = 'brunasilva@hotmail.com', senha = '2508' WHERE id_cliente = 6;

-- Destinos
UPDATE Destinos SET pais = 'São Paulo', preco = 950.00 WHERE id_destino = 1;

-- Reserva
UPDATE Reserva SET data_ida = '2023-12-25', data_return = '2023-12-31' WHERE id_reserva = 6;

-- Promoções
UPDATE Promocoes SET preco_promo = 0.20, validade = '2023-09-20 17:00:00' WHERE id_promocao = 2;

/* Exclusão de Dados */
-- Clientes 
DELETE FROM Clientes WHERE id_cliente = 6;

-- Destinos
DELETE FROM Destinos WHERE id_destino = 27;

-- Reserva
DELETE FROM Reserva WHERE id_reserva = 9;

-- Promoções
DELETE FROM Promocoes WHERE id_promocao = 4;
