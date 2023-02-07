# EssensGetter 2.0

This is a private student project and not a commercial application. Stable operation cannot be guaranteed.

EssensGetter 2.0 is a programming project that relies on SpringBoot, Java, MariaDB, Maven and Hibernate. It communicates with the OpenMensa API and saves the received data in a MariaDB database. This makes the data available for the EssensGetter API. The program then sends an email to all authorized users who have registered via .

## Installation

### Download the package
1. Download the Releasex.x.x.rar from the latest release on GitHub.
2. Transfer the archive to your server e.g. with WinSCP
3. Unpack the archive
3.1
```bash
# Ubuntu/Debian
sudo apt-get install unrar
unrar x Releasex.x.x.rar
```

### Setting up the environment

#### Install Java
1. Check if Java is already installed
```bash
java -version
```
2. If not update your packages and start the installation
```bash
sudo apt-get update
sudo apt-get install openjdk-11-jdk

# Check if everything works fine
java -version
```

4. Make sure you have Java 11, Maven, MariaDB and Hibernate installed.
5. Create a database named "essensgetter" in MariaDB and change the corresponding credentials in the `application.properties` file.
6. Navigate to the project directory in the command line.
7. Run the `mvn clean install` command to install the dependencies.
8. Start the program with the command `mvn spring-boot:run`.

## Verwendung

Das Programm läuft im Hintergrund und kommuniziert automatisch mit der OpenMensa API, um die Daten zu erhalten und in der Datenbank zu speichern. Autorisierte Nutzer erhalten automatisch eine E-Mail mit den aktualisierten Speiseplänen.

## Das Konzept
![EssensGetter SoftwareArchitektur drawio (1)](https://user-images.githubusercontent.com/76694468/212769942-63c4dd74-2664-4111-9736-429c27f669c5.png)


## OpenMensa
OpenMensa ist ein Projekt, das es ermöglicht, Speisepläne von Mensa- oder Kantinenbetreibern in einem offenen Format zur Verfügung zu stellen, damit diese von Dritten verwendet werden können. Es bietet eine API und eine Datenbank, die es Entwicklern ermöglicht, Speisepläne von Mensa- oder Kantinenbetreibern in ihre Anwendungen zu integrieren. https://openmensa.org/

## Zugehöriges Grafana Dashboard
Als kleines Nebenprojekt versuche ich interessante Statistiken aus den gesammelten Daten zu ziehen. Dafür habe ich mir folgendes Grafana Dashboard aufgesetzt, welches verschiedene Abfragen an die Datenbank schickt wodurch sich einerseits das Softwarekonstrukt gut überwachen lässt (API Zugriffe, Anzahl ausstehender Aktivierungen usw.) aber es entstehen auch Möglichkeiten Rückschlüsse auf das Essensangebot ziehen.
![Screenshot 2023-01-18 145523](https://user-images.githubusercontent.com/76694468/213191027-28390bcf-e5a5-4ed3-b321-e19dc6508378.png)


## Hinweis

Bitte beachten Sie, dass dies ein privates Studentenprojekt ist und das Programm nicht für die Öffentlichkeit zur Verfügung steht. Der Betrieb des Programms kann nicht garantiert werden und das Programm darf nicht zu kommerziellen Zwecken genutzt werden.

Ich hoffe, dass Sie das Programm trotzdem nützlich finden.
