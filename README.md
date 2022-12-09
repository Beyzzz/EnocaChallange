# EnocaChallange
## Technologies Used

* Java
* Spring Boot
* JPA
* PostgreSQL
* Swagger

## Description:

A sample MVC Java Spring application that supports CRUD operations 
The entity relationship is as follows:

![enoca_challenge_entity_diagram](https://user-images.githubusercontent.com/75632809/206754556-eb150446-34a4-495b-9047-fe3758fbd4ad.png)

## Requirements

* JDK 17
* PostgreSQL

## Usage

* Clone the repository `git clone https://github.com/Beyzzz/EncodaChallange.git`
* Change directory `cd EncodaChallenge`
* Set the environment variables for PostgreSQL connection at `src/main/resources/application.properties`
* Create a database named "language" you could run `createdb` command
 * `createdb -U <postgresql user> language`
* Restore the database using dump file `pg_restore -d language dump/language`
* Build the package `./mvnw clean install`
* Run the project `java -jar target\Challenge-0.0.1-SNAPSHOT.jar`
* Server will be running at localhost:8080

![Screenshot2](https://user-images.githubusercontent.com/75632809/206457566-f78501b7-17a0-474f-868b-633c40e645c6.PNG)

![Screenshot](https://user-images.githubusercontent.com/75632809/206457709-079ca551-83f8-4610-9b01-e99a20cbe721.PNG)

![Screenshot3](https://user-images.githubusercontent.com/75632809/206457734-066cbd5f-b653-4d60-88c3-dba976d0732b.PNG)

