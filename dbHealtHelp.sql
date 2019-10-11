


--
-- PostgreSQL create database HeathHelp
--

DROP DATABASE  HeathHelp

CREATE DATABASE HealthHelp
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;




SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;



CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';




CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;



COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';




CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;



COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_with_oids = false;


CREATE TABLE public.users (
    id SERIAL primary key NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    tenant_id SERIAL,
    profile_id SERIAL NOT NULL,
    email character varying(100) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;


CREATE TABLE public.user_profiles (
    user_id SERIAL NOT NULL,
    profile_id SERIAL NOT NULL
);


ALTER TABLE public.user_profiles OWNER TO postgres;


CREATE TABLE public.profiles (
    id SERIAL primary key NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.profiles OWNER TO postgres;



CREATE TABLE public.tenants (
    id SERIAL primary key NOT NULL,
    name character varying(40) NOT NULL,
    cif character varying(50),
    bussinessname character varying(50),
    address character varying(50)
);


ALTER TABLE public.tenants OWNER TO postgres;


ALTER TABLE public.tenants OWNER TO postgres;


CREATE TABLE public.patients (
    id SERIAL primary key NOT NULL,
    lopd SERIAL NOT NULL,
    user_id SERIAL NOT NULL,
    tenant_id SERIAL NOT NULL,
    name character varying(100) NOT NULL,
    lastname character varying(100) NOT NULL,
    dni character varying(100) NOT NULL,
    telephone character varying(100) NOT NULL,
    address character varying(100) NOT NULL,
    location character varying(100) NOT NULL,
    profession character varying(100) NOT NULL,
    email character varying(100) NOT NULL
);

ALTER TABLE public.patients OWNER TO postgres;


CREATE TABLE public.sessions (
    id SERIAL primary key NOT NULL,
    patient_id SERIAL NOT NULL,
    date timestamp without time zone,
    reason character varying(100) NOT NULL,
    background character varying(100) NOT NULL,
    diagnosis character varying(100) NOT NULL,
    valoration character varying(100) NOT NULL,
    complementary character varying(100) NOT NULL,
    treatment character varying(100) NOT NULL
);

ALTER TABLE public.sessions OWNER TO postgres;


CREATE TABLE public.billing (
    id SERIAL primary key NOT NULL,
    patient_id SERIAL NOT NULL,
    session_id SERIAL NOT NULL,
    tenant_id SERIAL NOT NULL,
    date timestamp without time zone,
    amount integer NOT NULL
   
);


ALTER TABLE public.billing OWNER TO postgres;



ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES public.tenants(id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_profile FOREIGN KEY (profile_id) REFERENCES public.profiles(id);

ALTER TABLE ONLY public.user_profiles
    ADD CONSTRAINT fk_profiles FOREIGN KEY (profile_id) REFERENCES public.profiles(id);

ALTER TABLE ONLY public.user_profiles
    ADD CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES public.users(id);


ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES public.tenants(id);

ALTER TABLE ONLY public.patients
    ADD CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES public.users(id);

ALTER TABLE ONLY public.sessions
    ADD CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES public.patients(id);

ALTER TABLE ONLY public.billing
    ADD CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES public.patients(id);

ALTER TABLE ONLY public.billing
    ADD CONSTRAINT fk_session FOREIGN KEY (session_id) REFERENCES public.sessions(id);

ALTER TABLE ONLY public.billing
    ADD CONSTRAINT fk_tenant FOREIGN KEY (tenant_id) REFERENCES public.tenants(id);