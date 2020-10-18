--
-- PostgreSQL database dump
--

-- Dumped from database version 10.12
-- Dumped by pg_dump version 10.12

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
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


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: grupo_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.grupo_produto (
    id_grupo_produto integer NOT NULL,
    ds_grupo_produto character varying(200) NOT NULL
);


ALTER TABLE public.grupo_produto OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: hibernate_sequences; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hibernate_sequences (
    sequence_name character varying(255) NOT NULL,
    next_val bigint
);


ALTER TABLE public.hibernate_sequences OWNER TO postgres;

--
-- Name: linha_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.linha_produto (
    id_linha_produto integer NOT NULL,
    id_grupo_produto integer NOT NULL,
    ds_linha_produto character varying(200) NOT NULL
);


ALTER TABLE public.linha_produto OWNER TO postgres;

--
-- Name: marca_veiculo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.marca_veiculo (
    id_marca integer NOT NULL,
    ds_marca character varying
);


ALTER TABLE public.marca_veiculo OWNER TO postgres;

--
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id_produto integer NOT NULL,
    id_linha_produto integer NOT NULL,
    cd_item integer NOT NULL,
    id_veiculo integer,
    peso_bruto numeric(5,2) NOT NULL,
    peso_liquido numeric(5,2) NOT NULL,
    dt_inclusao timestamp without time zone NOT NULL,
    dt_atualizacao timestamp without time zone,
    cd_usuario integer NOT NULL,
    CONSTRAINT check_peso CHECK ((peso_bruto > peso_liquido))
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id_produto;


--
-- Name: veiculo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.veiculo (
    id_marca integer,
    id_veiculo integer NOT NULL,
    ds_veiculo character varying(200)
);


ALTER TABLE public.veiculo OWNER TO postgres;

--
-- Name: veiculo_cd_veiculo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.veiculo_cd_veiculo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.veiculo_cd_veiculo_seq OWNER TO postgres;

--
-- Name: veiculo_cd_veiculo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.veiculo_cd_veiculo_seq OWNED BY public.veiculo.id_veiculo;


--
-- Name: produto id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- Name: veiculo id_veiculo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.veiculo ALTER COLUMN id_veiculo SET DEFAULT nextval('public.veiculo_cd_veiculo_seq'::regclass);


--
-- Data for Name: grupo_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.grupo_produto (id_grupo_produto, ds_grupo_produto) FROM stdin;
1	IMPULSOR DE PARTIDA
2	POLIA
3	TENSOR
4	KIT DE DISTRIBUIÇÃO
5	MANCAL
6	PLANETÁRIA
7	PINHÃO
8	COMPONENTE
\.


--
-- Data for Name: hibernate_sequences; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hibernate_sequences (sequence_name, next_val) FROM stdin;
produto	1100
veiculo	100
\.


--
-- Data for Name: linha_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.linha_produto (id_linha_produto, id_grupo_produto, ds_linha_produto) FROM stdin;
1	1	IMPULSOR DE PARTIDA DO MOTOR DE ARRANQUE
8	2	POLIA RODA LIVRE PARA ALTERNADOR - OAP
38	2	POLIA RODA LIVRE COM AMORTECIMENTO PARA ALTERNADOR Z-VIB
66	2	POLIA RÍGIDA PARA ALTERNADOR
17	3	TENSOR DA CORREIA DO ALTERNADOR
19	3	TENSOR DA CORREIA DA DIREÇÃO HIDRÁULICA
22	3	TENSOR DA CORREIA DO MOTOR PARA CAMINHÕES
34	3	TENSOR DA CORREIA DO AR-CONDICIONADO
42	3	TENSOR DA CORREIA DENTADA
48	6	PLANETÁRIA
16	6	REPARO PLANETÁRIA
35	5	SUPORTE DO ALTERNADOR
23	5	MANCAL DIANTEIRO DO MOTOR DE PARTIDA COM BRONZINA
21	5	MANCAL DIANTEIRO DO DÍNAMO SEM ROLAMENTO OU BRONZINA
20	5	MANCAL INTERMEDIÁRIO DO DÍNAMO SEM ROLAMENTO OU BRONZINA
18	5	MANCAL TRASEIRO DO MOTOR DE PARTIDA COM BRONZINA
15	5	MANCAL INTERMEDIÁRIO DO MOTOR DE PARTIDA SEM ROLAMENTO OU BRONZINA
14	5	MANCAL DIANTEIRO DO MOTOR DE PARTIDA SEM ROLAMENTO OU BRONZINA
13	5	MANCAL TRASEIRO DO MOTOR DE PARTIDA SEM ROLAMENTO OU BRONZINA
11	5	MANCAL TRASEIRO DO ALTERNADOR SEM ROLAMENTO OU BRONZINA
6	5	VENTOINHA DO ALTERNADOR", linha_produto_en: "ALTERNATOR FAN
5	5	MANCAL DIANTEIRO DO ALTERNADOR SEM ROLAMENTO OU BRONZINA
65	4	KIT DE DISTRIBUIÇÃO
45	2	POLIA DESVIADORA DA CORREIA DO MOTOR PARA CAMINHÕES COM AR-COND
44	2	POLIA DESVIADORA DA CORREIA DO MOTOR PARA CAMINHÕES COM OU SEM AR-CON
32	2	POLIA DESVIADORA DA CORREIA DO VENTILADOR
29	2	POLIA DESVIADORA DA CORREIA DO AR-CONDICIONADO
24	2	POLIA DESVIADORA DA CORREIA DA DIREÇÃO HIDRÁULICA
12	2	POLIA DESVIADORA DA CORREIA DO ALTERNADOR
4	2	POLIA DESVIADORA DA CORREIA DENTADA
3	7	PINHÃO
9	8	EMBREAGEM DE FRICÇÃO
30	8	FERRAMENTA PARA MONTAGEM/DESMONTAGEM DE POLIAS RODA LIVRE
39	8	TAMPA P/ POLIAS
\.


