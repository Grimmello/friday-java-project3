--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: clifford
--

CREATE TABLE clients (
    id integer NOT NULL,
    clientname character varying,
    stylistid integer
);


ALTER TABLE clients OWNER TO clifford;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: clifford
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO clifford;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: clifford
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: clifford
--

CREATE TABLE stylists (
    id integer NOT NULL,
    stylistname character varying
);


ALTER TABLE stylists OWNER TO clifford;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: clifford
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO clifford;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: clifford
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: clifford
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: clifford
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: clifford
--

COPY clients (id, clientname, stylistid) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: clifford
--

SELECT pg_catalog.setval('clients_id_seq', 29, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: clifford
--

COPY stylists (id, stylistname) FROM stdin;
1	James
2	James
3	James
4	James
5	James
6	James
7	James
8	James
9	James
10	James
11	James
12	James
13	James
14	James
15	James
16	James
17	James
18	James
19	James
20	James
21	James
22	James
23	James
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: clifford
--

SELECT pg_catalog.setval('stylists_id_seq', 23, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: clifford
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: clifford
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

