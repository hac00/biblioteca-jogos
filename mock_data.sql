INSERT INTO usuarios (nome, email, senha) VALUES ('user1', 'user1@email.com', '1234');
INSERT INTO usuarios (nome, email, senha) VALUES ('user2', 'user2@email.com', '4321');

INSERT INTO jogos (usuario_id, nome, genero, plataforma, horas, nota, jogando, capa) VALUES
(1, 'The Last of Us Part I', 'Acao-Aventura', 'PS5', 30, 10, FALSE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/coa1gq.webp'),
(1, 'TESV: Skyrim', 'RPG', 'PC', 150, 10, TRUE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/cobt0i.webp'),
(1, 'MGS4', 'RPG', 'PS3', 20, 8, TRUE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/co5eju.webp'),
(1, 'God of War Ragnarok', 'Ação/RPG', 'PS5', 12.0, 9, TRUE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/coba3d.webp'),
(1, 'The Witcher 3: Wild Hunt', 'RPG', 'PC', 150.2, 10, FALSE, NULL),
(2, 'Super Mario', 'Plataforma', 'SNES', 10, 9, FALSE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/co4az5.webp'),
(2, 'Top Gear', 'Corrida', 'SNES', 5, 7, FALSE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/co63nx.webp'),
(2, 'Elden Ring', 'RPG/Soulslike', 'PC', 85.0, 10, FALSE, 'https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.webp'),
(2, 'Cyberpunk 2077', 'RPG/Ficção', 'Xbox Series X', 4.5, 7, TRUE, NULL);

INSERT INTO wishlist (usuario_id, nome, plataforma, preco_maximo) VALUES
(1, 'Crimson Desert', 'PC', 250.00),
(1, 'Demon''s Souls', 'PS5', 100.00),
(2, 'GTA VI', 'PS5', 400.00),
(2, 'Resident Evil', 'PC', 30.00);