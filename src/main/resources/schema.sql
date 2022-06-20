DROP TABLE IF EXISTS avis CASCADE ;
DROP TABLE IF EXISTS participation CASCADE;
DROP TABLE IF EXISTS rencontre CASCADE;
DROP TABLE IF EXISTS avis CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;

DROP SEQUENCE IF EXISTS avis_id_seq ;
DROP SEQUENCE IF EXISTS participation_id_seq;
DROP SEQUENCE IF EXISTS roles_id_seq ;
DROP SEQUENCE IF EXISTS users_id_seq ;

CREATE SEQUENCE avis_id_seq;
CREATE SEQUENCE participation_id_seq;
CREATE SEQUENCE roles_id_seq;
CREATE SEQUENCE users_id_seq;


CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'),
    description character varying(255),
    email character varying(255) ,
    password character varying(255),
    username character varying(255),
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
    CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username)
);

CREATE TABLE public.avis
(
    id integer NOT NULL DEFAULT nextval('avis_id_seq'),
    description character varying(255),
    id_creator bigint,
    id_joueur bigint,
    note_joueur integer NOT NULL,
    CONSTRAINT avis_pkey PRIMARY KEY (id)
);


CREATE TABLE public.participation
(
    id bigint NOT NULL DEFAULT nextval('participation_id_seq'),
    player_id bigint,
    rencontre_id bigint,
    CONSTRAINT participation_pkey PRIMARY KEY (id)
);

CREATE TABLE public.rencontre
(
    id bigint NOT NULL,
    created_at timestamp without time zone,
    description character varying(255),
    nombre_joueur integer NOT NULL,
    owner bigint,
    planned_at timestamp without time zone,
    sport character varying(20),
    city character varying(255),
    postal_code character varying(255),
    latitude character varying(255),
    longitude character varying(255),
    CONSTRAINT rencontre_pkey PRIMARY KEY (id)
);

CREATE TABLE public.roles
(
    id integer NOT NULL DEFAULT nextval('roles_id_seq'),
    name character varying(20),
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE public.user_roles
(
    user_id bigint NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id)
        REFERENCES public.roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

