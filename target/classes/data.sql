INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES ('Ana Silva', 'ana@exemplo.com', 'Dados', 'Pleno', CURRENT_DATE());

INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES ('João Santos', 'joao@exemplo.com', 'Cibersegurança', 'Junior', CURRENT_DATE());

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal)
VALUES ('Fundamentos de IA', 'Trilha introdutória de IA', 'INICIANTE', 20, 'IA');

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal)
VALUES ('Análise de Dados', 'Trilha para análise de dados', 'INTERMEDIARIO', 40, 'Dados');
