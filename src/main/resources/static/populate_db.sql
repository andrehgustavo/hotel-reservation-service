INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(1, 'Natal', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(5, 'Miami', 'Estados Unidos', 'Comercial', 'Sunset Beach', 307, 'FL', 'NE 1st St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(3, 'Miami', 'Estados Unidos', 'Comercial', 'New Horizon', 103, 'FL', '206 St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(4, 'Miami', 'Estados Unidos', 'Comercial', 'Hope', 146, 'FL', 'Biscayne Blvd');

INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(2, '09206027468', 'chico@email.com', 1, 'Chico', '84888554423', 1);

INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(1, 3, '000.000-0001-1', 'contato@lakewood.com', 'Lakewood', '55 84 99998-55540', 3);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(3, 4, '000.000-0001-2', 'contato@bridgewood.com', 'Bridgewood', '55 84 99998-55540', 4);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(5, 5, '000.000-0001-3', 'contato@ridgewood.com', 'Ridgewood', '55 84 99998-55542', 5);

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

INSERT INTO public.rate
(id_rate, description)
VALUES(1, 'lakewood_regular_low_season');
INSERT INTO public.rate
(id_rate, description)
VALUES(2, 'lakewood_reward_low_season');
INSERT INTO public.rate
(id_rate, description)
VALUES(3, 'bridgewood_regular_low_season');
INSERT INTO public.rate
(id_rate, description)
VALUES(4, 'bridgewood_reward_low_season');
INSERT INTO public.rate
(id_rate, description)
VALUES(5, 'ridgewood_regular_low_season');
INSERT INTO public.rate
(id_rate, description)
VALUES(6, 'ridgewood_reward_low_season');

INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 110.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 110.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 110.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 110.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 110.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 90.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(1, 90.0, 6);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(2, 80.0, 6);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 160.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 160.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 160.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 160.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 160.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 60.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(3, 60.0, 6);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 110.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 110.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 110.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 110.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 110.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 50.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(4, 50.0, 6);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 220.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 220.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 220.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 220.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 220.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 150.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(5, 150.0, 6);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 100.0, 0);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 100.0, 1);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 100.0, 2);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 100.0, 3);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 100.0, 4);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 40.0, 5);
INSERT INTO public.rate_price_per_days
(rate_id_rate, price_per_days, pos)
VALUES(6, 40.0, 6);

     
