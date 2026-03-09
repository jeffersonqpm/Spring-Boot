-- #  quando inicializar, criar as tabelas

-- spring.jpa.defer-datasource-initialization=true
-- spring.sql.init.mode=always


INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Maria Oliveira', '98765432100', 'maria.oliveira@email.com',
        'senhaForte987', '1985-10-30', 'INATIVO');

        INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Carlos Pereira', '11122233344', 'carlos.pereira@email.com',
        'minhaSenha456', '1978-03-22', 'BLOQUEADO');

INSERT INTO TB_USUARIOS (nome, cpf, email, senha, data_nascimento, status)
VALUES ('Ana Costa', '55566677788', 'ana.costa@email.com',
        'anacosta2024', '1995-11-05', 'ATIVO');

        -- PROJETOS

INSERT INTO TB_PROJETOS
    (nome, descricao, data_inicio, data_final, status, usuario_resp_id)
VALUES
    ('Sistema de Gestão Escolar',
     'Projeto para desenvolver um sistema completo de gestão escolar.',
     '2024-01-10',
     NULL,
     'EM_ANDAMENTO',
     1);


INSERT INTO TB_PROJETOS
    (nome, descricao, data_inicio, data_final, status, usuario_resp_id)
VALUES
    ('Portal Corporativo',
     'Criação de um portal interno para comunicação e processos corporativos.',
     '2023-05-01',
     '2023-12-15',
     'FINALIZADO',
     2);

     INSERT INTO TB_PROJETOS
    (nome, descricao, data_inicio, data_final, status, usuario_resp_id)
VALUES
    ('Aplicativo Mobile de Entregas',
     'Aplicativo para otimizar a logística de entregas com geolocalização.',
     '2025-02-01',
     NULL,
     'PLANEJADO',
     3);

     INSERT INTO TB_PROJETOS
    (nome, descricao, data_inicio, data_final, status, usuario_resp_id)
VALUES
    ('Sistema Financeiro Integrado',
     'Projeto suspenso devido à reestruturação do orçamento anual.',
     '2024-06-20',
     NULL,
     'SUSPENSO',
     1);


-- tarefas

INSERT INTO TB_TAREFAS
    (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES
    ('Analisar requisitos do sistema',
     'Revisar documentação inicial e levantar requisitos com o cliente.',
     '2026-03-01',
     NULL,
     'ALTA',
     'PENDENTE',
     1,
     1);

     INSERT INTO TB_TAREFAS
    (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES
    ('Desenvolver módulo de login',
     'Implementar autenticação e geração de tokens JWT.',
     '2026-03-05',
     NULL,
     'MEDIA',
     'EM_ANDAMENTO',
     2,
     1);

     INSERT INTO TB_TAREFAS
    (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES
    ('Gerar documentação inicial',
     'Criar README e documentação do ambiente de desenvolvimento.',
     '2026-02-10',
     '2026-02-12',
     'BAIXA',
     'CONCLUIDA',
     3,
     2);

     INSERT INTO TB_TAREFAS
    (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES
    ('Criar protótipo de interface',
     'Prototipação das telas principais utilizando Figma.',
     '2026-01-20',
     NULL,
     'ALTA',
     'ATRASADA',
     1,
     3);

     INSERT INTO TB_TAREFAS
    (titulo, descricao, data_criacao, data_conclusao, prioridade, status, usuario_id, projeto_id)
VALUES
    ('Configurar ambiente de testes',
     'Preparar ambiente para testes automatizados e pipelines.',
     '2026-03-08',
     NULL,
     'MEDIA',
     'PLANEJADA',
     2,
     2);

