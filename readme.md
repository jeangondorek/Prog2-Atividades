# Atividades prog2

## Execução de exercicios para matéria de prog2
Projeto em Java, utiliza JSF com xhtml.

##### To create tables on database

```

-- Início SQL
CREATE USER aplicacao_user PASSWORD 'aplicacao_user';
-- Fim SQL

-- Início SQL

-- Remove tabelas caso já existam
-- DROP TABLE permissao, usuario, tipo_permissao;

-- Cria tabela para usuário do sistema e inicializa com dois usuários iniciais
CREATE TABLE IF NOT EXISTS public.usuario
(
    id_usuario SERIAL, 
    usuario text NOT NULL UNIQUE,
    email text NOT NULL,
    senha text NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
);

-- Cria tabela para tipos de permissões usadas no sistema e inicializa com dois valores
CREATE TABLE IF NOT EXISTS public.tipo_permissao
(
    id_tipo_permissao SERIAL,
    permissao text NOT NULL,
    CONSTRAINT tipo_permissao_pkey PRIMARY KEY (id_tipo_permissao)
);
-- Inicializa tipos de permissao do sistema
INSERT INTO tipo_permissao (permissao) VALUES ('ADMINISTRADOR');
INSERT INTO tipo_permissao (permissao) VALUES ('CLIENTE');
INSERT INTO tipo_permissao (permissao) VALUES ('SERVIDOR');

-- Cria tabela de relacionamento nxn entre usuários e tipos de permissões
CREATE TABLE IF NOT EXISTS public.permissao
(
    id_usuario bigint NOT NULL,
    id_tipo_permissao bigint NOT NULL,
    CONSTRAINT permissao_pkey PRIMARY KEY (id_usuario, id_tipo_permissao),
    CONSTRAINT permissao_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario) ON DELETE CASCADE,
    CONSTRAINT permissao_tipo_permissao_fkey FOREIGN KEY (id_tipo_permissao) REFERENCES tipo_permissao (id_tipo_permissao) ON DELETE CASCADE
);

-- Conceda permissões ao usuário do banco que será usado pela aplicação
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "public" to aplicacao_user;
GRANT SELECT, USAGE, UPDATE ON ALL SEQUENCES IN SCHEMA "public" to aplicacao_user;
-- Fim SQL

CREATE TABLE IF NOT EXISTS public.camiseta
(
    idCamiseta SERIAL,
    descricao text NOT null,
    tamanho text NOT NULL,
    CONSTRAINT camiseta_pkey PRIMARY KEY (idCamiseta)
);
CREATE TABLE IF NOT EXISTS public.t_client
(
    cli_id SERIAL,
    cli_cpf text NOT null,
    cli_name text NOT NULL,
    cli_social_name text NOT NULL,
    cli_height double precision NOT NULL,
    cli_weight double precision NOT NULL,
    cli_gender text NOT NULL,
    cli_age integer NOT NULL,
    cli_email text NOT NULL,
    cli_cellphone text NOT NULL,
    cli_address text NOT NULL, 
    CONSTRAINT client_pkey PRIMARY KEY (cli_id)
);
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "public" to aplicacao_user;
GRANT SELECT, USAGE, UPDATE ON ALL SEQUENCES IN SCHEMA "public" to aplicacao_user;
```