--
-- Data for Name: marca_veiculo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.marca_veiculo (id_marca, ds_marca) FROM stdin;
1	Subaru
2	Audi
3	Volvo
4	Acura
5	BMW
\.


--
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id_produto, id_linha_produto, cd_item, id_veiculo, peso_bruto, peso_liquido, dt_inclusao, dt_atualizacao, cd_usuario) FROM stdin;
76	17	5386	24	27.65	12.48	2020-10-16 10:08:28.988893	\N	1
77	17	5387	44	27.74	10.90	2020-10-16 10:08:28.988893	\N	1
78	17	5388	32	23.78	10.19	2020-10-16 10:08:28.988893	\N	1
79	17	5389	53	23.80	11.76	2020-10-16 10:08:28.988893	\N	1
80	17	5390	50	25.69	10.25	2020-10-16 10:08:28.988893	\N	1
81	17	5391	68	20.10	19.63	2020-10-16 10:08:28.988893	\N	1
82	17	5392	3	23.42	16.57	2020-10-16 10:08:28.988893	\N	1
4	4	5301	1	23.53	22.15	2020-10-16 08:15:00	\N	1
5	4	5302	5	23.33	22.45	2020-10-16 08:15:00	\N	1
6	4	5303	15	33.10	27.15	2020-10-16 08:15:00	\N	1
7	4	5304	33	44.22	41.12	2020-10-16 08:15:00	\N	1
8	4	5305	67	18.12	14.45	2020-10-16 08:15:00	\N	1
9	4	5306	89	23.53	22.15	2020-10-16 08:15:00	\N	1
10	4	5307	102	33.67	32.45	2020-10-16 08:15:00	\N	1
11	12	5321	30	27.67	10.95	2020-10-16 10:01:45.483814	\N	1
12	12	5322	47	20.70	16.37	2020-10-16 10:01:45.483814	\N	1
13	12	5323	91	24.49	13.25	2020-10-16 10:01:45.483814	\N	1
14	12	5324	30	28.20	14.99	2020-10-16 10:01:45.483814	\N	1
15	12	5325	43	28.86	16.45	2020-10-16 10:01:45.483814	\N	1
16	19	5326	65	28.34	16.60	2020-10-16 10:03:17.154058	\N	1
17	19	5327	19	23.46	15.90	2020-10-16 10:03:17.154058	\N	1
18	19	5328	60	25.27	10.65	2020-10-16 10:03:17.154058	\N	1
19	19	5329	30	20.49	18.36	2020-10-16 10:03:17.154058	\N	1
20	19	5330	15	20.80	15.54	2020-10-16 10:03:17.154058	\N	1
21	19	5331	52	21.83	11.22	2020-10-16 10:03:17.154058	\N	1
22	19	5332	27	26.47	14.62	2020-10-16 10:03:17.154058	\N	1
23	19	5333	95	29.55	19.51	2020-10-16 10:03:17.154058	\N	1
24	19	5334	108	26.72	18.29	2020-10-16 10:03:17.154058	\N	1
25	19	5335	33	26.60	13.53	2020-10-16 10:03:17.154058	\N	1
26	24	5336	80	23.00	18.56	2020-10-16 10:04:26.546027	\N	1
28	24	5338	76	20.21	15.89	2020-10-16 10:04:26.546027	\N	1
29	24	5339	80	21.75	15.62	2020-10-16 10:04:26.546027	\N	1
31	24	5341	95	21.01	10.25	2020-10-16 10:04:26.546027	\N	1
32	24	5342	13	24.40	11.79	2020-10-16 10:04:26.546027	\N	1
33	24	5343	42	29.22	17.24	2020-10-16 10:04:26.546027	\N	1
34	24	5344	57	23.44	17.82	2020-10-16 10:04:26.546027	\N	1
35	24	5345	90	24.06	14.35	2020-10-16 10:04:26.546027	\N	1
36	42	5346	44	24.69	13.36	2020-10-16 10:05:32.385792	\N	1
37	42	5347	85	23.88	19.34	2020-10-16 10:05:32.385792	\N	1
38	42	5348	26	22.12	13.23	2020-10-16 10:05:32.385792	\N	1
39	42	5349	43	28.58	15.65	2020-10-16 10:05:32.385792	\N	1
40	42	5350	94	24.74	12.95	2020-10-16 10:05:32.385792	\N	1
41	42	5351	52	29.34	15.14	2020-10-16 10:05:32.385792	\N	1
42	42	5352	69	20.53	12.60	2020-10-16 10:05:32.385792	\N	1
43	42	5353	94	29.72	14.37	2020-10-16 10:05:32.385792	\N	1
44	42	5354	87	20.72	19.68	2020-10-16 10:05:32.385792	\N	1
45	42	5355	20	27.03	12.06	2020-10-16 10:05:32.385792	\N	1
49	3	5359	63	24.22	15.32	2020-10-16 10:06:36.293448	\N	1
57	3	5367	30	22.02	10.41	2020-10-16 10:06:36.293448	\N	1
59	3	5369	31	25.92	15.34	2020-10-16 10:06:36.293448	\N	1
61	8	5371	99	25.56	14.46	2020-10-16 10:07:34.941802	\N	1
62	8	5372	90	25.63	16.82	2020-10-16 10:07:34.941802	\N	1
63	8	5373	45	29.13	16.35	2020-10-16 10:07:34.941802	\N	1
65	8	5375	103	26.59	16.58	2020-10-16 10:07:34.941802	\N	1
66	8	5376	105	27.01	16.31	2020-10-16 10:07:34.941802	\N	1
67	8	5377	96	22.19	15.37	2020-10-16 10:07:34.941802	\N	1
68	8	5378	74	21.92	15.05	2020-10-16 10:07:34.941802	\N	1
69	8	5379	107	27.81	14.37	2020-10-16 10:07:34.941802	\N	1
70	8	5380	48	27.14	19.68	2020-10-16 10:07:34.941802	\N	1
71	8	5381	92	23.62	14.77	2020-10-16 10:07:34.941802	\N	1
72	8	5382	105	24.42	15.56	2020-10-16 10:07:34.941802	\N	1
73	8	5383	92	27.03	18.21	2020-10-16 10:07:34.941802	\N	1
74	8	5384	50	21.35	13.89	2020-10-16 10:07:34.941802	\N	1
75	8	5385	73	21.33	17.62	2020-10-16 10:07:34.941802	\N	1
83	17	5393	32	21.03	16.93	2020-10-16 10:08:28.988893	\N	1
84	17	5394	79	21.85	14.23	2020-10-16 10:08:28.988893	\N	1
85	17	5395	68	25.04	14.00	2020-10-16 10:08:28.988893	\N	1
86	17	5396	16	24.05	17.88	2020-10-16 10:08:28.988893	\N	1
87	17	5397	101	20.08	11.35	2020-10-16 10:08:28.988893	\N	1
88	17	5398	23	24.04	18.23	2020-10-16 10:08:28.988893	\N	1
90	17	5400	71	24.75	19.98	2020-10-16 10:08:28.988893	\N	1
1	4	6666	\N	6.00	5.00	2020-10-17 19:08:43.527	\N	1
52	12	5555	45	8.00	7.00	2020-10-17 19:22:10.793	\N	1
53	29	7777	42	889.00	888.00	2020-10-17 19:28:32.739	\N	1
102	66	8888	44	47.00	45.00	2020-10-17 19:41:32.459	\N	1
352	4	2222	43	67.00	62.00	2020-10-17 21:57:04.925	\N	1
353	4	2345	42	55.00	44.00	2020-10-17 21:58:06.566	\N	1
652	4	55	1	3.00	2.00	2020-10-17 23:09:14.909	\N	1
654	4	55	33	3.00	2.00	2020-10-17 23:11:46.673	\N	1
658	4	5555	1	3.00	2.00	2020-10-17 23:16:07.295	\N	1
754	4	515	28	3.00	2.00	2020-10-17 23:33:39.819	\N	1
96	4	515	116	31.00	21.00	2020-10-18 00:46:25.774	\N	1
97	5	5215	1	31.00	21.00	2020-10-18 10:40:02.41	\N	1
103	3	52153	8	33.00	25.00	2020-10-18 10:47:11.261	\N	1
104	3	553	10	33.00	25.00	2020-10-18 10:49:50.446	\N	1
123	3	553	\N	33.00	25.00	2020-10-18 12:50:29.573	\N	1
124	5	553	11	33.00	25.00	2020-10-18 12:51:37.053	\N	1
\.


