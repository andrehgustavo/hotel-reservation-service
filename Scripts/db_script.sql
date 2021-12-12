-- Database: hotel-reservation-db

-- DROP DATABASE "hotel-reservation-db";

--CREATE DATABASE "hotel-reservation-db"
--    WITH 
--    OWNER = postgres
--    ENCODING = 'UTF8'
--    LC_COLLATE = 'Portuguese_Brazil.1252'
--    LC_CTYPE = 'Portuguese_Brazil.1252'
--    TABLESPACE = pg_default
--    CONNECTION LIMIT = -1;
CREATE SCHEMA "hotel-reservation-db";
-- public.address definition

-- Drop table

-- DROP TABLE public.address;

CREATE TABLE IF NOT EXISTS public.address (
	id_address int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	city varchar(255) NULL,
	country varchar(255) NULL,
	description varchar(255) NULL,
	neighborhood varchar(255) NULL,
	"number" int4 NULL,
	state varchar(255) NULL,
	street varchar(255) NULL,
	CONSTRAINT address_pkey PRIMARY KEY (id_address)
);

-- public.rate definition

-- Drop table

-- DROP TABLE public.rate;

CREATE TABLE IF NOT EXISTS public.rate (
	id_rate int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	description varchar(255) NULL,
	price_type varchar(255) NULL,
	CONSTRAINT rate_pkey PRIMARY KEY (id_rate)
);

-- public.price_per_days definition

-- Drop table

-- DROP TABLE public.price_per_days;

CREATE TABLE IF NOT EXISTS public.price_per_days (
	id_rate int8 NOT NULL,
	price float8 NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT price_per_days_pkey PRIMARY KEY (id_rate, name)
);


-- public.price_per_days foreign keys

ALTER TABLE public.price_per_days ADD CONSTRAINT fkeoboko90jp4237hobhkkthqy3 FOREIGN KEY (id_rate) REFERENCES public.rate(id_rate);

-- public.hotel definition

-- Drop table

-- DROP TABLE public.hotel;

CREATE TABLE IF NOT EXISTS public.hotel (
	id_hotel int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	classification int4 NULL,
	cnpj varchar(255) NULL,
	email varchar(255) NULL,
	"name" varchar(255) NULL,
	phone_number varchar(255) NULL,
	id_address int8 NULL,
	CONSTRAINT hotel_pkey PRIMARY KEY (id_hotel),
	CONSTRAINT uk_1u2pywhfbc294l9udblotbmep UNIQUE (cnpj)
);


-- public.hotel foreign keys
ALTER TABLE public.hotel ADD CONSTRAINT fkp3l08bu8uotbnym8g10s376v4 FOREIGN KEY (id_address) REFERENCES public.address(id_address);

-- public.customer definition

-- Drop table

-- DROP TABLE public.customer;

CREATE TABLE IF NOT EXISTS public.customer (
	id_customer int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	cpf varchar(255) NULL,
	email varchar(255) NULL,
	loyalty int4 NULL,
	"name" varchar(255) NULL,
	phone_number varchar(255) NULL,
	id_address int8 NULL,
	CONSTRAINT customer_pkey PRIMARY KEY (id_customer),
	CONSTRAINT uk_cwtgtb16nebxu54elskdjei66 UNIQUE (cpf),
	CONSTRAINT uk_dwk6cx0afu8bs9o4t536v1j5v UNIQUE (email)
);


-- public.customer foreign keys

ALTER TABLE public.customer ADD CONSTRAINT fkrtg0ytybwvot9ne0txhl5jxy4 FOREIGN KEY (id_address) REFERENCES public.address(id_address);

-- public.booking definition

-- Drop table

-- DROP TABLE public.booking;

CREATE TABLE IF NOT EXISTS public.booking (
	id_booking int8 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	checkin date NULL,
	checkout date NULL,
	booking_remarks varchar(255) NULL,
	booking_type int4 NULL,
	id_customer int8 NULL,
	id_hotel int8 NULL,
	booking_number int8 NULL,
	booking_date timestamp NULL,
	booking_price float8 NULL,
	active bool NULL,
	CONSTRAINT booking_pkey PRIMARY KEY (id_booking),
	CONSTRAINT uk_6j74n7w8mp19sixr5272028mk UNIQUE (booking_number)
);


-- public.booking foreign keys
ALTER TABLE public.booking ADD CONSTRAINT fkpik2mrag1cnn0tqf6pem6iuyc FOREIGN KEY (id_hotel) REFERENCES public.hotel(id_hotel);
ALTER TABLE public.booking ADD CONSTRAINT fksfkmk4sahyegxnjceqmpuy407 FOREIGN KEY (id_customer) REFERENCES public.customer(id_customer);

