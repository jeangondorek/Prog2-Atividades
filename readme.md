# Atividades prog2

## Execução de exercicios para matéria de prog2
Projeto em Java, utiliza JSF com xhtml.

##### To create tables on database

```
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