package br.com.projects.hotelreservationservice.service;

import java.text.DecimalFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.projects.hotelreservationservice.entity.Booking;

@Service
public class EmailServiceImpl implements EmailService{
    
    @Autowired 
    private JavaMailSender mailSender;

    @Override
    public String sendInformationMail(int status, Booking theBooking) {
        DecimalFormat df = new DecimalFormat("#,###.00");
        MimeMessage mail = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(theBooking.getCustomer().getEmail());
            helper.setFrom("andre.dev.tester@gmail.com");
            helper.setSubject("Reserva " + theBooking.getNumber());
            String htmlMsg = ("<p>Olá <b>"+ theBooking.getCustomer().getName() + "</b>, <br><br>" +
            "Aqui é do serviço de reservas de Hotéis, estamos entrando " +
            "em contato pois sua reserva foi " + (status == BookingService.CONFIRMED ? "<b>CONFIRMADA</b>" : "<b>CANCELADA</b>") +"! "+
            "Segue os detalhes abaixo:</p>" +
            "<ul>" +
                "<li>Número de Reserva: " + theBooking.getNumber() + "</li>" +
                "<li>Nome: " + theBooking.getCustomer().getName() + "</li>" +
                "<li>Telefone: " + theBooking.getCustomer().getPhoneNumber() + "</li>" +
                "<li>Email: " + theBooking.getCustomer().getEmail() + "</li>" +
                "<li>Período:" + theBooking.getCheckin() + "</li>" +
                "<li>Hotel:" + theBooking.getHotel().getName() + "</li>" +
                "<li>Tipo de Reserva:" + theBooking.getType() + "</li>" +
                "<li>Preço: R$" + df.format(theBooking.getPrice()) + "</li>" +
                "<li>Status:" + (status == BookingService.CONFIRMED ? "<b>CONFIRMADA</b>" : "<b>CANCELADA</b>") + "</li>" +
            "</ul>");
            helper.setText(htmlMsg, true);
            mailSender.send(mail);
            return "Email enviado com sucesso!";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
