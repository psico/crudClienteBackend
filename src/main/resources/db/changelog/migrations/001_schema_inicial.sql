--liquibase formatted sql

--changeset jg:1
-- CREATE DATABASE "crudClienteCooperSys"
--     WITH
--     OWNER = postgres
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'Portuguese_Brazil.1252'
--     LC_CTYPE = 'Portuguese_Brazil.1252'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1;

CREATE SEQUENCE perfil_id_perfil_seq;

CREATE TABLE IF NOT EXISTS perfil (
                        id_perfil INTEGER NOT NULL DEFAULT nextval('perfil_id_perfil_seq'),
                        descricao VARCHAR NOT NULL,
                        CONSTRAINT perfil_pk PRIMARY KEY (id_perfil)
);
COMMENT ON COLUMN perfil.id_perfil IS 'ID perfil';
COMMENT ON COLUMN perfil.descricao IS 'Descrição do perfil.';


ALTER SEQUENCE perfil_id_perfil_seq OWNED BY perfil.id_perfil;

CREATE SEQUENCE usuario_id_usuario_seq;

CREATE TABLE IF NOT EXISTS usuario (
                         id_usuario INTEGER NOT NULL DEFAULT nextval('usuario_id_usuario_seq'),
                         nome VARCHAR NOT NULL,
                         cpf VARCHAR(11) NOT NULL,
                         senha VARCHAR NOT NULL,
                         id_perfil INTEGER NOT NULL,
                         CONSTRAINT usuario_pk PRIMARY KEY (id_usuario)
);
COMMENT ON COLUMN usuario.id_usuario IS 'ID do usuário';
COMMENT ON COLUMN usuario.nome IS 'Nome do usuário.';
COMMENT ON COLUMN usuario.cpf IS 'CPF do usuário.';
COMMENT ON COLUMN usuario.senha IS 'Senha do usuário.';
COMMENT ON COLUMN usuario.id_perfil IS 'ID perfil';


ALTER SEQUENCE usuario_id_usuario_seq OWNED BY usuario.id_usuario;

CREATE SEQUENCE endereco_id_endereco_seq;

CREATE TABLE IF NOT EXISTS endereco (
                          id_endereco INTEGER NOT NULL DEFAULT nextval('endereco_id_endereco_seq'),
                          cep VARCHAR NOT NULL,
                          logradouro VARCHAR NOT NULL,
                          bairro VARCHAR NOT NULL,
                          cidade VARCHAR NOT NULL,
                          uf VARCHAR(2) NOT NULL,
                          complemento VARCHAR,
                          id_usuario INTEGER NOT NULL,
                          CONSTRAINT endereco_pk PRIMARY KEY (id_endereco)
);
COMMENT ON COLUMN endereco.id_endereco IS 'ID endereço';
COMMENT ON COLUMN endereco.cep IS 'CEP do endereço.';
COMMENT ON COLUMN endereco.logradouro IS 'Logradouro do endereço.';
COMMENT ON COLUMN endereco.bairro IS 'Bairro do endereço.';
COMMENT ON COLUMN endereco.cidade IS 'Cidade do endereço.';
COMMENT ON COLUMN endereco.uf IS 'UF do endereço, somente 2 caracteres.';
COMMENT ON COLUMN endereco.complemento IS 'Complemento do endereço.';
COMMENT ON COLUMN endereco.id_usuario IS 'ID do usuário';


ALTER SEQUENCE endereco_id_endereco_seq OWNED BY endereco.id_endereco;

CREATE SEQUENCE email_id_email_seq;

CREATE TABLE IF NOT EXISTS email (
                       id_email INTEGER NOT NULL DEFAULT nextval('email_id_email_seq'),
                       descricao VARCHAR NOT NULL,
                       principal BOOLEAN DEFAULT false NOT NULL,
                       id_usuario INTEGER NOT NULL,
                       CONSTRAINT email_pk PRIMARY KEY (id_email)
);
COMMENT ON COLUMN email.id_email IS 'ID e-mail';
COMMENT ON COLUMN email.descricao IS 'Descrição do e-mail.';
COMMENT ON COLUMN email.principal IS 'Diz se o telefone é principal a ser usado pelo usuário.';
COMMENT ON COLUMN email.id_usuario IS 'ID do usuário';


ALTER SEQUENCE email_id_email_seq OWNED BY email.id_email;

CREATE SEQUENCE log_operacoes_id_log_operacoes_seq;

