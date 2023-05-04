select * from clientes
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA "public" to aplicacao_user;
GRANT SELECT, USAGE, UPDATE ON ALL SEQUENCES IN SCHEMA "public" to aplicacao_user;

create table clientes(
    id_clientes bigint,
    nome text NOT NULL,
	email text NOT NULL,
	cpf integer NOT NULL,
    nome_social text NOT NULL,
	idade integer NOT NULL,
	altura double precision NOT NULL,
	massa integer NOT NULL,
	genero text NOT NULL,
	telefone integer NOT NULL,
	celular integer NOT NULL,
	endereco text NOT NULL,
    CONSTRAINT id_clientes PRIMARY KEY (id_clientes)
)