--
-- Data for Name: veiculo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.veiculo (id_marca, id_veiculo, ds_veiculo) FROM stdin;
1	1	Crosstrek H4
1	2	Forester
1	3	Impreza
1	4	Impreza H4
1	5	Legacy
1	6	Outback
1	7	WRX H4
2	8	A1 
2	9	A3
2	10	A4
2	11	A4 Allroad
2	12	A4 Avant
2	13	A5
2	14	A6
2	15	A6 Avant
2	16	A7
2	17	A7 Sportback
2	18	Q3 
2	19	Q5
3	24	B Series 7500
3	25	B Series 8500
3	26	C30
3	27	Fe
3	28	FH12 380
3	29	FH12 420
3	30	FH400
3	31	FH440
3	32	FH480
3	33	FH520
3	34	FL
3	35	FM12 380
3	36	FM12 420
3	37	FM400
3	38	FM440
3	39	FM480
3	40	Ônibus
3	41	S40
3	23	FL
3	22	FH480
3	21	B Series B9
3	20	B Series B5
4	42	CSX L4
4	43	EL
4	44	Integra
4	45	Integra L4
4	46	Legend
4	47	Nippondenso Starter
4	48	SLX
4	49	TSX L4
5	50	1500
5	51	1502
5	52	1600
5	53	1602
5	54	1800
5	55	1800TI
5	56	1802
5	57	2000
5	58	2002
5	59	2500
5	60	2600
5	61	2600L
5	62	2800
5	63	3000
5	64	315
5	65	316
5	66	316i
5	67	318
5	68	318i
5	69	320
5	70	3200
5	71	3200CS
5	72	320I
5	73	321I
5	74	323 i
5	75	325E
5	76	325i
5	77	3300
5	78	503
5	79	518
5	80	518i
5	81	520
5	82	520I
5	83	523 i
5	84	523i
5	85	525
5	86	525E
5	87	525i
5	88	528
5	89	528I
5	90	528l
5	91	530
5	92	628
5	93	630
5	94	635
5	95	663
5	96	728
5	97	728i
5	98	728l
5	99	730
5	100	732
5	101	733
5	102	735
5	103	745
5	104	90
5	105	900
5	106	9000
5	107	900INJ
5	108	M535I
5	109	R100
5	110	R45
5	111	R60
5	112	R65
5	113	R75
5	114	R80
\N	116	\N
\N	117	\N
\N	118	\N
\N	119	\N
\N	120	\N
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 29, true);