CREATE TABLE IF NOT EXISTS log_operacoes (
                               id_log_operacoes INTEGER NOT NULL DEFAULT nextval('log_operacoes_id_log_operacoes_seq'),
                               tipo_operacao VARCHAR NOT NULL,
                               data DATE NOT NULL,
                               id_usuario INTEGER NOT NULL,
                               CONSTRAINT log_operacoes_pk PRIMARY KEY (id_log_operacoes)
);
COMMENT ON COLUMN log_operacoes.id_log_operacoes IS 'ID log de operações';
COMMENT ON COLUMN log_operacoes.tipo_operacao IS 'Tipo Operação.';
COMMENT ON COLUMN log_operacoes.data IS 'Data inserção do registro.';
COMMENT ON COLUMN log_operacoes.id_usuario IS 'ID do usuário';


ALTER SEQUENCE log_operacoes_id_log_operacoes_seq OWNED BY log_operacoes.id_log_operacoes;

CREATE SEQUENCE tipo_telefone_id_tipo_telefone_seq;

CREATE TABLE IF NOT EXISTS tipo_telefone (
                               id_tipo_telefone INTEGER NOT NULL DEFAULT nextval('tipo_telefone_id_tipo_telefone_seq'),
                               descricao VARCHAR NOT NULL,
                               CONSTRAINT tipo_telefone_pk PRIMARY KEY (id_tipo_telefone)
);
COMMENT ON COLUMN tipo_telefone.id_tipo_telefone IS 'ID tipo telefone.';
COMMENT ON COLUMN tipo_telefone.descricao IS 'Descrição dos tipos de telefone.';


ALTER SEQUENCE tipo_telefone_id_tipo_telefone_seq OWNED BY tipo_telefone.id_tipo_telefone;

CREATE SEQUENCE telefone_id_telefone_seq;

CREATE TABLE IF NOT EXISTS telefone (
                          id_telefone INTEGER NOT NULL DEFAULT nextval('telefone_id_telefone_seq'),
                          ddi VARCHAR(3) NOT NULL,
                          ddd VARCHAR(3) NOT NULL,
                          telefone VARCHAR NOT NULL,
                          id_usuario INTEGER NOT NULL,
                          id_tipo_telefone INTEGER NOT NULL,
                          CONSTRAINT telefone_pk PRIMARY KEY (id_telefone)
);
COMMENT ON COLUMN telefone.id_telefone IS 'Id telefone';
COMMENT ON COLUMN telefone.telefone IS 'Telefone do usuario, deve ser somente o número de telefone, sem DDI, sem DDD e sem mascára.';
COMMENT ON COLUMN telefone.id_usuario IS 'ID do usuário';
COMMENT ON COLUMN telefone.id_tipo_telefone IS 'ID tipo telefone.';


ALTER SEQUENCE telefone_id_telefone_seq OWNED BY telefone.id_telefone;

ALTER TABLE usuario ADD CONSTRAINT perfil_usuario_fk
    FOREIGN KEY (id_perfil)
        REFERENCES perfil (id_perfil)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE log_operacoes ADD CONSTRAINT usuario_log_operacoes_fk
    FOREIGN KEY (id_usuario)
        REFERENCES usuario (id_usuario)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE telefone ADD CONSTRAINT usuario_telefone_fk
    FOREIGN KEY (id_usuario)
        REFERENCES usuario (id_usuario)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE email ADD CONSTRAINT usuario_email_fk
    FOREIGN KEY (id_usuario)
        REFERENCES usuario (id_usuario)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE endereco ADD CONSTRAINT usuario_endereco_fk
    FOREIGN KEY (id_usuario)
        REFERENCES usuario (id_usuario)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE telefone ADD CONSTRAINT tipo_telefone_telefone_fk
    FOREIGN KEY (id_tipo_telefone)
        REFERENCES tipo_telefone (id_tipo_telefone)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;



INSERT INTO perfil(
    id_perfil, descricao)
VALUES (1, 'admin');

INSERT INTO perfil(
    id_perfil, descricao)
VALUES (2, 'comum');

INSERT INTO perfil(
    id_perfil, descricao)
VALUES (3, 'cliente');

ALTER SEQUENCE perfil_id_perfil_seq RESTART WITH 4;


INSERT INTO tipo_telefone(
    id_tipo_telefone, descricao)
VALUES (1, 'residencial');

INSERT INTO tipo_telefone(
    id_tipo_telefone, descricao)
VALUES (2, 'comercial');

INSERT INTO tipo_telefone(
    id_tipo_telefone, descricao)
VALUES (3, 'celular');

ALTER SEQUENCE tipo_telefone_id_tipo_telefone_seq RESTART WITH 4;


INSERT INTO usuario(
    id_usuario, nome, cpf, senha, id_perfil)
VALUES (1, 'admin', '00000000000', '123456', 1);

INSERT INTO usuario(
    id_usuario, nome, cpf, senha, id_perfil)
VALUES (2, 'comum', '11111111111', '123456', 2);

ALTER SEQUENCE usuario_id_usuario_seq RESTART WITH 3;


--rollback DROP TABLE pessoa;
--rollback DROP TABLE perfil;
--rollback DROP TABLE usuario;