-- public.hotel_table_rate definition

-- Drop table

-- DROP TABLE public.hotel_table_rate;

CREATE TABLE IF NOT EXISTS public.hotel_table_rate (
	id_hotel int8 NOT NULL,
	id_rate int8 NOT NULL,
	CONSTRAINT hotel_table_rate_pkey PRIMARY KEY (id_hotel, id_rate),
	CONSTRAINT uk_ri8ovycgbj1r572vetl7h60tj UNIQUE (id_rate)
);


-- public.hotel_table_rate foreign keys
ALTER TABLE public.hotel_table_rate ADD CONSTRAINT fkf4l9y0rkt8mor9d016q5qq0s2 FOREIGN KEY (id_hotel) REFERENCES public.hotel(id_hotel);
ALTER TABLE public.hotel_table_rate ADD CONSTRAINT fkmocidry2b63sxcm5p88yg3lp4 FOREIGN KEY (id_rate) REFERENCES public.rate(id_rate);


-- INSERTS
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(1, 'Miami', 'Estados Unidos', 'Comercial', 'Sunset Beach', 307, 'FL', 'NE 1st St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(2, 'Miami', 'Estados Unidos', 'Comercial', 'New Horizon', 103, 'FL', '206 St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(3, 'Miami', 'Estados Unidos', 'Comercial', 'Hope', 146, 'FL', 'Biscayne Blvd');
SELECT setval('address_id_address_seq', (SELECT max(a.id_address) FROM public.address a));


INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(1, 3, '000.000-0001-1', 'contato@lakewood.com', 'Lakewood', '55 84 99998-55540', 1);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(3, 4, '000.000-0001-2', 'contato@bridgewood.com', 'Bridgewood', '55 84 99998-55540', 2);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(5, 5, '000.000-0001-3', 'contato@ridgewood.com', 'Ridgewood', '55 84 99998-55542', 3);
SELECT setval('hotel_id_hotel_seq', (SELECT max(h.id_hotel) FROM public.hotel h));

INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(1, 'Day type price for Regular customers', 'REGULAR');
INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(2, 'Day type price for Reward customers', 'REWARD');
INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(3, 'Day type price for Regular customers', 'REGULAR');
INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(4, 'Day type price for Reward customers', 'REWARD');
INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(5, 'Day type price for Regular customers', 'REGULAR');
INSERT INTO public.rate
(id_rate, description, price_type)
VALUES(6, 'Day type price for Reward customers', 'REWARD');
SELECT setval('rate_id_rate_seq', (SELECT max(r.id_rate) FROM public.rate r));

INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(1, 110.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(1, 90.0, 'WEEKENDDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(2, 80.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(2, 80.0, 'WEEKENDDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(3, 160.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(3, 60.0, 'WEEKENDDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(4, 110.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(4, 50.0, 'WEEKENDDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(5, 220.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(5, 150.0, 'WEEKENDDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(6, 100.0, 'WEEKDAYS');
INSERT INTO public.price_per_days
(id_rate, price, "name")
VALUES(6, 40.0, 'WEEKENDDAYS');



INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(1, 1);
INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(1, 2);
INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(3, 3);
INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(3, 4);
INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(5, 5);
INSERT INTO public.hotel_table_rate
(id_hotel, id_rate)
VALUES(5, 6);

INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(2, '09206027468', 'chico@email.com', 1, 'Chico', '84888554423', 1);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(4, '06792330400', 'andre@email.com', 1, 'André', '84888554423', 1);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(15, '075.604.100-73', 'Marcelo@email.com', 1, 'Marcelo', '84888554423', 2);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(17, '000.000.000-73', 'Marcelo1@email.com', 1, 'Marcelo1', '84888554423', 2);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(18, '000.000.000-74', 'Marcelo3@email.com', 1, 'Marcelo3', '84888554423', 3);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(19, '000.000.000-75', 'Marcelo4@email.com', 1, 'Marcelo4', '84888554423', 3);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(20, '000.000.000-76', 'Marcelo5@email.com', 1, 'Marcelo5', '84888554423', 1);
SELECT setval('customer_id_customer_seq', (SELECT max(c.id_customer) FROM public.customer c));

INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(1, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638130621578, '2021-11-28 17:17:01.620', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(2, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638240109789, '2021-11-29 23:41:49.824', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(3, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638243969183, '2021-11-30 00:46:09.215', 290.0, true);
SELECT setval('booking_id_booking_seq', (SELECT max(b.id_booking) FROM public.booking b));