--
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 124, true);


--
-- Name: veiculo_cd_veiculo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.veiculo_cd_veiculo_seq', 120, true);


--
-- Name: grupo_produto grupo_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.grupo_produto
    ADD CONSTRAINT grupo_produto_pkey PRIMARY KEY (id_grupo_produto);


--
-- Name: hibernate_sequences hibernate_sequences_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hibernate_sequences
    ADD CONSTRAINT hibernate_sequences_pkey PRIMARY KEY (sequence_name);


--
-- Name: linha_produto linha_produto_id_linha_produto_id_grupo_produto_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linha_produto
    ADD CONSTRAINT linha_produto_id_linha_produto_id_grupo_produto_key UNIQUE (id_linha_produto, id_grupo_produto);


--
-- Name: linha_produto linha_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linha_produto
    ADD CONSTRAINT linha_produto_pkey PRIMARY KEY (id_linha_produto);


--
-- Name: marca_veiculo marca_veiculo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.marca_veiculo
    ADD CONSTRAINT marca_veiculo_pkey PRIMARY KEY (id_marca);


--
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);


--
-- Name: veiculo veiculo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_pkey PRIMARY KEY (id_veiculo);


--
-- Name: produto fkg5eaqhs2yeh0e82q31555f2kn; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT fkg5eaqhs2yeh0e82q31555f2kn FOREIGN KEY (id_veiculo) REFERENCES public.veiculo(id_veiculo);


--
-- Name: linha_produto linha_produto_id_grupo_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.linha_produto
    ADD CONSTRAINT linha_produto_id_grupo_produto_fkey FOREIGN KEY (id_grupo_produto) REFERENCES public.grupo_produto(id_grupo_produto);


--
-- Name: produto produto_id_linha_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_id_linha_produto_fkey FOREIGN KEY (id_linha_produto) REFERENCES public.linha_produto(id_linha_produto);


--
-- Name: veiculo veiculo_id_marca_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_id_marca_fkey FOREIGN KEY (id_marca) REFERENCES public.marca_veiculo(id_marca);


--
-- PostgreSQL database dump complete
--

