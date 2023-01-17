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
import java.util.ArrayList;
import java.util.List;
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

            String msg = createEmail(menu, emailTarget.getFirstname(), deactivateUrl);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            log.debug("Email sent to " + emailTarget.getEmail());
        }

    }

    private String createEmail(Iterable<Meal> menu , String firstName, String deactivateUrl) {
        StringBuilder menuText = new StringBuilder();

        for(Meal meal : menu) {
            String menuString = StaticEmailText.foodText;
            menuString = menuString.replaceFirst("%s", meal.getCategory());
            menuString = menuString.replaceFirst("%s", meal.getName() + " (" + meal.getDescription() +" )" + " - " + meal.getPrice());
            menuText.append(menuString);
        }

        String header = StaticEmailText.foodPlanText;
        header = header.replaceFirst("%s", "Speiseplan " +
                LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - " +
                "Schönauer Straße");
        header = header.replaceFirst("%s", getRandomFunnyText());
        header = header.replaceFirst("%s", getRandomFunnyWelcomeText());
        header = header.replaceFirst("%s", firstName);
        header = header.replaceFirst("%s", "nachfolgend findest du den Speiseplan für heute.");

        String footer = StaticEmailText.foodPlanFooter;
        footer = footer.replaceFirst("%s", getRandomGreetingsText());
        footer = footer.replaceFirst("%s", deactivateUrl);

        StringBuilder msg = new StringBuilder();
        msg.append(header);
        msg.append(menuText);
        msg.append(footer);

        return msg.toString();
    }

    private String getRandomFunnyWelcomeText() {
        List<String> welcome = new ArrayList<>();
        welcome.add("Hallo");
        welcome.add("Servus");
        welcome.add("Moin");
        welcome.add("Hi");
        welcome.add("Guten Tag");
        welcome.add("Guten Morgen");
        welcome.add("Ahoi");
        welcome.add("Grüß Gott");
        welcome.add("Grüß di");
        welcome.add("Aloha");
        welcome.add("Alles cool im Pool");
        welcome.add("Alles fit im Schritt");
        welcome.add("Alles klar in Kanada");
        welcome.add("Alles Roger in Kambodscha");
        welcome.add("Buenas Tardes");
        welcome.add("Gib Flosse");
        welcome.add("Grüetzi");
        welcome.add("Grüßli Müsli");
        welcome.add("Hallihallohallöle");
        welcome.add("Hallochen");
        welcome.add("Hallöchen Popöchen");
        welcome.add("Hallöle");
        welcome.add("Heroin-spaziert");
        welcome.add("Hola");
        welcome.add("Holla die Waldfee");
        welcome.add("Howdy");
        welcome.add("Huhu");
        welcome.add("Huhu wie gehts");
        welcome.add("Juten Tach");
        welcome.add("Juten Tag");
        welcome.add("Namasté");
        welcome.add("Whazuuuuuuuup");
        welcome.add("Yo Moinsen");
        welcome.add("Yo");
        welcome.add("Mohoin");

        return welcome.get((int) (Math.random() * welcome.size()));
    }

    private String getRandomGreetingsText() {
        List<String> greetings = new ArrayList<>();
        greetings.add("Viele Grüße, ");
        greetings.add("Liebe Grüße, ");
        greetings.add("Mit freundlichen Grüßen, ");
        greetings.add("Mit besten Grüßen, ");
        greetings.add("Tschüssikowski, ");
        greetings.add("Bis bald, ");
        greetings.add("Bis dann, ");
        greetings.add("Auf Wiederhörnchen, ");
        greetings.add("Bis zum nächsten Mal, ");
        greetings.add("Tschausen, ");
        greetings.add("Bis baldrian, ");
        greetings.add("Tschö mit ö, ");
        greetings.add("Mach’s gut, Knut, ");
        greetings.add("Bis baldo, Ronaldo, ");
        greetings.add("Paris – Athen, Auf Wiedersehn, ");
        greetings.add("See you later, alligator!, ");
        greetings.add("Good Bye, Hawaii, ");
        greetings.add("In diesem Sinne: Ab in die Rinne, ");
        greetings.add("Ende im Gelände, ");
        greetings.add("So sieht’s aus im Schneckenhaus, ");
        greetings.add("Finger in Po – Mexiko, ");
        greetings.add("Jetzt geht’s los, Spätzle mit Soß, ");
        greetings.add("In a while, crocodile, ");
        greetings.add("Auf Wiedersehen, ");
        greetings.add("Bis denne, ");
        greetings.add("Bis denne Antenne, ");
        greetings.add("Au revoir, ");
        greetings.add("Arrivederci, ");
        greetings.add("Adiós, ");
        greetings.add("Até logo, ");
        greetings.add("До свидания, ");
        greetings.add("안녕히 가세요, ");
        greetings.add("再见, ");
        greetings.add("Ciao, ");
        greetings.add("Ciao Kakao, ");

        return greetings.get((int) (Math.random() * greetings.size()));
    }

    private String getRandomFunnyText() {
        List<String> funnyTexts = new ArrayList<>();
        funnyTexts.add("Guten Appetit!");
        funnyTexts.add("Guten Hunger!");
        funnyTexts.add("Guten Appetit und guten Hunger!");
        funnyTexts.add("Mahlzeit!");
        funnyTexts.add("Wir sind hier nicht bei “wünsch dir was”, sondern bei ” so isses”!");
        funnyTexts.add("Guten Appetit und guten Hunger! Und wenn du nicht satt bist, dann iss nochmal!");
        funnyTexts.add("Satz mit x, das war wohl nichts!");
        funnyTexts.add("Ich denke, ich werde meine Mittagspause heute zum Mittagessen benutzen.");
        funnyTexts.add("Ich denke, ich werde meine Mittagspause heute für ein köstliches Mittagessen opfern.");
        funnyTexts.add("Ein gutes Mittagessen ist das Geheimnis, um den Uni-Tag durchzustehen.");
        funnyTexts.add("Ohne Mittagessen wäre der Uni-Tag nur halb so erträglich.");
        funnyTexts.add("Ohne Mittagessen wäre der Uni-Tag nur halb so erträglich.");
        funnyTexts.add("Ich denke nur an mein Mittagessen, wenn ich in der Vorlesung sitze.");
        funnyTexts.add("Ich würde für ein gutes Mittagessen jede Vorlesung besuchen.");
        funnyTexts.add("Ich denke nur ans Mittagessen, wenn ich in einer langweiligen Vorlesung sitze.");
        funnyTexts.add("Ohne Mittagessen wäre die Uni nur ein Ort voller Trägheit und Müdigkeit.");
        funnyTexts.add("Nimm lieber Salz und Pfeffer mit.");
        funnyTexts.add("Mittagessen ist wie ein Mini-Urlaub von der Uni.");

        return funnyTexts.get((int) (Math.random() * funnyTexts.size()));
    }
}
