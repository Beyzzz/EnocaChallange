# EncodaChallange
 ## Kullanılan Teknojiler
<li>Java</li>
<li>Java Spring Boot</li>
<li>JPA</li>
<li>Postgre Sql</li>
<li>Swagger</li>
</br>
</br>
<b> Proje:</b>
<p>Sisteme programlama dillerini ve alt teknolojilerini  ekleyen, silen,
güncelleyen ve listeleyen bir proje yazdım.
<br>
örneğin; 
<li> Java: Spring, JSP. </li>
 <li>C#: WPF, ASP.NET </li>
 <li>JavaScript: Vue, React </li>
</br>
</p>

## Requirements
* JDK 17
* PostgreSQL

## How to Run?

* Clone the repository `git clone https://github.com/Beyzzz/EncodaChallange.git`
* Change directory `cd EncodaChallenge`
* Set the environment variables for PostgreSQL connection at `src/main/resources/application.properties`
* Create a database named "language" you could run `createdb` command
 * `createdb -U <postgresql user> language`
* Restore the database using dump file `pg_restore -d language dump/language`
* Build the package `./mvnw clean install`
* Run the project `java -jar target\Challenge-0.0.1-SNAPSHOT.jar`
* Server will be running at localhost:8080

![Ekran Alıntısı2](https://user-images.githubusercontent.com/75632809/206457566-f78501b7-17a0-474f-868b-633c40e645c6.PNG)

![Ekran Alıntısı](https://user-images.githubusercontent.com/75632809/206457709-079ca551-83f8-4610-9b01-e99a20cbe721.PNG)

![Ekran Alıntısı3](https://user-images.githubusercontent.com/75632809/206457734-066cbd5f-b653-4d60-88c3-dba976d0732b.PNG)

