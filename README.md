# EssensGetter 2.0

This is a private student project and not a commercial application. Stable operation cannot be guaranteed.

EssensGetter 2.0 is a programming project that relies on SpringBoot, Java, MariaDB, Maven and Hibernate. It communicates with the OpenMensa API and saves the received data in a MariaDB database. This makes the data available for the EssensGetter API. The program then sends an email to all authorized users who have registered via .

## Installation

### Download the package
1. Download the program from the latest release on GitHub.
```bash
git clone https://github.com/olech2412/EssensGetter-2.0.git
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

#### Install MariaDB
1. Add the MariaDB Repositorys to install the latest version
```bash
sudo apt-get install software-properties-common
sudo apt-key adv --recv-keys --keyserver hkp://keyserver.ubuntu.com:80 0xF1656F24C74CD1D8
sudo add-apt-repository 'deb [arch=amd64,arm64,ppc64el] http://mirrors.accretive-networks.net/mariadb/repo/10.5/ubuntu bionic main'
```

2. Update your packages and start the installation
```bash
sudo apt-get update
sudo apt-get install mariadb-server

# Check if everything works fine
sudo systemctl status mariadb
# You should see something like 'active (running)' if not see the MariaDB documentation
```

3. MariaDB secure installation
```bash
sudo mysql_secure_installation

# Do the configuration-steps (for more Information visit the MariaDB documentation
# set password for the root user
# remove anonymous user
# deactivate remote access for root
```

#### Setup MariaDB
** The following steps are based on the default installation and can be different to your setup. Checkout the application.properties file 'src/main/resources/application.properties' for your properties **
1. Create the database
```sql
CREATE DATABASE essensGetter;
```
2. Create the user and give him all rights to interact with the database
```sql
CREATE USER 'egrAdmin'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON essensGetter.* TO 'egrAdmin'@'localhost';
FLUSH PRIVILEGES;
```
3. You are done! MariaDB was set up correctly

##### Prepare

6. Create a database named "essensgetter" in MariaDB and change the corresponding credentials in the `application.properties` file.
7. Navigate to the project directory in the command line.
8. Run the `mvn clean install` command to install the dependencies.
9. Start the program with the command `mvn spring-boot:run`.

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
