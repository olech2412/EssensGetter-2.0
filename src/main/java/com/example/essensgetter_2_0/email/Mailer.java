package com.example.essensgetter_2_0.email;

import com.example.essensgetter_2_0.JPA.MailUser;
import com.example.essensgetter_2_0.JPA.Meal;
import com.example.essensgetter_2_0.JPA.authentification.Users;
import lombok.extern.log4j.Log4j2;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Properties;

@Log4j2
public class Mailer {

    /**
     * Sends an email to the given email address with the current menu
     * @throws MessagingException
     */
    public void sendSpeiseplan(Iterable<MailUser> emailTargets, Iterable<Meal> menu) throws MessagingException, IOException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", false);
        prop.put("mail.smtp.host", "localhost");
        prop.put("mail.smtp.port", "25");

        for (MailUser emailTarget: emailTargets) {
            String deactivateUrl = "https://egr.olech2412.de/deactivate?code=" + emailTarget.getDeactivationCode().getCode();
            Message message = new MimeMessage(Session.getInstance(prop));
            message.setFrom(new InternetAddress("noreply_essensgetter@olech2412.de"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(emailTarget.getEmail()));
            message.setSubject("Speiseplan " +
                    LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - " +
                    "Schönauer Straße");
            String msg = String.format(createEmail(menu), emailTarget.getFirstname(), deactivateUrl);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            log.debug("Email sent to " + emailTarget.getEmail());
        }

    }

    private String createEmail(Iterable<Meal> menu) {
        StringBuilder menuText = new StringBuilder();

        for(Meal meal : menu) {
            menuText.append(String.format("<h5 class=\"text-teal-700\">%s</h5>", meal.getCategory()));
            menuText.append(String.format("<p class=\"text-gray-700\">%s (%s) - %s</p>", meal.getName(), meal.getDescription(), meal.getPrice()));
        }

        String header =
                "<body class=\"bg-light\">" +
                    "<div class=\"container\">" +
                        "<div class=\"card my-10\">" +
                            "<div class=\"card-body\">" +
                                "<h1 class=\"h3 mb-2\">Geschmackvolle Neuigkeiten - Dein Speiseplan für heute</h1>" +
                                "<hr>" +
                                "<div class=\"space-y-3\">" +
                                    "<p class=\"text-gray-700\"> Moin, %s</p>" +
                                    "<p class=\"text-gray-700\"> nachfolgend findest du den aktuellen Speiseplan für die Kantine: \"Schönauer Straße\". </p>";
        String footer =
                                    "<p class=\"text-gray-700\"> Wenn du nicht weißt wieso du diese Email bekommst oder den Newsletter nicht länger erhalten willst, klicke einfach auf \"Ciao EssensGetter\" und ich lösche alle deine Daten.</p>" +
                                    "<a class=\"btn btn-danger\" href=\"%s\" target=\"_blank\">Ich war das nicht</a>" +
                                    "<p class=\"text-gray-700\"> Guten Appetit wünscht dir, </p>" +
                                    "<p class=\"text-gray-700\"> dein EssensGetter </p>" +
                                "</div>" +
                                "<hr>" +
                            "</div>" +
                        "</div>" +
                    "</div>" +
                "</body>";

        StringBuilder msg = new StringBuilder();
        msg.append(header);
        msg.append(menuText);
        msg.append(footer);

        return msg.toString();
    }
}
