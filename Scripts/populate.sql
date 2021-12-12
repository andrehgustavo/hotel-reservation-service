INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(1, 'Miami', 'Estados Unidos', 'Comercial', 'Sunset Beach', 307, 'FL', 'NE 1st St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(2, 'Miami', 'Estados Unidos', 'Comercial', 'New Horizon', 103, 'FL', '206 St');
INSERT INTO public.address
(id_address, city, country, description, neighborhood, "number", state, street)
VALUES(3, 'Miami', 'Estados Unidos', 'Comercial', 'Hope', 146, 'FL', 'Biscayne Blvd');


INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(1, 3, '000.000-0001-1', 'contato@lakewood.com', 'Lakewood', '55 84 99998-55540', 1);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(3, 4, '000.000-0001-2', 'contato@bridgewood.com', 'Bridgewood', '55 84 99998-55540', 2);
INSERT INTO public.hotel
(id_hotel, classification, cnpj, email, "name", phone_number, id_address)
VALUES(5, 5, '000.000-0001-3', 'contato@ridgewood.com', 'Ridgewood', '55 84 99998-55542', 3);

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
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(2, '09206027468', 'chico@email.com', 1, 'Chico', '84888554423', 1);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(5, NULL, 'andreh_gustavo@hotmail.com', 0, '', '84999278557', 10);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(6, NULL, 'andreh_gustavohotmail.com', 0, '', '84999278557', 11);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(4, '06792330400', 'andre@email.com', 1, 'André', '84888554423', 9);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(15, '075.604.100-73', 'Marcelo@email.com', 1, 'Marcelo', '84888554423', 21);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(17, '000.000.000-73', 'Marcelo1@email.com', 1, 'Marcelo1', '84888554423', 23);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(18, '000.000.000-74', 'Marcelo3@email.com', 1, 'Marcelo3', '84888554423', 26);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(19, '000.000.000-75', 'Marcelo4@email.com', 1, 'Marcelo4', '84888554423', 27);
INSERT INTO public.customer
(id_hotel, cpf, email, loyalty, "name", phone_number, id_address)
VALUES(20, '000.000.000-76', 'Marcelo5@email.com', 1, 'Marcelo5', '84888554423', 27);

INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(1, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638130621578, '2021-11-28 17:17:01.620', 290.0, false);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(2, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638240109789, '2021-11-29 23:41:49.824', 290.0, true);
INSERT INTO public.booking
(id_booking, checkin, checkout, booking_remarks, booking_type, id_customer, id_hotel, booking_number, booking_date, booking_price, active)
VALUES(3, '2021-11-28', '2021-11-26', 'Teste teste', 0, 4, 1, 1638243969183, '2021-11-30 00:46:09.215', 290.0, true);