package br.com.projects.hotelreservationservice;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import br.com.projects.hotelreservationservice.entity.Address;
import br.com.projects.hotelreservationservice.entity.Customer;
import br.com.projects.hotelreservationservice.entity.Hotel;
import br.com.projects.hotelreservationservice.entity.Person;
import br.com.projects.hotelreservationservice.entity.Rate;

public class TesteFuncionamento {
    public static void main(String[] args) {
        Address address = new Address("Residencial", "Rua tal", 2034, "Lagoa Nova", "Natal", "RN", "Brasil");
        Person person = new Person("André Gustavo", "84 999278557", "andre@email.com", address);
        Customer customer = new Customer(person, "06792330400");

        System.out.println(customer);
        double[] values1 = {90.0, 110.0, 110.0, 110.0, 110.0, 110.0, 90.0};
        double[] values2 = {80.0, 80.0, 80.0, 80.0, 80.0, 80.0, 80.0};
        Rate rate1 = new Rate("Regular - Low Station", values1);
        Rate rate2 = new Rate("Reward - Low Station", values2);
        Map<String, Rate> tableRate = new HashMap<String, Rate>();
        tableRate.put("Regular_Low_Station", rate1);
        tableRate.put("Reward_Low_Station", rate2);
        Hotel hotel = new Hotel("Hotel Lakewood", "84 99999-9999", "reservation@lakewood.com", address, "590700-0001", 3, tableRate);

        System.out.println(hotel);
    }
}
