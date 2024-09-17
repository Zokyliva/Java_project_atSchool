--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: conjoint; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.conjoint (
    numpension character(225) NOT NULL,
    nomconjoint character(225),
    prenomconjoint character(225),
    montant character(225)
);


ALTER TABLE public.conjoint OWNER TO postgres;

--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    names character(225) NOT NULL,
    pass character(225)
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: payer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payer (
    im character varying(225) NOT NULL,
    num_tarif character varying(225),
    date date
);


ALTER TABLE public.payer OWNER TO postgres;

--
-- Name: personne; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.personne (
    im character varying(225) NOT NULL,
    nom character varying(225),
    prenom character varying(225),
    datenais date,
    diplome character varying(225),
    contact character varying(225),
    statut character varying(225),
    situation character varying(225),
    nomconjoint character varying(225),
    prenomconjoint character varying(225)
);


ALTER TABLE public.personne OWNER TO postgres;

--
-- Name: tarif; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarif (
    num_tarif character varying(225) NOT NULL,
    diplome character varying(225),
    categorie character varying(225),
    montant integer
);


ALTER TABLE public.tarif OWNER TO postgres;

--
-- Name: vente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vente (
    idvente character(25) NOT NULL,
    produit character(155),
    quantite integer
);


ALTER TABLE public.vente OWNER TO postgres;

--
-- Name: conjoint conjoint_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.conjoint
    ADD CONSTRAINT conjoint_pkey PRIMARY KEY (numpension);


--
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (names);


--
-- Name: payer payer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payer
    ADD CONSTRAINT payer_pkey PRIMARY KEY (im);


--
-- Name: personne personne_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (im);


--
-- Name: tarif tarif_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarif
    ADD CONSTRAINT tarif_pkey PRIMARY KEY (num_tarif);


--
-- Name: vente vente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vente
    ADD CONSTRAINT vente_pkey PRIMARY KEY (idvente);


--
-- PostgreSQL database dump complete
--

