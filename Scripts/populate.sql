INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(5, 'Miami', 'Estados Unidos', 'Comercial', 'Sunset Beach', 307, 'FL', 'NE 1st St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(3, 'Miami', 'Estados Unidos', 'Comercial', 'New Horizon', 103, 'FL', '206 St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(4, 'Miami', 'Estados Unidos', 'Comercial', 'Hope', 146, 'FL', 'Biscayne Blvd');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(1, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(9, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(11, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(12, 'Orlando', 'Estados Unidos', 'Residencial', 'Mall', 26, 'FL', '45 street');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(21, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(23, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(26, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua tal');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(27, 'Mossoró', 'Brasil', 'Residencial', 'Lagoa Nova', 2034, 'RN', 'Rua teste');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(7, NULL, NULL, NULL, NULL, 0, NULL, NULL);
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(10, 'Orlando', 'EUA', 'Comercial', 'Neighbor', 56, 'CA', 'Rua do Hotel');

INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(2, '09206027468', 'chico@email.com', 1, 'Chico', '84888554423', 1);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(5, NULL, 'andreh_gustavo@hotmail.com', 0, '', '84999278557', 10);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(6, NULL, 'andreh_gustavohotmail.com', 0, '', '84999278557', 11);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(4, '06792330400', 'andre@email.com', 1, 'André', '84888554423', 9);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(15, '075.604.100-73', 'Marcelo@email.com', 1, 'Marcelo', '84888554423', 21);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(17, '000.000.000-73', 'Marcelo1@email.com', 1, 'Marcelo1', '84888554423', 23);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(18, '000.000.000-74', 'Marcelo3@email.com', 1, 'Marcelo3', '84888554423', 26);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(19, '000.000.000-75', 'Marcelo4@email.com', 1, 'Marcelo4', '84888554423', 27);
INSERT INTO public.customer
(id_customer, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(20, '000.000.000-76', 'Marcelo5@email.com', 1, 'Marcelo5', '84888554423', 27);

INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(1, 3, '000.000-0001-1', 'contato@lakewood.com', 'Lakewood', '55 84 99998-55540', 3);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(3, 4, '000.000-0001-2', 'contato@bridgewood.com', 'Bridgewood', '55 84 99998-55540', 4);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(5, 5, '000.000-0001-3', 'contato@ridgewood.com', 'Ridgewood', '55 84 99998-55542', 5);

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

INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(1, '2021-11-26', '2021-11-30', 'Cama extra.', 1, 4, 1, 2021, NULL, NULL, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(2, '2021-12-02', '2021-11-28', 'Teste teste', 0, 4, 1, 2022, NULL, NULL, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(3, '2021-12-02', '2021-11-28', 'Teste teste', 0, 4, 1, 1638120483388, NULL, NULL, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(4, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638124807442, NULL, NULL, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(5, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638125575989, '2021-11-28 15:52:55.995', NULL, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(6, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638130621578, '2021-11-28 17:17:01.620', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(7, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638240109789, '2021-11-29 23:41:49.824', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(9, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638243969183, '2021-11-30 00:46:09.215', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(8, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638242040632, '2021-11-30 00:14:00.665', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(10, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638460984078, '2021-12-02 13:03:04.113', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(11, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638461967623, '2021-12-02 13:19:27.651', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(12, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638462284479, '2021-12-02 13:24:44.489', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(13, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638462377984, '2021-12-02 13:26:17.994', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(14, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638462543808, '2021-12-02 13:29:03.816', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(15, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638463016587, '2021-12-02 13:36:56.589', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(16, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638463168376, '2021-12-02 13:39:28.383', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(17, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638464635952, '2021-12-02 14:03:55.961', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(18, '2021-11-28', '2021-11-26', 'Teste teste', 0, 5, 1, 1638464719799, '2021-12-02 14:05:19.929', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(22, '2021-11-28', '2021-11-26', 'Teste teste', 0, 6, 1, 1638728978310, '2021-12-05 15:29:38.318', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(23, '2021-11-28', '2021-11-26', '', 0, 5, 1, 1638982730969, '2021-12-08 13:58:50.988', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(26, '2021-11-27', '2021-12-01', 'Cama extra.', 0, 4, 1, NULL, NULL, NULL, NULL);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(28, '2021-11-28', '2021-11-26', '', 0, 5, 1, 1639093828269, '2021-12-09 20:50:28.279', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(29, '2021-11-28', '2021-11-26', '', 0, 5, 1, 1639095693588, '2021-12-09 21:21:33.595', 290.0, false);

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