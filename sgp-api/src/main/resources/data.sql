#  quando inicializar, criar as tabelas

-- spring.jpa.defer-datasource-initialization=true
-- spring.sql.init.mode=always

INSERT INTO tb_usuarios (nome, cpf, email, senha, data_nascimento, status) 
VALUES ('João Silva', '12345678901', 'joao@email.com', 'senha123', '1990-05-15', 'ATIVO');

INSERT INTO tb_usuarios (nome, cpf, email, senha, data_nascimento, status) 
VALUES ('Maria Souza', '98765432100', 'maria@email.com', 'segredo456', '1985-10-20', 'BLOQUEADO');

INSERT INTO tb_usuarios (nome, cpf, email, senha, data_nascimento, status) 
VALUES ('Carlos Oliveira', '55544433322', 'carlos@email.com', 'abc@123', '1998-02-28', 'INATIVO');


INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_final, status, usuario_resp_id) 
VALUES ('Sistema de Gestão', 'Desenvolvimento de um ERP completo', '2024-01-10', '2024-12-31', 'ATIVO', 1);

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_final, status, usuario_resp_id) 
VALUES ('App Mobile', 'Criação de aplicativo para iOS e Android', '2024-03-01', NULL, 'CONCLUIDO', 2);

INSERT INTO TB_PROJETOS (nome, descricao, data_inicio, data_final, status, usuario_resp_id) 
VALUES ('Migração de Dados', 'Transferência de banco local para nuvem', '2024-02-15', '2024-02-20', 'CANCELADO', 1);





-- tarefas**********************************************

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


    --  =============TAREFAS======================

    -- {
        
    --     "titulo": "Jefferson Queirozzzzzzzzzzzzzzzzzzzzzzzzzzzz",
    --     "descricao": "Queiroz Jefferson",
    --     "dataCriacao": "2026-03-01",
    --     "dataConclusao": "2026-03-09",
    --     "prioridade": "ALTA",
    --     "status": "PENDENTE",
    --     "usuario": {
    --         "id": 3,
    --         "nome": "João Silva",
    --         "cpf": "12345678901",
    --         "email": "joao@email.com",
    --         "senha": "senha123",
    --         "dataNascimento": "1990-05-15",
    --         "status": "ATIVO"
    --     },
    --     "projeto": {
    --         "id": 2,
    --         "nome": "Sistema de Gestão",
    --         "descricao": "Desenvolvimento de um ERP completo",
    --         "dataInicio": "2024-01-10",
    --         "dataFinal": "2024-12-31",
    --         "status": "ATIVO",
    --         "responsavel": {
    --             "id": 1,
    --             "nome": "João Silva",
    --             "cpf": "12345678901",
    --             "email": "joao@email.com",
    --             "senha": "senha123",
    --             "dataNascimento": "1990-05-15",
    --             "status": "ATIVO"
    --         }
    --     }
    -- }

