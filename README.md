# EssensGetter 2.0

Dies ist ein privates Studentenprojekt und keine kommerzielle Anwendung. Es kann kein stabilen Betrieb gewährleistet werden.

EssensGetter 2.0 ist ein Programmierprojekt, das auf SpringBoot, Java, MariaDB, Maven und Hibernate setzt. Es kommuniziert mit der API von OpenMensa und speichert die erhaltenen Daten in eine MariaDB Datenbank. Dadurch stehen die Daten dann für die EssensGetter API zur Verfügung. Anschließend versendet das Programm eine E-Mail an alle autorisierten Nutzer, die sich über <EGR> registriert haben.

## Installation

1. Laden Sie das Projekt von GitHub herunter.
2. Stellen Sie sicher, dass Sie Java 11, Maven, MariaDB und Hibernate installiert haben.
3. Erstellen Sie eine Datenbank namens "essensgetter" in MariaDB und ändern Sie die entsprechenden Zugangsdaten in der `application.properties`-Datei.
4. Navigieren Sie in der Kommandozeile in das Verzeichnis des Projekts.
5. Führen Sie den Befehl `mvn clean install` aus, um die Abhängigkeiten zu installieren.
6. Starten Sie das Programm mit dem Befehl `mvn spring-boot:run`.

## Verwendung

Das Programm läuft im Hintergrund und kommuniziert automatisch mit der OpenMensa API, um die Daten zu erhalten und in der Datenbank zu speichern. Autorisierte Nutzer erhalten automatisch eine E-Mail mit den aktualisierten Speiseplänen.

## Das Konzept
![EssensGetter Softwarearchitektur](https://github.com/olech2412/EssensGetter-2.0/blob/master/EssensGetter%20SoftwareArchitektur.drawio.png)

## Hinweis

Bitte beachten Sie, dass dies ein privates Studentenprojekt ist und das Programm nicht für die Öffentlichkeit zur Verfügung steht. Der Betrieb des Programms kann nicht garantiert werden und das Programm darf nicht zu kommerziellen Zwecken genutzt werden.

Ich hoffe, dass Sie das Programm trotzdem nützlich finden.
