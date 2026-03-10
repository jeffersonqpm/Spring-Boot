
-- #  quando inicializar, criar as tabelas

-- spring.jpa.defer-datasource-initialization=true
-- spring.sql.init.mode=always

-- Registro 1: ATIVO
INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Ricardo Sanches', '55544433322', 'ricardo.sanches@email.com', 'senha123', '1992-04-12', 'ATIVO');

-- Registro 2: INATIVO
INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Beatriz Souza', '11122233344', 'beatriz.souza@email.com', 'bia#2026', '1998-07-20', 'INATIVO');

-- Registro 3: BLOQUEADO
INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Fernando Rocha', '99988877766', 'fernando.rocha@email.com', 'rocha_pass', '1980-01-30', 'BLOQUEADO');

-- Registro 4: ATIVO
INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Luciana Alencar', '77766655544', 'luciana.a@email.com', 'lu@acesso', '1994-11-05', 'ATIVO');

-- Registro 5: BLOQUEADO
INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Marcos Pontes', '22233344455', 'marcos.p@email.com', 'mudar@321', '1987-09-15', 'BLOQUEADO');

INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Maria Oliveira', '98765432100', 'maria.oliveira@email.com','senhaForte987', '1985-10-30', 'INATIVO');

        INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Carlos Pereira', '11122233344', 'carlos.pereira@email.com','minhaSenha456', '1978-03-22', 'BLOQUEADO');

INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Ana Costa', '55566677788', 'ana.costa@email.com','anacosta2024', '1995-11-05', 'ATIVO');



INSERT INTO TB_PROJETOS (data_final, data_inicio, descricao, nome, status, usuario_resp_id)
VALUES ('2023-11-30', '2023-10-01', 'Análise de vulnerabilidades e conformidade.', 'Auditoria Anual', 'CONCLUIDO', 3);

INSERT INTO TB_PROJETOS (data_final, data_inicio, descricao, nome, status, usuario_resp_id)
VALUES ('2025-06-15', '2024-02-01', 'Desenvolvimento de plataforma de vendas.', 'E-commerce B2B', 'ATIVO', 1);

INSERT INTO TB_PROJETOS (data_final, data_inicio, descricao, nome, status, usuario_resp_id)
VALUES ('2024-04-10', '2024-03-01', 'Capacitação da equipe em novas tecnologias.', 'Treinamento Tech', 'ATIVO', 2);

INSERT INTO TB_PROJETOS (data_final, data_inicio, descricao, nome, status, usuario_resp_id)
VALUES ('2024-12-20', '2024-01-15', 'Upgrade de servidores e rede local.', 'Expansão Infra', 'ATIVO', 3);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES ('Analisar requisitos do sistema', 'Revisar documentação inicial e levantar requisitos com o cliente.', '2026-03-01', '2026-03-16', 'ALTA', 'CONCLUIDA', 1, 1);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES ('Desenvolver módulo de login', 'Implementar autenticação e geração de tokens JWT.', '2026-03-05', '2026-03-15', 'MEDIA', 'PENDENTE', 2, 1);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES ('Gerar documentação inicial', 'Criar README e documentação do ambiente de desenvolvimento.', '2026-02-10', '2026-02-12', 'BAIXA', 'CONCLUIDA', 3, 2);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES ('Criar protótipo de interface', 'Prototipação das telas principais utilizando Figma.', '2026-01-20', '2026-03-11', 'ALTA', 'PENDENTE', 1, 3);

INSERT INTO TB_TAREFAS (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES ('Configurar ambiente de testes', 'Preparar ambiente para testes automatizados e pipelines.', '2026-03-08', NULL, 'MEDIA', 'CONCLUIDA', 2, 2);